package com.opensource.dada.problems.pattern.twoPointers;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem:
 * Count and print the number of (contiguous) subarrays where the product of all
 * the elements in the subarray is less than k.
 * <p>
 * Example 1:
 * Input: nums = [10, 5, 2, 6], k = 100
 * Output: 8
 * Explanation: The 8 subarrays that have product less than 100 are:
 * [10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6].
 * Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.
 *
 * Example 2:
 * Input : [1, 2, 3, 4]
 * k = 10
 * Output :11
 * The subsequences are {1}, {2}, {3}, {4},
 * {1, 2}, {1, 3}, {1, 4}, {2, 3}, {2, 4},
 * {1, 2, 3}, {1, 2, 4}
 *
 * Example 3:
 * Input  : [4, 8, 7, 2]
 * k = 50
 * Output : 9
 */
public class SubarraysWithProductLessThanTarget {

    // Function to count numbers of such
    // subsequences having product less than k.
    public static int productSubSeqCount(List<Integer> arr,
                                         int k) {
        int n = arr.size();
        int dp[][] = new int[k + 1][n + 1];

        for (int i = 1; i <= k; i++) {
            for (int j = 1; j <= n; j++) {

                // number of subsequence using j-1 terms
                dp[i][j] = dp[i][j - 1];

                // if arr[j-1] > i it will surely make
                // product greater thus it won't contribute
                // then
                if (arr.get(j - 1) <= i && arr.get(j - 1) > 0)

                    // number of subsequence using 1 to j-1
                    // terms and j-th term
                    dp[i][j] += dp[i / arr.get(j - 1)][j - 1] + 1;
            }
        }
        return dp[k][n];
    }

    // Driver code
    public static void main(String args[]) {
        List<Integer> A = new ArrayList<Integer>();
        A.add(1);
        A.add(2);
        A.add(3);
        A.add(4);
        int k = 10;
        System.out.println(productSubSeqCount(A, k));
    }
}
