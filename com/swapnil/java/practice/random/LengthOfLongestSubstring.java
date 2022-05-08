package com.swapnil.java.practice.random;

import java.util.HashMap;
import java.util.Scanner;

public class LengthOfLongestSubstring {

	public static void main(String[] args) {
		Scanner sc = null;
		try {
			sc = initScanner(sc);
			String input = getInput(sc);
			
			String result = getLongestNonRepeatingSubString1(input);
			
			System.out.println("Longest substring is: " + result);
			System.out.println("Length of longest substring is: " + result.length());
		} catch (Exception e) {
			System.out.println("Error while processing...");
			e.printStackTrace();
		} finally {
			sc.close();
		}
	}

	private static Scanner initScanner(Scanner sc) {
		return new Scanner(System.in);
	}
	
	//
	// Commented out the less efficient method
	//
//	private static String getLongestNonRepeatingSubString(String input) {
//		/**
//		 * Algorithm:
//		 *  0. Iterate until the size of the input
//		 *  1. Keep adding to buffer until a word is repeated
//		 *  2. When a word is repeated --> Check if the maxSubstring was longer
//		 *  	than this? --> If yes, replace it with this one
//		 *  3. Purge the buffer until the last occurrence of the repeating word
//		 *  4. Return the maxString from buffer v/s (last) maxSubstring
//		 */
//		String maxSubstring = "";
//		String buffer = "";
//		
//		for (int i = 0; i < input.length(); i++) {
//			Character ele = input.charAt(i);
//			
//			if (buffer.contains(ele.toString())) {
//				if (maxSubstring.length() < buffer.length()) {
//					maxSubstring = buffer;
//				}
//				buffer = buffer.substring(buffer.indexOf(ele) + 1, buffer.length());
//			}
//			
//			buffer += ele;
//		}
//		
//		return (maxSubstring.length() > buffer.length()) ? maxSubstring : buffer;
//	}
	
	private static String getLongestNonRepeatingSubString1(String input) {
		/**
		 * Algorithm:
		 *  0. Iterate until the size of the input
		 *  1. Add in visited HashMap as <char, index>
		 *  2. Set starting point 'startPnt' as the starting point of current buffer
		 *  3. If a word is present in the HashMap --> Check if it's >= startPnt
		 *  4. if (maxLen < currentIdx - currStartPoint) --> Update it and save the current Start Point as MaxStartPoint
		 *  5. For next substring --> set the startPoint to idx of last occurrence of currentElement
		 *  6. Return input.subString(maxStartPoint, maxStartPoint + maxLen)
		 */
		int maxLen = 0;
		HashMap<String, Integer> visited = new HashMap<>();
		int startPnt = 0;
		int maxStartPnt = 0;
		
		for (int i = 0; i < input.length(); i++) {
			Character ele = input.charAt(i);
			
			if (visited.get(ele.toString()) != null && visited.get(ele.toString()) >= startPnt) {
				if (maxLen < (i - startPnt)) {
					maxLen = (i - startPnt);
					maxStartPnt = startPnt;
				}
				startPnt = visited.get(ele.toString()) + 1;
			}
			
			visited.put(ele.toString(), i);
		}
		
		if (maxLen < (input.length() - startPnt)) {
			maxLen = (input.length() - startPnt);
			maxStartPnt = startPnt;
		}
		
		return input.substring(maxStartPnt, maxStartPnt + maxLen);
	}

	private static String getInput(Scanner sc) {
		System.out.println("Please enter your string.");
		return sc.nextLine();
	}

}
