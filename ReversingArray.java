package com.swapnil.practice;
import java.util.Scanner;

public class ReversingArray {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int input[] = getInput(sc);
		reverseArray(input);
		
		sc.close();
	}

	private static int[] getInput(Scanner sc) {
		System.out.println("Enter your array as: 1 3 4 5 64 3");
		String[] input = sc.nextLine().split(" ");
		int[] intInput = new int[input.length];
		
		for (int i=0; i<input.length; i++) {
			intInput[i] = Integer.parseInt(input[i]);
		}
		
		return intInput;
	}

	private static void reverseArray(int[] array) {
		int reverseArray[] = new int[array.length];
		int reverseArrayIndex = 0;
		
		for (int i = reverseArray.length - 1; i >= 0; i--) {
			reverseArray[reverseArrayIndex] = array[i];
			reverseArrayIndex++;
		}
		
		printArray(reverseArray);
	}

	private static void printArray(int[] reverseArray) {
		for (int i=0; i<reverseArray.length; i++) {
			System.out.print(reverseArray[i]);
		}
	}
}
