package com.opensource.dada.ds.array;

/**
 * Problem:
 * Find 2nd largest element and its occurrence in unsorted array:
 * array = [1,5,2,4,5,3,5,6,3], output should be 5 and occurrence 3;
 * time complexity is O(n).
 */
public class FindSecondLargestNumber {
    public static void main(String[] args) {
        test1();
        test2();
    }

    private static void test1() {
        int[] arr = {1,5,2,4,5,3,5,6,3};
        int[] result = findSecondLargestNumberAndOccurrence(arr);
        System.out.println("2nd Largest number:"+result[0]+" occurrence:"+result[1]);
    }

    private static void test2() {
        int[] arr = {10,5,2,4,5,3,5,6,3,6,10};
        int[] result = findSecondLargestNumberAndOccurrence(arr);
        System.out.println("2nd Largest number:"+result[0]+" occurrence:"+result[1]);
    }

    static int[] findSecondLargestNumberAndOccurrence(int[] arr) {
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE - 1;
        int largestOccurrences = 0;
        int secondariesOccurrences = 0;
        for(int i= 0; i< arr.length; i++) {
            if(largest == arr[i]) {
                largestOccurrences++;
            } else if(secondLargest == arr[i]) {
                secondariesOccurrences++;
            } else if(largest < arr[i]) {
                secondLargest = largest;
                secondariesOccurrences = largestOccurrences;

                largest = arr[i];
                largestOccurrences = 1;
            } else if (largest > arr[i] && secondLargest < arr[i]) {
                secondLargest = arr[i];
                secondariesOccurrences = 1;
            }
        }
        return new int[]{secondLargest, secondariesOccurrences};
    }
}
