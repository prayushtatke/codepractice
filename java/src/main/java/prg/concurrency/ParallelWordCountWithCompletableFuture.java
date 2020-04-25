package prg.concurrency;

import prg.Util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class ParallelWordCountWithCompletableFuture {
    private static final String FILE_PATH = "../test.txt";
    private static final int MAX_LINES_PER_THREAD = 20000;
    private static final int MAX_THREADS = 5;
    private AtomicLong linesCompleted;
    private long numLines;

    public ParallelWordCountWithCompletableFuture() {
        linesCompleted = new AtomicLong(0);
    }

    public void startMultiThread() throws IOException {
        System.out.println("Counting MultiThreaded...");
        Path path = Paths.get(FILE_PATH);
        long totalSizeInBytes = path.toFile().length();

        // get total line count
        numLines = Files.lines(path).count();

        System.out.println("Number Of Lines: " + numLines);
        ForkJoinPool pool = new ForkJoinPool(5);

        // Initialize Mapper
        List<CompletableFuture<Long>> counters = new ArrayList<>();
        List<String> tmp = new ArrayList<>();
        try (Stream<String> lineStream = Files.lines(path)) {
            Iterator<String> strIter = lineStream.iterator();

            while (strIter.hasNext()) {
                tmp.add(strIter.next());

                if (tmp.size() == MAX_LINES_PER_THREAD) {
                    counters.add(CompletableFuture.supplyAsync(new WordCounter(tmp.stream(),tmp.size()),pool));
                    tmp = new ArrayList<>();
                }

                // It is important to wait for some threads to complete so as to avoid OOM error.
                if (pool.getActiveThreadCount() == MAX_THREADS)
                    Util.sleepMillis(500);
            }
            counters.add(CompletableFuture.supplyAsync(new WordCounter(tmp.stream(),tmp.size()),pool));
            tmp = null;

            // initialize reducer
            CompletableFuture<Long> sum = CompletableFuture.allOf(counters.toArray(new CompletableFuture[counters.size()]))
                    .thenApplyAsync(v -> counters.stream()
                            .mapToLong(CompletableFuture::join)
                            .sum()
                    );


//            while (!sum.isDone())
//                Util.sleepMillis(5);

            System.out.println("TotalCount: " + sum.join());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private long countWordInStream(Stream<String> stream) {
        return stream.flatMap(s -> Arrays.stream(s.split("\\W+"))).count();
    }

    public static void main(String[] args) {
        try {
            ParallelWordCountWithCompletableFuture mtwc = new ParallelWordCountWithCompletableFuture();
            mtwc.startMultiThread();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private class WordCounter implements Supplier<Long> {
        private Stream<String> lines;
        private long lineCount;
        WordCounter(Stream<String> lines, long lineCount) {
            this.lines = lines;
            this.lineCount = lineCount;
        }

        @Override
        public Long get() {
            long count = countWordInStream(lines);
            long completed = linesCompleted.addAndGet(lineCount);
            float percent = (Float.valueOf(completed) / numLines) * 100;
            System.out.println(percent + "% Completed.");

            return count;

        }
    }
}
