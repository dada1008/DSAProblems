package com.opensource.dada.problems.pattern.twoPointers;

import java.util.Arrays;

/**
 * Problem:
 * Given an array, find the length of the smallest subarray in it which when sorted will sort the whole array.
 *
 * Example 1:
 *
 * Input: [1, 2, 5, 3, 7, 10, 9, 12]
 * Output: 5
 * Explanation: We need to sort only the subarray [5, 3, 7, 10, 9] to make the whole array sorted
 * Example 2:
 *
 * Input: [1, 3, 2, 0, -1, 7, 10]
 * Output: 5
 * Explanation: We need to sort only the subarray [1, 3, 2, 0, -1] to make the whole array sorted
 * Example 3:
 *
 * Input: [1, 2, 3]
 * Output: 0
 * Explanation: The array is already sorted
 * Example 4:
 *
 * Input: [3, 2, 1]
 * Output: 3
 * Explanation: The whole array needs to be sorted.
 *
 * Solution #
 * As we know, once an array is sorted (in ascending order),
 * the smallest number is at the beginning and the largest number is at the end of the array.
 * So if we start from the beginning of the array to find the first element
 * which is out of sorting order i.e., which is smaller than its previous element,
 * and similarly from the end of array to find the first element which is bigger
 * than its previous element, will sorting the subarray between these two numbers result
 * in the whole array being sorted?
 *
 * Let’s try to understand this with Example-2 mentioned above. In the following array,
 * what are the first numbers out of sorting order from the beginning and the end of the array:
 *
 *     [1, 3, 2, 0, -1, 7, 10]
 * 1. Starting from the beginning of the array the first number out of the sorting order is ‘2’
 *    as it is smaller than its previous element which is ‘3’.
 * 2. Starting from the end of the array the first number out of the sorting order is ‘0’
 *    as it is bigger than its previous element which is ‘-1’
 * As you can see, sorting the numbers between ‘3’ and ‘-1’ will not sort the whole array.
 * To see this, the following will be our original array after the sorted subarray:
 *
 *     [1, -1, 0, 2, 3, 7, 10]
 * The problem here is that the smallest number of our subarray is ‘-1’ which dictates that we need
 * to include more numbers from the beginning of the array to make the whole array sorted.
 * We will have a similar problem if the maximum of the subarray is bigger than some elements
 * at the end of the array. To sort the whole array we need to include all such elements
 * that are smaller than the biggest element of the subarray. So our final algorithm will look like:
 *
 * 1. From the beginning and end of the array, find the first elements that are out of the sorting order. The two
 *    elements will be our candidate subarray.
 * 2. Find the maximum and minimum of this subarray.
 * 3. Extend the subarray from beginning to include any number which is bigger than the minimum
 *    of the subarray.
 * 4. Similarly, extend the subarray from the end to include any number which is smaller than
 *    the maximum of the subarray.
 */
public class MinimumWindowSort {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
    }

    public static void test1() {
        int[] arr = {1, 2, 5, 3, 7, 10, 9, 12};
        int result = sort(arr);
        System.out.println("Result:"+result+" sorted array:" +Arrays.toString(arr));//5
    }
    public static void test2() {
        int[] arr = {1, 3, 2, 0, -1, 7, 10};
        int result = sort(arr);
        System.out.println("Result:"+result+" sorted array:" +Arrays.toString(arr));//5
    }
    public static void test3() {
        int[] arr = {1, 2, 3};
        int result = sort(arr);
        System.out.println("Result:"+result+" sorted array:" +Arrays.toString(arr));//0
    }
    public static void test4() {
        int[] arr = {3, 2, 1};
        int result = sort(arr);
        System.out.println("Result:"+result+" sorted array:" +Arrays.toString(arr));//3
    }

    static int sort(int[] arr) {
        int low =0, high = arr.length -1;
        // find 1st element out of sorting from start
        while (low < arr.length-1 && arr[low+1] >= arr[low] ) {
            low++;
        }
        //If array already sorted
        if (low == high) {
            return 0;
        }
        // find 1st element out of sorting from end
        while (high >0 && arr[high] >= arr[high-1] ) {
            high--;
        }
        //Find min and max of sub array
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = low; i <= high; i++) {
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
        }
        // extend the subarray to include any number which is bigger than the minimum of the subarray
        while (low > 0 && arr[low-1] >min) {
            low--;
        }
        // extend the subarray to include any number which is smaller than the maximum of the subarray
        while (high < arr.length-1 && arr[high+1] < max) {
            high++;
        }
        return high - low + 1;
    }
}
