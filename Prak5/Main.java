package Prak5;

public class Main {
    public static void main(String[] args) {
        Singleton staticInstance = Singleton.getInstance();
        System.out.println("Standart Initialization instance: " + staticInstance.getClass().getSimpleName());

        LazySingleton lazyInstance = LazySingleton.getInstance();
        System.out.println("Lazy Initialization instance: " + lazyInstance.getClass().getSimpleName());

        EnumSingleton enumInstance = EnumSingleton.getInstance();
        System.out.println("Double Checked Locking instance: " + enumInstance.getClass().getSimpleName());

    }
}

