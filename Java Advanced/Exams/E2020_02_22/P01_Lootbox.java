package E2020_02_22;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P01_Lootbox {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> fistLootBox = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));
        ArrayDeque<Integer> secondLootBox = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(secondLootBox::push);

        int sumItems = 0;

        while (!fistLootBox.isEmpty() && !secondLootBox.isEmpty()) {
            int sum = fistLootBox.peek() + secondLootBox.peek();
            if (sum % 2 == 0) {
                sumItems += sum;
                fistLootBox.poll();
                secondLootBox.pop();
            } else {
                fistLootBox.offer(secondLootBox.pop());
            }
        }
        if (fistLootBox.isEmpty()) {
            System.out.println("First lootbox is empty");
        } else {
            System.out.println("Second lootbox is empty");
        }
        if (sumItems >= 100) {
            System.out.println("Your loot was epic! Value: " + sumItems);
        } else {
            System.out.println("Your loot was poor... Value: " + sumItems);
        }
    }
}
