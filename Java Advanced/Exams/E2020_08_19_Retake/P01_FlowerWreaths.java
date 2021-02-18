package E2020_08_19_Retake;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P01_FlowerWreaths {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> lilies = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).forEach(lilies::push);
        ArrayDeque<Integer> roses = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));

        int leftFlowers = 0;
        int countWreaths = 0;

        while (lilies.peek() != null && roses.peek() != null) {
            int sumRosesAndLilies = lilies.pop() + roses.poll();

            while (sumRosesAndLilies > 15) {
                sumRosesAndLilies -= 2;
            }
            if (sumRosesAndLilies == 15) {
                countWreaths++;
            } else {
                leftFlowers += sumRosesAndLilies;
            }
        }
        countWreaths += leftFlowers / 15;

        if (countWreaths >= 5) {
            System.out.printf("You made it, you are going to the competition with %d wreaths!", countWreaths);
        } else {
            System.out.printf("You didn't make it, you need %d wreaths more!", 5 - countWreaths);
        }
    }
}
