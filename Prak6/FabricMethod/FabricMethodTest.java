package Prak6.FabricMethod;

public class FabricMethodTest {
    public static void main(String[] args) {
        // Создание экземпляра конкретного создателя
        Creator creator = new ConcreteCreator();

        // Использование фабричного метода для создания продукта
        Product product = creator.factoryMethod();

        // Выполнение операции с продуктом
        creator.anOperation();

        // Вывод информации о продукте
        System.out.println("Product created: " + product.getClass().getSimpleName());
    }
}
