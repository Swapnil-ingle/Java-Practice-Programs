package com.swapnil.java.practice.string;

public class ZAlgorithm {
    public static void main(String[] args) {
        String s = "swapnil";
        int[] z = getZAlgoArr(s);
        System.out.println(z);
    }

    private static int[] getZAlgoArr(String s) {
        return calZArr(s.toCharArray());
    }

    private static int[] calZArr(char[] S) {
        int L = 0;
        int R = 0;
        int N = S.length;
        int[] z = new int[N];

        for (int i = 1; i < N; i++) {
            if (i > R) {
                // This is unknown territory, do brute-force, matching each substring starting with i with prefix of entire string
                L = i;
                R = i;

                while (R < N && S[R] == S[R - L]) { // S[R - L] is the corresponding prefix idx of current idx
                    R++;
                }

                z[i] = R - L; // Here, (L to R) is substring which is also the prefix of string, so z[i] is length of L --> R which is R - L
                R--; // In while loop, R is going through one more value before failing, hence compensating here
            } else {
                // i is in between L - R, so we know that (current window is also the prefix of entire string) (Assumption#1)
                // As per Assumption#1, the z[i] of corresponding prefix element of current idx i (i - L), would also be the z[i] of current idx i
                // Given that, z[i] of corresponding prefix element (z[i - L] + i) does NOT exceed the current substring right bound R.
                // This is important because: we've not seen elements beyond R, and we cannot say that they're same as corresponding prefix element substring
                // We don't even know that there are ANY elements beyond R.

                if (z[i - L] + i <= R) {
                    // We can use the last value as current value of z[i]
                    z[i - L] = z[i];
                } else {
                    // Last value of z[i] exceeds the boundary of R
                    // We need to move L to i and expand R until it matches with it's corresponding prefix element

                    L = i; // Because at the end we calculate substring starting with i, and we are expanding R, so L needs to be moved ahead.

                    while (R < N && S[R] == S[R - L]) {
                        R++;
                    }

                    z[i] = R - L;
                    R--;
                }
            }
        }

        return z;
    }
}
