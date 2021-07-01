package com.swapnil.java.practice;

import com.swapnil.java.practice.ds.linkedlist.Node;

public class LinkedListDeleteNodeWithoutHead {

	public static void main(String[] args) {
		int[] elements = { 5, 4, 4, 2, 4 };
		int toBeDeleted = 2;
		System.out.println("=== LinkedList Before Deleting " + toBeDeleted + " ===");
		Node.LinkedListUtils.printLL(Node.LinkedListUtils.generateLL(elements));
		System.out.println("=== LinkedList After Deleting === ");
		Node head = Node.LinkedListUtils.generateLL(elements);
		delete(getNodeFor(head, toBeDeleted));
		Node.LinkedListUtils.printLL(head);
	}

	private static boolean delete(Node node) {
		if (node != null && node.getNext() != null) {
			node.setData(node.getNext().getData());
			node.setNext(node.getNext().getNext());
			return true;
		}

		return false;
	}

	private static Node getNodeFor(Node head, Integer data) {
		Node h = head;

		while (h != null) {
			if (h.getData() == data) {
				return h;
			}

			h = h.getNext();
		}

		return null;
	}

}
