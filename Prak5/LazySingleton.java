package Prak5;

public class LazySingleton {
    private static LazySingleton instance;
    public static synchronized LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
            return instance;
        }
        return instance;
    }
}


