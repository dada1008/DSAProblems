package com.opensource.dada.problems.pattern.topKElements;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Problem: https://www.geeksforgeeks.org/k-largestor-smallest-elements-in-an-array/
 *
 * Given an unsorted array of numbers, find the ‘K’ largest numbers in it.
 *
 * Note: For a detailed discussion about different approaches to solve this problem,
 * take a look at Kth Smallest Number.
 *
 * Example 1:
 *
 * Input: [3, 1, 5, 12, 2, 11], K = 3
 * Output: [5, 12, 11]
 * Example 2:
 *
 * Input: [5, 12, 11, -1, 12], K = 3
 * Output: [12, 11, 12]
 */
public class KLargestElementsInArray {
    public static void main(String[] args) {
        test1();
        test2();
    }

    static void test1(){
        /**
         * Integer arr[] = new Integer[] { 1, 23, 12, 9,
         *                                         30, 2, 50 };
         *         int k = 3;
         *
         * Output: 23 30 50
         */
        kLargest(new Integer[] { 1, 23, 12, 9, 30, 2, 50 }, 3);
    }

    static void test2(){
        /**
         * Integer arr[] = new Integer[] { 11, 3, 2, 1, 15, 5, 4,
         *                            45, 88, 96, 50, 45 };
         *         int k = 3;
         *
         * Output: 50 88 96
         */
        kLargest(new Integer[] { 11, 3, 2, 1, 15, 5, 4,45, 88, 96, 50, 45 }, 3);
    }

    public static void kLargest(Integer[] arr, int k)
    {
        // create a min heap
        PriorityQueue<Integer> heap
                = new PriorityQueue<>();

        //maintain a heap of size k.
        for (Integer entry : arr) {
            heap.offer(entry);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        // Print the first kth largest elements
        while(!heap.isEmpty()) {
            System.out.print(heap.poll() + " ");
        }
        System.out.println("");
    }
}
