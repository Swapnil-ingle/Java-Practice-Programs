package com.swapnil.java.practice.random;

public class FizzBuzz {
	public static final String FIZZ = "FIZZ";
	
	public static final String BUZZ = "BUZZ";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i=1; i<=100; i++) {
			System.out.print(" " + getResult(i) + " ");
			if (i % 10 == 0) {
				System.out.println("");
			}
		}
	}

	private static String getResult(int currNum) {
		if ((currNum % 3 == 0) && (currNum % 5 == 0)) {
			return FIZZ+BUZZ;
		} else if (currNum % 3 == 0) {
			return FIZZ;
		} else if (currNum % 5 == 0) {
			return BUZZ;
		}
	
		return Integer.toString(currNum);
	}

}
