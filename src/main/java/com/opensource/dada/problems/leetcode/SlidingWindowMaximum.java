package com.opensource.dada.problems.leetcode;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Problem:
 * https://leetcode.com/problems/sliding-window-maximum/
 */
public class SlidingWindowMaximum {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
    }

    private static void test1() {
        /**
         * Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
         * Output: [3,3,5,5,6,7]
         */
        int[] input = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] output = maxSlidingWindow(input, k);
        System.out.println("Input Array:" + Arrays.toString(input) + " k:" + k + " Output:" + Arrays.toString(output));
    }

    private static void test2() {
        /**
         * Input: nums = [], and k = 1
         * Output: []
         */
        int[] input = {};
        int k = 1;
        int[] output = maxSlidingWindow(input, k);
        System.out.println("Input Array:" + Arrays.toString(input) + " k:" + k + " Output:" + Arrays.toString(output));
    }

    private static void test3() {
        /**
         * Input: nums = [1, -1], and k = 1
         * Output: [1, -1]
         */
        int[] input = {1, -1};
        int k = 1;
        int[] output = maxSlidingWindow(input, k);
        System.out.println("Input Array:" + Arrays.toString(input) + " k:" + k + " Output:" + Arrays.toString(output));
    }

    private static void test4() {
        /**
         * Input: nums = [7 ,2, 4], and k = 2
         * Output: [7, 4]
         */
        int[] input = {7, 2, 4};
        int k = 2;
        int[] output = maxSlidingWindow(input, k);
        System.out.println("Input Array:" + Arrays.toString(input) + " k:" + k + " Output:" + Arrays.toString(output));
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        return maxSlidingWindow2(nums, k);
    }

    //time complexity O(n*k)
    public static int[] maxSlidingWindow1(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        int[] output = new int[nums.length - k + 1];
        int outputIndex = 0;
        for (int i = 0; i < nums.length - k + 1; i++) {
            int max = Integer.MIN_VALUE;
            int j = 0;
            while (j < k) {
                if (nums[i + j] > max) {
                    max = nums[i + j];
                }
                j++;
            }
            output[outputIndex++] = max;
        }
        return output;
    }

    //time complexity O(n)
    public static int[] maxSlidingWindow2(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return new int[0];

        int[] result = new int[nums.length - k + 1];

        LinkedList<Integer> deque = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if (!deque.isEmpty() && deque.peekFirst() == i - k)
                deque.poll();

            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.removeLast();
            }

            deque.offer(i);

            if (i + 1 >= k)
                result[i + 1 - k] = nums[deque.peek()];
        }

        return result;
    }
}
