package E2020_06_28;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P01_Bombs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque< Integer > effects = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));
        ArrayDeque< Integer > casing = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).forEach(casing::push);

        int countDatura = 0;
        int countCherry = 0;
        int countSmoke = 0;

        while (!effects.isEmpty() && !casing.isEmpty()
                && (countDatura < 3 || countCherry < 3 || countSmoke < 3)) {
            int currentEffects = effects.poll();
            int currentCasing = casing.pop();

            if (currentEffects + currentCasing == 40) {
                countDatura++;
            } else if (currentEffects + currentCasing == 60) {
                countCherry++;
            } else if (currentEffects + currentCasing == 120) {
                countSmoke++;
            } else {
                casing.push(currentCasing - 5);
                effects.offerFirst(currentEffects);
            }
        }

        if (countDatura >= 3 && countCherry >= 3 && countSmoke >= 3) {
            System.out.println("Bene! You have successfully filled the bomb pouch!");
        } else {
            System.out.println("You don't have enough materials to fill the bomb pouch.");
        }

        if (effects.isEmpty()) {
            System.out.println("Bomb Effects: empty");
        } else {
            System.out.printf("Bomb Effects: %s%n", String.join(", ", effects.toString().replaceAll("[\\[\\]]", "")));
        }

        if (casing.isEmpty()) {
            System.out.println("Bomb Casings: empty");
        } else {
            System.out.printf("Bomb Casings: %s%n", String.join(", ", casing.toString().replaceAll("[\\[\\]]", "")));
        }

        System.out.printf("Cherry Bombs: %d%nDatura Bombs: %d%nSmoke Decoy Bombs: %d", countCherry, countDatura, countSmoke);
    }
}
