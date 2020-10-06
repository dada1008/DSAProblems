package com.opensource.dada.problems.pattern.modifiedBinarySearch;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class OptumProblem {
    //{24,26,27,28,29,33,35,38,39,41,42,44,46,49,50,55,62,2,5,10,13,16,19,22}
    //0, 1,2
    static int getIndexForSmallestNumber(Integer[] arr) {
        int start = 0, end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (mid > start && arr[mid - 1] > arr[mid]) {
                return mid;
            }
            if (mid < end && arr[mid] > arr[mid + 1]) {
                return mid + 1;
            }
            if (arr[mid] >= arr[start]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return 0;
    }

    static int getIndexForSmallestNumber2(Integer[] arr) {
        int start = 0, end = arr.length - 1;
        while (start <= end) {
            if (start==end) {
                return start;
            } else if (start==end-1) {
                return Math.max(arr[start], arr[end]);
            } else {
                int mid = start + (end - start) / 2;
                if (arr[mid - 1] < arr[mid] && arr[mid] > arr[mid+1]) {
                    return mid;
                } else if (arr[mid - 1] < arr[mid] && arr[mid] < arr[mid+1]) {
                    start = mid + 1;
                } else if (arr[mid - 1] > arr[mid] && arr[mid] > arr[mid+1]) {
                    end = mid - 1;
                } else {
                    return Integer.MIN_VALUE;
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println("Test case 0");
        Integer[] array = {24, 26, 27, 28, 29, 33, 35, 38, 39, 41, 42, 44, 46, 49, 50, 55, 62, 2, 5, 10, 13, 16, 19, 22};
        //i think call got discnnected, can. u plz call again
        int index = getIndexForSmallestNumber(array);
        System.out.println(index);
        System.out.println(array[index]);  //expected: 2

        System.out.println("Test case 1");
        Integer[] array1 = {5, 6, 7, 8, 1, 2, 3, 4};
        index = getIndexForSmallestNumber(array1);
        System.out.println(index);
        System.out.println(array1[index]);

        System.out.println("Test case 2");
        Integer[] array2 = {5, 6, 7, 8, 9, 1, 2, 3, 4};
        index = getIndexForSmallestNumber(array2);
        System.out.println(index);
        System.out.println(array2[index]);

        System.out.println("Test case 3");
        Integer[] array3 = {8, 1, 2, 3, 4, 5, 6, 7};
        index = getIndexForSmallestNumber(array3);
        System.out.println(index);
        System.out.println(array3[index]);

        System.out.println("Test case 4");
        Integer[] array4 = {2, 3, 4, 5, 6, 7, 8, 1};
        index = getIndexForSmallestNumber(array4);
        System.out.println(index);
        System.out.println(array4[index]);

        System.out.println("Test case 5");
        Integer[] array5 = {1, 2, 3, 4, 5, 6, 7, 8};
        index = getIndexForSmallestNumber(array5);
        System.out.println(index);
        System.out.println(array5[index]);
    }
}
