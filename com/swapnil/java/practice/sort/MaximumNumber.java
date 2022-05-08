package com.swapnil.java.practice.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaximumNumber {
    public static void main(String[] args) {
        // System.out.println(getMax(new int[] {3, 30, 34, 5, 9, 0, 0, 0, 0}));
        System.out.println(getMax(new int[] {0, 0, 0, 0}));
    }

    private static String getMax(int[] A) {
        List<Integer> list = new ArrayList<>();
        Arrays.stream(A).forEach(e -> list.add(e));

        list.sort((k1, k2) -> {
            String a1a2 = k1 + String.valueOf(k2);
            String a2a1 = k2 + String.valueOf(k1);

            if (Long.valueOf(a1a2) > Long.valueOf(a2a1)) {
                return -1;
            } else {
                return 1;
            }
        });

        return handleAllZeros(list);
    }

    private static String handleAllZeros(List<Integer> list) {
        StringBuilder sb = new StringBuilder();

        for (Integer e : list) {
            if (e == 0 && sb.length() == 0) {
                // This is starting with 0, skip
                continue;
            }

            sb.append(e);
        }

        if (sb.length() <= 0) {
            sb.append(0);
        }

        return sb.toString();
    }
}
