package com.swapnil.java.practice;

public class FastPow {
    public static void main(String[] args) {
        System.out.println(fastPow(2, 5));
    }

    private static int fastPow(int a, int p) {
        if (p == 0) {
            return 1;
        }

        if (p == 1) {
            return a;
        }

        if (p % 2 != 0) {
            return a * fastPow(a, p - 1);
        }

        return fastPow(a, p / 2) * fastPow(a, p / 2);
    }
}
