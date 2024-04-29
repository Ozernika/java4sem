package Prak6.FabricMethod;

public class ConcreteCreator extends Creator {
    @Override
    Product factoryMethod() {
        return new ConcreteProduct();
    }
}

