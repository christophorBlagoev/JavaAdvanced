package Lab;

import java.util.Arrays;
import java.util.Scanner;

public class E01_CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] firstMatrix = readMatrix(scanner);
        int[][] secondMatrix = readMatrix(scanner);

        boolean areNotEqual = firstMatrix.length != secondMatrix.length;

        if (!areNotEqual) {
            for (int row = 0; row < firstMatrix.length; row++) {
                int[] firstArr = firstMatrix[row];
                int[] secondArr = secondMatrix[row];
                areNotEqual = firstArr.length != secondArr.length;
                if (!areNotEqual) {
                    for (int col = 0; col < firstArr.length; col++) {
                        if (firstArr[col] != secondArr[col]){
                            areNotEqual = true;
                            break;
                        }
                    }
                }

                if (areNotEqual){
                    break;
                }
            }

        }

        String output = areNotEqual ? "not equal" : "equal";

        System.out.println(output);
    }


    private static int[][] readMatrix(Scanner scanner) {
        int[] rowsAndCols = reedArray(scanner);

        int rows = rowsAndCols[0];
        int cols = rowsAndCols[1];

        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            matrix[i] = reedArray(scanner);
        }

        return matrix;
    }

    private static int[] reedArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
