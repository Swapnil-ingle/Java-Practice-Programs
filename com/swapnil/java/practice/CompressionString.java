package com.swapnil.java.practice;

public class CompressionString {

	public static void main(String[] args) {
		String input = "Baaaaat Maaaaaaaaaannnnn";
		System.out.println(compressString(input));
	}

	private static String compressString(String input) {
		String compressed = "";
		StringBuilder builder = new StringBuilder();
		Character currLetter = null;
		int currLetterIdx = 0;
		
		for (int i = 0; i < input.length(); i++) {
			if (currLetter != null && input.charAt(i) != currLetter) {
				// Append 'currLetter''currLetterIdx' to compressed string
				builder.append(currLetter);
				builder.append(currLetterIdx);
				// Reset both currLetter and currLetterIdx
				currLetter = input.charAt(i);
				currLetterIdx = 1;
			} else {
				currLetter = input.charAt(i);
				currLetterIdx++;
			}
		}
		
		if (currLetter != null && currLetterIdx > 0) {
			// Append 'currLetter''currLetterIdx' to compressed string
			builder.append(currLetter);
			builder.append(currLetterIdx);
		}
		
		compressed = builder.toString();
		
		return compressed.length() < input.length() ? compressed : input;
	}

}
