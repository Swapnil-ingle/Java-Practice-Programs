package com.swapnil.java.practice;

import com.swapnil.java.practice.ds.linkedlist.Node;

public class LinkedListLastKthNode {
    public static void main(String[] args) {
        int[] elements = {4, 5, 2, 1, 2, 5, 4, 8};
        System.out.println("=== LinkedList === ");
        Node.LinkedListUtils.printLL(Node.LinkedListUtils.generateLL(elements));
        System.out.println("=== Kth Element from the last  === ");
        System.out.println((returnKthFromLastElement(Node.LinkedListUtils.generateLL(elements), 0)));
        System.out.println((returnKthFromLastElementUpdated(Node.LinkedListUtils.generateLL(elements), 0)));
    }

    /**
     * Considering last element as 1st
     *
     * @param head
     * @param k
     * @return
     */
    private static Integer returnKthFromLastElementUpdated(Node head, int k) {
        Node h1 = head;
        Node h2 = head;

        if (k <= 0) {
            return null;
        }

        for (int i = 0; i < k; i++) {
            if (h1 == null) {
                return null;
            }

            h1 = h1.getNext();
        }

        while (h1 != null) {
            h1 = h1.getNext();
            h2 = h2.getNext();
        }

        return h2.getData();
    }

    /***
     *
     * Considering last element as 0th
     *
     * @param head
     * @param k
     * @return
     */
    private static Integer returnKthFromLastElement(Node head, int k) {
        if (k < 0) {
            return null;
        }

        int space = -1;
        Node h1 = head;
        Node h2 = null;

        while (h1 != null) {
            if (space == (k - 1)) {
                // Assign head --> h2
                h2 = head;
            }

            if (h1.getNext() != null) {
                h1 = h1.getNext();
            } else {
                break;
            }

            if (h2 != null) {
                h2 = h2.getNext();
            }

            space++;
        }

        return h2 != null ? h2.getData() : null;
    }
}
