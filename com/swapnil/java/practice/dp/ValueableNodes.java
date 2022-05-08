package com.swapnil.java.practice.dp;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class ValueableNodes {

    public static void main(String[] args) {
        System.out.println(solve(new int[]{0}, new int[]{1}));
    }

    private static final int M = 1000000007;

    private static int[] V;

    private static int[] P;

    private static Map<Integer, Set<Integer>> child;

    private static Map<Integer, Set<Integer>> ggc;

    private static int solve(int[] A, int[] B) {
        int N = A.length;

        makeParentArray(A);
        makeValueArray(B);
        makeChildMap();
        makeGGCMap();

        return ans(1, makeDp(N));
    }

    private static int ans(int root, int[] dp) {
        if (dp[root] != -1) {
            return dp[root];
        }

        // Selecting root
        int c1 = V[root];
        // We can select all ggcs
        if (ggc.get(root) != null) {
            // Great grand children exists
            for (Integer ggChild : ggc.get(root)) {
                c1 = ((c1 + ans(ggChild, dp)) % M);
            }
        }

        // Not selecting the root
        int c2 = 0;

        // We can select all the immediate children
        if (child.get(root) != null) {
            // Children exists
            for (Integer c : child.get(root)) {
                c2 = ((c2 + ans(c, dp)) % M);
            }
        }

        dp[root] = Math.max(c1, c2);
        return dp[root];
    }

    private static int[] makeDp(int N) {
        int[] dp = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            dp[i] = -1;
        }

        return dp;
    }

    private static void makeGGCMap() {
        ggc = new HashMap<>();
        int N = P.length;

        for (int i = 0; i < N; i++) {
            int ggp = P[P[P[i]]];
            if (ggp != 0) {
                // Great Grandparent Exist of current node exists
                if (ggc.get(ggp) == null) {
                    Set<Integer> currGGC = new LinkedHashSet<>();
                    currGGC.add(i);
                    ggc.put(ggp, currGGC);
                } else {
                    ggc.get(ggp).add(i);
                }
            }
        }
    }

    private static void makeChildMap() {
        child = new HashMap<>();
        int N = P.length;

        for (int i = 0; i < N; i++) {
            if (P[i] != 0) {
                // Parent Exist
                // i --> Parent --> P[i]
                // P[i] --> Child --> i
                if (child.get(P[i]) == null) {
                    Set<Integer> children = new LinkedHashSet<>();
                    children.add(i);
                    child.put(P[i], children);
                } else {
                    child.get(P[i]).add(i);
                }
            }
        }
    }

    private static void makeParentArray(int[] A) {
        int N = A.length;
        P = new int[N + 1];

        for (int i = 0; i < N; i++) {
            // A[i] is parent of i + 1
            // P[i] is parent of i
            P[i + 1] = A[i];
        }
    }

    private static void makeValueArray(int[] B) {
        int N = B.length;
        V = new int[N + 1];

        for (int i = 0; i < N; i++) {
            // A[i] is parent of i + 1
            // P[i] is parent of i
            V[i + 1] = B[i];
        }
    }
}
