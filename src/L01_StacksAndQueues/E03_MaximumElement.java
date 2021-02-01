package L01_StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class E03_MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countCommands = Integer.parseInt(scanner.nextLine());

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < countCommands; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String command = tokens[0];
            int number = 0;
            if (tokens.length > 1) {
                number = Integer.parseInt(tokens[1]);
            }
            switch (command) {
                case "1":
                    stack.push(number);
                    break;
                case "2":
                    stack.pop();
                    break;
                case "3":
                    int maxElement = Integer.MIN_VALUE;
                    for (Integer element : stack) {
                        if (element > maxElement) {
                            maxElement = element;
                        }
                    }
                    System.out.println(maxElement);
                    break;
            }
        }
    }
}
