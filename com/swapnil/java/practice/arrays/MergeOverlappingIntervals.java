package com.swapnil.java.practice.arrays;

import java.util.ArrayList;
import java.util.Collections;

public class MergeOverlappingIntervals {
    public static void main(String[] args) {
        ArrayList<Interval> intervals = new ArrayList<>();

        intervals.add(new Interval(1,10));
        intervals.add(new Interval(2,9));
        intervals.add(new Interval(3,8));
        intervals.add(new Interval(4,7));
        intervals.add(new Interval(5,6));
        intervals.add(new Interval(6,6));

        sort(intervals);
        intervals = merge(intervals);
        System.out.println(intervals);
    }

    private static ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        intervals = sort(intervals);
        ArrayList<Interval> res = new ArrayList<>();

        int cs = intervals.get(0).start; // currentStart
        int ce = intervals.get(0).end; // currentEnd
        int N = intervals.size();

        for (int i = 0; i < N - 1; i++) {
            Interval next = intervals.get(i + 1);

            if (overlapping(new Interval(cs, ce), next)) {
                cs = cs;
                ce = Math.max(ce, next.end);
            } else {
                res.add(new Interval(cs, ce));
                cs = next.start;
                ce = next.end;
            }
        }

        res.add(new Interval(cs, ce));

        return res;
    }

    private static ArrayList<Interval> sort(ArrayList<Interval> intervals) {
        Collections.sort(intervals, (o1, o2) -> {
            if (o1.start == o2.start) {
                return 0;
            } else if (o1.start < o2.start) {
                return -1;
            } else {
                return 1;
            }
        });

        return intervals;
    }

    private static boolean overlapping(Interval a, Interval b) {
        int s1 = a.start;
        int e1 = a.end;
        int s2 = b.start;
        int e2 = b.end;

        if (s2 <= e1 && e2 >= e1) {
            // Partial Overlap
            return true;
        }

        if (s1 <= s2 && e1 >= e2) {
            // Complete Overlap
            return true;
        }

        // No Overlap
        return false;
    }
}

class Interval {
    public int start;

    public int end;

    public Interval() {
        start = 0;
        end = 0;
    }

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
