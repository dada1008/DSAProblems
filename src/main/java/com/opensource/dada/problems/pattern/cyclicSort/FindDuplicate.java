package com.opensource.dada.problems.pattern.cyclicSort;

/**
 * Problem:
 * https://www.geeksforgeeks.org/find-duplicates-in-on-time-and-constant-extra-space/
 *
 * We are given an unsorted array containing ‘n+1’ numbers taken from the range 1 to ‘n’.
 * The array has only one duplicate but it can be repeated multiple times.
 * Find that duplicate number without using any extra space.
 * You are, however, allowed to modify the input array.
 *
 * Example 1:
 *
 * Input: [1, 4, 4, 3, 2]
 * Output: 4
 * Example 2:
 *
 * Input: [2, 1, 3, 3, 5, 4]
 * Output: 3
 * Example 3:
 *
 * Input: [2, 4, 1, 4, 4]
 * Output: 4
 *
 */
// Java code to find
// duplicates in O(n) time

class FindDuplicate {
    // Function to print duplicates
    void printRepeating(int arr[], int size) {
        int i;
        System.out.println("The repeating elements are : ");

        for (i = 0; i < size; i++) {
            if (arr[Math.abs(arr[i])] >= 0)
                arr[Math.abs(arr[i])] = -arr[Math.abs(arr[i])];
            else
                System.out.print(Math.abs(arr[i]) + " ");
        }
    }

    // Driver program
    public static void main(String[] args) {
        FindDuplicate duplicate = new FindDuplicate();
        int arr[] = {1, 2, 3, 1, 3, 6, 6};
        int arr_size = arr.length;

        duplicate.printRepeating(arr, arr_size);

        System.out.println("Found duplicate:"+findDuplicateNumber(new int[] {1, 4, 4, 3, 2}));
        System.out.println("Found duplicate:"+findDuplicateNumber(new int[] {2, 1, 3, 3, 5, 4}));
        System.out.println("Found duplicate:"+findDuplicateNumber(new int[] {2, 4, 1, 4, 4}));
    }

    static int findDuplicateNumber(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] != i+1) {
                if (nums[i] != nums[nums[i]-1]) {
                    swap(nums, i, nums[i]-1);
                } else {
                    return nums[i];
                }
            } else {
                i++;
            }
        }

        return -1;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

