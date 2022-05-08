package com.swapnil.java.practice.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class RemoveInvalidParenthesis {
    public static void main(String[] args) {
        System.out.println(solve(")(o)(()x)(m)()"));
    }

    private static Set<String> finalAns;

    private static ArrayList<String> solve(String A) {
        finalAns = new HashSet<String>();
        solve(A, 0, 0, 0, "");
        return toArrayList(finalAns);
    }

    private static ArrayList<String> toArrayList(Set<String> set) {
        ArrayList<String> res = new ArrayList<>();

        for (String s : set) {
            res.add(s);
        }

        return res;
    }

    private static void solve(String A, int i, int o, int c, String ans) {
        if (c > o) {
            // This is an invalid config
            return;
        }

        // Base Cond
        if (i >= A.length()) {
            if (o == c) {
                // Done traversing the String (Reached the end)
                // Number of open and closed paranthesis are balanced
                // Make sure that the ans is the biggest of the one's we've seen
                // Biggest answer means that smallest number of parenthesis were removed
                if (finalAns.isEmpty()) {
                    finalAns.add(ans);
                } else {
                    if (ans.length() == getAnElementFrom(finalAns).length()) {
                        finalAns.add(ans);
                    } else if (ans.length() > getAnElementFrom(finalAns).length()) {
                        // New record for length, going forward consider this length as new benchmark
                        finalAns.clear();
                        finalAns.add(ans);
                    } else {
                        // This ans is smaller than the ones we've seen before, ignore this...
                    }
                }
            }
            return;
        }

        char cc = A.charAt(i); // Current char

        while (i < A.length() && !isParanthesis(A.charAt(i))) {
            cc = A.charAt(i);
            ans += cc;
            i++;
        }

        if (i < A.length()) {
            cc = A.charAt(i);
        }

        // Take the current char is it is not parenthesis
        if (cc == '(') {
            solve(A, i + 1, o + 1, c, ans + cc);
        } else if (cc == ')') {
            // This is a closed bracket - make sure that #openBracket are more than closed
            solve(A, i + 1, o, c + 1, ans + cc);
        }

        // Leave for another path
        solve(A, i + 1, o, c, ans);
    }

    private static String getAnElementFrom(Set<String> finalAns) {
        return finalAns.iterator().next();
    }

    private static boolean isParanthesis(char c) {
        return c == '(' || c == ')';
    }
}
