package Prak3;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class SemaphoreList<E> {
    private final List<E> list;
    private final Semaphore semaphore;

    public SemaphoreList(int permits) {
        list = new ArrayList<>();
        semaphore = new Semaphore(permits);
    }

    public boolean isEmpty() {
        return operation(() -> list.isEmpty());
    }

    public boolean contains(Object o) {
        return operation(() -> list.contains(o));
    }

    public boolean add(E e) {
        return operation(() -> list.add(e));
    }

    public boolean remove(Object o) {
        return operation(() -> list.remove(o));
    }

    private boolean operation(Operation<Boolean> op) {
        try {
            semaphore.acquire();
            return op.execute();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
            return false;
        } finally {
            semaphore.release();
        }
    }

    interface Operation<T> {
        T execute();
    }
}


