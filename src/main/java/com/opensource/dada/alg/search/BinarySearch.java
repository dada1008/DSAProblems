package com.opensource.dada.alg.search;

public class BinarySearch {
    public static void main(String[] args) {
        System.out.println("Binary search");
        int[] arr = {1,2,4,6,8,9,15,18,20,25,30};
        int foundIndex = binarySearch(arr,25);
        System.out.println("Index of 25: "+foundIndex);
        foundIndex = binarySearch(arr,5);
        System.out.println("Index of 5: "+foundIndex);
    }

    public static int binarySearch(int[] arr, int searchValue) {
        int min =0;
        int max = arr.length -1;
        while (min<=max) {
            int mid = (min + max)/2;
            if (searchValue > arr[mid]) {
                min = mid + 1;
            } else if (searchValue < arr[mid]) {
                max = mid -1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
