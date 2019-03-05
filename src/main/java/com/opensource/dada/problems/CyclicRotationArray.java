package com.opensource.dada.problems;

import java.util.Arrays;

/** Codility Problem:
 * An array A consisting of N integers is given.
 * Rotation of the array means that each element is shifted right by one index,
 * and the last element of the array is moved to the first place.
 * For example, the rotation of array A = [3, 8, 9, 7, 6] is [6, 3, 8, 9, 7]
 * (elements are shifted right by one index and 6 is moved to the first place).
 *
 * The goal is to rotate array A K times; that is, each element of A will be shifted to the right K times.
 *
 * Write a function:
 *
 * class Solution { public int[] solution(int[] A, int K); }
 *
 * that, given an array A consisting of N integers and an integer K, returns the array A rotated K times.
 *
 * For example, given
 *
 *     A = [3, 8, 9, 7, 6]
 *     K = 3
 * the function should return [9, 7, 6, 3, 8]. Three rotations were made:
 *
 *     [3, 8, 9, 7, 6] -> [6, 3, 8, 9, 7]
 *     [6, 3, 8, 9, 7] -> [7, 6, 3, 8, 9]
 *     [7, 6, 3, 8, 9] -> [9, 7, 6, 3, 8]
 * For another example, given
 *
 *     A = [0, 0, 0]
 *     K = 1
 * the function should return [0, 0, 0]
 *
 * Given
 *
 *     A = [1, 2, 3, 4]
 *     K = 4
 * the function should return [1, 2, 3, 4]
 *
 * Assume that:
 *
 * N and K are integers within the range [0..100];
 * each element of array A is an integer within the range [−1,000..1,000].
 */
public class CyclicRotationArray {
    public static void main(String[] args) {
        int[] arr = {3, 8, 9, 7, 6};
        int k =3;
        System.out.println("Arr:"+ Arrays.toString(arr)+" and rotation: "
                +k+" result actual:"+Arrays.toString(solution(arr, k))+" expected:[9, 7, 6, 3, 8]");

        int[] arr2 = {1, 2, 3, 4};
        k =4;
        System.out.println("Arr:"+ Arrays.toString(arr2)+" and rotation: "
                +k+" result actual:"+Arrays.toString(solution(arr2, k))+" expected:[1, 2, 3, 4]");
    }

    public static int[] solution(int[] A, int K) {
        if (A==null || A.length==0) {
            return A;
        }
        while (K>0) {
            int index = 0;
            int temp = A[index];
            while (A.length-1>index) {
                int swap = A[index+1];
                A[index+1] = temp;
                temp = swap;
                index++;
            }
            A[0]=temp;
            K--;
        }

        return A;
    }
}
