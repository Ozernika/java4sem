package Prak6.AbstractFabric;

public class ConcreteFactory implements AbstractFactory {
    @Override
    public AbstractProduct createProductA() {
        System.out.println("Создан продукт А");
        return new ConcreteProduct();
    }

    @Override
    public AbstractProduct createProductB() {
        System.out.println("Создан продукт B");
        return new ConcreteProduct();
    }
}


