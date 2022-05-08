package com.swapnil.java.practice.arrays;

public class GenerateMatrix {
    public static void main(String[] args) {
        int[][] res = generateMatrix(3);
        System.out.println(res);
    }

    private static int[][] generateMatrix(int A) {
        int[][] res = new int[A][A];
        int s = 0;
        int e = A - 1;
        int i = 0;
        int j = 0;
        int c = 1;

        while (s <= e) {
            // Move Right (i, j++)
            while (j <= e) {
                res[i][j] = c;
                c++;
                j++;
            }
            i++;
            j--;

            // Move Down (i++, j)
            while (i <= e) {
                res[i][j] = c;
                c++;
                i++;
            }
            j--;
            i--;

            // Move Left (i, j--)
            while (j >= s) {
                res[i][j] = c;
                c++;
                j--;
            }
            s++;
            e--;
            j++;
            i--;

            if (s > e) {
                return res;
            }

            // Move Up (i--, j)
            while (i >= s) {
                res[i][j] = c;
                c++;
                i--;
            }
            j++;
            i++;
        }

        return res;
    }
}
