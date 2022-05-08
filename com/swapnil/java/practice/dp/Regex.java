package com.swapnil.java.practice.dp;

public class Regex {
    public static void main(String[] args) {
        System.out.println(iterativeRegex("bacb", "b*c*?*"));
        System.out.println(iterativeRegex("aaa", "*a"));
        System.out.println(iterativeRegex("aaa", "*"));
        System.out.println(iterativeRegex("aa", "*b"));
    }

    private static int iterativeRegex(String A, String P) {
        int pl = P.length();
        int al = A.length();

        boolean[][] dp = new boolean[pl + 1][al + 1];

        // Last cell (Empty Pattern --> Empty String) will always be true
        dp[pl][al] = true;

        // Fill empty pattern --> Each string
        for (int c = 0; c < al; c++) {
            dp[pl][c] = false;
        }

        // Fill empty string --> pattern
        for (int r = 0; r < pl; r++) {
            dp[r][al] = false;
        }

        if (P.charAt(pl - 1) == '*') {
            dp[pl-1][al] = true;
        }

        // Iterate and fill DP array
        for (int j = pl - 1; j >= 0; j--) {
            for (int i = al - 1; i >= 0; i--) {
                if (A.charAt(i) == P.charAt(j)) {
                  dp[j][i] = true;
                } else if (P.charAt(j) == '?') {
                    dp[j][i] = dp[j + 1][i + 1];
                } else if (P.charAt(j) == '*') {
                    dp[j][i] = dp[j + 1][i] || dp[j][i + 1];
                } else {
                    dp[j][i] = false;
                }
            }
        }

//        RotateNbyNMatrix.printMatrix(dp);

        return dp[0][0] == true ? 1 : 0;
    }

    private static int isMatch(final String A, final String B) {
        Boolean[][] dp = new Boolean[A.length() + 1][B.length() + 1];
        boolean match = regex(0, 0, A, removeConsecutiveStars(B), dp);
        return match ? 1 : 0;
    }

    private static boolean regex(int i, int j, String S, String P, Boolean[][] dp) {
        if (i >= S.length()) {
            // Seed pointer has ran out
            if (j == P.length() - 1 && P.charAt(j) == '*') {
                // Pattern Pointer is at the last place and it is *
                // Everything remaining in the seed pointer will be a match
                return true;
            } else if (j < P.length()) {
                // Pattern pointer is still incomplete
                return false;
            }
            return true;
        }

        if (j >= P.length()) {
            // Pattern pointer has ran out
            if (i < S.length()) {
                // Seed pointer is still incomplete
                return false;
            }
            return true;
        }

        if (dp[i][j] != null) {
            return dp[i][j];
        }

        char pc = P.charAt(j); // Pattern curr char
        char sc = S.charAt(i); // Seed curr char

        boolean match = true;

        if (pc == sc || pc == '?') {
            dp[i][j] = true;
            match = regex(i + 1, j + 1, S, P, dp);
        } else if (pc == '*') {
            match = regex(i + 1, j, S, P, dp) || regex(i, j + 1, S, P, dp);
            dp[i][j] = match;
        } else {
            match = false;
            dp[i][j] = false;
            return false;
        }

        return match;
    }

    private static String removeConsecutiveStars(String A) {
        StringBuilder sb = new StringBuilder();

        for (char c : A.toCharArray()) {
            if (sb.length() > 0) {
                char last = sb.charAt(sb.length() - 1);

                if (c == '*' && last == '*') {
                    continue;
                }
            }

            sb.append(c);
        }

        return sb.toString();
    }
}
