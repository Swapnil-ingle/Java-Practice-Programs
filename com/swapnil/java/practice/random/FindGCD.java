package com.swapnil.java.practice.random;

import java.util.Scanner;

public class FindGCD {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Please enter your numbers: ");
		String input[] = sc.nextLine().split(" ");
		
		int gcd = findGcd(input);
		
		System.out.println("Gcd is: " + gcd);
		sc.close();
	}

	private static int findGcd(String[] input) {
		int firstInt = Integer.parseInt(input[0]);
		int secondInt = Integer.parseInt(input[1]);
		
		if (firstInt < secondInt) {
			return findGcd(firstInt, secondInt);
		}
		
		return findGcd(secondInt, firstInt);
	}
	
	private static int findGcd(int smallerInt, int biggerInt) {
		for (int i=smallerInt; i>0; i--) {
			if ((smallerInt % i == 0) && (biggerInt % i == 0)) {
				return i;
			}
		}
		
		return 1;
	}
}
