package com.opensource.dada.problems.pattern.mergeIntervals;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

/**
 * Problem: https://www.geeksforgeeks.org/merging-intervals/
 * <p>
 * Step-by-step algo to solve the issue efficiently-
 * <p>
 * 1) Sort all intervals in decreasing order of start time.
 * 2) Traverse sorted intervals starting from first interval,
 * do following for every interval.
 * a) If current interval is not first interval and it
 * overlaps with previous interval, then merge it with
 * previous interval. Keep doing it while the interval
 * overlaps with the previous one.
 * b) Else add current interval to output list of intervals.
 */
public class MergeOverlappingIntervals {

    // The main function that takes a set of intervals, merges
    // overlapping intervals and prints the result
    public static void mergeIntervals(Interval arr[]) {
        // Sort Intervals in decreasing order of
        // start time
        Arrays.sort(arr, (i1, i2) -> Integer.compare(i1.start, i2.start));

        int index = 0; // Stores index of last element
        // in output array (modified arr[])

        // Traverse all input Intervals
        for (int i = 0; i < arr.length; i++) {
            // If this is not first Interval and overlaps
            // with the previous one
            if (index != 0 && arr[index - 1].start <= arr[i].end) {
                while (index != 0 && arr[index - 1].start <= arr[i].end) {
                    // Merge previous and current Intervals
                    arr[index - 1].end = Math.max(arr[index - 1].end, arr[i].end);
                    arr[index - 1].start = Math.min(arr[index - 1].start, arr[i].start);
                    index--;
                }
            } else // Doesn't overlap with previous, add to solution
                arr[index] = arr[i];
            index++;
        }

        // Now arr[0..index-1] stores the merged Intervals
        System.out.print("The Merged Intervals are: ");
        for (int i = 0; i < index; i++)
            System.out.print("[" + arr[i].start + "," + arr[i].end + "]");
    }

    public static void main(String args[]) {
        Interval arr[] = new Interval[4];
        arr[0] = new Interval(6, 8);
        arr[1] = new Interval(1, 9);
        arr[2] = new Interval(2, 4);
        arr[3] = new Interval(4, 7);
        mergeIntervals(arr);
    }
}

