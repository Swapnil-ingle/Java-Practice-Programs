package com.swapnil.java.practice.random;

import java.util.Scanner;

public class MakeChange {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the total sum: ");
		int sum = sc.nextInt();
		
		int[] output = findChange(new String[4], sum);
		printOutput(output);
		
		sc.close();
	}

	private static int[] findChange(String[] changeCoins, int sum) {
		int[] change = getChangeIntoArray(changeCoins);
		int[] outputChange = new int[change.length];
		
		for (int i=0; i<change.length; i++) {
			if ((sum / change[i] > 0) && sum > 0) {
				outputChange[i] = sum / change[i];
				sum = sum - (change[i] * outputChange[i]);
			}
		}
		
		return outputChange;
	}

	private static int[] getChangeIntoArray(String[] change) {
		//Arrays.asList(change);
		// TODO: Implement sorting logic
		return new int[] {10,5,2,1};
	}
	
	private static void printOutput(int[] output) {
		int[] notes = new int[] {10,5,2,1};
		
		for (int i=0; i<output.length; i++) {
			System.out.println("Note: " + notes[i] + " Sum: " + output[i]);
		}
	}

}
