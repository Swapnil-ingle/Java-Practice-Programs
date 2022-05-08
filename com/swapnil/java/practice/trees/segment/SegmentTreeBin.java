package com.swapnil.java.practice.trees.segment;

public class SegmentTreeBin {
    public static void main(String[] args) {
        SegmentTreeBin treeBin = new SegmentTreeBin(8);
        treeBin.decrement(3);
        System.out.println(treeBin.search(3,7));
        treeBin.print();
    }

    private int[] SGT;

    public SegmentTreeBin(int seedSize) {
        SGT = new int[(4 * seedSize)];
    }

    /**
     * Query#1: Increment target Idx (0 based indexing)
     */
    public void increment(int tarIdx) {
        increment(0, (SGT.length / 4) - 1, 0, tarIdx, true);
    }

    /**
     * Query#2: Decrement target Idx (0 based indexing)
     */
    public void decrement(int tarIdx) {
        increment(0, (SGT.length / 4) - 1, 0, tarIdx, false);
    }

    /**
     * Query#3: Search from (l, r) (Inclusive in 0 based indexing)
     */
    public int search(int l, int r) {
        return search(0, (SGT.length / 4) - 1, 0, l, r);
    }

    public void print() {

        for (Integer e :  SGT) {
            System.out.print(e + " ");
        }

        System.out.println();
    }

    private int search(int s, int e, int i, int l, int r) {
        if (r < s|| l > e) {
            // Non overlap, return identity as we don't want contribution of this range
            return 0;
        }

        if (l <= s && r >= e) {
            // Complete overlap, what we're looking for (l, r) is bigger than curr range (s, e)
            // So, no need to go to the children and we can just take contribution of node
            return SGT[i];
        }

        // Partial overlap, explore both branches
        int m = (s + e) / 2;
        int lc = search(s, m, (2 * i) + 1, l, r);
        int rc = search(m + 1, e, (2 * i) + 2, l ,r);

        return lc + rc;
    }

    private void increment(int s, int e, int i, int tarIdx, boolean isOpIncrement) {
        if (tarIdx < s || tarIdx > e) {
            // i is out of bound of curr range (s, e) don't explore this branch further
            return;
        }

        if (s == e && s == tarIdx) {
            if (isOpIncrement) {
                SGT[i] = SGT[i] + 1;
            } else {
                SGT[i] = SGT[i] == 0 ? 0 : SGT[i] - 1;
            }
            return;
        }

        int m = (s + e) / 2;
        int lc = (2 * i) + 1;
        int rc = (2 * i) + 2;
        increment(s, m, lc, tarIdx, isOpIncrement);
        increment(m + 1, e, rc, tarIdx, isOpIncrement);

        SGT[i] = SGT[lc] + SGT[rc];
    }
}
