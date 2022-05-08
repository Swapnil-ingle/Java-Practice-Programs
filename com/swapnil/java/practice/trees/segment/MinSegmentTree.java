package com.swapnil.java.practice.trees.segment;

import java.util.Arrays;

import static java.lang.Math.min;

public class MinSegmentTree {
    private int[] SGT;

    public int[] getSGT() {
        return SGT;
    }

    public MinSegmentTree(int[] seed) {
        int n = seed.length;
        SGT = new int[4 * n];
        build(0, n - 1, SGT, seed, 0);
    }

    /**
     * Returns a value of node for range (s, e)
     *
     * @param l Start of range (Inclusive)
     * @param r end of range (Inclusive)
     * @return
     */
    public int search(int l, int r) {
        return search(0, ((SGT.length)/4) - 1, 0, l, r);
    }

    private int search(int s, int e, int i, int l, int r) {
        if (r < s || l > e) {
            // Non-overlap --> Return Identity --> In this case Integer.Min
            return Integer.MAX_VALUE;
        }

        if (l <= s && e <= r) {
            // Complete overlap --> Return node val
            return SGT[i];
        }

        // Partial overlap --> Search both children
        int m = (s + e) / 2;

        int lc = search(s, m, (2*i) + 1, l, r);
        int rc = search(m+1, e, (2*i) + 2, l ,r);

        return min(lc, rc);
    }


    public void update(int tarIdx, int tar) {
        update(0, ((SGT.length) / 4) - 1, 0, tarIdx, tar);
    }

    /**
     *
     * @param s -->
     * @param e
     * @param i
     * @param tarIdx
     * @param tar
     */
    private void update(int s, int e, int i, int tarIdx, int tar) {
        if (tarIdx < s || tarIdx > e) {
            return;
        }

        if (s == e && s == tarIdx) {
            SGT[i] = tar;
            return;
        }

        int m = (s + e) / 2;
        int lc = (2 * i) + 1;
        int rc = (2 * i) + 2;

        update(s, m, lc, tarIdx, tar);
        update(m + 1, e, rc, tarIdx, tar);

        SGT[i] = min(SGT[lc], SGT[rc]);
    }

    public void print() {

        for (Integer e :  SGT) {
            System.out.print(e + " ");
        }

        System.out.println();
    }

    private int build(int s, int e, int[] sgt, int[] seed, int idx) {
        if (s == e) {
            SGT[idx] = seed[s];
            return SGT[idx];
        }

        int m = (s + e) / 2;
        int lc = build(s, m, sgt, seed, (2 * idx) + 1);
        int rc = build(m + 1, e, sgt, seed, (2 * idx) + 2);

        sgt[idx] = min(rc, lc);
        return sgt[idx];
    }
}
