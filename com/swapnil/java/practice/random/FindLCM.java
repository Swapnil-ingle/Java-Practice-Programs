package com.swapnil.java.practice.random;

import java.util.Scanner;

public class FindLCM {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your numbers: ");
		String[] input = sc.nextLine().split(" ");
		int lcm = findLcm(input);
		
		System.out.println("L.C.M is: " + lcm);
		
		sc.close();
	}
	
	private static int findLcm(String[] input) {
		int firstInt = Integer.parseInt(input[0]);
		int secondInt = Integer.parseInt(input[1]);
		
		if (firstInt < secondInt) {
			return findLcm(firstInt, secondInt);
		}
		
		return findLcm(secondInt, firstInt);
	}

	private static int findLcm(int firstInt, int secondInt) {
		return (firstInt * secondInt) / findGcd(firstInt, secondInt);
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
