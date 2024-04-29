package Prak1;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Function<int[], String> convert = numbers -> {
            if (numbers == null || numbers.length == 0) {
                return "";
            }
        // преобразует массив numbers в поток (stream) элементов
            String result = Arrays.stream(numbers)
                    .distinct()     //удаляет все дубликаты из потока
                    .sorted()         //сортирует элементы потока
                    .mapToObj(String::valueOf)    //преобразует каждый элемент потока в строку
                    .collect(Collectors.joining()); //собирает элементы потока в единую строку

            return result;
        };

        int[] numbers = {1, 8, 1, 3, 8};
        System.out.println(convert.apply(numbers));
    }
}


