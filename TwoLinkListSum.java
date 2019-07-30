package com.swapnil.java.practice;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TwoLinkListSum {
	/**
	 * Problem Statement:
	 *  Given two linked-lists of non-negative numbers 
	 *  ex (2 --> 6 --> 3) and (5 --> 4 --> 5)
	 *  Add them from left to right and give output in a linked-list.
	 *  Output: (7 --> 0 --> 9)
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = null;
		try {
			sc = initScanner(sc);
			// Get Input to two LinkedList
			LinkedList<Integer> ll1 = getInputLinkedList(sc);
			LinkedList<Integer> ll2 = getInputLinkedList(sc);
			
			System.out.println(addLinkedLists(ll1, ll2));
		} catch (Exception e) {
			System.out.println("Error while running: " + e);
		} finally {
			sc.close();
		}
	}
	
	private static Scanner initScanner(Scanner sc) {
		return new Scanner(System.in);
	}
	
	private static LinkedList<Integer> getInputLinkedList(Scanner sc) {
		System.out.println("Please enter your linked list.");
		String[] input = sc.nextLine().split(" ");
		
		List<Integer> inputInts = Arrays.stream(input)
			.map(Integer::valueOf)
			.collect(Collectors.toList());
		
		return new LinkedList<>(inputInts);
	}

	private static LinkedList<Integer> addLinkedLists(LinkedList<Integer> l1, LinkedList<Integer> l2) {
		/**
		 * Algorithm: 
		 *  0. Iterate until the size of large of l1 and l2
		 *  1. Pop first element from both the linked lists and add (Add carryOver - if any)
		 *  2. If greater than 10 --> Mod 10 AND carry over unit place (face value) --> Add to the resulting LinkedList
		 *  3. Else Add to the resulting LinkedList
		 */
		LinkedList<Integer> resultingLL = new LinkedList<>();
		int carryOver = 0;
		int iteratingSize = (l1.size() >= l2.size() ? l1.size() : l2.size());
		
		for (int i = 0; i < iteratingSize; i++) {
			int elmt1 = getFirstNodeVal(l1);
			int elmt2 = getFirstNodeVal(l2);
			int resultingElmnt = ((elmt1 + elmt2) >= 10) ? ((elmt1 + elmt2) % 10) : (elmt1 + elmt2);
			
			resultingLL.addLast(resultingElmnt + carryOver);
			carryOver = ((elmt1 + elmt2) >= 10) ? ((elmt1 + elmt2) / 10) : 0;
		}
		
		return resultingLL;
	}

	private static int getFirstNodeVal(LinkedList<Integer> linkedList) {
		Integer first = linkedList.pollFirst();
		return ((first == null) ? 0 : first);
	}
}
