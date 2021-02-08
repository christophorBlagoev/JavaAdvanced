package Exercises;

import java.util.ArrayDeque;
import java.util.Scanner;

public class E08_SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        ArrayDeque< String > inputText = new ArrayDeque<>();
        StringBuilder text = new StringBuilder();

        for (int i = 0; i < n; i++) {
            String[] command = scanner.nextLine().split("\\s+");

            switch (command[0]) {
                case "1":
                    inputText.push(text.toString());
                    text.append(command[1]);
                    break;
                case "2":
                    inputText.push(text.toString());
                    text.delete(text.length() - Integer.parseInt(command[1]), text.length());
                    break;
                case "3":
                    System.out.println(text.charAt(Integer.parseInt(command[1]) - 1));
                    break;
                case "4":
                    text = new StringBuilder(inputText.pop());
                    break;
            }
        }
    }
}
