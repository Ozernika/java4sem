package Prak6.Prototype;

public class ConcretePrototype2 implements Prototype {
    @Override
    public Prototype clone() {
        System.out.println("Prototype2 is cloned!");
        return new ConcretePrototype2();
    }
}

