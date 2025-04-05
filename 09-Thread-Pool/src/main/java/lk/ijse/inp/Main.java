package lk.ijse.inp;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (int i = 1; i <= 10; i++) {
            Runnable runnable = new MyRunnable("Worker Thread"+i);
            executor.execute(runnable);
        }
        executor.shutdown();
    }
}