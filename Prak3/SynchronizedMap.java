package Prak3;

import java.util.HashMap;
import java.util.Map;

public class SynchronizedMap<K, V> {
    private final Map<K, V> synchronizedMap;

    public SynchronizedMap() {
        synchronizedMap = new HashMap<>();
    }

    public synchronized int size() {
        return synchronizedMap.size();
    }

    public synchronized boolean isEmpty() {
        return synchronizedMap.isEmpty();
    }

    public synchronized boolean containsKey(Object key) {
        return synchronizedMap.containsKey(key);
    }

    public synchronized boolean containsValue(Object value) {
        return synchronizedMap.containsValue(value);
    }

    public synchronized V get(Object key) {
        return synchronizedMap.get(key);
    }

    public synchronized V put(K key, V value) {
        return synchronizedMap.put(key, value);
    }

    public synchronized V remove(Object key) {
        return synchronizedMap.remove(key);
    }
}


