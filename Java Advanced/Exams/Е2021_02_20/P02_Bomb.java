import java.util.Scanner;

public class P02_Bomb {

    static int rowMatrix;
    static int colMatrix;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        String[] data = scanner.nextLine().split(",");
        char[][] matrix = readMatrix(scanner, size);
        int bombs = remainingBombs(matrix);

        for (String cmd : data) {
            matrix[rowMatrix][colMatrix] = '+';
            switch (cmd) {
                case "up":
                    rowMatrix--;
                    if (rowMatrix < 0) {
                        rowMatrix++;
                    }
                    break;
                case "down":
                    rowMatrix++;
                    if (rowMatrix >= matrix.length) {
                        rowMatrix--;
                    }
                    break;
                case "left":
                    colMatrix--;
                    if (colMatrix < 0) {
                        colMatrix++;
                    }
                    break;
                case "right":
                    colMatrix++;
                    if (colMatrix >= matrix.length) {
                        colMatrix--;
                    }
                    break;
            }
            if (matrix[rowMatrix][colMatrix] == 'e') {
                System.out.printf("END! %d bombs left on the field%n", bombs);
                return;
            } else if (matrix[rowMatrix][colMatrix] == 'B') {
                System.out.println("You found a bomb!");
                bombs--;
            }
            matrix[rowMatrix][colMatrix] = 's';
            if (bombs == 0) {
                break;
            }
        }
        if (bombs > 0) {
            System.out.printf("%d bombs left on the field. Sapper position: (%d,%d)%n", bombs, rowMatrix, colMatrix);
        } else {
            System.out.println("Congratulations! You found all bombs!");
        }
    }

    public static int remainingBombs(char[][] matrix) {
        int count = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 'B') {
                    count++;
                }
            }
        }
        return count;
    }

    private static char[][] readMatrix(Scanner scanner, int size) {
        char[][] charMatrix = new char[size][size];
        for (int row = 0; row < charMatrix.length; row++) {
            String input = scanner.nextLine();
            input = input.replaceAll("\\s+", "");
            charMatrix[row] = input.toCharArray();
            if (input.contains("s")) {
                rowMatrix = row;
                colMatrix = input.indexOf("s");
            }
        }
        return charMatrix;
    }
}