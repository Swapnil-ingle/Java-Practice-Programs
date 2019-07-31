package com.github.swapnil.practice;

import java.util.Scanner;

public class LengthOfLongestSubstring {

	public static void main(String[] args) {
		Scanner sc = null;
		try {
			sc = initScanner(sc);
			String input = getInput(sc);
			
			String result = getLongestNonRepeatingSubString(input);
			
			System.out.println("Longest substring is: " + result);
			System.out.println("Length of longest substring is: " + result.length());
		} catch (Exception e) {
			System.out.println("Error while processing..." + e);
		} finally {
			sc.close();
		}
	}

	private static Scanner initScanner(Scanner sc) {
		return new Scanner(System.in);
	}
	
	private static String getLongestNonRepeatingSubString(String input) {
		/**
		 * Algorithm:
		 *  0. Iterate until the size of the input
		 *  1. Keep adding to buffer until a word is repeated
		 *  2. When a word is repeated --> Check if the maxSubstring was longer
		 *  	than this? --> If yes, replace it with this one
		 *  3. Purge the buffer until the last occurrence of the repeating word
		 *  4. Return the maxString from buffer v/s (last) maxSubstring
		 */
		String maxSubstring = "";
		String buffer = "";
		
		for (int i = 0; i < input.length(); i++) {
			Character ele = input.charAt(i);
			
			if (buffer.contains(ele.toString())) {
				if (maxSubstring.length() < buffer.length()) {
					maxSubstring = buffer;
				}
				buffer = buffer.substring(buffer.indexOf(ele) + 1, buffer.length());
			}
			
			buffer += ele;
		}
		
		return (maxSubstring.length() > buffer.length()) ? maxSubstring : buffer;
	}

	private static String getInput(Scanner sc) {
		System.out.println("Please enter your string.");
		return sc.nextLine();
	}

}
