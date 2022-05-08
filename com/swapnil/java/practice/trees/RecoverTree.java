//package com.swapnil.java.practice.trees;
//
//public class RecoverTree {
//    public int[] recoverTree(TreeNode A) {
//        return morrify(A);
//    }
//
//    private static int[] morrify(TreeNode curr) {
//        if (curr == null) {
//            return new int[]{};
//        }
//
//        TreeNode root = curr;
//        TreeNode par = null;
//        Integer first = null;
//        Integer second = null;
//
//        while (root != null) {
//            if (root.left == null) {
//                // We've arrived at a leaf node
//                int L = par == null ? Integer.MIN_VALUE : par.val;
//                int R = root.right == null  ? Integer.MAX_VALUE : root.right.val;
//
//                // Update ans
//                boolean cond = ((L <= root.val) && (root.val <= R));
//                // System.out.println("Cond is " + cond + String.format(" root: %d L: %d and R: %d", root.val, L, R));
//                if (!cond) {
//                    if (first == null) {
//                        first = root.val;
//                    } else {
//                        second = root.val;
//                    }
//                }
//
//                // Move on then
//                par = root;
//                root = root.right;
//            } else {
//                TreeNode pred = pre(root);
//
//                if (pred.right == root) {
//                    // We've arrived at a loop, go right
//                    int L = par == null ? Integer.MIN_VALUE : par.val;
//                    int R = root.right == null ? Integer.MAX_VALUE : root.right.val;
//
//                    // Update ans
//                    boolean cond = ((L <= root.val) && (root.val <= R));
//                    // System.out.println("Cond is " + cond + String.format(" root: %d L: %d and R: %d", root.val, L, R));
//                    if (!cond) {
//                        if (first == null) {
//                            first = root.val;
//                        } else {
//                            second = root.val;
//                        }
//                    }
//
//                    // Move on then
//                    par = root;
//                    root = root.right;
//                    pred.right = null; // UNDO
//                } else {
//                    pred.right = root; // DO
//                    root = root.left;
//                }
//            }
//        }
//
//        int min = first < second ? first : second;
//        int max = first > second ? first : second;
//
//        return new int[]{min, max};
//    }
//
//    private static TreeNode pre(TreeNode root) {
//        // System.out.println("Finding pre of: " + root.val);
//        TreeNode temp = root.left;
//
//        while (temp.right != null && temp.right != root) {
//            temp = temp.right;
//        }
//
//        // System.out.println("Pre of: " + root.val + " is " + temp.val);
//        return temp;
//    }
//}
