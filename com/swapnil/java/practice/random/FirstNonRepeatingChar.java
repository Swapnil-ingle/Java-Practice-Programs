package com.swapnil.java.practice.random;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FirstNonRepeatingChar {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your String...");
		String input = sc.nextLine();
		
		Character output = firstNonRepeatingChar(input);
		
		if (output == null) {
			System.out.println("Not a single non-repeating character found");
		} else {
			System.out.println("First non-repeating character is: " + output);
		}
		
		sc.close();
	}

	private static Character firstNonRepeatingChar(String input) {
		List<Character> occuredChars = new ArrayList<>();
		
		for (int i=0; i< input.length() -1; i++) {

			if (!charIsPresentInResidueString(input, i) && !occuredChars.contains(input.charAt(i))) {
				return input.charAt(i);
			}
			
			if (!occuredChars.contains(input.charAt(i))) {
				occuredChars.add(input.charAt(i));
			}
		}
		
		return null;
	}

	private static boolean charIsPresentInResidueString(String input, int i) {
		for (int j=i+1; j<input.length(); j++) {
			if (input.charAt(i) == input.charAt(j)) {
				return true;
			}
		}
		return false;
	}

}
