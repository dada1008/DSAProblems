package com.opensource.dada.problems.pattern.slidingWindow;

import java.util.List;

/**
 * Problem:
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
 * For example:
 * Given the array [-2,1,-3,4,-1,2,1,-5,4],
 * the contiguous subarray [4,-1,2,1] has the largest sum = 6.
 * For this problem, return the maximum sum.
 */
public class MaxSumContiguousSubarray {
    public static void main(String[] args) {
        List<Integer> list = List.of(-2, 1, -3, 4, -1, 2, 1, -5, 4);
        System.out.println("list:" + list + " result:" + maxSubArray2(list));//[4,-1,2,1]
    }

    public static int maxSubArrayMy(final List<Integer> A) {
        int result = 0;
        int currentMaxSum = 0;
        int start = 0, end = A.size() - 1;
        while (start <= end) {
            int currentStart = start;
        }

        return 0;
    }

    //Davide and conquer
    public static int maxSubArray1(List<Integer> A) {
        return maxSubArray1(A, A.size());
    }

    public static int maxSubArray1(List<Integer> A, int n) {
        if (n == 1) {
            return A.get(0);
        }
        int m = n / 2;
        int left_MSS = maxSubArray1(A, m);
        int right_MSS = maxSubArray1(A, n - m);
        int leftsum = Integer.MIN_VALUE, rightsum = Integer.MIN_VALUE, sum = 0;
        for (int i = m; i < n; i++) {
            sum += A.get(i);
            rightsum = Integer.max(rightsum, sum);
        }
        sum = 0;
        for (int i = (m - 1); i >= 0; i--) {
            sum += A.get(i);
            leftsum = Integer.max(leftsum, sum);
        }
        int ans = Integer.max(left_MSS, right_MSS);
        return Integer.max(ans, leftsum + rightsum);
    }

    //Best soln: Kadane's Algorithm
    public static int maxSubArray2(List<Integer> A) {
        int ans = A.get(0), sum = 0;
        int start = 0, end = 0, s = 0;
        for (int i = 1; i < A.size(); ++i)    //Check if all are negative
            ans = Integer.max(ans, A.get(i));
        if (ans < 0)                    //if Max < 0 return Max
            return ans;
        ans = 0;
        for (int i = 0; i < A.size(); ++i) {
            if (sum + A.get(i) > 0) {
                sum += A.get(i);
                start = s;
                end = i;
            } else {
                sum = 0;
                s = i + 1;
            }
            ans = Integer.max(ans, sum);
        }
        System.out.println("Starting index:" + start + " Ending index:" + end);
        return ans;
    }
}
