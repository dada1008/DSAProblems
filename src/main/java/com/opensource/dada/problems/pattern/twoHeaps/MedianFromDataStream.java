package com.opensource.dada.problems.pattern.twoHeaps;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Problem: https://www.geeksforgeeks.org/median-of-stream-of-integers-running-integers/
 *          https://www.hackerrank.com/challenges/find-the-running-median/problem
 *          https://leetcode.com/problems/find-median-from-data-stream/
 *
 * Design a class to calculate the median of a number stream.
 * The class should have the following two methods:
 *
 * insertNum(int num): stores the number in the class
 * findMedian(): returns the median of all numbers inserted in the class
 * If the count of numbers inserted in the class is even,
 * the median will be the average of the middle two numbers.
 *
 * Example 1:
 *
 * 1. insertNum(3)
 * 2. insertNum(1)
 * 3. findMedian() -> output: 2
 * 4. insertNum(5)
 * 5. findMedian() -> output: 3
 * 6. insertNum(4)
 * 7. findMedian() -> output: 3.5
 */
public class MedianFromDataStream {

    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
    }
    public static void test1() {
        System.out.println("Test1 result");
        medianTracker(new int[]{2,3,4});//2 2.5 3
    }

    public static void test2() {
        System.out.println("Test2 result");
        medianTracker(new int[]{12, 4, 5, 3, 8, 7});//Output 12.0 8.0 5.0 4.5 5.0 6.0
    }

    public static void test3() {
        System.out.println("Test3 result");
        medianTracker(new int[]{5, 15, 1, 3});//Output 5, 10, 5, 4
    }

    public static void test4() {
        System.out.println("Test4 result");
        medianTracker(new int[]{5, 10, 100, 200, 6, 13, 14});//Output 5, 7.5, 10, 55, 10, 11.5, 13
    }

    // - We use 2 Heaps to keep track of median
// - We make sure that 1 of the following conditions is always true:
//    1) maxHeap.size() == minHeap.size()
//    2) maxHeap.size() - 1 = minHeap.size()
    public static void medianTracker(int [] array) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); // keeps track of the SMALL numbers
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();                           // keeps track of the LARGE numbers


        for (int i = 0; i < array.length; i++) {
            addNumber(array[i], maxHeap, minHeap);
            System.out.println(getMedian(maxHeap, minHeap));
        }
    }

    private static void addNumber(int n, PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap) {
        if (maxHeap.isEmpty() || maxHeap.peek() >= n) {
            maxHeap.add(n);
        } else {
            minHeap.add(n);
        }

        // either both the heaps will have equal number of elements or max-heap will have one
        // more element than the min-heap
            if (maxHeap.size() > minHeap.size() + 1) {
                minHeap.add(maxHeap.poll());
            } else if (maxHeap.size() < minHeap.size()) {
                maxHeap.add(minHeap.poll());
            }
        // maxHeap will never have fewer elements than minHeap
    }

    private static double getMedian(PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap) {
        if (maxHeap.isEmpty()) {
            return 0;
        } else if (maxHeap.size() == minHeap.size()) {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        } else { // maxHeap must have more elements than minHeap
            return maxHeap.peek();
        }
    }
}
