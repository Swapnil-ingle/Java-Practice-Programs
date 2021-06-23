package com.swapnil.java.practice;

import java.util.HashMap;
import java.util.Map;

import com.swapnil.java.practice.ds.linkedlist.Node;

public class LinkedListRemoveDuplicate {

	public static void main(String[] args) {
		int[] elements = {4, 4, 4, 5, 4, 4, 2, 4};
		System.out.println("=== LinkedList Before Removing Duplicates === ");
		Node.LinkedListUtils.printLL(Node.LinkedListUtils.generateLL(elements));
		System.out.println("=== LinkedList After Removing Duplicates  === ");
		Node.LinkedListUtils.printLL(removeDuplicateElements(Node.LinkedListUtils.generateLL(elements)));
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



}
