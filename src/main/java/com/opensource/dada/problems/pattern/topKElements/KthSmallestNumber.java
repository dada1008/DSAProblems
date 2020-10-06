package com.opensource.dada.problems.pattern.topKElements;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Problem:
 *
 * Given an unsorted array of numbers, find Kth smallest number in it.
 *
 * Please note that it is the Kth smallest number in the sorted order, not the Kth distinct element.
 *
 * Note: For a detailed discussion about different approaches to solve this problem,
 * take a look at Kth Smallest Number.
 *
 * Example 1:
 *
 * Input: [1, 5, 12, 2, 11, 5], K = 3
 * Output: 5
 * Explanation: The 3rd smallest number is '5', as the first two smaller numbers are [1, 2].
 * Example 2:
 *
 * Input: [1, 5, 12, 2, 11, 5], K = 4
 * Output: 5
 * Explanation: The 4th smallest number is '5', as the first three small numbers are [1, 2, 5].
 * Example 3:
 *
 * Input: [5, 12, 11, -1, 12], K = 3
 * Output: 11
 * Explanation: The 3rd smallest number is '11', as the first two small numbers are [5, -1].
 */
public class KthSmallestNumber {
    //Time complexity: O(N∗logK)
    //Space complexity: O(K)
    public static int findKthSmallestNumber(int[] nums, int k) {
        // create a min heap
        PriorityQueue<Integer> heap
                = new PriorityQueue<>(Collections.reverseOrder());

        //maintain a heap of size k.
        for (Integer entry : nums) {
            heap.offer(entry);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        return heap.peek();
    }

    /**
     * Solution:
     *
     * We can use the Median of Medians algorithm to choose a good pivot for
     * the partitioning algorithm of the Quicksort.
     * This algorithm finds an approximate median of an array in linear time O(N)O(N).
     * When this approximate median is used as the pivot,
     * the worst-case complexity of the partitioning procedure reduces to linear O(N)O(N),
     * which is also the asymptotically optimal worst-case complexity of any sorting/selection algorithm.
     * This algorithm was originally developed by Blum, Floyd, Pratt, Rivest,
     * and Tarjan and was describe in their 1973 paper.
     *
     * This is how the partitioning algorithm works:
     *
     * If we have 5 or less than 5 elements in the input array, we simply take its first element as the pivot.
     * If not then we divide the input array into subarrays of five elements
     * (for simplicity we can ignore any subarray having less than five elements).
     * Sort each subarray to determine its median. Sorting a small and
     * fixed numbered array takes constant time. At the end of this step,
     * we have an array containing medians of all the subarray.
     * Recursively call the partitioning algorithm on the array containing medians until we get our pivot.
     * Every time the partition procedure needs to find a pivot, it will follow the above three steps.
     *
     */
    public static int findKthSmallestNumberUsingQuicksortMedianOfMedians(int[] nums, int k) {
        return findKthSmallestNumberRec(nums, k, 0, nums.length - 1);
    }
    public static int findKthSmallestNumberRec(int[] nums, int k, int start, int end) {
        int p = partition(nums, start, end);
        if (p == k - 1)
            return nums[p];
        if (p > k - 1) // search lower part
            return findKthSmallestNumberRec(nums, k, start, p - 1);
        // search higher part
        return findKthSmallestNumberRec(nums, k, p + 1, end);
    }
    private static int partition(int[] nums, int low, int high) {
        if (low == high)
            return low;
        int median = medianOfMedians(nums, low, high);
        // find the median in the array and swap it with 'nums[high]' which will become our pivot
        for (int i = low; i < high; i++) {
            if (nums[i] == median) {
                swap(nums, i, high);
                break;
            }
        }
        int pivot = nums[high];
        for (int i = low; i < high; i++) {
            // all elements less than 'pivot' will be before the index 'low'
            if (nums[i] < pivot)
                swap(nums, low++, i);
        }
        // put the pivot in its correct place, remember nums[high] is our pivot
        swap(nums, low, high);
        return low;
    }
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private static int medianOfMedians(int[] nums, int low, int high) {
        int n = high - low + 1;
        // if we have less than 5 elements, ignore the partitioning algorithm
        if (n < 5)
            return nums[low];
        // for simplicity, lets ignore any partition with less than 5 elements
        int numOfPartitions = n / 5; // represents total number of 5 elements partitions
        int[] medians = new int[numOfPartitions];
        for (int i = 0; i < numOfPartitions; i++) {
            int partitionStart = low + i * 5; // starting index of the current partition
            Arrays.sort(nums, partitionStart, partitionStart + 5); // sort the 5 elements array
            medians[i] = nums[partitionStart + 2]; // get the middle element (or the median)
        }
        return partition(medians, 0, numOfPartitions - 1);
    }

    public static void main(String[] args) {
        int result = findKthSmallestNumber(new int[] { 1, 5, 12, 2, 11, 5}, 3);
                System.out.println("Kth smallest number is: " + result);
        // since there are two 5s in the input array, our 3rd and 4th smallest
        result = findKthSmallestNumber(new int[] { 1, 5, 12, 2, 11, 5}, 4);
                System.out.println("Kth smallest number is: " + result);
        result = findKthSmallestNumber(new int[] { 5, 12, 11, -1, 12}, 3);
                System.out.println("Kth smallest number is: " + result);
 }
}
