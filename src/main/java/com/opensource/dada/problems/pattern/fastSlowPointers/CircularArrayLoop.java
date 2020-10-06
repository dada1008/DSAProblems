package com.opensource.dada.problems.pattern.fastSlowPointers;

/**
 * Problem: https://www.geeksforgeeks.org/check-loop-array-according-given-constraints/
 *          https://leetcode.com/problems/circular-array-loop/
 *
 * We are given an array containing positive and negative numbers.
 * Suppose the array contains a number ‘M’ at a particular index.
 * Now, if ‘M’ is positive we will move forward ‘M’ indices and
 * if ‘M’ is negative move backwards ‘M’ indices. You should assume that the array is circular
 * which means two things:
 *
 * If, while moving forward, we reach the end of the array, we will jump to the first element
 * to continue the movement.
 * If, while moving backward, we reach the beginning of the array, we will jump to the last element
 * to continue the movement.
 * Write a method to determine if the array has a cycle. The cycle should have more than
 * one element and should follow one direction which means the cycle should not contain both forward
 * and backward movements.
 *
 * Example 1:
 *
 * Input: [1, 2, -1, 2, 2]
 * Output: true
 * Explanation: The array has a cycle among indices: 0 -> 1 -> 3 -> 0
 * Example 2:
 *
 * Input: [2, 2, -1, 2]
 * Output: true
 * Explanation: The array has a cycle among indices: 1 -> 3 -> 1
 * Example 3:
 *
 * Input: [2, 1, -1, -2]
 * Output: false
 * Explanation: The array does not have any cycle.
 */
public class CircularArrayLoop {

    public static void main(String[] args) {
        System.out.println("Is circular: "+ circularArrayLoop(new int[]{2, -1, 1, 2, 2}));//true
        System.out.println("Is circular: "+ circularArrayLoop(new int[]{1, 1, 1, 1, 1, 1}));//true
        System.out.println("Is circular: "+ circularArrayLoop(new int[]{1, 2}));//false

        System.out.println("Is circular: "+ circularArrayLoop(new int[]{2,-1,1,2,2}));//true
        System.out.println("Is circular: "+ circularArrayLoop(new int[]{-1,2}));//false
        System.out.println("Is circular: "+ circularArrayLoop(new int[]{-2,1,-1,-2,-2}));//false

        System.out.println("Is LoopExists: "+ loopExists(new int[]{2, -1, 1, 2, 2}));//true
        System.out.println("Is LoopExists: "+ loopExists(new int[]{1, 1, 1, 1, 1, 1}));//true
        System.out.println("Is LoopExists: "+ loopExists(new int[]{1, 2}));//false

        System.out.println("Is LoopExists: "+ loopExists(new int[]{2,-1,1,2,2}));//true
        System.out.println("Is LoopExists: "+ loopExists(new int[]{-1,2}));//false
        System.out.println("Is LoopExists: "+ loopExists(new int[]{-2,1,-1,-2,-2}));//false
    }
    static boolean circularArrayLoop(int[] nums) {
        if (nums == null || nums.length == 0) { return false; }
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0 && dfs(i, 0, n, nums) != 0) {
                return true;
            }
        }
        return false;
    }

    static int dfs(int index, int count, int n, int[] nums) {
        if (count < n) {
            int nextIndex = (index + nums[index] + n) % n;
            if (nextIndex == index
                    || nums[nextIndex] + nums[index] <= 0
                    || dfs(nextIndex, count + 1, n, nums) == 0) {
                nums[index] = 0;
            }
        }
        return nums[index];
    }

    // 2nd solution
    static boolean loopExists(int[] arr) {
        if (arr == null || arr.length == 0) {
            return false;
        }
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            //We are moving forward or backward
            boolean isForward = arr[i]>=0;
            int slow = i, fast = i;
            // if slow or fast becomes '-1' this means we can't find cycle for this number
            do {
                slow = findNextIndex(arr, isForward, slow);
                fast = findNextIndex(arr, isForward, fast);
                if (fast!= -1) {
                    fast = findNextIndex(arr, isForward, fast);
                }
            }while (slow!=-1 && fast!=-1 && slow!=fast);

            if (slow!=-1 && slow==fast) {
                return true;
            }
        }
        return false;
    }

    static int findNextIndex(int[] arr, boolean isForward, int currentIndex) {
        boolean direction = arr[currentIndex] >= 0;
        if (isForward!=direction) {
            return -1;
        }
        int nextIndex = (currentIndex + arr[currentIndex])%arr.length;
        if (nextIndex<0){
            nextIndex+=arr.length;
        }
        if (nextIndex==currentIndex){
            return -1;
        }
        return nextIndex;
    }
}
