package com.opensource.dada.problems.leetcode;

import java.util.*;

/**Problem:
 *Given an array of integers, return indices of the two numbers
 * such that they add up to a specific target.
 *
 * You may assume that each input would have exactly one solution,
 * and you may not use the same element twice.
 *
 * Example:
 *
 * Given nums = [2, 7, 11, 15], target = 9,
 *
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */
public class TwoSumProblem {
    public static void main(String[] args) {
        int[] result = twoSum(new int[]{2,7,11,15}, 9);
        System.out.println("Result:"+Arrays.toString(result));

        result = twoSum(new int[]{3, 2,4}, 6);
        System.out.println("Result:"+Arrays.toString(result));
    }

    static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];

            int start = 0;
            int end = nums.length-1;
            while (start<end) {
                int sum = nums[start]+nums[end];
                if(sum==target) {
                    return new int[]{start,end};
                } else if (sum<0) {
                    int temp = start;
                    while (nums[temp] == nums[start] && start < end) {
                        start++;
                    }
                } else {
                    int temp = end;
                    while (nums[temp] == nums[end] && start < end) {
                        end--;
                    }
                }
            }
        return result;
    }

    //better solution
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
