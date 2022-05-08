package com.swapnil.java.practice;

public class BoringSubstring {
    public static void main(String[] args) {
        System.out.println(solve("abcd"));
    }

    private static boolean solve(String A) {
        int[] FA = new int[26];
        char[] input = A.toCharArray();
        String even = "";
        String odd = "";

        for (int i = 0; i < input.length; i++) {
            char c = input[i];
            FA[c - 97] = FA[c - 97] + 1;
        }

        for (int i = 0; i < 26; i += 2) {
            if (FA[i] != 0) {
                even += (char) (i + 97);
            }
        }

        for (int i = 1; i < 26; i += 2) {
            if (FA[i] != 0) {
                odd += (char) (i + 97);
            }
        }

        char largestEven = even.charAt(even.length() - 1);
        char smallestOdd = odd.charAt(0);
        char largestOdd = odd.charAt(odd.length() - 1);
        char smallestEven = even.charAt(0);

        if (!areNeighboring(largestEven, smallestOdd) || !areNeighboring(largestOdd, smallestEven)) {
            return true;
        }

        return false;
    }

    private static boolean areNeighboring(char c1, char c2) {
        return c2 == c1 + 1 || c2 == c1 - 1;
    }
}
