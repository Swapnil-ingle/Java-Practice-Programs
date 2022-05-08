package com.swapnil.java.practice.random;

import java.util.Scanner;

public class FindCoPrime {
	// CoPrime numbers are numbers 
	// that have common factor
	// as 1 only.

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the two numbers: ");
		String[] input = sc.nextLine().split(" ");
		
		try {
			if (areCoPrime(input)) {
				System.out.println("Yes, these numbers are co-prime indeed!");
			} else {
				System.out.println("These are not co-prime numbers.");
			}
		} catch (Exception e) {
			System.out.println("Exception occured: " + e);
		}
		sc.close();
	}

	private static boolean areCoPrime(String[] input) {
		int firstInt = Integer.parseInt(input[0]);
		int secondInt = Integer.parseInt(input[1]);
		
		if (firstInt < secondInt) {
			return areCoPrime(firstInt, secondInt);
		} 
		
		return areCoPrime(secondInt, firstInt);
	}

	private static boolean areCoPrime(int smallerInt, int biggerInt) {
		for (int i=2; i<=smallerInt/2; i++) {
			if ((smallerInt % i  == 0) && (biggerInt % i == 0)) {
				return false;
			}
		}
		return true;
	}
}
