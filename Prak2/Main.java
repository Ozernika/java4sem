package Prak2;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // Создаем список из объектов класса Human
        List<Human> humans = new ArrayList<>();
        humans.add(new Human(24, "John", "Doe", LocalDate.of(1999, 5, 13), 73));
        humans.add(new Human(18, "Maria", "Lane", LocalDate.of(2005, 10, 27), 58));
        humans.add(new Human(23, "Karen", "Gillan", LocalDate.of(2000, 6, 27), 58));
        humans.add(new Human(32, "Alice", "Smith", LocalDate.of(1991, 8, 8), 62));
        humans.add(new Human(38, "Bob", "Johnson", LocalDate.of(1986, 3, 11), 81));

        System.out.println("Исходный список:");
        humans.forEach(System.out::println);
        System.out.println();

        //фильтрация по дате рождения
        List<Human> bornAfter2000 = humans.stream()
                .filter(human -> human.getBirthDate().isAfter(LocalDate.of(2000, 6, 24)))
                .collect(Collectors.toList());
        System.out.println("Люди, родившиеся после 24 июня 2000 года:");
        bornAfter2000.forEach(System.out::println);
        System.out.println();

        // Сортировка по имени
        List<Human> sortedByName = humans.stream()
                .sorted((h1, h2) -> h1.getFirstName().compareTo(h2.getFirstName()))
                .collect(Collectors.toList());
        System.out.println("Люди, отсортированные по имени:");
        sortedByName.forEach(System.out::println);
        System.out.println();

        // Сортировка по фамилии
        List<Human> sortedByLastName = humans.stream()
                .sorted((h1, h2) -> h1.getLastName().compareTo(h2.getLastName()))
                .collect(Collectors.toList());
        System.out.println("Люди, отсортированные по фамилии:");
        sortedByLastName.forEach(System.out::println);
        System.out.println();

        // Нахождение суммы всех возрастов
        int totalAge = humans.stream()
                .mapToInt(Human::getAge)
                .sum();
        System.out.println("Сумма всех возрастов: " + totalAge);
    }

}


