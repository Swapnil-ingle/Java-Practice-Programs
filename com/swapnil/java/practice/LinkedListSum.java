package com.swapnil.java.practice;

import com.swapnil.java.practice.ds.linkedlist.Node;
import com.swapnil.java.practice.ds.linkedlist.Node.LinkedListUtils;

public class LinkedListSum {

	public static void main(String[] args) {
		Node ll1 = LinkedListUtils.generateLL(new int[] { 7, 1, 0, 6 });
		Node ll2 = LinkedListUtils.generateLL(new int[] { 5, 9, 2 });

		LinkedListUtils.printLL(addLinkedLists(ll1, ll2));
	}

	private static Node addLinkedLists(Node h1, Node h2) {
		Node ll3 = genEmptyLL(h1, h2);
		Node h3 = ll3;

		int carry = 0;
		int sum = 0;

		while (h1 != null || h2 != null) {
			// Add H1 and H2 data
			int h1Data = h1 != null ? h1.getData() : 0;
			int h2Data = h2 != null ? h2.getData() : 0;

			sum = h1Data + h2Data;
			sum += carry;
			carry = 0;

			if (sum >= 10) {
				carry = 1;
				sum -= 10;
			}

			// Add sum to new LL
			h3.setData(sum);

			// Move pointers ahead
			h3 = h3.getNext();
			h1 = h1 != null ? h1.getNext() : null;
			h2 = h2 != null ? h2.getNext() : null;
		}

		return ll3;
	}

	private static Node genEmptyLL(Node h1, Node h2) {
		int sizeOfNewLL = 0;

		while (h1 != null || h2 != null) {
			sizeOfNewLL++;
			h1 = h1 != null ? h1.getNext() : null;
			h2 = h2 != null ? h2.getNext() : null;
		}

		int[] elements = new int[sizeOfNewLL];

		return LinkedListUtils.generateLL(elements);
	}

}
