package com.opensource.dada.problems;

/**
 * Problem:
 * Objective: Given three sorted(ascending order) arrays of integers,
 * find out all the common elements in them.
 * <p>
 * Input: Three sorted arrays.
 * <p>
 * Output: All the common elements.
 * <p>
 * Examples :
 * <p>
 * Array A = {1,2,3,4,5,6,7,8,9,10};
 * Array B = {1,3,5,6,7,8,12};
 * Array C = {2,3,4,5,8,9};
 * Common Elements are 3,5,8
 * <p>
 * ar1[] = {1, 5, 10, 20, 40, 80}
 * ar2[] = {6, 7, 20, 80, 100}
 * ar3[] = {3, 4, 15, 20, 30, 70, 80, 120}
 * Output: 20, 80
 * <p>
 * ar1[] = {1, 5, 5}
 * ar2[] = {3, 4, 5, 5, 10}
 * ar3[] = {5, 5, 10, 20}
 * Output: 5, 5
 */
public class FindCommonElement3SortedArrays {
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] B = {1, 3, 5, 6, 7, 8, 12};
        int[] C = {2, 3, 4, 5, 8, 9};
        findCommon(A, B, C);
        System.out.println("======");
        int[] ar1 = {1, 5, 10, 20, 40, 80};
        int[] ar2 = {6, 7, 20, 80, 100};
        int[] ar3 = {3, 4, 15, 20, 30, 70, 80, 120};
        findCommon(ar1, ar2, ar3);
        System.out.println("======");
        int[] arr1 = {1, 5, 5};
        int[] arr2 = {3, 4, 5, 5, 10};
        int[] arr3 = {5, 5, 10, 20};
        findCommon(arr1, arr2, arr3);
        System.out.println("======");
    }

    public static void findCommon(int[] arr1, int[] arr2, int[] arr3) {

        int i = 0, j = 0, k = 0;
        while (i < arr1.length && j < arr2.length && k < arr3.length) {
            if (arr1[i] == arr2[j] && arr2[j] == arr3[k]) {
                System.out.println(arr1[i]);
                i++;
                j++;
                k++;
            } else if (arr1[i] < arr2[j]) {
                i++;
            } else if (arr2[j] < arr3[k]) {
                j++;
            } else {
                k++;
            }
        }
    }
}
