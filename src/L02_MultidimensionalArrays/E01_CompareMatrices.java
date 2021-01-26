package L02_MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class E01_CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] rowsAndCols = reedArray(scanner);

        int row = rowsAndCols[0];
        int col = rowsAndCols[1];

        int[][] matrix = new int[row][col];

        for (int i = 0; i < row; i++) {
            matrix[i] = reedArray(scanner);
        }

        reedArray(scanner);
    }

    private static int[] reedArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
