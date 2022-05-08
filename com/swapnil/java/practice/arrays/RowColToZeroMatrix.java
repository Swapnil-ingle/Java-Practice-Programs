package com.swapnil.java.practice.arrays;

public class RowColToZeroMatrix {
	
	private static final int[][] THREE_BY_THREE_MATRIX = {
            {1, 0, 1, 1},
            {4, 5, 6, 1},
            {7, 0, 1, 1}
    };

	public static void main(String[] args) {
		System.out.println("=== Before ===");
		printMatrix(THREE_BY_THREE_MATRIX);
		System.out.println("=== After ===");
		printMatrix(makeRowColOfZeroToZero(THREE_BY_THREE_MATRIX));
	}

	private static int[][] makeRowColOfZeroToZero(int[][] matrix) {
		int[] zerosForRow = new int[matrix.length];
		int[] zerosForCol = new int[matrix[0].length];
		
		for (int row = 0; row < matrix.length; row++) {
			for (int col = 0; col < matrix[0].length; col++) {
				int ele = matrix[row][col];
				
				if (ele == 0) {
					zerosForRow[row] = -1;
					zerosForCol[col] = -1;
				}
			}
		}
		
		for (int row = 0; row < matrix.length; row++) {
			for (int col = 0; col < matrix[0].length; col++) {
				if (zerosForRow[row] == -1 || zerosForCol[col] == -1) {
					matrix[row][col] = 0;
				}
			}
		}
		
		return matrix;
	}
	
	private static void printMatrix(int[][] input) {
        for (int row = 0; row < input.length; row++) {
            for (int col = 0; col < input[0].length; col++) {
                System.out.print(" | " + input[row][col] + " | ");
            }
            System.out.println("");
        }
    }
}
