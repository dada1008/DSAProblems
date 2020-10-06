package com.opensource.dada.problems.pattern.cyclicSort;

/**
 * Problem:
 * We are given an array containing ‘n’ distinct numbers taken from the range 0 to ‘n’.
 * Since the array has only ‘n’ numbers out of the total ‘n+1’ numbers, find the missing number.
 * <p>
 * Example 1:
 * <p>
 * Input: [4, 0, 3, 1]
 * Output: 2
 * Example 2:
 * <p>
 * Input: [8, 3, 5, 2, 4, 6, 0, 1]
 * Output: 7
 */
public class FindMissingNumber {
    public static void main(String[] args) {
        System.out.println("Result:"+findMissingNumber(new int[]{4, 0, 3, 1}));
        System.out.println("Result:"+findMissingNumber(new int[]{8, 3, 5, 2, 4, 6, 0, 1}));
    }

    static int findMissingNumber(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] < nums.length && nums[i] != nums[nums[i]]) {
                swap(nums, i, nums[i]);
            } else {
                i++;
            }
        }

        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j) {
                return j;
            }
        }
        return nums.length;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
