package com.swapnil.java.practice.stack;

import java.util.ArrayList;
import java.util.List;

public class FindNearestSmallerLeftElement {
    public static void main(String[] args) {
        int[] A = new int[]{-1, 1, 4, 5, 2, 0, 8};
        printArr(findNearestSmallerLeftElement(A));
        printArr(findNearestSmallerElementLeft(A));
        printArr(findNearestSmallerThanOrEqualRightElement(A));
        printArr(findNearestSmallerElementRight(A));
    }

    private static int[] findNearestSmallerElementRight(int[] A) {
        int N = A.length;
        int p1 = N - 1;
        int p2 = N - 2;
        int[] res = new int[N];
        res[N - 1] = N;

        while (p2 >= 0) {
            if (A[p1] < A[p2]) {
                res[p2] = p1;
                p1--;
                p2--;
            } else {
                while (p1 != N && A[p1] >= A[p2]) {
                    p1 = res[p1];
                }

                res[p2] = p1;
                p1 = p2;
                p2--;
            }
        }

        return res;
    }

    private static int[] findNearestSmallerElementLeft(int[] A) {
        int N = A.length;
        int p1 = 0;
        int p2 = 1;
        int[] res = new int[N];
        res[0] = -1;

        while (p2 < N) {
            if (A[p1] < A[p2]) {
                res[p2] = p1;
                p1++;
                p2++;
            } else {
                while (p1 != -1 && A[p1] >= A[p2]) {
                    p1 = res[p1];
                }

                res[p2] = p1;
                p1 = p2;
                p2++;
            }
        }

        return res;
    }

    private static int findSumMaxMinusMinOfEverySubArray(int[] A) {
        int[] SL = findNearestSmallerLeftElement(A);
        int[] SR = findNearestSmallerThanOrEqualRightElement(A);
        int[] GL = findNearestGreaterLeftElement(A);
        int[] GR = findNearestGreaterThanOrEqualRightElement(A);
        long res = 0;

        for (int i = 0; i < A.length; i++) {
            long numOfSubArrWithIMin = (i - SL[i]) * (SR[i] - i);
            long numOfSubArrWithIMax = (i - GL[i]) * (GR[i] - i);
            res = res + (A[i] * (numOfSubArrWithIMax - numOfSubArrWithIMin));
        }

        return (int) res;
    }

    private static int[] findNearestGreaterThanOrEqualRightElement(int[] A) {
        int N = A.length;
        int[] res = new int[N];
        res[N - 1] = N;

        int p1 = N - 1;
        int p2 = p1 - 1;

        for (int i = N - 1; i > 0; i--) {
            if (A[p1] >= A[p2]) {
                res[p2] = p1;
                p1--;
                p2--;
            } else {
                while (p1 != N && A[p1] < A[p2]) {
                    p1 = res[p1];
                }

                res[p2] = p1;
                p1 = p2;
                p2--;
            }
        }

        return res;
    }

    private static int[] findNearestSmallerThanOrEqualRightElement(int[] A) {
        int N = A.length;
        int[] res = new int[N];
        res[N - 1] = N;

        int p1 = N - 1;
        int p2 = p1 - 1;

        for (int i = N - 1; i > 0; i--) {
            if (A[p1] <= A[p2]) {
                res[p2] = p1;
                p1--;
                p2--;
            } else {
                while (p1 != N && A[p1] > A[p2]) {
                    p1 = res[p1];
                }

                res[p2] = p1;
                p1 = p2;
                p2--;
            }
        }

        return res;
    }

    private static int[] findNearestGreaterLeftElement(int[] A) {
        int N = A.length;
        int[] res = new int[N];
        res[0] = -1;

        int p1 = 0;
        int p2 = p1 + 1;

        for (int i = 1; i < N; i++) {
            if (A[p1] > A[p2]) {
                res[p2] = p1;
                p1++;
                p2++;
            } else {
                while (p1 != -1 && A[p1] <= A[p2]) {
                    p1 = res[p1];
                }

                res[p2] = p1;
                p1 = p2;
                p2++;
            }
        }

        return res;
    }

    private static int[] findNearestSmallerLeftElement(int[] A) {
        int N = A.length;
        int[] res = new int[N];
        res[0] = -1;

        int p1 = 0;
        int p2 = p1 + 1;

        for (int i = 1; i < N; i++) {
            if (A[p1] < A[p2]) {
                res[p2] = p1;
                p1++;
                p2++;
            } else {
                while (p1 != -1 && A[p1] >= A[p2]) {
                    p1 = res[p1];
                }

                res[p2] = p1;
                p1 = p2;
                p2++;
            }
        }

        return res;
    }

    private static void printArr(int[] A) {
        for (int i = 0; i < A.length; i++) {
            System.out.print(A[i] + " | ");
        }
        System.out.println("");
    }

    public class Stack {
        private List<Integer> stack;

        private int top;

        public Stack() {
            stack = new ArrayList<>();
            top = -1;
        }

        public boolean isEmpty() {
            return top == -1;
        }

        public void push(int x) {
            stack.add(x);
            top++;
        }

        public void pop() {
            if (isEmpty()) {
                return;
            }

            stack.remove(top);
            top--;
        }

        public int top() {
            if (isEmpty()) {
                return -1;
            }

            return stack.get(top);
        }
    }
}
