package com.opensource.dada.problems.pattern.mergeIntervals;

import java.util.Arrays;

/**
 * Problem: https://www.geeksforgeeks.org/find-intersection-of-all-intervals/
 */
public class FindIntersectionOfAllIntervals {
    public static void main(String[] args) {

        int intervals[][] = {{ 1, 6 },
                { 2, 8 },
                { 3, 10 },
                { 5, 8 }};
        System.out.println("Intersection of intervals:"+ Arrays.toString(intervals));
        findIntersection(intervals);

        int intervals2[][] = {{1, 6}, {8, 18}};
        System.out.println("Intersection of intervals:"+ Arrays.toString(intervals2));
        findIntersection(intervals2);
    }

    // Function to print the intersection
    static void findIntersection(int intervals[][])
    {
        int N = intervals.length;
        // First interval
        int l = intervals[0][0];
        int r = intervals[0][1];

        // Check rest of the intervals
        // and find the intersection
        for (int i = 1; i < N; i++)
        {

            // If no intersection exists
            if (intervals[i][0] > r ||
                    intervals[i][1] < l)
            {
                System.out.println(-1);
                return;
            }

            // Else update the intersection
            else
            {
                l = Math.max(l, intervals[i][0]);
                r = Math.min(r, intervals[i][1]);
            }
        }
        System.out.println ("[" + l +", " + r + "]");
    }
}
