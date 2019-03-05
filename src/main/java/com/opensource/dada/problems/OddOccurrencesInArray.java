package com.opensource.dada.problems;

import java.util.Arrays;

/** Codility Problem:
 * A non-empty array A consisting of N integers is given.
 * The array contains an odd number of elements, and each element of the array can be paired
 * with another element that has the same value, except for one element that is left unpaired.
 *
 * For example, in array A such that:
 *
 *   A[0] = 9  A[1] = 3  A[2] = 9
 *   A[3] = 3  A[4] = 9  A[5] = 7
 *   A[6] = 9
 * the elements at indexes 0 and 2 have value 9,
 * the elements at indexes 1 and 3 have value 3,
 * the elements at indexes 4 and 6 have value 9,
 * the element at index 5 has value 7 and is unpaired.
 * Write a function:
 *
 * class Solution { public int solution(int[] A); }
 *
 * that, given an array A consisting of N integers fulfilling the above conditions,
 * returns the value of the unpaired element.
 *
 * For example, given array A such that:
 *
 *   A[0] = 9  A[1] = 3  A[2] = 9
 *   A[3] = 3  A[4] = 9  A[5] = 7
 *   A[6] = 9
 * the function should return 7, as explained in the example above.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * N is an odd integer within the range [1..1,000,000];
 * each element of array A is an integer within the range [1..1,000,000,000];
 * all but one of the values in A occur an even number of times.
 */
public class OddOccurrencesInArray {
    public static void main(String[] args) {
        int[] arr = {9,3,9,3,9,7,9};
        System.out.println("Arr:"+ Arrays.toString(arr)+" result:"+solution(arr));

        int[] arr2 = {71,91,63,49,59,61,63,49,71,91,59};
        System.out.println("Arr:"+ Arrays.toString(arr2)+" result:"+solution(arr2));
    }

    public static int solution(int[] A) {
        Arrays.sort(A);
        int res = 0;
        for (int i=0; i<A.length; i++) {
            if(i%2!=0) {
                if (A[i-1]!=A[i]) {
                    return A[i-1];
                }
            } else if (i==A.length-1) {
                return A[i];
            }
        }

        return res;
    }
}
