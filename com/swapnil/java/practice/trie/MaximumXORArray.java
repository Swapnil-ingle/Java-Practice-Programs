package com.swapnil.java.practice.trie;

import java.util.*;

public class MaximumXORArray {
    public static void main(String[] args) {
        MaximumXORArray obj = new MaximumXORArray();
        int[] a = new int[]{1,2,3,4,5};
        int[] res = obj.solve(a);
        System.out.println(res[0] + " " + res[1]);
    }

    public int[] solve(int[] A) {
        int[] pre = new int[A.length + 1];

        for (int i = 0; i < A.length; i++) {
            pre[i + 1] = A[i];
        }

        for (int i = 1; i < pre.length; i++) {
            pre[i] = pre[i - 1] ^ pre[i];
        }

        Trie root = new Trie();

        int finalL = 0;
        int finalR = 0;
        int maxXor = 0;

        for (int j = 0; j < pre.length; j++) { // j ~ r
            String bin = String.format("%31s", Integer.toBinaryString(pre[j])).replace(' ', '0');

            // Add to Trie
            // System.out.println("Adding bin to Trie: " + bin + String.format("[%d]", pre[j]));
            Trie.insert(root, bin, j);

            // Find optimal XOR - Either it will be itself or a prefix
            int xor = Trie.getOptimalXOROf(root, bin);
            int newL = Trie.getOptimalXORIdxOf(root, bin) + 1;

            if (j == 0) {
                continue;
            }

            if (xor == maxXor) {
              // See if new length is smaller than previous length
                if (j - newL < finalR - finalL) {
                    finalL = newL;
                    finalR = j;
                }
            } else if (xor > maxXor) {
                finalL = newL;
                finalR = j;
                maxXor = xor;
            }
        }

        // Trie.print(root);

        return new int[] {finalL, finalR};
    }

    private static List<String> toBinaryStrings(int[] A) {
        List<String> res = new ArrayList<>();

        for (Integer e : A) {
            String bin = String.format("%31s", Integer.toBinaryString(e)).replace(' ', '0');
            res.add(bin);
        }

        return res;
    }
}

class Trie {
    boolean isEnd;

    Map<String, Trie> children;

    int index;

    public Trie() {
        isEnd = false;
        children = new HashMap<>();
    }

    public static void print(Trie root) {
        if (root == null) {
            return;
        }

        Queue<Pair<String, Trie>> q = new LinkedList<>();

        for (Map.Entry<String, Trie> entry : root.children.entrySet()) {
            q.add(Pair.makePair(entry.getKey(), entry.getValue()));
        }

        while (!q.isEmpty()) {
            Pair<String, Trie> temp = q.remove();

            for (Map.Entry<String, Trie> e : temp.second.children.entrySet()) {
                q.add(Pair.makePair(temp.first + e.getKey(), e.getValue()));
            }

            if (temp.second.isEnd) {
                System.out.println(temp.first + String.format("(idx: %d)", temp.second.index));
            }
        }
    }

    public static boolean isPresent(Trie root, String input) {
        int n = input.length();
        Trie temp = root;

        for (int i = 0; i < n; i++) {
            String c = String.valueOf(input.charAt(i));

            if (temp.children.get(c) != null) {
                temp = temp.children.get(c);
            } else {
                return false;
            }
        }

        return temp.isEnd;
    }

    public static int getOptimalXOROf(Trie root, String input) {
        Trie temp = root;
        int N = input.length();
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < N; i++) {
            String c = String.valueOf(input.charAt(i));
            String opp = c.equals("0") ? "1" : "0";

            if (temp.children.get(opp) != null) {
                res.append("1"); // As the opposite children is present, XOR of the bit would be 1
                temp = temp.children.get(opp);
            } else {
                res.append("0"); // As the opposite children is NOT present, XOR of the bit would be 0
                temp = temp.children.get(c);
            }
        }

        return Integer.parseInt(res.toString(), 2);
    }

    public static int getOptimalXORIdxOf(Trie root, String input) {
        Trie temp = root;
        int N = input.length();
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < N; i++) {
            String c = String.valueOf(input.charAt(i));
            String opp = c.equals("0") ? "1" : "0";

            if (temp.children.get(opp) != null) {
                res.append("1"); // As the opposite children is present, XOR of the bit would be 1
                temp = temp.children.get(opp);
            } else {
                res.append("0"); // As the opposite children is NOT present, XOR of the bit would be 0
                temp = temp.children.get(c);
            }
        }

        return temp.index;
    }

    public static void insert(Trie root, String input, int idx) {
        Trie temp = root;
        int N = input.length();

        for (int i = 0; i < N; i++) {
            String c = String.valueOf(input.charAt(i));

            if (temp.children.get(c) != null) {
                // Curr Node has an outgoing edge as ${c}.
                // Move to that edge
                temp = temp.children.get(c);
            } else {
                // Curr Node does NOT have an outgoing branch
                // as ${c}.
                // Create that branch
                Trie newTrieNode = new Trie();
                temp.children.put(c, newTrieNode);
                temp = newTrieNode;
            }
        }

        temp.isEnd = true;
        temp.index = idx;
    }
}

class Pair<A,B> {
    public A first;

    public B second;

    private Pair(A first, B second) {
        this.first = first;
        this.second = second;
    }

    public static Pair makePair(String a, Trie b) {
        return new Pair<String, Trie>(a, b);
    }

    @Override
    public String toString() {
        return "Pair{" +
                "a=" + first +
                ", b=" + second +
                '}';
    }
}
