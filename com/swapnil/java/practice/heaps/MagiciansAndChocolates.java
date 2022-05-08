package com.swapnil.java.practice.heaps;

import java.util.PriorityQueue;

public class MagiciansAndChocolates {
    public static void main(String[] args) {
        System.out.println(nchoc(10, new int[]{2147483647, 2000000014, 2147483647}));
    }

    private static int nchoc(int A, int[] B) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        for (Integer e : B) {
            maxHeap.add(e);
        }

        long max = 0;

        for (int i = 0; i < A; i++) {
            int temp = maxHeap.poll();
            maxHeap.add((int) (temp / 2L));
            max += temp;
        }

        return (int) max;
    }

    private static int min(int a, int b) {
        return a < b ? a : b;
    }
}
