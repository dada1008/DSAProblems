package com.opensource.dada.problems.hackerrank;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** Problem:
 * Karl has an array of integers. He wants to reduce the array until all remaining elements are equal.
 * Determine the minimum number of elements to delete to reach his goal.
 *
 * For example, if his array is arr = [1,2,2,3],
 * we see that he can delete the 2 elements 1 and 3 leaving arr = [2,2].
 * He could also delete both twos and either the 1 or the 3, but that would take 3 deletions.
 * The minimum number of deletions is 2.
 *
 * Function Description
 *
 * Complete the equalizeArray function in the editor below.
 * It must return an integer that denotes the minimum number of deletions required.
 *
 * equalizeArray has the following parameter(s):
 *
 * arr: an array of integers
 * Input Format
 *
 * The first line contains an integer , the number of elements in .
 * The next line contains  space-separated integers arr[i].
 *
 * Constraints
 * 1 <= n <= 100
 * 1 <= arr[i] <= 100
 *
 * Output Format
 *
 * Print a single integer that denotes the minimum number of elements Karl must delete
 * for all elements in the array to be equal.
 *
 * Sample Input
 *
 * 5
 * 3 3 2 1 3
 * Sample Output
 *
 * 2
 * Explanation
 *
 * Array arr = [3,3,2,1,3]. If we delete arr[2] = 2 and arr[3] = 1,
 * all of the elements in the resulting array, A`=[3,3,3], will be equal.
 * Deleting these 2 elements is minimal. Our only other options would be to delete 4
 * elements to get an array of either [1] or [2].
 */
public class EqualizeArray {
    public static void main(String[] args) {
        test1();
        test2();
    }
    public static void test1(){
        int[] arr = {1,2,2,3};
        System.out.println("Array:"+ Arrays.toString(arr)+" result:"+equalizeArray2(arr));
    }
    public static void test2(){
        int[] arr = {3,3,2,1,3};
        System.out.println("Array:"+ Arrays.toString(arr)+" result:"+equalizeArray2(arr));
    }

    // Complete the equalizeArray function below.
    static int equalizeArray1(int[] arr) {
        if (arr==null || arr.length==0) {
            return 0;
        }
        int result = 0;
        Map<Integer, Integer> number2IndexMap = new HashMap<>();
        int maxCount = Integer.MIN_VALUE;
        for (int num: arr) {
            Integer count = number2IndexMap.get(num);
            if(count==null) {
                count = 0;
            }
            number2IndexMap.put(num, ++count);
            if(maxCount < count) {
                maxCount = count;
            }
        }

        return arr.length - maxCount;
    }

    static int equalizeArray2(int[] arr) {
        if (arr==null || arr.length==0) {
            return 0;
        }
        int result = 0;
        int[] countArr = new int[101];
        int maxCount = Integer.MIN_VALUE;
        for (int num: arr) {
            countArr[num]++;
            if(maxCount < countArr[num]) {
                maxCount = countArr[num];
            }
        }

        return arr.length - maxCount;
    }
}
