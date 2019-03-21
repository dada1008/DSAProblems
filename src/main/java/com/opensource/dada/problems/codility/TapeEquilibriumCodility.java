package com.opensource.dada.problems.codility;

import java.util.Arrays;

/**
 * Codility Problem:
 * A non-empty array A consisting of N integers is given. Array A represents numbers on a tape.
 *
 * Any integer P, such that 0 < P < N, splits this tape into two non-empty parts:
 * A[0], A[1], ..., A[P − 1] and A[P], A[P + 1], ..., A[N − 1].
 *
 * The difference between the two parts is the value of:
 * |(A[0] + A[1] + ... + A[P − 1]) − (A[P] + A[P + 1] + ... + A[N − 1])|
 *
 * In other words, it is the absolute difference between the sum of the first part
 * and the sum of the second part.
 *
 * For example, consider array A such that:
 *
 *   A[0] = 3
 *   A[1] = 1
 *   A[2] = 2
 *   A[3] = 4
 *   A[4] = 3
 * We can split this tape in four places:
 *
 * P = 1, difference = |3 − 10| = 7
 * P = 2, difference = |4 − 9| = 5
 * P = 3, difference = |6 − 7| = 1
 * P = 4, difference = |10 − 3| = 7
 * Write a function:
 *
 * class Solution { public int solution(int[] A); }
 *
 * that, given a non-empty array A of N integers, returns the minimal difference that can be achieved.
 *
 * For example, given:
 *
 *   A[0] = 3
 *   A[1] = 1
 *   A[2] = 2
 *   A[3] = 4
 *   A[4] = 3
 * the function should return 1, as explained above.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * N is an integer within the range [2..100,000];
 * each element of array A is an integer within the range [−1,000..1,000].
 **/
public class TapeEquilibriumCodility {
    public static void main(String[] args) {
        int[] A = {3,1,2,4,3};
        System.out.println("Array: "+ Arrays.toString(A)+" minDiff: "+solutionMy(A));
    }

    public static int solutionMy(int[] A) {
        int minDiff = Integer.MAX_VALUE;

        for (int p=1;p<A.length-1;p++) {
            long sum1 = sumArray(A, 0, p);
            long sum2 = sumArray(A, p, A.length);
            int tempMinDiff = (int)Math.abs(sum1 - sum2);
            if (tempMinDiff < minDiff) {
                minDiff = tempMinDiff;
            }
        }
        return minDiff;
    }

    private static long sumArray(int[] A, int startIndex, int endIndex) {
        long sum = 0;
        while(startIndex < endIndex) {
            sum += A[startIndex];
            startIndex++;
        }
        return sum;
    }

    public static int solution2(int[] A) {
        int total = 0;

        for (int i = 0; i < A.length; i++)
            total += A[i];

        int diff = Integer.MAX_VALUE;
        int prev = 0;
        int next = total;

        for (int p = 1; p < A.length; p++) {
            prev += A[p - 1];
            next = total - prev;
            diff = Math.min(diff, Math.abs(prev - next));
        }

        return diff;
    }

    public static int solution3(int[] A) {
        int smallestDifference = Integer.MAX_VALUE;

        int[] sumArray = new int[A.length];

        for(int i = 0; i < A.length; i++) {

            if (i > 0)
                sumArray[i] = sumArray[i - 1] + A[i];
            else
                sumArray[i] = A[i];

        }

        for(int j = 0; j < sumArray.length - 1; j++) {

            int secondHalf = sumArray[sumArray.length - 1] - sumArray[j];

            int splitNum = Math.abs(sumArray[j] - secondHalf);

            if(splitNum < smallestDifference)
                smallestDifference = splitNum;

        }

        return smallestDifference;
    }
}
