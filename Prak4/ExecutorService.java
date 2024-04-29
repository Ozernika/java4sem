package Prak4;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ExecutorService {
    private final BlockingQueue<Task> taskQueue;
    private final WorkerThread[] workerThreads;

    public ExecutorService(int numThreads) {
        this.taskQueue = new LinkedBlockingQueue<>();
        this.workerThreads = new WorkerThread[numThreads];

        for (int i =  0; i < numThreads; i++) {
            workerThreads[i] = new WorkerThread(taskQueue);
            workerThreads[i].start();
        }
    }

    public void submit(Task task) {
        try {
            taskQueue.put(task);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Interrupted while adding task to the queue.", e);
        }
    }

    public void shutdown() {
        for (WorkerThread worker : workerThreads) {
            worker.shutdown();
        }
    }

    private static class WorkerThread extends Thread {
        private final BlockingQueue<Task> taskQueue;
        private volatile boolean shutdown = false;

        public WorkerThread(BlockingQueue<Task> taskQueue) {
            this.taskQueue = taskQueue;
        }

        @Override
        public void run() {
            while (!shutdown) {
                try {
                    Task task = taskQueue.take();
                    task.execute();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    shutdown = true;
                }
            }
        }

        public void shutdown() {
            this.shutdown = true;
            this.interrupt();
        }
    }

    public interface Task {
        void execute();
    }
}

