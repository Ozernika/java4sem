package Prak6.Prototype;

public class PrototypeTest {
    public static void main(String[] args) {
        // Создаем экземпляры прототипов
        Prototype prototype1 = new ConcretePrototype1();
        Prototype prototype2 = new ConcretePrototype2();

        // Создаем клиентов и устанавливаем прототипы
        Client client1 = new Client(prototype1);
        Client client2 = new Client(prototype2);

        // Клонируем прототипы с помощью клиентов
        Prototype clonedPrototype1 = client1.getPrototype().clone();
        Prototype clonedPrototype2 = client2.getPrototype().clone();

        // Выводим информацию о клонированных прототипах
        System.out.println("Cloned Prototype 1: " + clonedPrototype1.getClass().getSimpleName());
        System.out.println("Cloned Prototype 2: " + clonedPrototype2.getClass().getSimpleName());
    }
}

