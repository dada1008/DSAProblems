package com.opensource.dada.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Given three sorted arrays A, B, and C of not necessarily same sizes.
 * Calculate the minimum absolute difference between the maximum and
 * minimum number of any triplet A[i], B[j], C[k] such that they belong
 * to arrays A, B and C respectively,
 * i.e., minimize (max(A[i], B[j], C[k]) – min(A[i], B[j], C[k]))
 *
 * Examples:
 *
 * Input : A : [ 1, 4, 5, 8, 10 ]
 *         B : [ 6, 9, 15 ]
 *         C : [ 2, 3, 6, 6 ]
 * Output : 1
 * Explanation: When we select A[i] = 5
 * B[j] = 6, C[k] = 6, we get the minimum difference
 * as max(A[i], B[j], C[k]) - min(A[i], B[j], C[k]))
 * = |6-5| = 1
 *
 * Input : A = [ 5, 8, 10, 15 ]
 *         B = [ 6, 9, 15, 78, 89 ]
 *         C = [ 2, 3, 6, 6, 8, 8, 10 ]
 * Output : 1
 * Explanation: When we select A[i] = 10
 * b[j] = 9, C[k] = 10.
 */
public class MinimumAbsoluteDifference {
    public static void main(String[] args) {
        /**
         * A : [ 1, 4, 5, 8, 10 ]
         * B : [ 6, 9, 15 ]
         * C : [ 2, 3, 6, 6 ]
         */
        List<Integer> A = Arrays.asList(1, 4, 5, 8, 10);
        List<Integer> B = Arrays.asList(6, 9, 15);
        List<Integer> C = Arrays.asList(2, 3, 6, 6);

        int result = solve(A, B, C);
        System.out.println("1. Result: "+result);

        /**
         * Input : A = [ 5, 8, 10, 15 ]
         *         B = [ 6, 9, 15, 78, 89 ]
         *         C = [ 2, 3, 6, 6, 8, 8, 10 ]
         */

        A = Arrays.asList(5, 8, 10, 15);
        B = Arrays.asList(6, 9, 15, 78, 89);
        C = Arrays.asList(2, 3, 6, 6, 8, 8, 10);

        result = solve(A, B, C);
        System.out.println("2. Result: "+result);
    }

    public static int solve(List<Integer> A, List<Integer> B, List<Integer> C) {
        int i = A.size() -1, j = B.size() -1, k = C.size() -1;
        int result_i=0, result_j=0, result_k=0;

        int min_diff, current_diff, max_term;

        // calculating min difference
        // from last index of lists
        int a = A.get(i);
        int b = B.get(j);
        int c = C.get(k);

        min_diff = Math.abs(Math.max(a, Math.max(b, c))
                - Math.min(a, Math.min(b, c)));

        while (i != -1 && j != -1 && k != -1)
        {
            a = A.get(i);
            b = B.get(j);
            c = C.get(k);

            current_diff = Math.abs(Math.max(a, Math.max(b, c))
                    - Math.min(a, Math.min(b, c)));

            // checking condition
            if (current_diff < min_diff) {
                min_diff = current_diff;
                result_i = i;
                result_j = j;
                result_k = k;
            }

            // calculating max term from list
            max_term = Math.max(a, Math.max(b, c));

            // Moving to smaller value in the
            // array with maximum out of three.
            if (a == max_term) {
                i--;
            } else if (b == max_term) {
                j--;
            } else {
                k--;
            }
        }
        System.out.println("result_i: "+result_i+" result_j :"+result_j+" result_k: "+result_k);
        return min_diff;
    }
}
