package com.swapnil.java.practice.searching.bs;

import java.util.ArrayList;
import java.util.List;

public class BinarySearch {
    public static void main(String[] args) {
        System.out.println(bs(1, new int[]{1, 1, 2, 4, 7, 14, 17, 29, 90}));
        List<Integer> arrList = new ArrayList<>();
        Integer[] arr = arrList.toArray(new Integer[]{});
    }

    private static int bs(int k, int[] arr) {
        return bs(k, arr, 0, arr.length);
    }

    private static int bs(int k, int[] arr, int start, int end) {
        if (start > end) {
            return -1;
        }

        int mid = (end + start) / 2;

        if (k < arr[mid]) {
            return bs(k, arr, start, mid - 1);
        } else if (k > arr[mid]) {
            return bs(k, arr, mid + 1, end);
        } else {
            return arr[mid];
        }
    }
}
