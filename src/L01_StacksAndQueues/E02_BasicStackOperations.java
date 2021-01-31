package L01_StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class E02_BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split("\\s+");
        int pushElements = Integer.parseInt(tokens[0]);
        int popElements = Integer.parseInt(tokens[1]);
        int number = Integer.parseInt(tokens[2]);

        String[] stackAsString = scanner.nextLine().split("\\s+");
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < pushElements; i++) {
            stack.push(Integer.parseInt(stackAsString[i]));
        }

        for (int i = 0; i < popElements; i++) {
            stack.pop();
        }

        if (!stack.isEmpty()) {
            if (stack.contains(number)) {
                System.out.println("true");
            } else {
                int minNumber = Integer.MAX_VALUE;
                for (Integer integer : stack) {
                    if (integer < minNumber) {
                        minNumber = integer;
                    }
                }
                System.out.println(minNumber);
            }
        } else {
            System.out.println("0");
        }
    }
}
