package com.swapnil.java.practice;

public class OneAway {

	public static void main(String[] args) {
		System.out.println(oneAway("bale", "pale"));
	}
	
	private static boolean oneAway(String target, String source) {
		if (diff(target.length(), source.length()) > 1) {
			return false;
		}

		boolean oneMismatchFound = false;

		if (source.length() == target.length()) {
			// Everything but one should match
			for (int i = 0; i < source.length(); i++) {
				if (source.charAt(i) != target.charAt(i)) {
					if (!oneMismatchFound) {
						oneMismatchFound = true;
					} else {
						return false;
					}
				}
			}
		} else {
			String longerStr = source.length() > target.length() ? source : target;
			String shorterStr = source.length() > target.length() ? target : source;
			int longerStrIdx = 0;
			int shorterStrIdx = 0;

			for (shorterStrIdx = 0; shorterStrIdx < shorterStr.length(); shorterStrIdx++) {
				if (shorterStr.charAt(shorterStrIdx) != longerStr.charAt(longerStrIdx)) {
					if (!oneMismatchFound) {
						oneMismatchFound = true;
					} else {
						return false;
					}
					--shorterStrIdx;
				}
				longerStrIdx++;
			}
		}

		return true;
	}
	
	private static int diff(int first, int second) {
		int larger = first > second ? first : second;
		int smaller = first > second ? second : first;

		return larger - smaller;
	}

}
