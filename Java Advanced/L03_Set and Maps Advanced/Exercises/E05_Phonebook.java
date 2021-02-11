package Exercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class E05_Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> phoneBook = new LinkedHashMap<>();

        String line = "";

        while (!"search".equals(line = scanner.nextLine())) {
            String name = line.split("-")[0];
            String number = line.split("-")[1];
            phoneBook.putIfAbsent(name, number);
        }

        while (!"stop".equals(line = scanner.nextLine())) {
            if (phoneBook.containsKey(line)) {
                System.out.println(String.format("%s -> %s", line,phoneBook.get(line)));
            } else {
                System.out.println(String.format("Contact %s does not exist.", line));;
            }
        }
    }
}
