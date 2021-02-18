package E2020_06_28;

import java.util.Arrays;
import java.util.Scanner;

public class P02_Snake {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[][] territory = readMatrix(scanner, Integer.parseInt(scanner.nextLine()));
        int countFood = 0;
        int[] currentPosition = findIndexes(territory, 'S');

        while (countFood < 10) {
            String input = scanner.nextLine();
            territory[currentPosition[0]][currentPosition[1]] = '.';

            switch (input) {
                case "up":
                    currentPosition[0]--;
                    break;
                case "down":
                    currentPosition[0]++;
                    break;
                case "left":
                    currentPosition[1]--;
                    break;
                case "right":
                    currentPosition[1]++;
                    break;
            }

            if (indexIsInTerritory(currentPosition, territory)) {
                if (territory[currentPosition[0]][currentPosition[1]] == '*') {
                    countFood++;
                    territory[currentPosition[0]][currentPosition[1]] = 'S';
                } else if (territory[currentPosition[0]][currentPosition[1]] == 'B') {
                    territory[currentPosition[0]][currentPosition[1]] = '.';
                    currentPosition = findIndexes(territory, 'B');
                }
            } else {
                break;
            }
        }

        if (countFood < 10) {
            System.out.println("Game over!");
        } else {
            System.out.println("You won! You fed the snake.");
        }

        System.out.println("Food eaten: " + countFood);
        printTerritory(territory);
    }

    private static void printTerritory(char[][] territory) {
        Arrays.stream(territory).map(row -> Arrays.toString(row).replaceAll("[\\[\\]]", "")
                .replaceAll(", ", "")).forEach(System.out::println);
    }

    private static boolean indexIsInTerritory(int[] currentPosition, char[][] territory) {
        return currentPosition[0] >= 0 && currentPosition[0] < territory.length
                && currentPosition[1] >= 0 && currentPosition[1] < territory.length;
    }

    private static int[] findIndexes(char[][] matrix, char toFind) {
        int[] indexes = new int[2];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == toFind) {
                    indexes[0] = row;
                    indexes[1] = col;
                }
            }
        }
        return indexes;
    }

    private static char[][] readMatrix(Scanner scanner, int n) {
        char[][] matrix = new char[n][n];
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().replaceAll("\\s+", "").toCharArray();
        }
        return matrix;
    }
}
