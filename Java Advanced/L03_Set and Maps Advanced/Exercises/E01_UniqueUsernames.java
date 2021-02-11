package Exercises;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class E01_UniqueUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nameCount = Integer.parseInt(scanner.nextLine());

        Set<String> name = new LinkedHashSet<>();

        for (int i = 0; i < nameCount; i++) {
            String inputName = scanner.nextLine();
            name.add(inputName);
        }

        name.forEach(System.out::println);
    }
}
