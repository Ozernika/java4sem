package Prak4;

public class Main {
    public static void main(String[] args) {
        ExecutorService executor = new ExecutorService(3);

        for (int i =  1; i <  7; i++) {
            final int taskId = i;
            executor.submit(() -> {
                System.out.println("Executing task " + taskId);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                System.out.println("Finished task " + taskId);
            });
        }

        try {
            Thread.sleep(5000); // Даем задачам время на выполнение
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        executor.shutdown();
    }
}

