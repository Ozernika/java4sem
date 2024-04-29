package Prak6.Prototype;

public class ConcretePrototype1 implements Prototype {
    @Override
    public Prototype clone() {
        System.out.println("Prototype1 is cloned!");
        return new ConcretePrototype1();
    }
}

