package com.swapnil.java.practice.backtracking;

import java.util.*;

public class WordBreak2 {
    public static void main(String[] args) {
        System.out.println(solve("aabbbabaaabbbabaabaab"));
        // System.out.println(solve("catsanddog"));
    }

    private static Set<String> dict;

    private static List<String> solve(String A) {
        List<String> finalAns = new ArrayList<>();
        dict = new HashSet<>();

        // dict.addAll(Arrays.asList("aabbbbb", "babba"));
        dict.addAll(Arrays.asList("cat", "cats", "and", "dog", "sand"));
        dict.addAll(Arrays.asList("bababbbb", "bbbabaa", "abbb", "a", "aabbaab", "b", "babaabbbb", "aa", "bb"));

        recur(A, 0, "", finalAns);
        return finalAns;
    }

    private static void recur(String A, int i, String ans, List<String> finalAns) {
        // System.out.println("Recur: i" + i);
        if (i >= A.length()) {
            // Done travelling, find if answer is correct
            if (allPresentInDict(ans.split(" "))) {
                finalAns.add(ans);
            }
            return;
        }

        char cc = A.charAt(i);
        // Add blank at this place
        String lastToken = ans.substring(getLastSpaceIdx(ans));
        if (dict.contains(lastToken.trim())) {
            recur(A, i + 1, ans + " " + cc, finalAns);
        }

        // Remove blank from this place
        recur(A, i + 1, ans + cc, finalAns);
    }

    private static int getLastSpaceIdx(String ans) {
        int N = ans.length();

        for (int i = N - 1; i >= 0; i--) {
            if (ans.charAt(i) == ' ') {
                return i;
            }
        }

        return 0;
    }

    private static boolean allPresentInDict(String[] tokens) {
        for (String token : tokens) {
            if (!dict.contains(token)) {
                return false;
            }
        }

        return true;
    }
}
