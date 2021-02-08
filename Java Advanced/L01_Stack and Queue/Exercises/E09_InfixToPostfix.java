package Exercises;

import java.util.ArrayDeque;
import java.util.Scanner;

public class E09_InfixToPostfix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        ArrayDeque<String> stack = new ArrayDeque<>();
        ArrayDeque<String> queue = new ArrayDeque<>();

        for (String s : input) {
            if (!"-+/*()".contains(s)) {
                queue.offer(s);
            } else if (s.equals("(")) {
                stack.push(s);
            } else if (s.equals(")") && (!stack.isEmpty() && !stack.peek().equals("("))) {
                queue.offer(stack.pop());
                stack.pop();
            }
            else {
                if ("-+".contains(s)) {
                    while (!stack.isEmpty() && !stack.peek().equals("(")) {
                        queue.offer(stack.pop());
                    }
                } else {
                    while (!stack.isEmpty() && !"-+(".contains(stack.peek())) {
                        queue.offer(stack.pop());
                    }
                }

                stack.push(s);
            }
        }

        while (!stack.isEmpty()) {
            queue.offer(stack.pop());
        }

        System.out.println(String.join(" ", queue));
    }
}
