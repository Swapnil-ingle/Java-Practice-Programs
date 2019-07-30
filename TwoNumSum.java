package com.swapnil.java.practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TwoNumSum {
	/**
	 * Problem Statement:
	 * 	Given an array ex: [1, 6, 9] and a target number ex: 10.
	 * 	Find if there is a pair which sums up to the target.
	 * 	Catch: Restrict the complexity to BigO(n) 
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = null;
		int target = getTargetInt(sc);
		
		try {
			sc = initScanner(sc);
			// Get input Array
			Integer[] inputArray = getInputArray(sc);
			
			// Get index of the numbers if sum exists
			int[] finalIdx = getTwoNumSum(inputArray, target);
			
			// Display value
			displayResultingIndexes(target, finalIdx);
		} catch (Exception e) {
			System.out.println("Error while running: " + e);
		} finally {
			sc.close();
		}
	}
	
	private static int getTargetInt(Scanner sc) {
		System.out.println("Enter the target number");
		return sc.nextInt();
	}
	
	private static Scanner initScanner(Scanner sc) {
		return new Scanner(System.in);
	}
	
	private static Integer[] getInputArray(Scanner sc) {
		System.out.println("Enter the input array...");
		
		String[] input = sc.nextLine().split(" ");
		
		return Arrays.stream(input)
			.map(Integer::valueOf)
			.collect(Collectors.toList())
			.toArray(new Integer[input.length]);
	}
	
	private static int[] getTwoNumSum(Integer[] input, int target) {
		// Make a hash table of the input num --> index
		Map<Integer, Integer> inputHashMap = convertToHashMap(input);
		
		/** Algorithm --
		 * 0. Iterate input array
		 * 1. Check if diff(input[i], target) exists in inputHashMap<>
		 *    and counterpart's index != current index (This would cause the
		 *    program to consider the same index twice)
		 * 2. If yes --> return [i, inputHashMap.get(diff(input[i],target))]
		 */
		for (int i = 0; i < input.length; i++) {
			if (inputHashMap.containsKey(diff(input[i],target)) && 
					(inputHashMap.get(diff(input[i],target)) != i)) {
				return new int[] {i, inputHashMap.get(diff(input[i],target))};
			}
		}
		
		return null;
	}
	
	private static Map<Integer, Integer> convertToHashMap(Integer[] input) {
		Map<Integer, Integer> inputHashMap = new HashMap<>();
		
		for (int i = 0; i < input.length; i++) {
			inputHashMap.put(input[i], i);
		}
		
		return inputHashMap;
	}

	private static Integer diff(Integer currInt, int targetInt) {
		if (currInt > targetInt) {
			return (currInt - targetInt);
		}
		
		return (targetInt - currInt);
	}

	private static void displayResultingIndexes(int target, int[] finalIdx) {
		if (finalIdx != null) {
			System.out.println(finalIdx[0] + " , " + finalIdx[1]);
		} else {
			System.out.println("No two integer exists who's sum is: " + target);
		}
	}
}
