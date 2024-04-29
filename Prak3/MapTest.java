package Prak3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MapTest {
    public static void main(String[] args) throws InterruptedException {

        System.out.println("SynchronizedMap Test");
        System.out.println();

        SynchronizedMap<String, String> synchronizedMap = new SynchronizedMap<>();
        ExecutorService executorService = Executors.newFixedThreadPool(3); // Создаем пул из 3 потоков

        for (int i = 0; i < 3; i++) {
            executorService.submit(() -> {
                synchronizedMap.put("Key" + Thread.currentThread().getId(), "Value" + Thread.currentThread().getId());
                System.out.println("Put operation by " + Thread.currentThread().getId());
                String value = synchronizedMap.get("Key" + Thread.currentThread().getId());
                System.out.println("Get operation by " + Thread.currentThread().getId() + ", Value: " + value);
            });
        }

        executorService.shutdown(); // Завершаем прием новых задач
        executorService.awaitTermination(1, TimeUnit.MINUTES); // Ожидаем завершения всех задач
        System.out.println("Map size: " + synchronizedMap.size());
    }
}


