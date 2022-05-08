package com.swapnil.java.practice.stack;

import java.util.Stack;

public class CheckTwoBracketExpression {
    public static void main(String[] args) {
        String A = "-(a+b)-(z)+(p-q+r)-(e+f)";
        String B = "-e-f-(-p+q-r)+(-a-b)-z";
        System.out.println(solve(A, B));
    }

    private static int solve(String A, String B) {
        char[] A1 = resolve(A.toCharArray());
        char[] B1 = resolve(B.toCharArray());

        if (A1.length != B1.length) {
            return 0;
        }

        return allSignsMatch(A1, B1);
    }

    private static int allSignsMatch(char[] a1, char[] b1) {
        int[] a1OperandSigns = getSignArr(a1);
        int[] b1OperandSigns = getSignArr(b1);

        for (int i = 0; i < 26; i++) {
            if (a1OperandSigns[i] != b1OperandSigns[i]) {
                return 0;
            }
        }

        return 1;
    }

    private static int[] getSignArr(char[] a) {
        int[] signs = new int[26];

        for (int i = 0; i < a.length; i++) {
            if (a[i] != '+' && a[i] != '-') {
                int charIdx = a[i] - 97;
                // This is an operand
                if (i == 0) {
                    // The sign for this idx is +
                    signs[charIdx] = 1;
                } else if (a[i - 1] == '-') {
                    // The sign for this charIdx is -1
                    signs[charIdx] = -1;
                } else if (a[i - 1] == '+') {
                    signs[charIdx] = 1;
                }
            }
        }

        return signs;
    }

    private static char[] resolve(char[] A) {
        Stack<Integer> lastOp = new Stack<>();

        int i = 0;
        int N = A.length;

        while (i < N) {
            if (A[i] == '(') {
                if (i == 0) {
                    lastOp.push(0);
                } else {
                    lastOp.push(A[i - 1] == '-' ? -1 : 1);
                }
            } else if (A[i] == ')') {
                A[i] = '$';
                int op = lastOp.pop();

                while (A[i] != '(') {
                    if (op == -1 && (A[i] == '-' || A[i] == '+')) {
                        // Reverse every operator
                        char oppOperator = A[i] == '-' ? '+' : '-';
                        A[i] = oppOperator;
                    }

                    i--;
                }

                A[i] = '$';
                // If the neighboring cells of '(' both has operator this needs to be merged
                if (i > 0 && i < A.length - 1 && (isOperator(A[i - 1]) && isOperator(A[i + 1]))) {
                    int op1 = A[i - 1];
                    int op2 = A[i + 1];

                    if (op1 != op2) {
                        if (op1 == '-') {
                            // Diff operator --> resulting in + (As right neighboring operator of ( already is flipped)
                            A[i + 1] = '$';
                            A[i - 1] = '+';
                        } else {
                            A[i + 1] = '$';
                            A[i - 1] = '-';
                        }
                    } else {
                        if (op1 == '-') {
                            // Same operator --> resulting in - (As right neighboring operator of ( already is flipped)
                            A[i + 1] = '$';
                            A[i - 1] = '-';
                        } else {
                            A[i + 1] = '$';
                            A[i - 1] = '+';
                        }
                    }
                }
            }

            i++;
        }

        return removeDollars(A);
    }

    private static boolean isOperator(char op) {
        return op == '+' || op == '-';
    }

    private static char[] removeDollars(char[] A) {
        StringBuilder sb = new StringBuilder();

        int idx = 0;

        while (A[idx] == '+') {
            // Trim prefix '+' sign
            idx++;
        }

        for (int i = idx; i < A.length; i++) {
            if (A[i] != '$') {
                sb.append(A[i]);
            }
        }

        return sb.toString().toCharArray();
    }
}
