package Exercises;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class E05_ReverseAndExclude {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        int n = Integer.parseInt(scanner.nextLine());

        Collections.reverse(numbers);

//        Predicate<Integer> predicate = e -> e % n != 0;
//        Function<List<Integer>, List<Integer>> excludeFunc = list -> list.stream().filter()
        numbers.stream()
                .filter(e -> e % n != 0)
//              .filter(predicate::test)
                .forEach(e -> System.out.print(e + " "));
    }
}
