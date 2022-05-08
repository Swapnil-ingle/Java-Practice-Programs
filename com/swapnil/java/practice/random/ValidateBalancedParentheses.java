package com.swapnil.java.practice.random;

import java.util.Scanner;
import java.util.Stack;

public class ValidateBalancedParentheses {
	public static void main(String args[]) {
		Scanner sc = null;
		try {
			sc = initScanner(sc);
			String input = getInput(sc);
			
			System.out.println(isValid(input));
		} catch (Exception e) {
			System.out.println("Error while processing...");
			e.printStackTrace();
		} finally {
			sc.close();
		}
	}

	private static boolean isValid(String input) {
		Stack<Character> stack = new Stack<>();
		
		for (int i = 0; i < input.length(); i++) {
			Character ele = input.charAt(i);
			if (isOpeningParentheses(ele)) {
				stack.push(ele);
			} else if (isOpeningClosingSame(ele, stack.peek())) {
				stack.pop();
			} else {
				return false;
			}
		}
		
		return stack.size() > 0 ? false : true;
	}

	private static boolean isOpeningClosingSame(Character closing, Character opening) {
		switch (closing) {
			case ']':
				return (opening.equals('[')) ? true : false;
			case ')':
				return (opening.equals('(')) ? true : false;
			case '}':
				return (opening.equals('{')) ? true : false;
			default:
				return false;
		}
	}

	private static boolean isOpeningParentheses(Character ele) {
		return (ele.equals('(') || ele.equals('[') || ele.equals('{'));
	}

	private static String getInput(Scanner sc) {
		System.out.println("Enter the parentheses string");
		return sc.nextLine();
	}

	private static Scanner initScanner(Scanner sc) {
		return new Scanner(System.in);
	}
}
