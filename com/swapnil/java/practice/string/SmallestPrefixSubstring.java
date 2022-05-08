package com.swapnil.java.practice.string;

public class SmallestPrefixSubstring {
    public static void main(String[] args) {
        System.out.println(smallestPrefix("tom", "riddle"));
    }

    private static String smallestPrefix(String A, String B) {
        StringBuilder sb = new StringBuilder();

        for (char c : A.toCharArray()) {
            if ((int) c <= (int) B.charAt(0)) {
                sb.append(c);
            } else {
                break;
            }
        }

        if (sb.length() == 0) {
            sb.append(A.charAt(0));
        }

        sb.append(B.charAt(0));

        return sb.toString();
    }
}
