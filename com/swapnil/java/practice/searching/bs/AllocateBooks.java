package com.swapnil.java.practice.searching.bs;

public class AllocateBooks {
    public static void main(String[] args) {
        System.out.println(books(new int[]{12, 34, 67, 90}, 2));
    }

    private static int books(int[] A, int B) {
        int N = A.length;
        if (B > N) {
            return -1;
        }

        int LL = 0;
        int UL = 0;

        for (int i = 0; i < N; i++) {
            UL += A[i];
            LL = LL < A[i] ? A[i] : LL;
        }

        return bs(A, 0, Integer.MAX_VALUE, B);
    }

    private static int bs(int[] A, int start, int end, int B) {
        if (start >= end) {
            return end;
        }

        int mid = (start + end) / 2;

        if (isAllocationPossible(A, mid, B)) {
            return bs(A, start, mid, B);
        } else {
            return bs(A, mid + 1, end, B);
        }
    }

    private static boolean isAllocationPossible(int[] A, int pages, int students) {
        int req = 1;
        int currPages = 0;

        for (int i = 0; i < A.length; i++) {
            currPages += A[i];

            if (currPages > pages) {
                req++;
                currPages = A[i];
            }
        }

        if (req > students) {
            return false;
        } else {
            return true;
        }
    }
}
