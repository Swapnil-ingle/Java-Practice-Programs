package com.swapnil.java.practice;

import com.swapnil.java.practice.ds.linkedlist.Node;

public class LinkedListRemoveDuplicateNoBuffer {
    public static void main(String[] args) {
        int[] elements = {4, 5, 2, 1, 2, 5, 4, 8};
        System.out.println("=== LinkedList Before Removing Duplicates === ");
        Node.LinkedListUtils.printLL(Node.LinkedListUtils.generateLL(elements));
        System.out.println("=== LinkedList After Removing Duplicates (Not Using Buffer)  === ");
        Node.LinkedListUtils.printLL(removeDuplicateElementsNoBuffer(Node.LinkedListUtils.generateLL(elements)));
    }

    private static Node removeDuplicateElementsNoBuffer(Node head) {
        Node h1 = head;

        while (h1 != null) {
            // Iterate H1
            Node h2 = h1.getNext();
            Node prev = h1;

            while (h2 != null) {
                if (h2.getData() == h1.getData()) {
                    // Remove H2
                    prev.setNext(h2.getNext());
                } else {
                    prev = h2;
                }
                h2 = h2.getNext();
            }

            h1 = h1.getNext();
        }

        return head;
    }
}
