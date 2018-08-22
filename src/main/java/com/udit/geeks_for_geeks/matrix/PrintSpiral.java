package com.udit.geeks_for_geeks.matrix;

/**
 * @author Udit Sharma.
 * @since 25 Apr, 2018 10:01 AM
 */
public class PrintSpiral {
    public static void main(String[] args) {
        int a[][] = {{1, 2, 3, 4, 5, 6},
                {7, 8, 9, 10, 11, 12},
                {13, 14, 15, 16, 17, 18}
        };
        new PrintSpiral().printSpiral(a);
    }

    void printSpiral(int[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        int currentRow = 0, currentColumn = 0;

        while (currentRow < rows && currentColumn < columns) {
            for (int i = currentColumn; i < columns; i++) {
                System.out.print(matrix[currentRow][i] + "\t");
            }
            currentRow++;
            for (int i = currentRow; i < rows; i++) {
                System.out.print(matrix[i][columns - 1] + "\t");
            }
            columns--;
            if (currentRow < rows) {
                for (int i = columns - 1; i >= currentColumn; i--) {
                    System.out.print(matrix[rows - 1][i] + "\t");
                }
                rows--;
            }
            if (currentColumn < columns) {
                for (int i = rows - 1; i >= currentRow; i--) {
                    System.out.print(matrix[i][currentColumn] + "\t");
                }
                currentColumn++;
            }
        }
    }
}
