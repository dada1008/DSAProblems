package com.opensource.dada.problems.pattern.topKElements;

import java.util.*;

/**
 * Problem: https://www.geeksforgeeks.org/k-largestor-smallest-elements-in-an-array/
 *          https://www.geeksforgeeks.org/find-k-numbers-occurrences-given-array/
 *          https://www.programcreek.com/2014/05/leetcode-top-k-frequent-elements-java/
 *
 * Given an unsorted array of numbers, find the top ‘K’ frequently occurring numbers in it.
 *
 * Example 1:
 *
 * Input: [1, 3, 5, 12, 11, 12, 11], K = 2
 * Output: [12, 11]
 * Explanation: Both '11' and '12' apeared twice.
 * Example 2:
 *
 * Input: [5, 12, 11, 3, 11], K = 2
 * Output: [11, 5] or [11, 12] or [11, 3]
 * Explanation: Only '11' appeared twice, all other numbers appeared once.
 */
public class TopKFrequentNumbers {
    public static void main(String[] args) {

        /**
         * Input : arr[] = {3, 1, 4, 4, 5, 2, 6, 1},
         *              k = 2
         * Output : 4 1
         * Frequency of 4 = 2
         * Frequency of 1 = 2
         * These two have the maximum frequency and
         * 4 is larger than 1.
         */
        int k = 2;
        System.out.println("top "+k+" frequent elements:"+topKFrequent(new int[]{3, 1, 4, 4, 5, 2, 6, 1}, k));
        /**
         * Input : arr[] = {7, 10, 11, 5, 2, 5, 5, 7, 11, 8, 9},
         *             k = 4
         * Output : 5 11 7 10
         */
        k = 4;
        System.out.println("top "+k+" frequent elements:"+topKFrequent(new int[]{7, 10, 11, 5, 2, 5, 5, 7, 11, 8, 9}, k));

    }

    public static List<Integer> topKFrequent(int[] nums, int k) {
        //count the frequency for each element
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // create a min heap
        PriorityQueue<Map.Entry<Integer, Integer>> heap
                = new PriorityQueue<>(Comparator.comparing(e -> e.getValue()));

        //maintain a heap of size k.
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            heap.offer(entry);
            if (heap.size() > k) {
                heap.poll();
            }
        }

        //get all elements from the heap
        List<Integer> result = new ArrayList<>();
        while (heap.size() > 0 ) {
            result.add(heap.poll().getKey());
        }

        //reverse the order
        Collections.reverse(result);

        return result;
    }
}
