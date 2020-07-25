package prg.concurrency;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MultiThreadedWordCount {
    private static final String FILE_PATH = "../test.txt";
    private static final int MAX_LINES_PER_THREAD = 20000;
    private static final int MAX_THREADS = 5;
    private long numLines;
    private AtomicLong linesCompleted;
    private AtomicLong wordCount;
    private Supplier<Double> percentCompleted;
    private ThreadPoolExecutor pool;
    private ScheduledExecutorService progressPrinterService;

    public MultiThreadedWordCount() {
        linesCompleted = new AtomicLong(0l);
        wordCount = new AtomicLong(0l);
        percentCompleted = () -> (linesCompleted.doubleValue() / numLines) * 100 ;
        pool = (ThreadPoolExecutor) Executors.newFixedThreadPool(MAX_THREADS);
    }

    public void startSingleThread() throws IOException {
        System.out.println("Counting SingleThreaded...");
        long wc = countWordInStream(Files.lines(Paths.get(FILE_PATH)));
        System.out.println("Total Count: " + wc);
    }

    public void startMultiThread() throws IOException {
        System.out.println("Counting MultiThreaded...");
        Path path = Paths.get(FILE_PATH);

        // get total line count
        numLines = Files.lines(path).count();
        System.out.println("Number Of Lines: "+numLines);
        startProgressDisplay();

        List<String> tmp = new ArrayList<>();
        try (Stream<String> lineStream = Files.lines(path)) {
            Iterator<String> strIter = lineStream.iterator();

            while (strIter.hasNext()) {
                tmp.add(strIter.next());

                if ( tmp.size() == MAX_LINES_PER_THREAD ) {
                    Future<?> newTask = pool.submit(new WordCounter(tmp.stream(),tmp.size()));

                    // It is important to wait for some threads to complete so as to avoid OOM error.
                    if (pool.getActiveCount() == MAX_THREADS)
                        newTask.get();

                    tmp = new ArrayList<>();
                }
            }

            // submitting last remaining lines. (totalLines - (n * MAX_LINES_PER_THREAD))
            pool.submit(new WordCounter(tmp.stream(),tmp.size()));
            tmp = null;
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
            System.out.println("Total Count: " + wordCount.longValue());
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

    private class WordCounter implements Runnable {
        private Stream<String> lines;
        private long lineCount;

        WordCounter(Stream<String> lines, long lineCount) {
            this.lines = lines;
            this.lineCount = lineCount;
        }

        @Override
        public void run() {
            long count = countWordInStream(lines);
            wordCount.addAndGet(count);
            linesCompleted.addAndGet(lineCount);
            lines = null;
        }
    }

    public static void main(String[] args) {
        try {
            MultiThreadedWordCount mtwc = new MultiThreadedWordCount();
//            mtwc.startSingleThread();
            mtwc.startMultiThread();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
