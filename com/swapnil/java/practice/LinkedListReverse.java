package com.swapnil.java.practice;

import com.swapnil.java.practice.ds.linkedlist.Node;
import com.swapnil.java.practice.ds.linkedlist.Node.LinkedListUtils;

public class LinkedListReverse {

	public static void main(String[] args) {
		Node ll = LinkedListUtils.generateLL(new int[] { 1, 2, 3, 4, 5 });
		LinkedListUtils.printLL(reverse(ll));
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
