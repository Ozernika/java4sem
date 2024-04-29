package Prak6.Builder;

public class BuilderTest {
    public static void main(String[] args) {

        Builder builder = new ConcreteBuilder();
        Director director = new Director(builder);
        director.construct();

        // Получение результата от строителя
        ((ConcreteBuilder) builder).getResult();
    }
}

