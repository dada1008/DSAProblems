package com.opensource.dada.problems.pattern.mergeIntervals;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Problem:
 * For ‘K’ employees, we are given a list of intervals representing the working hours of each employee.
 * Our goal is to find out if there is a free interval that is common to all employees.
 * You can assume that each list of employee working hours is sorted on the start time.
 *
 * Example 1:
 *
 * Input: Employee Working Hours=[[[1,3], [5,6]], [[2,3], [6,8]]]
 * Output: [3,5]
 * Explanation: Both the employess are free between [3,5].
 * Example 2:
 *
 * Input: Employee Working Hours=[[[1,3], [9,12]], [[2,4]], [[6,8]]]
 * Output: [4,6], [8,9]
 * Explanation: All employess are free between [4,6] and [8,9].
 * Example 3:
 *
 * Input: Employee Working Hours=[[[1,3]], [[2,4]], [[3,5], [7,9]]]
 * Output: [5,7]
 * Explanation: All employess are free between [5,7].
 */
public class EmployeeFreeTime {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }
    static void test1() {
        List<Interval> emp1 = new ArrayList<>(List.of(new Interval(1,3), new Interval(5,6)));
        List<Interval> emp2 = new ArrayList<>(List.of(new Interval(2,3), new Interval(6,8)));
        List<List<Interval>> schedule = new ArrayList<>();
        schedule.add(emp1);
        schedule.add(emp2);
        System.out.println("Result:"+findEmployeeFreeTime2(schedule));//[3,5]
    }

    static void test2() {
        List<Interval> emp1 = new ArrayList<>(List.of(new Interval(1,3), new Interval(9,12)));
        List<Interval> emp2 = new ArrayList<>(List.of(new Interval(2,4), new Interval(6,8)));
        List<List<Interval>> schedule = new ArrayList<>();
        schedule.add(emp1);
        schedule.add(emp2);
        System.out.println("Result:"+findEmployeeFreeTime2(schedule));//[4,6], [8,9]
    }

    static void test3() {
        List<Interval> emp1 = new ArrayList<>(List.of(new Interval(1,3), new Interval(2,4)));
        List<Interval> emp2 = new ArrayList<>(List.of(new Interval(3,5), new Interval(7,9)));
        List<List<Interval>> schedule = new ArrayList<>();
        schedule.add(emp1);
        schedule.add(emp2);
        System.out.println("Result:"+findEmployeeFreeTime2(schedule));//[5,7]
    }

    //This solution takes N*logN time complexity
    static List<Interval> findEmployeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> intervals = schedule.stream().flatMap(Collection::stream).collect(Collectors.toList());
        Collections.sort(intervals, (a, b) -> a.start - b.start);
        List<Interval> mergedIntervals = new LinkedList<>();
        for (int i = 1; i < intervals.size(); i++) {
            Interval left = intervals.get(i-1);
            Interval right = intervals.get(i);
            if (left.end<right.start) {
                mergedIntervals.add(new Interval(left.end, right.start));
            }
        }
        return mergedIntervals;
    }

    //This solution takes N*logK time complexity, At any time the heap will not have more than ‘K’ elements.
    static List<Interval> findEmployeeFreeTime2(List<List<Interval>> schedule) {
        List<Interval> mergedIntervals = new LinkedList<>();

        PriorityQueue<EmployeeInterval> minHeap = new PriorityQueue<>(
                (a, b) -> Integer.compare(a.interval.start, b.interval.start)
        );
        //Insert 1st interval of each employee to queue
        for (int i = 0; i < schedule.size(); i++) {
            List<Interval> intervals = schedule.get(i);
            minHeap.offer(new EmployeeInterval(i,0, intervals.get(0)));
        }

        Interval previousInterval = minHeap.peek().interval;

        while (!minHeap.isEmpty()) {
            EmployeeInterval queueTop = minHeap.poll();
            // if previousInterval is not overlapping with the next interval, insert a free interval
            if (previousInterval.end < queueTop.interval.start) {
                mergedIntervals.add(new Interval(previousInterval.end, queueTop.interval.start));
                previousInterval = queueTop.interval;
            } else {
                // overlapping intervals, update the previousInterval if needed
                if (previousInterval.end < queueTop.interval.end) {
                    previousInterval = queueTop.interval;
                }
            }
            // if there are more intervals available for the same employee, add their next interval
            List<Interval> empSchedule = schedule.get(queueTop.employeeIndex);
            if (empSchedule.size() > queueTop.intervalIndex + 1) {
                EmployeeInterval empInterval = new EmployeeInterval(
                        queueTop.employeeIndex,
                        queueTop.intervalIndex+1,
                        empSchedule.get(queueTop.intervalIndex+1)
                );
                minHeap.offer(empInterval);
            }

        }

        return mergedIntervals;
    }
}
