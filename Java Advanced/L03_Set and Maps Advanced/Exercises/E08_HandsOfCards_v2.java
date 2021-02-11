package Exercises;

import java.util.*;

public class E08_HandsOfCards_v2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Set<String> > playersInfo = new LinkedHashMap<>();
        String input = "";

        while (!"JOKER".equals(input = scanner.nextLine())) {
            String[] data = input.split(": ");
            String[] cards = data[1].split(", ");
            playersInfo.putIfAbsent(data[0], new HashSet<>());
            playersInfo.get(data[0]).addAll(Arrays.asList(cards.clone()));
        }

        playersInfo.forEach((k, v) -> System.out.printf("%s: %d%n", k, getSumOfCards(v)));
    }

    private static int getSumOfCards(Set<String> value) {
        int sum = 0;
        for (String s : value) {
            char type = s.charAt(s.length() - 1);
            String power = s.substring(0, s.length() - 1);

            int multiplied = 0;
            //S -> 4, H-> 3, D -> 2, C -> 1
            switch (type) {
                case 'S':
                    multiplied = 4;
                    break;
                case 'H':
                    multiplied = 3;
                    break;
                case 'D':
                    multiplied = 2;
                    break;
                case 'C':
                    multiplied = 1;
                    break;
            }

            int powerNumber = 0;
            //J to A are 11 to 14
            switch (power) {
                case "J":
                    powerNumber = 11;
                    break;
                case "Q":
                    powerNumber = 12;
                    break;
                case "K":
                    powerNumber = 13;
                    break;
                case "A":
                    powerNumber = 14;
                    break;
                default:
                    powerNumber = Integer.parseInt(power);
                    break;
            }

            sum += powerNumber * multiplied;
        }

        return sum;
    }
}
