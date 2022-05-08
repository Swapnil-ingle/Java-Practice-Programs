package com.swapnil.java.practice.backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    private static int target = 0;

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(2);
        list.add(3);
        list.add(6);
        list.add(2);
        list.add(7);
        list.sort(((o1, o2) -> o1 < o2 ? -1 : 1));
        combinationSum(list, 7);
    }

    private static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> temp = new ArrayList<Integer>();
        target = B;

        res = solve(A.toArray(new Integer[]{}), temp, res, 0, 0);
        return res;
    }

    private static ArrayList<ArrayList<Integer>> solve(Integer[] A, ArrayList<Integer> temp, ArrayList<ArrayList<Integer>> res, int sum, int idx) {
        if (idx >= A.length) {
            return res;
        }
        if (sum > target) {
            return res;
        }
        if (sum == target) {
            res.add((ArrayList<Integer>) temp.clone());
            return res;
        }

        temp.add(A[idx]);
        solve(A, temp, res, sum + A[idx], idx);
        temp.remove(temp.size() - 1);
        solve(A, temp, res, sum, idx + 1);
        return res;
    }
}
