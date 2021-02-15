package Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class E11_ReverseMatrixDiagonals {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[][] matrix = readMatrix(reader);
        int currentRow = matrix.length - 1;
        int currentCol = matrix[currentRow].length - 1;

        while (currentCol >= 0) {
            printDiagonals(currentCol, currentRow, matrix);
            if (currentCol == 0) {
                currentRow--;
                while (currentRow >= 0) {
                    printDiagonals(currentCol, currentRow, matrix);
                    currentRow--;
                }
            }

            currentCol--;
        }
    }

    private static void printDiagonals(int currentCol, int currentRow, int[][] matrix) {
        int increaseCol = 0;
        for (int i = currentRow; i >= 0; i--) {
            if (currentCol + increaseCol < matrix[currentRow].length) {
                System.out.printf("%d ", matrix[i][currentCol + increaseCol]);
            } else {
                break;
            }

            increaseCol++;
        }

        System.out.println();
    }

    private static int[][] readMatrix(BufferedReader reader) throws IOException {
        int[] size = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[][] matrix = new int[size[0]][size[1]];
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        }

        return matrix;
    }
}
