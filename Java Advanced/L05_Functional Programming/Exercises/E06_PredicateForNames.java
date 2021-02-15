package Exercises;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

public class E06_PredicateForNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int length = Integer.parseInt(scanner.nextLine());
        Predicate<String> lengthName = s -> s.length() <= length;

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .filter(lengthName)
                .forEach(System.out::println);
    }
}
