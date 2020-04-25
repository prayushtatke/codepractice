package prg.concurrency;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class MultiThreadedWordCountWithCallable {
    private static final String FILE_PATH = "../test.txt";
    private static final int MAX_LINES_PER_THREAD = 20000;
    private static final int MAX_THREADS = 5;
    private long numLines;
    private AtomicLong linesCompleted;
    private AtomicLong wordCount;
    private Supplier<Double> percentCompleted;
    private ThreadPoolExecutor pool;
    private ScheduledExecutorService progressPrinterService;

    public MultiThreadedWordCountWithCallable() {
        linesCompleted = new AtomicLong(0l);
        wordCount = new AtomicLong(0l);
        percentCompleted = () -> (linesCompleted.doubleValue() / numLines) * 100 ;
        pool = (ThreadPoolExecutor) Executors.newFixedThreadPool(MAX_THREADS);
    }

    public void startMultiThread() throws IOException {
        System.out.println("Counting MultiThreaded...");
        Path path = Paths.get(FILE_PATH);

        // get total line count
        numLines = Files.lines(path).count();
        System.out.println("Number Of Lines: "+numLines);
//        startProgressDisplay();

        Predicate<List<Future<Long>>> allDone = list -> list.stream().allMatch(Future::isDone) ;

        List<String> tmp = new ArrayList<>();
        List<Future<Long>> counters = new ArrayList<>();
        try (Stream<String> lineStream = Files.lines(path)) {
            Iterator<String> strIter = lineStream.iterator();

            while (strIter.hasNext()) {
                tmp.add(strIter.next());

                if ( tmp.size() == MAX_LINES_PER_THREAD ) {
                    counters.add(pool.submit(new WordCounter(tmp.stream(),tmp.size())));

                    // It is important to wait for some threads to complete so as to avoid OOM error.
                    if (pool.getActiveCount() == MAX_THREADS)
                        Util.sleep(500,TimeUnit.MILLISECONDS);
                    tmp = new ArrayList<>();
                }
            }

            // submitting last remaining lines. (totalLines - (n * MAX_LINES_PER_THREAD))
            counters.add(pool.submit(new WordCounter(tmp.stream(),tmp.size())));
            tmp = null;

            while ( ! allDone.test(counters) ) {
                Util.sleep(50,TimeUnit.MILLISECONDS);
            }
            long wordCount = counters.stream().mapToLong(f -> {
                long count = 0;
                try{
                    count = f.get();
                } catch (InterruptedException | ExecutionException ie) {

                }
                return count;
            }).sum();
            System.out.println("Total Count: " + wordCount);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void printProgress() {
        long percent = percentCompleted.get().longValue();
        System.out.println(percent + "% Completed.");
        if (percent == 100l) {
            progressPrinterService.shutdownNow();
            pool.shutdown();

        }
    }

    private void startProgressDisplay() {
        Runnable progressPrinter = this::printProgress;
        progressPrinterService = Executors.newSingleThreadScheduledExecutor();
        progressPrinterService.scheduleAtFixedRate(progressPrinter, 1l,1l , TimeUnit.SECONDS);
    }

    private long countWordInStream(Stream<String> stream) {
        return stream.flatMap(s -> Arrays.stream(s.split("\\W+"))).count();
    }

    private class WordCounter implements Callable<Long> {
        private Stream<String> lines;
        private long lineCount;

        WordCounter(Stream<String> lines, long lineCount) {
            this.lines = lines;
            this.lineCount = lineCount;
        }

        @Override
        public Long call() {
            long count = countWordInStream(lines);
            long completed = linesCompleted.addAndGet(lineCount);
            float percent = (Float.valueOf(completed) / numLines) * 100 ;
            System.out.println(percent + "% Completed.");
            return count;
        }
    }

    public static void main(String[] args) {
        try {
            MultiThreadedWordCountWithCallable mtwc = new MultiThreadedWordCountWithCallable();
            mtwc.startMultiThread();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
