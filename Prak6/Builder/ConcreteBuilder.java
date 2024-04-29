package Prak6.Builder;

public class ConcreteBuilder implements Builder {
    @Override
    public void buildPart() {
        System.out.println("Part have been built successfully.");
    }

    public void getResult() {
        System.out.println("Result achieved.");
    }
}

