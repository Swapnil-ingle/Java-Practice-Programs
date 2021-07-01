package com.swapnil.java.practice;

import com.swapnil.java.practice.ds.linkedlist.Node;

public class LinkedListDeleteNode {

	public static void main(String[] args) {
		int[] elements = {5, 4, 4, 2, 4};
		int toBeDeleted = 8;
		System.out.println("=== LinkedList Before Deleting " + toBeDeleted + " ===");
		Node.LinkedListUtils.printLL(Node.LinkedListUtils.generateLL(elements));
		System.out.println("=== LinkedList After Deleting === ");
		Node.LinkedListUtils.printLL(delete(Node.LinkedListUtils.generateLL(elements), toBeDeleted));
	}
	
	private static Node delete(Node head, int data) {
		Node h1 = head;
		Node prev = null;
		
		while (h1 != null) {
			if (h1.getData() == data) {
				if (h1 == head) {
					// If head is being deleted, move head pointer ahead
					head = h1.getNext();
				}
				if (prev != null) {
					prev.setNext(h1.getNext());
				}
			} else {
				prev = h1;
			}
			
			h1 = h1.getNext();
		}
		
		return head;
	}

}
