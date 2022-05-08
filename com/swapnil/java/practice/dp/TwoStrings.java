package com.swapnil.java.practice.dp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TwoStrings {
    public static void main(String[] args) {
        String A = "ababababababababababaasdasdasdasd";
        String B = "abaasdasdasdasdasdasd";
        System.out.println(solve(A, B));
    }

    private static Set<Integer> set;

    private static int solve(String A, String B) {
        set = new HashSet<>();
        Boolean[][] dp = new Boolean[A.length()][B.length()];
        ways(0, 0, A, B, dp, new ArrayList<>());
        return areAllIndexesPresent(A.length(), set);
    }

    private static boolean ways(int i, int j, String A, String B, Boolean[][] dp, List<Integer> indexes) {
        if (j >= B.length() || (j >= B.length() && i >= A.length())) {
            set.addAll(indexes);
            return true;
        }

        if (i >= A.length()) {
            return false;
        }

        if (dp[i][j] != null) {
            if (dp[i][j] == true) {
//                set.addAll(indexes);
                set.add(i);
                return true;
            } else {
                return false;
            }
        }

        boolean ans = false;

        if (A.charAt(i) == B.charAt(j)) {
//            indexes.add(i);
            boolean ans0 = ways(i + 1, j + 1, A, B, dp, indexes);
            boolean ans1 = ways(i + 1, j, A, B, dp, indexes);

            if (ans0 == true) {
                set.add(i);
            }

            ans = ans0 || ans1;
//            indexes.remove(indexes.size() - 1);
        } else {
            ways(i + 1, j, A, B, dp, indexes);
        }

        dp[i][j] = ans;
        return ans;
    }

    private static int areAllIndexesPresent(int N, Set<Integer> set) {
        int ans = 1;

        for (int i = 0; i < N; i++) {
            if (!set.contains(i)) {
                return 0;
            }
        }

        return ans;
    }
}
