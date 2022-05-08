package com.swapnil.java.practice.random;

/**
 * 
 * @author Swap
 * 
 * Solution for 'Cracking The Coding Interview' Chapter 1 - Ex#3
 * 
 * com.swapnil.java.practice.random.URLify(input, len)
 *
 */
public class URLify {

	public static void main(String[] args) {
		String input = "Mr John Smith    ";
		System.out.println(urlify(input.toCharArray(), 13));
	}
	
	private static char[] urlify(char[] input, int len) {
		int lenNew = input.length - 1;
		int j = len - 1;
		
		for (int i = lenNew; i >= 0; i--) {
			if (input[j] == ' ') {
				input[i] = '0';
				input[--i] = '2';
				input[--i] = '%';				
			} else {
				input[i] = input[j];
			}
			j--;
		}
		
		return input;
	}

}
