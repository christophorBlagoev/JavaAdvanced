package Exercises;

import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;

public class E03_PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        TreeSet<String> chemicalCompounds = new TreeSet<>();

        for (int i = 0; i < number; i++) {
            String[] inputChemicalCompounds = scanner.nextLine().split("\\s+");
            chemicalCompounds.addAll(Arrays.asList(inputChemicalCompounds));
        }

        chemicalCompounds.forEach(s-> System.out.print(String.format(s + " ")));
    }
}
