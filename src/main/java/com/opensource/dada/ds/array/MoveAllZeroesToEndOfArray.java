package com.opensource.dada.ds.array;

import java.util.Arrays;

public class MoveAllZeroesToEndOfArray {

    public static void main(String[] args) {
        int arr[]  = {1, 2, 0, 0, 0, 3, 6};
        System.out.println("Array before moving zero:"+ Arrays.toString(arr));
        moveZerosToEnd(arr);
        System.out.println("Array after moving zero:"+ Arrays.toString(arr));
        int arr2[] = {0, 1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0, 9};
        System.out.println("Array before moving zero:"+ Arrays.toString(arr2));
        moveZerosToEnd(arr2);
        System.out.println("Array after moving zero:"+ Arrays.toString(arr2));
    }

    // method to move all zeroes at the end of array
    public static void moveZerosToEnd(int arr[]) {
        // Count of non-zero elements
        int count = 0;
        int temp;

        // Traverse the array. If arr[i] is
        // non-zero, then swap the element at
        // index 'count' with the element at
        // index 'i'
        for (int i = 0; i < arr.length; i++) {
            if ((arr[i] != 0)) {
                temp = arr[count];
                arr[count] = arr[i];
                arr[i] = temp;
                count++;
            }
        }
    }
}
