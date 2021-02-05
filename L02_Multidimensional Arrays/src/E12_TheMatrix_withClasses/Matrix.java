package E12_TheMatrix_withClasses;

import java.util.List;

public class Matrix {
    private int rows;
    private int cols;
    private char[][] matrix;

    public Matrix(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.matrix = new char[this.rows][this.cols]
    }

    public void setMatrix(List< String > lines) {
        for (int i = 0; i < lines.size(); i++) {

        }
    }

    public char getCell(int row, int col) {
        return this.matrix[row][col];
    }

    public void setCell(int row, int col, char fillColor) {
    }

    public boolean isOutOfBounds(int row, int col) {
        return row >= rows || row < 0 || col >= cols || col < 0;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
    }
}
