package com.swapnil.java.practice.dp;

public class LongestPalindromeSubstring {
    public static void main(String[] args) {
        String A = "nayanan";
        System.out.println(longestPalindromeSubstring(getPalindromeDpMatrix(A), A));
    }

    /**
     * Returns longest palindrome substring (leftmost)
     * @param dp
     */
    private static String longestPalindromeSubstring(int[][] dp, String A) {
        int N = A.length();
        int i = 0;
        int j = N - 1;
        int cc = j;

        while (true) {
            if (dp[i][j] == 1) {
                return A.substring(i, j + 1);
            }

            if (j == N - 1) {
                i = 0;
                --cc;
                j = cc;
                continue;
            }

            i++;
            j++;
        }
    }

    private static void print(int[][] dp) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println("");
        }
    }

    private static int[][] getPalindromeDpMatrix(String A) {
        int N = A.length();
        int[][] dp = new int[N][N];

        // Fill Diagonals as 1
        for (int i = 0; i < N; i++) {
            dp[i][i] = 1;
        }

        // Fill 2 length substring values
        for (int i = 0; i < N - 1; i++) {
            int j = i + 1;

            if (A.charAt(i) == A.charAt(j)) {
                dp[i][j] = 1;
            }
        }

        // Fill rest of the upper diagonal
        for (int i = N - 3; i >= 0; i--) {
            for (int j = N - 1; j >= 2; j--) {
                if (A.charAt(i) == A.charAt(j) && dp[i + 1][j - 1] == 1) {
                    dp[i][j] = 1;
                }
            }
        }

        return dp;
    }
}
