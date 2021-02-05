package Lab;

import java.util.Scanner;

public class E03_IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());

        char[][] firstMatrix = new char[rows][cols];
        char[][] secondMatrix = new char[rows][cols];

        for (int row = 0; row < rows; row++) {
            firstMatrix[row] = scanner.nextLine()
                    .replaceAll("\\s+", "")
                    .toCharArray();
        }
        for (int row = 0; row < rows; row++) {
            secondMatrix[row] = scanner.nextLine()
                    .replaceAll("\\s+", "")
                    .toCharArray();
        }

        char [][] finalMatrix = new char[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                char firstSymbol = firstMatrix[row][col];
                char secondSymbol = secondMatrix[row][col];
                finalMatrix[row][col] = firstSymbol == secondSymbol ? firstSymbol : '*';
            }
        }

        printMatrix(finalMatrix);
    }

    private static void printMatrix(char[][] firstMatrix) {
        for (int row = 0; row < firstMatrix.length; row++) {
            for (int col = 0; col < firstMatrix[row].length; col++) {
                System.out.print(firstMatrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
