package com.swapnil.java.practice.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SquaredArray {
    private static int ANS;

    public static void main(String[] args) {
        System.out.println(solve(new int[]{25}));
    }

    private static int solve(int[] A) {
        Map<Integer, Integer> map = new HashMap<>();
        ANS = 0;

        for (Integer e : A) {
            if (map.get(e) == null) {
                map.put(e, 1);
            } else {
                map.put(e, map.get(e) + 1);
            }
        }
        solve(new ArrayList<>(), A, map);
        return ANS;
    }

    private static void solve(List<Integer> temp, int[] A, Map<Integer, Integer> map) {
        if (temp.size() == A.length) {
            if (temp.size() == 1) {
                if (isPerfectSquare(A[0])) {
                    ANS++;
                }
            } else {
                ANS++;
            }
            return;
        }

        if (temp.size() == 0) {
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getValue() > 0) {
                    entry.setValue(entry.getValue() - 1);
                    temp.add(entry.getKey());
                    solve(temp, A, map);
                    temp.remove(temp.size() - 1);
                    entry.setValue(entry.getValue() + 1);
                }
            }
        } else {
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getValue() > 0 &&
                        (isPerfectSquare(temp.get(temp.size() - 1) + entry.getKey()))) {
                    entry.setValue(entry.getValue() - 1);
                    temp.add(entry.getKey());
                    solve(temp, A, map);
                    temp.remove(temp.size() - 1);
                    entry.setValue(entry.getValue() + 1);
                }
            }
        }
    }

    private static boolean isPerfectSquare(int A) {
        int root = (int) Math.sqrt(A);
        return root * root == A;
    }
}
