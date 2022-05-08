package com.swapnil.java.practice.arrays;

public class RotateNbyNMatrix {

	public static void main(String[] args) {
		int[][] inputMatrix = new int[3][3];
		inputMatrix[0][0] = 1;
		inputMatrix[0][1] = 2;
		inputMatrix[0][2] = 3;
		inputMatrix[1][0] = 4;
		inputMatrix[1][1] = 5;
		inputMatrix[1][2] = 6;
		inputMatrix[2][0] = 7;
		inputMatrix[2][1] = 8;
		inputMatrix[2][2] = 9;

		System.out.println("=========== Before rotation =========== ");
		printMatrix(inputMatrix);
		System.out.println("=========== After rotation =========== ");
		printMatrix(rotateMatrix(inputMatrix));
	}
	
	private static int[][] rotateMatrix(int[][] input) {
		int n = input[0].length;
		int[][] newMatrix = new int[n][n];
		
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < n; c++) {
				int ele = input[r][c];
				newMatrix[n - (c + 1)][r] = ele;
			}
		}
		
		return newMatrix;
	}
	
	public static void printMatrix(int[][] matrix) {
		int n = matrix[0].length;

		for (int r = 0; r < n; r++) {
			for (int c = 0; c < n; c++) {
				System.out.print(" | " + matrix[r][c]);
			}
			System.out.println(" | ");
		}
	}

	public static void printMatrix(boolean[][] matrix) {
		for (int r = 0; r < matrix.length; r++) {
			for (int c = 0; c < matrix[0].length; c++) {
				System.out.print(" | " + matrix[r][c]);
			}
			System.out.println(" | ");
		}
	}
}
