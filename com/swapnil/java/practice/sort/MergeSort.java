package com.swapnil.java.practice.sort;

public class MergeSort {

    public static int[] sort(int[] A) {
        mergeSort(A, 0, A.length - 1);
        return A;
    }

    public static void main(String[] args) {
        int[] input = new int[]{2, 3, 1, 5, 2, 6, 0};
        mergeSort(input, 0, input.length - 1);
        for (Integer e : input) {
            System.out.print(e + " ");
        }
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
}
