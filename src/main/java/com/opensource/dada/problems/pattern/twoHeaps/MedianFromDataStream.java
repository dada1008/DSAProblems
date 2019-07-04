package com.opensource.dada.problems.pattern.twoHeaps;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Problem: https://www.geeksforgeeks.org/median-of-stream-of-integers-running-integers/
 *          https://www.hackerrank.com/challenges/find-the-running-median/problem
 *          https://leetcode.com/problems/find-median-from-data-stream/
 */
public class MedianFromDataStream {

    public static void main(String[] args) {
        test1();
        test2();
        test3();
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
        if (maxHeap.isEmpty()) {
            maxHeap.add(n);
        } else if (maxHeap.size() == minHeap.size()) {
            if (n < minHeap.peek()) {
                maxHeap.add(n);
            } else {
                minHeap.add(n);
                maxHeap.add(minHeap.remove());
            }
        } else if (maxHeap.size() > minHeap.size()) {
            if (n > maxHeap.peek()) {
                minHeap.add(n);
            } else {
                maxHeap.add(n);
                minHeap.add(maxHeap.remove());
            }
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
