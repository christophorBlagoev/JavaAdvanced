package Exercises;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class E04_CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<Character, Integer> charOccurrences = new TreeMap<>();

        for (int i = 0; i < input.length(); i++) {
            char symbol = input.charAt(i);
            charOccurrences.putIfAbsent(symbol, 0);
            charOccurrences.put(symbol, charOccurrences.get(symbol) + 1);
        }

        charOccurrences.forEach((k,v) -> System.out.println(String.format("%c: %d time/s", k, v)));
    }
}
