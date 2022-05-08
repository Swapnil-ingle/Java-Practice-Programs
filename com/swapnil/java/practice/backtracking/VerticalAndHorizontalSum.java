package com.swapnil.java.practice.backtracking;

import java.util.ArrayList;
import java.util.List;

public class VerticalAndHorizontalSum {
    private static int[][] MAT = {
            {1, 1, 1},
            {1, 1, 1},
            {1, 1, 1}
    };

    public static void main(String[] args) {
        int A = 3;
        int C = 2;
        System.out.println(solve(MAT, A, C));
    }

    private static int solve(int[][] M, int A, int C) {
        int ans = resolve(0, 0, M, A, C);
        return ans;
    }

    private static int resolve(int r, int c, int[][] M, int A, int C) {
        if (!existsASubArrWithGreaterSum(M, C)) {
            return 1;
        }

        if (A <= 0) {
            return 0;
        }

        if (r >= M.length || c >= M[0].length) {
            return 0;
        }

        int ans = 0;
        boolean flipped = false;

        if (partOfSubArrWithGreaterSum(r, c, M, C)) {
            // Current index is part of a subArr whose's sum is > C
            // Need to flip this index
            M[r][c] = - (M[r][c]); // Flip it!
            flipped = true;
        }

        int nextR = M.length;
        int nextC = M[0].length;

        if (c < nextC - 1) {
            // col idx can move
            ans |= resolve(r, c + 1, M, flipped ? A - 1 : A, C);
        } else if (r < nextR - 1) {
            // row idx can move
            ans |= resolve(r + 1, 0, M, flipped ? A - 1 : A, C);
        } else {
            // Both cannot move return ans
            ans |= (existsASubArrWithGreaterSum(M, C) ? 0 : 1);
        }

        if (flipped) {
            // Back track
            M[r][c] = -M[r][c];
            flipped = false;

            if (c < nextC - 1) {
                // col idx can move
                ans |= resolve(r, c + 1, M, flipped ? A - 1 : A, C);
            } else if (r < nextR - 1) {
                // row idx can move
                ans |= resolve(r + 1, 0, M, flipped ? A - 1 : A, C);
            } else {
                // Both cannot move return ans
                ans |= (existsASubArrWithGreaterSum(M, C) ? 0 : 1);
            }
        }

        return ans;
    }

    private static boolean partOfSubArrWithGreaterSum(int r, int c, int[][] m, int sum) {
        int max = Integer.MIN_VALUE;
        int[] row = new int[m[0].length];
        int[] col = new int[m.length];

        for (int j = 0; j < m[0].length; j++) {
            row[j] = m[r][j];
        }

        for (int i = 0; i < m.length; i++) {
            col[i] = m[i][c];
        }

        int[] rowPre = getPrefixArr(row);
        int[] colPre = getPrefixArr(col);

        max = Math.max(max, getMaxSubArrSumIncludingIndex(rowPre, c + 1));
        max = Math.max(max, getMaxSubArrSumIncludingIndex(colPre, r + 1));


        return max > sum;
    }

    private static int getMaxSubArrSumIncludingIndex(int[] preArr, int R) {
        int max = Integer.MIN_VALUE;

        for (int L = 0; L < R; L++) {
            int temp = preArr[R] - preArr[L];
            max = Math.max(max, temp);
        }

        int L = R - 1;

        while (R < preArr.length) {
            int temp = preArr[R] - preArr[L];
            max = Math.max(max, temp);
            R++;
        }

        return max;
    }

    private static boolean existsASubArrWithGreaterSum(int[][] m, int sum) {
        // Checks if there is present a subArr with sum > sum

        // Check horizontal sum
        for (int r = 0; r < m.length; r++) {
            List<Integer> currRow = new ArrayList<>();

            for (int c = 0; c < m[0].length; c++) {
                currRow.add(m[r][c]);
            }

            int maxSubArrSum = getMaxSubArrSum(currRow);

            if (maxSubArrSum > sum) {
                return true;
            }
         }

        // Check vertical sum
        for (int c = 0; c < m[0].length; c++) {
            List<Integer> currCol = new ArrayList<>();

            for (int r = 0; r < m.length; r++) {
                currCol.add(m[r][c]);
            }

            int maxSubArrSum = getMaxSubArrSum(currCol);

            if (maxSubArrSum > sum) {
                return true;
            }
        }

        return false;
    }

    private static int getMaxSubArrSum(List<Integer> arr) {
        int[] temp = new int[arr.size()];

        for (int i = 0; i < temp.length; i++) {
            temp[i] = arr.get(i);
        }

        return getMaxSubArrSum(temp);
    }

    private static int getMaxSubArrSum(int[] arr) {
        int max = Integer.MIN_VALUE;
        int[] pre = getPrefixArr(arr);

        for (int i = 1; i < pre.length; i++) {
            // max sum of subarr ending at i
            int tempMax = 0;

            for (int j = 0; j < i; j++) {
                int sum = pre[i] - pre[j];
                tempMax = Math.max(sum, tempMax);
            }

            max = Math.max(tempMax, max);
        }

        return max;
    }

    private static int[] getPrefixArr(int[] arr) {
        int[] pre = new int[arr.length + 1];

        for (int i = 1; i <= arr.length; i++) {
            pre[i] = pre[i - 1] + arr[i - 1];
        }

        return pre;
    }
}
