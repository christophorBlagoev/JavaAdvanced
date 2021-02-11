package Exercises.P03_StackIterator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        CustomStack customStack = new CustomStack();
        String[] input = scanner.nextLine().split(", ");

        customStack.push(Integer.parseInt(input[0].split("\\s+")[1]));
        for (int i = 1; i < input.length ; i++) {
            customStack.push(Integer.parseInt(input[i].trim()));
        }

        String line = "";

        while (!"END".equals(line = scanner.nextLine())) {
            if (line.equals("Pop")) {
                try {
                    customStack.pop();
                } catch (IllegalStateException e) {
                    System.out.println(e.getMessage());
                }
            } else {
                customStack.push(Integer.parseInt(line.split("\\s+")[1]));
            }
        }

        for (int i = 0; i < 2; i++) {
            for (Integer element : customStack) {
                System.out.println(element);
            }
        }
    }
}
