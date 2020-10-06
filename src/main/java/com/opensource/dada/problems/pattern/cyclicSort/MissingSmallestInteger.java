package com.opensource.dada.problems.pattern.cyclicSort;

/** Problem: https://www.geeksforgeeks.org/find-the-smallest-positive-number-missing-from-an-unsorted-array/
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
 *
 *
 * Find the Smallest Missing Positive Number (medium) #
 * Given an unsorted array containing numbers, find the smallest missing positive number in it.
 *
 * Example 1:
 *
 * Input: [-3, 1, 5, 4, 2]
 * Output: 3
 * Explanation: The smallest missing positive number is '3'
 * Example 2:
 *
 * Input: [3, -2, 0, 1, 2]
 * Output: 4
 * Example 3:
 *
 * Input: [3, 2, 5, 1]
 * Output: 4
 */
public class MissingSmallestInteger {
    public static void main(String[] agrs) {
        System.out.println("Result:"+findSmallestMissingNumber(new int[]{-3, 1, 5, 4, 2}));//3
        System.out.println("Result:"+findSmallestMissingNumber(new int[]{3, -2, 0, 1, 2}));//4
        System.out.println("Result:"+findSmallestMissingNumber(new int[]{3, 2, 5, 1}));//4
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

    // solution from GeeksforGeeks

    /* Utility function that puts all non-positive
       (0 and negative) numbers on left side of
       arr[] and return count of such numbers */
    static int segregate (int arr[], int size)
    {
        int j = 0, i;
        for(i = 0; i < size; i++)
        {
            if (arr[i] <= 0)
            {
                int temp;
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                // increment count of non-positive
                // integers
                j++;
            }
        }

        return j;
    }

    /**
     *
     * Following is the two step algorithm.
     * 1) Segregate positive numbers from others i.e.,
     *      move all non-positive numbers to left side.
     *      In the following code, segregate() function does this part.
     * 2) Now we can ignore non-positive elements and consider only the part of array
     *      which contains all positive elements. We traverse the array containing all positive numbers
     *      and to mark presence of an element x, we change the sign of value at index x to negative.
     *      We traverse the array again and print the first index which has positive value.
     *      In the following code, findMissingPositive() function does this part.
     *      Note that in findMissingPositive, we have subtracted 1 from the values
     *      as indexes start from 0 in C.
     *
     * Time complexity is O(n)
     */
    /* Find the smallest positive missing
       number in an array that contains
       all positive integers */
    static int findMissingPositive(int arr[], int size)
    {
        int i;

        // Mark arr[i] as visited by making
        // arr[arr[i] - 1] negative. Note that
        // 1 is subtracted because index start
        // from 0 and positive numbers start from 1
        for(i = 0; i < size; i++)
        {
            int x = Math.abs(arr[i]);
            if(x - 1 < size && arr[x - 1] > 0)
                arr[x - 1] = -arr[x - 1];
        }

        // Return the first index value at which
        // is positive
        for(i = 0; i < size; i++)
            if (arr[i] > 0)
                return i+1;  // 1 is added becuase indexes start from 0

        return size+1;
    }

    /* Find the smallest positive missing
       number in an array that contains
       both positive and negative integers */
    static int findMissing(int arr[], int size)
    {
        // First separate positive and
        // negative numbers
        int shift = segregate (arr, size);
        int arr2[] = new int[size-shift];
        int j=0;
        for(int i=shift;i<size;i++)
        {
            arr2[j] = arr[i];
            j++;
        }
        // Shift the array and call
        // findMissingPositive for
        // positive part
        return findMissingPositive(arr2, j);
    }

    static int findSmallestMissingNumber(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i]-1]) {
                swap(nums, i, nums[i]-1);
            } else {
                i++;
            }
        }

        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j+1) {
                return j+1;
            }
        }
        return nums.length+1;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
