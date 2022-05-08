package com.swapnil.java.practice.trees.segment;

public class SegmentTreeDriver {
    public static void main(String[] args) {
        MinSegmentTree tree = new MinSegmentTree(new int[]{5, 7, -4, 12, 18, 2, 21, 5, 1});
        System.out.println(tree.search(0, 2));
    }
}
