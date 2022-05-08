package com.swapnil.java.practice.random;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class LongestPalindrome {

	public static void main(String[] args) {
		Scanner sc = null;
		try {
			sc = initScanner();
			System.out.println("Enter your string...");
			String input = sc.nextLine();
			
			String result = longestPalindrome(input);
			
			System.out.println("Longest palindrome substring is: " + result);
		} catch (Exception e) {
			System.out.println("Error while running: " + e);
		} finally {
			sc.close();
		}
	}

	private static Scanner initScanner() {
		return new Scanner(System.in);
	}
	
	private static String longestPalindrome(String input) {
		/** Algorithm
		 *  0. Iterate until the size of the input
		 *  1. See if current element has occurred before
		 *  2. If yes --> For every index that it has occurred --> Take substring from that index to currentIdx
		 *  3. See whether this substring is a Palindrome or not.
		 *  4. If yes --> See if this is bigger than the current longestPalindrome 
		 *  	--> If yes --> Replace currLongestPalindrome with this. 
		 *  5. Mark char as visited in the visited HashMap and store it's corresponding indexes in the List.
		 *  	('a', [0,2])
		 */
		
		HashMap<String, ArrayList<Integer>> visited = new HashMap<>();
		String maxPalindrome = "";
		
		for (int i = 0; i < input.length(); i++) { 
			String ele = String.valueOf(input.charAt(i));
			
			if (visited.get(ele) != null) {
				for (Integer occurredIdx: visited.get(ele)) {
					if ((i - occurredIdx) <= maxPalindrome.length()) {
						continue; // Just an optimization. 
						// So that we won't check potential Palindrome substring which are smaller than the current one.
					}
					
					String subString = input.substring(occurredIdx, i + 1);
					
					if(isPalindrome(subString)) {
						maxPalindrome = (subString.length() > maxPalindrome.length()) ? subString : maxPalindrome;
					}
				}
			}
			
			visited.put(ele, addToExistingList(visited, ele, i));
		}
		
		return maxPalindrome.length() > 0 ? maxPalindrome : null;
	}

	private static boolean isPalindrome(String substring) {
		Character first = substring.charAt(0);
		Character last = substring.charAt(substring.length() - 1);
		
		if (first.equals(last)) {
			if (substring.length() == 1) {
				return true;
			} 
			
			if (substring.length() == 2) {
				return (first.equals(last)) ? true : false;
			}
			
			return isPalindrome(substring.substring(1, substring.length() - 1));
		}
		
		return false;
	}

	private static ArrayList<Integer> addToExistingList(HashMap<String, ArrayList<Integer>> visited, String ele, int currIdx) {
		ArrayList<Integer> occurredIdxs = null;
		
		if (visited.get(ele) != null) {
			occurredIdxs = visited.get(ele);
		} else {
			occurredIdxs = new ArrayList<>();
		}
		
		occurredIdxs.add(currIdx);
		return occurredIdxs;
	}
}
