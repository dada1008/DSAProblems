package com.opensource.dada.problems.pattern.mergeIntervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Problem:
 * <p>
 * Given a list of intervals, merge all the overlapping intervals to produce a list
 * that has only mutually exclusive intervals.
 * <p>
 * Example 1:
 * <p>
 * Intervals: [[1,4], [2,5], [7,9]]
 * Output: [[1,5], [7,9]]
 * Explanation: Since the first two intervals [1,4] and [2,5] overlap, we merged them into
 * one [1,5].
 * <p>
 * Example 2:
 * <p>
 * Intervals: [[6,7], [2,4], [5,9]]
 * Output: [[2,4], [5,9]]
 * Explanation: Since the intervals [6,7] and [5,9] overlap, we merged them into one [5,9].
 * <p>
 * Example 3:
 * <p>
 * Intervals: [[1,4], [2,6], [3,5]]
 * Output: [[1,6]]
 * Explanation: Since all the given intervals overlap, we merged them into one.
 */
public class MergeIntervals {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

    private static void test3() {
        List<Interval> intervals = new ArrayList<>(List.of(new Interval(1,4), new Interval(2,6), new Interval(3,5)));
        List<Interval> mergedIntervals = merge(intervals);
        System.out.println("Result:"+mergedIntervals);
    }

    private static void test2() {
        List<Interval> intervals = new ArrayList<>(List.of(new Interval(6,7), new Interval(2,4), new Interval(5,9)));
        List<Interval> mergedIntervals = merge(intervals);
        System.out.println("Result:"+mergedIntervals);
    }

    private static void test1() {
        List<Interval> intervals = new ArrayList<>(List.of(new Interval(1,4), new Interval(2,5), new Interval(7,9)));
        List<Interval> mergedIntervals = merge(intervals);
        System.out.println("Result:"+mergedIntervals);
    }

    static List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() < 2) {
            return intervals;
        }
        List<Interval> mergedIntervals = new LinkedList<>();
        Collections.sort(intervals, (a, b) -> a.start - b.start);
        Interval interval = intervals.get(0);
        int start = interval.start;
        int end = interval.end;
        for (int i = 1; i < intervals.size(); i++) {
            interval = intervals.get(i);
            if (interval.start <= end) {
                end = Math.max(end, interval.end);
            } else {
                mergedIntervals.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }
        }
        mergedIntervals.add(new Interval(start, end));
        return mergedIntervals;
    }
}
