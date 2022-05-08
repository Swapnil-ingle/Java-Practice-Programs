package com.swapnil.java.practice.heaps;

import java.util.PriorityQueue;

public class RunningMedian {
    public static void main(String[] args) {
        System.out.println(solve(new int[]{32, 91, 86, 8, 4, 100, 98, 15, 79, 32, 4, 99}));
    }

    private static int[] solve(int[] A) {
        int N = A.length;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b-a);

        for (int i = 0; i < N; i++) {
            minHeap.add(A[i]);
            if (diff(minHeap.size(), maxHeap.size()) > 2) {
                maxHeap.add(minHeap.poll());
            }

            A[i] = minHeap.peek();
        }

        return A;
    }

    private static int diff(int a, int b) {
        return a > b ? a - b : b - a;
    }
}
