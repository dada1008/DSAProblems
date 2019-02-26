package com.opensource.dada.problems;

/**
 * Write a function:
 *
 * class Solution { public int solution(int[] A); }
 *
 * that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.
 *
 * For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.
 *
 * Given A = [1, 2, 3], the function should return 4.
 *
 * Given A = [−1, −3], the function should return 1.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * N is an integer within the range [1..100,000];
 * each element of array A is an integer within the range [−1,000,000..1,000,000].
 */
public class MissingSmallestInteger {
    public static void main(String[] agrs) {

    }
    public int solution(int[] A) {
        int n = A.length;
        int val;
        int nextval;

        for (int i = 0; i < n; i++) {
            if (A[i] <= 0 || A[i] > n)
                continue;

            val = A[i];
            while (A[val - 1] != val) {
                nextval = A[val - 1];
                A[val - 1] = val;
                val = nextval;
                if (val <= 0 || val > n)
                    break;
            }
        }
        for (int i = 0; i < n; i++) {
            if (A[i] != i + 1) {
                return i + 1;
            }
        }
        return n + 1;
    }
}
