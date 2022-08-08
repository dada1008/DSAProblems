package com.opensource.dada.problems.pattern.mergeIntervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Problem:
 * Given a list of non-overlapping intervals sorted by their start time,
 * insert a given interval at the correct position and merge all necessary intervals
 * to produce a list that has only mutually exclusive intervals.
 *
 * Example 1:
 *
 * Input: Intervals=[[1,3], [5,7], [8,12]], New Interval=[4,6]
 * Output: [[1,3], [4,7], [8,12]]
 * Explanation: After insertion, since [4,6] overlaps with [5,7], we merged them into one [4,7].
 * Example 2:
 *
 * Input: Intervals=[[1,3], [5,7], [8,12]], New Interval=[4,10]
 * Output: [[1,3], [4,12]]
 * Explanation: After insertion, since [4,10] overlaps with [5,7] & [8,12], we merged them into [4,12].
 * Example 3:
 *
 * Input: Intervals=[[2,3],[5,7]], New Interval=[1,4]
 * Output: [[1,4], [5,7]]
 * Explanation: After insertion, since [1,4] overlaps with [2,3], we merged them into one [1,4].
 */
public class InsertInterval {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

    private static void test1() {
        List<Interval> intervals = new ArrayList<>(List.of(new Interval(1,3), new Interval(5,7), new Interval(8,12)));
        List<Interval> mergedIntervals = insert(intervals, new Interval(4, 6));
        System.out.println("Result:"+mergedIntervals);
    }

    private static void test2() {
        List<Interval> intervals = new ArrayList<>(List.of(new Interval(1,3), new Interval(5,7), new Interval(8,12)));
        List<Interval> mergedIntervals = insert(intervals, new Interval(4, 10));
        System.out.println("Result:"+mergedIntervals);
    }

    private static void test3() {
        List<Interval> intervals = new ArrayList<>(List.of(new Interval(2,3), new Interval(5,7)));
        List<Interval> mergedIntervals = insert(intervals, new Interval(1,4));
        System.out.println("Result:"+mergedIntervals);
    }
    static List<Interval> insert(List<Interval> intervals, Interval interval) {
        List<Interval> mergedIntervals = new LinkedList<>();
        if (intervals==null || intervals.isEmpty()) {
            mergedIntervals.add(interval);
            return mergedIntervals;
        }
        int index = -1;
        for (int i = 0; i < intervals.size(); i++) {
            Interval itvl = intervals.get(i);
            if (itvl.start > interval.start) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            intervals.add(interval);
        } else {
            intervals.add(index, interval);
        }
        Interval startingInterval = intervals.get(0);
        int start = startingInterval.start;
        int end = startingInterval.end;
        for (int i = 1; i < intervals.size(); i++) {
            Interval itvl = intervals.get(i);
            if (itvl.start <= end) {
                end = Math.max(end, itvl.end);
            } else {
                mergedIntervals.add(new Interval(start, end));
                start = itvl.start;
                end = itvl.end;
            }
        }
        mergedIntervals.add(new Interval(start, end));
        return mergedIntervals;
    }
}
