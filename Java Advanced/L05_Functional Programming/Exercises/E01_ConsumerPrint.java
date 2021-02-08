package Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class E01_ConsumerPrint {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .forEach(name -> System.out.println(name));

    }
}
