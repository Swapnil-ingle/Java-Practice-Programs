package com.swapnil.java.practice.maths;

public class Summation {
    private static final int MOD = 1000000007;

    public static void main(String[] args) {
        System.out.println(solve(90));
        // System.out.println(pow(2, 1));
    }

    private static int solve(int A) {
        long t1 = A;
        long t2 = A - 1;
        long t3 = (pow(3, A - 2));
        long res = ((((t1 * t2) % MOD) * t3) % MOD);
        return (int) (res % MOD);
    }

    private static long pow(int base, int pow) {
        if (pow == 0) {
            return 1;
        }

        if (pow % 2 != 0) {
            // Odd power
            return ((((base * pow(base, pow/2)) % MOD) * pow(base, pow/2)) % MOD);
        }

        // Even power
        return ((pow(base, pow/2) * pow(base, pow/2)) % MOD);
    }
}
