package com.swapnil.java.practice.ds.linkedlist;

public class NumberOfInversion {
    private static int inversions = 0;

    public static void main(String[] args) {
        int[] arr = new int[]{28, 18, 44, 49, 41, 14};
//        print(merge(arr, 5, 6, 9));
        mergeSort(arr, 0, arr.length - 1);
        print(arr);
        System.out.println(inversions);
    }

    private static void mergeSort(int[] base, int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;
            mergeSort(base, l, m);
            mergeSort(base, m + 1, r);
            merge(base, l, m, r);
        }
    }

    private static void merge(int[] base, int l, int m, int r) {
        int[] tempL = new int[(m - l) + 1];
        int[] tempR = new int[r - m];
        int[] tempF = new int[r - l + 1];

        for (int i = 0; i < tempL.length; i++) {
            tempL[i] = base[l + i];
        }

        for (int i = 0; i < tempR.length; i++) {
            tempR[i] = base[m + 1 + i];
        }

        int p1 = 0;
        int p2 = 0;

        for (int p3 = l; p3 <= r; p3++) {
            if (p1 > (m - l)) {
                tempF[p3 - l] = tempR[p2];
                p2++;
            } else if (p2 > (r - m) - 1) {
                tempF[p3 - l] = tempL[p1];
                p1++;
            } else if (tempL[p1] < tempR[p2]) {
                tempF[p3 - l] = tempL[p1];
                p1++;
            } else {
                tempF[p3 - l] = tempR[p2];
                p2++;
            }
        }

        for (int i = l; i <= r; i++) {
            if (base[i] > tempF[i - l]) {
                inversions++;
            }

            base[i] = tempF[i - l];
        }
    }

    private static void print(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
}
