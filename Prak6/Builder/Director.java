package Prak6.Builder;

public class Director {
    Builder builder;

    Director(Builder builder) {
        this.builder = builder;
    }
    void construct() {
        builder.buildPart();
    }
}

