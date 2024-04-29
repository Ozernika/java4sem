package Prak6.AbstractFabric;

public class Client {

    private final AbstractProduct concreteProductA;
    private final AbstractProduct concreteProductB;
    private AbstractFactory factory;

    // Конструктор, принимающий фабрику
    public Client(AbstractFactory factory) {
        this.factory = factory;
        concreteProductA = factory.createProductA();
        concreteProductB = factory.createProductB();
    }
}



