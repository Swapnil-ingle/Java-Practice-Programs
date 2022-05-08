package com.swapnil.java.practice.stack;

public class Pattern132 {
    public static void main(String[] args) {
        int[] A = new int[] {-1,3,2,0};
        System.out.println(solve(A));
    }

    private static boolean solve(int[] nums) {
        int N = nums.length;
        int[] minLeft = new int[N]; // Smallest on left
        int[] maxLeft = new int[N]; // Next greater on left

        minLeft[0] = -1;
        maxLeft[0] = -1;

        for (int i = 1; i < N; i++) {
            int ptr = i - 1;

            while (maxLeft[ptr] != -1 && nums[maxLeft[ptr]] <= nums[i]) {
                ptr = maxLeft[ptr];
            }

            maxLeft[i] = maxLeft[ptr];
        }

        for (int i = 1; i < N; i++) {
            int ptr = i - 1;

            while (minLeft[ptr] != -1 && nums[minLeft[ptr]] >= nums[i]) {
                ptr = minLeft[ptr];
            }

            minLeft[i] = ptr;
        }

        for (int k = 2; k < N; k++) {
            // For this k, we need to find i, j
            // Such that i < j < k AND nums[i] < nums[j] < nums[k]
            int j = maxLeft[k];

            if (j == -1 || j == 0) {
                // Greater element (j) on left does not exist
                // num[k] does not exists such that num[k] < num[j]
                continue;
            }

            int i = minLeft[j];

            if (i == -1) {
                // Smaller element on left of j does not exists
                continue;
            }

            // All condition satisfied
            return true;
        }

        return false;
    }
}
