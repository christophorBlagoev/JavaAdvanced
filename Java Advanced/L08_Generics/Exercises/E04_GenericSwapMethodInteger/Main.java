package Exercises.E04_GenericSwapMethodInteger;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Box<Integer> box = new Box<>();

        IntStream.range(0, n).map(i -> Integer.parseInt(scanner.nextLine())).forEach(box::add);

        int[] indexes = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        box.swap(indexes[0], indexes[1]);

        System.out.println(box.toString());
    }
}
