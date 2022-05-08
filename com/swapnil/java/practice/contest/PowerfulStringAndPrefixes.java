package com.swapnil.java.practice.contest;

import java.util.HashMap;
import java.util.Map;

public class PowerfulStringAndPrefixes {
    public static void main(String[] args) {
        String A = "bca";
        int B = 2;
        int C = 4;
        System.out.println(solve(A, B, C));
    }

    private static final Integer M = 1000000007;

    private static int solve(String A, int B, int C) {
        String lexi = getSmallestLexiString(A);
        Map<String, Pair> map = new HashMap<>();
        int ANS = 0;
        int CP = 0; // Current Power
        int N = A.length();
        boolean oddInner = true;
        boolean odd = true; // First char is odd, keep altering this

        for (int i = 0; i < B; i++) {
            for (char ch : odd ? A.toCharArray() : lexi.toCharArray()) {
                String c = String.valueOf(ch);
                int cpc = getPowerOfChar(c, map);
                updatePower(c, map, oddInner);
                int npc = getPowerOfChar(c, map);

                if (npc > cpc) {
                    CP++;
                } else {
                    CP--;
                }

                if (CP == C) {
                    ANS = ((ANS + 1) % M);
                }
                oddInner = !oddInner;
            }
            odd = !odd;
        }

        return ANS;
    }

    private static void updatePower(String c, Map<String, Pair> map, boolean odd) {
        Pair pair = map.get(c);
        if (pair != null) {
            if (odd) {
                pair.o++;
            } else {
                pair.e++;
            }
        } else {
            pair = new Pair();
            if (odd) {
                pair.o = 1;
            } else {
                pair.e = 1;
            }
            map.put(c, pair);
        }
    }

    private static int getPowerOfChar(String c, Map<String, Pair> map) {
        if (map.get(c) == null) {
            return 0;
        }

        Pair pair = map.get(c);
        return diff(pair.e, pair.o);
    }

    private static int diff(int a, int b) {
        return a > b ? a - b : b - a;
    }

    private static String makePowerful(String A, int B) {
        String lexi = getSmallestLexiString(A);
        StringBuilder sb = new StringBuilder();
        boolean og = true;

        for (int i = 0; i < B; i++) {
            if (og) {
                sb.append(A);
            } else {
                sb.append(lexi);
            }

            og = !og;
        }

        return sb.toString();
    }

    private static String getSmallestLexiString(String input) {
        int[] dict = new int[26];
        for (char c : input.toCharArray()) {
            dict[c - 97]++;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 26; i++) {
            while (dict[i] > 0) {
                sb.append((char) ('a' + i));
                dict[i]--;
            }
        }

        return sb.toString();
    }

    static class Pair {
        int e;

        int o;

        public Pair() {
            this.e = 0;
            this.o = 0;
        }

        public Pair(int e, int o) {
            this.e = e;
            this.o = o;
        }
    }
}
