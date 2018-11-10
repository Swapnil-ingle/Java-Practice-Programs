package com.swapnil.practice;

import java.util.Scanner;

public class FibonacciSeries {
	public static void main (String args[]) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Upto which number do you wish to see the fibonacci");
		int number = scan.nextInt();
		System.out.println(fibonacci(number));
		scan.close();
	}
	
	public static int fibonacci(int n) {
		if (n == 1 || n == 2) {
			return 1;
		} else {
			return fibonacci(n-1) + fibonacci(n-2);
		}
	}
}
