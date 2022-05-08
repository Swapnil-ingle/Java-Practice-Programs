package com.swapnil.java.practice.heaps;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class MinHeap {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] A = new int[]{4, 4, 8, 15, 6};
        int[] B = new int[]{9, 5, 15, 16, 7};
        System.out.println(solution.solve(A, B));
    }
}

class Solution {
    public int solve(int[] A, int[] B) {
        int min = min(B);
        int max = max(B);
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        int n = B.length;

        for (int i = 0; i < n; i++) {
            if (map.get(B[i]) == null) {
                PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
                heap.add(A[i]);
                map.put(B[i], heap);
            } else {
                map.get(B[i]).add(A[i]);
            }
        }

        int maxJobs = 0;
        int ce = 0;

        for (int i = min; i <= max; i++) {
            if (map.get(i) != null) {
                // We found the next ending job
                // Make sure it's start is >= ce
                PriorityQueue<Integer> njsp = map.get(i); // njsp --> NextJobsStartingPoints-+
                while (!njsp.isEmpty()) {
                    if (njsp.peek() >= ce) {
                        maxJobs++;
                        ce = i;
                        break;
                    }

                    njsp.remove();
                }
            }
        }

        return maxJobs;
    }

    private static int min(int[] A) {
        int min = Integer.MAX_VALUE;

        for (Integer e : A) {
            min = e < min ? e : min;
        }

        return min;
    }

    private static int max(int[] A) {
        int max = Integer.MIN_VALUE;

        for (Integer e : A) {
            max = e > max ? e : max;
        }

        return max;
    }
}
