package com.swapnil.java.practice.heaps;

public class MaxPossibleHeaps {
    private static final int M = 1000000007;

    public static void main(String[] args) {
        System.out.println(solve(100));
    }

    private static int solve(int A) {
        return (int) (ways(A) % M);
    }

    private static long ways(long N) {
        if (N <= 2) {
            return 1;
        }

        long h = log2(N);
        long l = min(N - (fastPow(2, h) - 1), fastPow(2, h - 1)) + (fastPow(2, h - 1) - 1);
        long r = (N - 1) - l;
        return ncr(N - 1, l, new int[(int)N][(int)l + 1]) * ways(l) * ways(r);
    }

    private static long ncr(long n, long r, int[][] memo) {
        if (r == 0 | r == n) {
            return 1;
        }

        if (memo[(int) n][(int) r] != 0) {
            return memo[(int) n][(int) r];
        }

        long ans = ncr(n-1,r-1, memo) + ncr(n-1,r,memo);
        ans = (ans % M);
        memo[(int) n][(int) r] = (int) ans;
        return ans;
    }

    private static long comb(long n, long k, int[][] nck) {
        if (k > n)
            return 0L;

        if (n <= 1)
            return 1L;

        if (k == 0)
            return 1L;

        if (nck[(int)n][(int)k] != -1L)
            return nck[(int)n][(int)k];

        long answer = comb(n - 1L, k - 1L, nck) + comb(n - 1L, k, nck);
        answer %= M;
        nck[(int)n][(int)k] = (int) (answer % M);
        return answer;
    }

    private static long fact(long i) {
        long res = 1;

        while (i >= 1) {
            res = ((res * i) % M);
            i--;
        }

        return res;
    }

    private static long fastPow(long a, long p) {
        if (p == 0) {
            return 1;
        }

        if (p % 2 != 0) {
            // Odd power
            return a * fastPow(a, p - 1);
        }

        return fastPow(a, p/2) * fastPow(a, p/2);
    }

    private static long min(long a, long b) {
        return a < b ? a : b;
    }

    private static long log2(long x) {
        return (long) (Math.log(x) / Math.log(2L));
    }
}