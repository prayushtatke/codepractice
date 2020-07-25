package prg.concurrency;

import java.util.concurrent.CompletableFuture;
import prg.Util;

public class CompletableFutureTest {
    public static void main(String[] args) {
        CompletableFuture<Void> cf = CompletableFuture.runAsync( () -> System.out.println("Starting1.."));

        CompletableFuture<String> start = CompletableFuture.supplyAsync(() -> {
            System.out.println("Starting..");
            return "Starting...";
        }  );

        cf.thenRunAsync(() -> System.out.println("done1.."));
        start.thenApplyAsync((s) -> {
            String p = s + "done";
            System.out.println(p);
            return p;
        });

        Util.sleepSecs(1);
    }
}
