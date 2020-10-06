package com.opensource.dada.problems.pattern.mergeIntervals;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Problem:
 * Given two lists of intervals, find the intersection of these two lists.
 * Each list consists of disjoint intervals sorted on their start time.
 * <p>
 * Example 1:
 * <p>
 * Input: arr1=[[1, 3], [5, 6], [7, 9]], arr2=[[2, 3], [5, 7]]
 * Output: [2, 3], [5, 6], [7, 7]
 * Explanation: The output list contains the common intervals between the two lists.
 * Example 2:
 * <p>
 * Input: arr1=[[1, 3], [5, 7], [9, 12]], arr2=[[5, 10]]
 * Output: [5, 7], [9, 10]
 * Explanation: The output list contains the common intervals between the two lists.
 */
public class IntervalsIntersection {
    public static void main(String[] args) {
        test1();
        test2();
    }

    private static void test1() {
        List<Interval> mergedIntervals = merge(
                List.of(new Interval(1,3), new Interval(5,6), new Interval(7,9))
                , List.of(new Interval(2, 3), new Interval(5, 7))
        );
        System.out.println("Result:"+mergedIntervals);
    }

    private static void test2() {
        List<Interval> mergedIntervals = merge(
                List.of(new Interval(1,3), new Interval(5,7), new Interval(9,12))
                , List.of(new Interval(5, 10))
        );
        System.out.println("Result:"+mergedIntervals);
    }

    static List<Interval> merge(List<Interval> list1, List<Interval> list2) {
        List<Interval> mergedIntervals = new LinkedList<>();
        int start1 = 0, start2 = 0;

        while (start1 < list1.size() && start2 < list2.size()) {
            Interval interval1 = list1.get(start1);
            Interval interval2 = list2.get(start2);
            if ((interval1.start >= interval2.start && interval1.start <= interval2.end)
                    || (interval2.start >= interval1.start && interval2.start <= interval1.end)) {
                int start = Math.max(interval1.start, interval2.start);
                int end = Math.min(interval1.end, interval2.end);
                mergedIntervals.add(new Interval(start, end));
            }
            if (interval1.end<interval2.end) {
                start1++;
            } else {
                start2++;
            }
        }
        return mergedIntervals;
    }
}
