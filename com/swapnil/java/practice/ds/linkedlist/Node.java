package com.swapnil.java.practice.ds.linkedlist;

public class Node {
	private Integer data;
	
	private Node next;
	
	public Node(Integer data) {
		this.data = data;
	}

	public Integer getData() {
		return data;
	}

	public void setData(Integer data) {
		this.data = data;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public static class LinkedListUtils {
		public static void printLL(Node head) {
			Node node = head;
			while (node != null) {
				System.out.print("[" + node.getData() + "] => ");
				node = node.getNext();
			}
			System.out.println("[X]");
		}

		public static Node generateLL(int[] elements) {
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
}
