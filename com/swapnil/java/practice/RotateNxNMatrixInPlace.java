package com.swapnil.java.practice;

public class RotateNxNMatrixInPlace {
	private static final int[][] TWO_BY_TWO_MATRIX = {
            {1, 2},
            {3, 4}
    };

    private static final int[][] THREE_BY_THREE_MATRIX = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
    };

    private static final int[][] FOUR_BY_FOUR_MATRIX = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16}
    };

    private static final int[][] FIVE_BY_FIVE_MATRIX = {
            {1, 2, 3, 4, 5},
            {6, 7, 8, 9, 10},
            {11, 12, 13, 14, 15},
            {16, 17, 18, 19, 20},
            {21, 22, 23, 24, 25}
    };

    public static void main(String[] args) {
        int[][] matrix = FOUR_BY_FOUR_MATRIX;

        System.out.println("===== Before Rotation =====");
        printMatrix(matrix);
        System.out.println("===== After Rotation =====");
        printMatrix(rotateMatrix(matrix));
    }

    private static int[][] rotateMatrix(int[][] matrix) {
        int n = matrix.length;

        for (int layer = 0; layer < (n / 2); layer++) {
            int lastRowOrCol = n - layer - 1;
            int firstRowOrCol = layer;

            for (int i = 0; i < (lastRowOrCol - firstRowOrCol); i++) {
                // top --> temp
                int temp = matrix[firstRowOrCol][i + layer];
                // left --> top
                matrix[firstRowOrCol][i + layer] = matrix[lastRowOrCol - i][firstRowOrCol];
                // bottom --> left
                matrix[lastRowOrCol - i][firstRowOrCol] = matrix[lastRowOrCol][lastRowOrCol - i];
                // right --> bottom
                matrix[lastRowOrCol][lastRowOrCol - i] = matrix[i + layer][lastRowOrCol];
                // temp --> right
                matrix[i + layer][lastRowOrCol] = temp;
            }
        }

        return matrix;
    }

    private static void printMatrix(int[][] input) {
        for (int row = 0; row < input.length; row++) {
            for (int col = 0; col < input.length; col++) {
                System.out.print(" | " + input[row][col] + " | ");
            }
            System.out.println("");
        }
    }
}
