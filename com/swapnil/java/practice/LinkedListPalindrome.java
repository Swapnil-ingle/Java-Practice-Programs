package com.swapnil.java.practice;

import com.swapnil.java.practice.ds.linkedlist.Node;
import com.swapnil.java.practice.ds.linkedlist.Node.LinkedListUtils;

/**
 * 
 * Checks if a LinkedList is Palindrome
 * 
 * 
 * 
 * @author Swap
 *
 */
public class LinkedListPalindrome {
	public static void main(String[] args) {
		Node ll = LinkedListUtils.generateLL(new int[] { 1, 2, 3, 2, 1 });
		System.out.println((isPalindrome(ll)));
	}

	private static boolean isPalindrome(Node ll1) {
		Node ll2 = reverse(ll1); // O(n)

		while (ll1 != null) { // O(n)
			if (ll1.getData() != ll2.getData()) {
				return false;
			}
			
			ll1 = ll1.getNext();
			ll2 = ll2.getNext();
		}

		return true;
	}

	private static Node reverse(Node ll1) {
		Node current = ll1;
		Node prev = null;

		while (current != null) {
			Node node = new Node(current.getData());

			if (prev != null) {
				node.setNext(prev);
			}

			prev = node;
			current = current.getNext();
		}

		return prev;
	}
}
