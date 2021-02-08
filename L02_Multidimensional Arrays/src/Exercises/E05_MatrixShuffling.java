package Exercises;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class E05_MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] input = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int rowSize = input[0];
        int colSize = input[1];

        String[][] array = new String[rowSize][];

        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextLine().split("\\s+");
        }

        String pattern = "^swap (\\d+) (\\d+) (\\d+) (\\d+)$";
        Pattern patternCompile = Pattern.compile(pattern);
        String command = scanner.nextLine();

        while (!"END".equals(command)) {
            boolean isValid = true;
            Matcher matcher = patternCompile.matcher(command);

            if (matcher.matches()) {
                int row1 = Integer.parseInt(matcher.group(1));
                int col1 = Integer.parseInt(matcher.group(2));
                int row2 = Integer.parseInt(matcher.group(3));
                int col2 = Integer.parseInt(matcher.group(4));

                boolean isInArray = row1 >= 0 && row1 < rowSize && row2 >= 0 && row2 < rowSize
                        && col1 >= 0 && col1 < colSize && col2 >= 0 && col2 < colSize;

                if (isInArray) {
                    String temp = array[row1][col1];
                    array[row1][col1] = array[row2][col2];
                    array[row2][col2] = temp;
                    printArray(array);
                } else {
                    isValid = false;
                }

            } else {
                isValid = false;
            }

            if (!isValid) {
                System.out.println("Invalid input!");
            }

            command = scanner.nextLine();
        }
    }

    private static void printArray(String[][] array) {
        for (String[] row : array) {
            for (String element : row) {
                System.out.printf("%s ", element);
            }
            System.out.println();
        }
    }
}
