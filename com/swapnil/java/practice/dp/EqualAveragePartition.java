package com.swapnil.java.practice.dp;

import java.util.*;

public class EqualAveragePartition {
    private static Set<Integer> res;

    private static int SUM;

    private static int N;

    private static boolean FOUND_ANS;

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>();
        A.add(2);
        A.add(2);

        avgset1(A);
    }

    private static ArrayList<ArrayList<Integer>> avgset1(ArrayList<Integer> A) {
        Collections.sort(A);
        int N = A.size();
        int total = sum(A) / N;
        res = new LinkedHashSet<>();
        int max = max(A);

        FOUND_ANS = false;

        for (int l = 1; l <= N; l++) {
            if (FOUND_ANS) {
                break;
            }

            int sumNeeded = total * l;
            solve(A, 0, sumNeeded, l, new ArrayList<>(), makeDp(N + 1, l * max, N + 1));
        }

        return res.size() <= 0 ? new ArrayList<>() : convertToRes(A);
    }

    private static int max(ArrayList<Integer> A) {
        int max = 0;

        for (Integer e : A) {
            max = Math.max(max, e);
        }

        return max;
    }

    private static int[][][] makeDp(int A, int B, int C) {
        int[][][] dp = new int[A][B][C];

        for (int i = 0; i < A; i++) {
            for (int j = 0; j < B; j++) {
                for (int k = 0; k < C; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }

        return dp;
    }

    private static boolean solve(ArrayList<Integer> A, int currIdx, int currSum, int currLen, ArrayList<Integer> ansIdx, int[][][] dp) {
        if (FOUND_ANS) {
            return true;
        }

        if (currSum == 0 && currLen == 0) {
            res.addAll(ansIdx);
            dp[currIdx][currSum][currLen] = 1;
            FOUND_ANS = true;
            return true;
        }

        if (currSum <= 0 || currLen <= 0) {
            return false;
        }

        if (currIdx >= A.size()) {
            return false;
        }

        if (dp[currIdx][currSum][currLen] != -1) {
            return dp[currIdx][currSum][currLen] == 1 ? true : false;
        }

        // select
        ansIdx.add(currIdx);
        boolean a = solve(A, currIdx + 1, currSum - A.get(currIdx), currLen - 1, ansIdx, dp);

        // don't select
        ansIdx.remove(ansIdx.size() - 1);
        boolean b = solve(A, currIdx + 1, currSum, currLen, ansIdx, dp);

        dp[currIdx][currSum][currLen] = (a || b) ? 1 : -1;
        return dp[currIdx][currSum][currLen] == 1 ? true : false;
    }

    private static List<List<Integer>> avgset(List<Integer> A) {
        Collections.sort(A);
        res = new LinkedHashSet<>();
        SUM = sum(A);
        N = A.size();
        solve(A, 0, 0, 0, new ArrayList<>(), new int[N][N]);
        return res.size() <= 0 ? new ArrayList<>() : convertToRes(A);
    }

    private static List<List<Integer>> convertToRes(List<Integer> A) {
        List<Integer> first = new ArrayList<>();
        List<Integer> second = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            if (res.contains(i)) {
                first.add(A.get(i));
            } else {
                second.add(A.get(i));
            }
        }

        List<List<Integer>> output = new ArrayList<>();
        if (first.size() == second.size()) {
            output.add(first);
            output.add(second);
        } else {
            output.add(first.size() < second.size() ? first : second);
            output.add(first.size() > second.size() ? first : second);
        }

        return output;
    }

    private static void solve(List<Integer> A, int i, int S, int L, List<Integer> firstIdx, int[][] dp) {
        if (L != 0 && L != N) {
            if ((S / L) == (SUM - S) / (N - L)) {
                if (res.isEmpty()) {
                    res.addAll(firstIdx);
                } else if (res.size() > firstIdx.size()) {
                    res.clear();
                    res.addAll(firstIdx);
                }
                return;
            }
        }

        if (i >= N) {
            return;
        }

        // Select
        firstIdx.add(i);
        solve(A, i + 1, S + A.get(i), L + 1, firstIdx, dp);

        // Don't Select
        firstIdx.remove(firstIdx.size() - 1);
        solve(A, i + 1, S, L, firstIdx, dp);
    }

    private static int sum(List<Integer> A) {
        int ans = 0;

        for (Integer e : A) {
            ans += e;
        }

        return ans;
    }

    private static ArrayList<ArrayList<Integer>> convertToRes(ArrayList<Integer> A) {
        ArrayList<Integer> first = new ArrayList<>();
        ArrayList<Integer> second = new ArrayList<>();

        for (int i = 0; i < A.size(); i++) {
            if (res.contains(i)) {
                first.add(A.get(i));
            } else {
                second.add(A.get(i));
            }
        }

        ArrayList<ArrayList<Integer>> output = new ArrayList<>();

        if (first.size() == second.size()) {
            output.add(first);
            output.add(second);
        } else {
            output.add(first.size() < second.size() ? first : second);
            output.add(first.size() > second.size() ? first : second);
        }

        return output;
    }
}