package com.opensource.dada.problems.leetcode;

import java.util.Arrays;

public class MaximumProductOfThreeNumbers {
    public static void main(String[] args) {

    }

    //complexity: nlogn
    public static int maximumProduct(int[] nums) {
        int arrLength = nums.length;
        if (nums == null || arrLength < 3) {
            return 0;
        }
        Arrays.sort(nums);

        int maxProduct = Math.max(nums[0] * nums[1] * nums[arrLength - 1],
                nums[arrLength - 1] * nums[arrLength - 2] * nums[arrLength - 3]);

        return maxProduct;
    }

    //complexity: n
    public static int maximumProduct2(int[] nums) {
        int arrLength = nums.length;
        if (nums == null || arrLength < 3) {
            return 0;
        }
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            // Update Maximum, second maximum and third
            // maximum element
            if (nums[i] > max1) {
                max3 = max2;
                max2 = max1;
                max1 = nums[i];
            }
            // Update second maximum and third maximum element
            else if (nums[i] > max2) {
                max3 = max2;
                max2 = nums[i];
            }
            // Update third maximum element
            else if (nums[i] > max3) {
                max3 = nums[i];
            }

            // Update Minimum and second mimimum element
            if (nums[i] < min1) {
                min2 = min1;
                min1 = nums[i];
            }
            // Update second mimimum element
            else if (nums[i] < min2) {
                min2 = nums[i];
            }
        }
        int maxProduct = Math.max(min1 * min2 * max1,
                max1 * max2 * max3);

        return maxProduct;
    }
}
