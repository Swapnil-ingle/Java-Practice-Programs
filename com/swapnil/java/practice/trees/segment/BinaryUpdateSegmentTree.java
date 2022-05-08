package com.swapnil.java.practice.trees.segment;

import java.util.ArrayList;

public class BinaryUpdateSegmentTree {
    private int[] SGT;

    public static void main(String[] args) {
//        BinaryUpdateSegmentTree sgt = new BinaryUpdateSegmentTree(13);
//        sgt.print();
//        sgt.update(7 - 1);
//        sgt.print();
        StringBuilder sb = new StringBuilder();
        Character c = 'a';
        sb.append(c);
        System.out.println("a".charAt(2));
//        System.out.println(sgt.indexOfythOne(8) + 1); // 9 1 8 -1 11 3
    }

    public BinaryUpdateSegmentTree(int A) {
        SGT = new int[4 * A];
        build(0, A - 1, 0);
    }

    /**
     * Query x=0: Updates the tarIdx to 0 (0 based indexing)
     */
    public void update(int tarIdx) {
        update(0, (SGT.length / 4) - 1, 0, tarIdx);
    }

    /**
     * Query x=1: Returns index of y'th 1
     */
    public int indexOfythOne(int idxOf1) {
        return indexOfythOne(0, (SGT.length / 4) - 1, 0, idxOf1);
    }

    public void print() {
        for (Integer e :  SGT) {
            System.out.print(e + " ");
        }
        System.out.println();
    }

    private int indexOfythOne(int s, int e, int i, int idxOf1) {
        if (SGT[i] < idxOf1 || idxOf1 <= 0) {
            return -1;
        }

        if (s == e && SGT[i] == 1) {
            return s;
        }

        int m = (s + e) / 2;
        int lc = indexOfythOne(s, m, (2 * i) + 1, idxOf1);
        int rc = indexOfythOne(m + 1, e, (2 * i) + 2, idxOf1 - SGT[(2 * i) + 1]);

        return Math.max(lc, rc);
    }

    private void update(int s, int e, int i, int tarIdx) {
        if (s > tarIdx || e < tarIdx) {
            return;
        }

        if (s == e && s == tarIdx) {
            SGT[i] = 0;
            return;
        }

        int m = (s + e) / 2;
        int lc = (2 * i) + 1;
        int rc = lc + 1;

        update(s, m, lc, tarIdx);
        update(m + 1, e, rc, tarIdx);

        SGT[i] = SGT[lc] + SGT[rc];
    }

    private void build(int s, int e, int i) {
        if (s == e) {
            SGT[i] = 1;
            return;
        }

        int m = (s + e)/2;
        int lc = (2 * i) + 1;
        int rc = lc + 1;

        build(s, m, lc);
        build(m + 1, e, rc);

        SGT[i] = SGT[lc] + SGT[rc];
    }
}
