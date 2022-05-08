package com.swapnil.java.practice.bits;

public class BitsOperations {
    public static void main(String[] args) {
        int a = 4;
        System.out.println(isIthLSBSet(a, 0));
        System.out.println(isIthLSBSet(a, 1));
        System.out.println(isIthLSBSet(a, 2));
        System.out.println(isIthLSBSet(a, 3));

        a = setIthLSB(a, 0);
        System.out.println(isIthLSBSet(a, 0));

        a = clearIthBit(a, 0);
        System.out.println(isIthLSBSet(a, 0));

        System.out.println("Dividing using bit operation");
        System.out.println(divideUsingBitOps(Integer.MIN_VALUE, -1));
    }

    /**
     * 0010
     * 0011
     * -----
     * 0010
     *
     * @param dividend
     * @param divisor
     * @return
     */
    public static int divideUsingBitOps(long dividend, long divisor) {
        if (dividend < 0 || divisor < 0) {
           int ans = divideUsingBitOps(dividend < 0 ? -Long.valueOf(dividend) : dividend, divisor < 0 ? -Long.valueOf(divisor) : divisor);

           if (dividend < 0 ^ divisor < 0) {
               return -ans;
           }

           return ans;
        }

        int ans = 0;

        for (int i = 31; i >= 0; i--) {
            if (dividend == 0) {
                break;
            }

            long bitContri = 1L << i;
            if ((divisor * bitContri) <= dividend) {
                ans += bitContri;
                dividend -= (divisor * bitContri);
            }
        }

        return ans;
    }

    public static int unsetIthBit(int a, int bitIdx) {
        return clearIthBit(a, bitIdx);
    }

    public static int clearIthBit(int a, int bitIdx) {
        int mask = 1 << bitIdx;

        if (isIthLSBSet(a, bitIdx)) {
            return a ^ mask;
        } else {
            return a;
        }
    }

    public static int setIthLSB(int a, int bitIdx) {
        int mask = 1 << bitIdx;
        return a | mask;
    }

    public static boolean isIthLSBSet(int a, int bitIdx) {
        int mask = 1 << bitIdx;

        if ((mask & a) != 0) {
            return true;
        }

        return false;
    }
}
