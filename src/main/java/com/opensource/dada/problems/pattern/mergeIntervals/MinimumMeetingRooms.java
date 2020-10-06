package com.opensource.dada.problems.pattern.mergeIntervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Problem:
 * Given a list of intervals representing the start and end time of ‘N’ meetings,
 * find the minimum number of rooms required to hold all the meetings.
 *
 * Example 1:
 *
 * Meetings: [[1,4], [2,5], [7,9]]
 * Output: 2
 * Explanation: Since [1,4] and [2,5] overlap, we need two rooms to hold these two meetings. [7,9] can
 * occur in any of the two rooms later.
 * Example 2:
 *
 * Meetings: [[6,7], [2,4], [8,12]]
 * Output: 1
 * Explanation: None of the meetings overlap, therefore we only need one room to hold all meetings.
 * Example 3:
 *
 * Meetings: [[1,4], [2,3], [3,6]]
 * Output:2
 * Explanation: Since [1,4] overlaps with the other two meetings [2,3] and [3,6], we need two rooms to
 * hold all the meetings.
 *
 * Example 4:
 *
 * Meetings: [[4,5], [2,3], [2,4], [3,5]]
 * Output: 2
 * Explanation: We will need one room for [2,3] and [3,5], and another room for [2,4] and [4,5].
 *
 * Here is a visual representation of Example 4:
 */
public class MinimumMeetingRooms {
    public static void main(String[] args) {
        System.out.println("Result:"+findMinMeetingRooms(
                new ArrayList<>(List.of(new Interval(1,4), new Interval(2,5), new Interval(7,9))))
        );//2

        System.out.println("Result:"+findMinMeetingRooms(
                new ArrayList<>(List.of(new Interval(6,7), new Interval(2,4), new Interval(8,12))))
        );//1

        System.out.println("Result:"+findMinMeetingRooms(
                new ArrayList<>(List.of(new Interval(1,4), new Interval(2,3), new Interval(3,6))))
        );//2

        System.out.println("Result:"+findMinMeetingRooms(
                new ArrayList<>(List.of(new Interval(4,5), new Interval(2,3), new Interval(2,4), new Interval(3,5))))
        );//2
    }

    static int findMinMeetingRooms(List<Interval> meetings) {
        Collections.sort(meetings, (a, b) -> a.start - b.start);
        PriorityQueue<Interval> minHeap = new PriorityQueue<>(meetings.size(),
                (a, b) -> Integer.compare(a.end, b.end));
        int minRooms = 0;
        for (Interval interval: meetings) {
            while (!minHeap.isEmpty() && interval.start >= minHeap.peek().end) {
                minHeap.poll();
            }
            minHeap.offer(interval);

            minRooms = Math.max(minRooms, minHeap.size());
        }
        return minRooms;
    }
}
