package com.swapnil.java.practice.sort;

/**
 * Given an array of integers A, we call (i, j) an important reverse pair if i < j and A[i] > (2 * A[j]).
 * <p>
 * Return the number of important reverse pairs in the given array A.
 */
public class ReversePairs {
    private static final int MOD = 1000000007;

    private static int ANS;

    public static void main(String[] args) {
        ANS = 0;
        int[] A = new int[]{2000000000,2000000000,-2000000000};
        mergeSort(A, 0, A.length - 1);
        System.out.println(ANS);
    }

    private static void mergeSort(int[] A, int s, int e) {
        if (s >= e) {
            return;
        }
        int m = (s + e) / 2;
        mergeSort(A, s, m);
        mergeSort(A, m + 1, e);
        sort(A, s, m, m + 1, e);
    }

    private static void sort(int[] A, int s1, int e1, int s2, int e2) {
        int p1 = s1;
        int p2 = s2;
        int[] temp = new int[((e1 - s1) + 1) + ((e2 - s2) + 1)];

        calculateAns(A, p1, p2, e1, e2);

        for (int i = 0; i < temp.length; i++) {
            if (p1 <= e1 && p2 <= e2) {

                if (A[p1] <= A[p2]) {
                    temp[i] = A[p1];
                    p1++;
                } else {
                    temp[i] = A[p2];
                    p2++;
                }
            } else {
                if (p1 > e1) {
                    temp[i] = A[p2];
                    p2++;
                } else {
                    temp[i] = A[p1];
                    p1++;
                }
            }
        }

        int k = 0;
        for (int i = s1; i <= e1; i++) {
            A[i] = temp[k];
            k++;
        }

        for (int i = s2; i <= e2; i++) {
            A[i] = temp[k];
            k++;
        }
    }

    private static void calculateAns(int[] a, int s1, int s2, int e1, int e2) {
        int i = s1;
        int j = s2;

        while (i <= e1 && j <= e2) {
            if (a[i] > (2L * a[j])) {
                // We know that all the following elements from (i, e1)
                // are also greater for (j)
                int noOfRemainingEle = (e1 - i) + 1;
                ANS += noOfRemainingEle;
                j++;
            } else {
                // We know that all the elements from (i, e1)
                // would be lesser than (j, e2), hence we move the i
                i++;
            }
        }
    }
}
