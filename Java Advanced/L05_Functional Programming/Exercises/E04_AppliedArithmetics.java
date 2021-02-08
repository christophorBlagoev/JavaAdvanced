package Exercises;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;

public class E04_AppliedArithmetics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        Function<int[], int[]> addOne = arr -> Arrays.stream(arr).map(e -> e += 1).toArray();
        Function<int[], int[]> multiplyByTwo = arr -> Arrays.stream(arr).map(e -> e *= 2).toArray();

        Consumer<int[]> printConsumer = arr -> Arrays.stream(arr).forEach(e -> System.out.print(e + " "));

        String command = "";
        while (!"end".equals(command = scanner.nextLine())) {
            switch (command) {
                case "add":
                    numbers = addOne.apply(numbers);
                    break;
                case "multiply":
                    numbers = multiplyByTwo.apply(numbers);
                    break;
                case "subtract":
                    numbers = subtract(numbers);
                    break;
                case "print":
                    printConsumer.accept(numbers);
                    System.out.println();
                    break;
            }
        }
    }

    public  static int[] subtract(int[] numbers) {
        return Arrays.stream(numbers).map(num -> num -= 1).toArray();
    }
}
