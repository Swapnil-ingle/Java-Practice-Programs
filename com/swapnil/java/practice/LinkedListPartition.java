package com.swapnil.java.practice;

import com.swapnil.java.practice.ds.linkedlist.Node;

/**
 * Time Complexity => O(n)
 * Space Complexity => O(n) // Including Space used by input
 * Auxiliary Space => O(1)
 * 
 * @author Swap
 *
 */
public class LinkedListPartition {

	public static void main(String[] args) {
		int[] elements = { 9, 1, 4, 5, 7, 6, 2, 3 };
		int partitionAt = 6;
		System.out.println("=== LinkedList Before Partition at " + partitionAt + " ===");
		Node.LinkedListUtils.printLL(Node.LinkedListUtils.generateLL(elements));
		System.out.println("=== LinkedList After Partition === ");
		Node.LinkedListUtils.printLL(partition(Node.LinkedListUtils.generateLL(elements), partitionAt));
	}

	private static Node partition(Node head, int x) {
		// H1 ==> Rolling pointer
		Node h1 = head;
		// H2 ==> Farthest Pointer to element > x
		Node h2 = head;

		/**
		 * 1. Move H2 until we get to an element which is > x 
		 * 2. H2 will be stuck at
			 * Step#1 until H1 (which is constantly rolling till EOD) gets the first element
			 * smaller than x, so H2 (which is stuck at bigger x) will be replaced with
			 * smaller element. 
		 * 3. Resync H2 to H1's current place
		 */
		while (h1 != null) {
			if (h2.getData() < x) {
				// Move H2
				h2 = h2.getNext();
			} else {
				if (h1.getData() < x) {
					// Swap h1 and h2
					int temp = h2.getData();
					h2.setData(h1.getData());
					h1.setData(temp);
					// Move H2
					h2 = h2.getNext();
				}
			}

			h1 = h1.getNext();
		}

		return head;
	}

}
