package com.swapnil.java.practice;

import java.util.HashMap;
import java.util.Map;

import com.swapnil.java.practice.ds.linkedlist.Node;

public class LinkedListRemoveDuplicate {

	public static void main(String[] args) {
		int[] elements = {4, 4, 4, 5, 4, 4, 2, 4};
		System.out.println("=== LinkedList Before Removing Duplicates === ");
		printLL(generateLL(elements));
		System.out.println("=== LinkedList After Removing Duplicates  === ");
		printLL(removeDuplicateElements(generateLL(elements)));
	}
	
	private static Node removeDuplicateElements(Node head) {
		Node node = head;
		Node prevNode = null;
		Map<Integer, Boolean> buffer = new HashMap<>();

		while (node != null) {
			Integer ele = node.getData();
			
			if (buffer.get(ele) != null) {
				// Ele Duplicate, remove CurrNode, PrevNode Remains Same
				prevNode.setNext(node.getNext());
			} else {
				prevNode = node;
				buffer.put(ele, true);
			}
			
			node = node.getNext();
		}

		return head;
	}

	private static void printLL(Node head) {
		Node node = head;
		while (node != null) {
			System.out.print("[" + node.getData() + "] => ");
			node = node.getNext();
		}
		System.out.println("[X]");
	}
	
	private static Node generateLL(int[] elements) {
		Node head = new Node(elements[0]);
		Node prevNode = head;
		
		for (int i = 1; i < elements.length; i++) {
			Node node = new Node(elements[i]);
			prevNode.setNext(node);
			prevNode = node;
		}
		
		return head;
	}

}
