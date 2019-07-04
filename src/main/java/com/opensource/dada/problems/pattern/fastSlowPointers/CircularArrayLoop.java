package com.opensource.dada.problems.pattern.fastSlowPointers;

/**
 * Problem: https://www.geeksforgeeks.org/check-loop-array-according-given-constraints/
 *          https://leetcode.com/problems/circular-array-loop/
 */
public class CircularArrayLoop {

    public static void main(String[] args) {
        System.out.println("Is circular: "+ circularArrayLoop(new int[]{2, -1, 1, 2, 2}));//true
        System.out.println("Is circular: "+ circularArrayLoop(new int[]{1, 1, 1, 1, 1, 1}));//true
        System.out.println("Is circular: "+ circularArrayLoop(new int[]{1, 2}));//false

        System.out.println("Is circular: "+ circularArrayLoop(new int[]{2,-1,1,2,2}));//true
        System.out.println("Is circular: "+ circularArrayLoop(new int[]{-1,2}));//false
        System.out.println("Is circular: "+ circularArrayLoop(new int[]{-2,1,-1,-2,-2}));//false
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
}
