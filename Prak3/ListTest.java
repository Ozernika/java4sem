package Prak3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ListTest {
    public static void main(String[] args) {
        System.out.println("SemaphoreList Test");
        System.out.println();

        SemaphoreList<Integer> semaphoreList = new SemaphoreList<>(3);

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 3; i++) {
            executorService.submit(() -> {
                semaphoreList.add((int) Thread.currentThread().getId());
                System.out.println("Add operation by " + Thread.currentThread().getId());
                boolean value = semaphoreList.contains((int) Thread.currentThread().getId());
                System.out.println("Get operation by " + Thread.currentThread().getId() + ", Result: " + value);
            });
        }
        executorService.shutdown();
    }
}

