package com.opensource.dada.microsoft;

/**
 * Problem: https://www.geeksforgeeks.org/search-an-element-in-a-sorted-and-pivoted-array/
 * solution in O(logN)
 */
public class SearchElementInSortedAndRotatedArray {
    public static void main(String[] args) {

        int[] arr = {5, 6, 7, 8, 9, 10, 1, 2, 3};
        int key = 3;
        int index1 = pivotedBinarySearch(arr, arr.length, key);
        int index2 = search(arr, 0, arr.length-1, key);
        System.out.println("Key: "+key+"'s index1:"+index1+" index2:"+index2);

        arr = new int[]{4, 5, 6, 7, 8, 9, 1, 2, 3};
        key = 6;
        index1 = pivotedBinarySearch(arr, arr.length, key);
        index2 = search(arr, 0, arr.length-1, key);
        System.out.println("Key: "+key+"'s index1:"+index1+" index2:"+index2);

        arr = new int[]{5, 6, 7, 8, 9, 10, 1, 2, 3};
        key = 30;
        index1 = pivotedBinarySearch(arr, arr.length, key);
        index2 = search(arr, 0, arr.length-1, key);
        System.out.println("Key: "+key+"'s index1:"+index1+" index2:"+index2);

        arr = new int[]{30, 40, 50, 10, 20};
        key = 10;
        index1 = pivotedBinarySearch(arr, arr.length, key);
        index2 = search(arr, 0, arr.length-1, key);
        System.out.println("Key: "+key+"'s index1:"+index1+" index2:"+index2);

    }

    /*
    Input arr[] = {3, 4, 5, 1, 2}
    Element to Search = 1
    1) Find out pivot point and divide the array in two
        sub-arrays. (pivot = 2) *//*Index of 5*//*
    2) Now call binary search for one of the two sub-arrays.
         (a) If element is greater than 0th element then
            search in left array
         (b) Else Search in right array
          (1 will go in else as 1 < 0th element(3))
    3) If element is found in selected sub-array then return index
        Else return -1.
    */

    /* Searches an element key in a
       pivoted sorted array arrp[]
       of size n */
    static int pivotedBinarySearch(int arr[], int n, int key)
    {
        int pivot = findPivot(arr, 0, n-1);

        // If we didn't find a pivot, then
        // array is not rotated at all
        if (pivot == -1)
            return binarySearch(arr, 0, n-1, key);

        // If we found a pivot, then first
        // compare with pivot and then
        // search in two subarrays around pivot
        if (arr[pivot] == key)
            return pivot;
        if (arr[0] <= key)
            return binarySearch(arr, 0, pivot-1, key);
        return binarySearch(arr, pivot+1, n-1, key);
    }

    /* Function to get pivot. For array
       3, 4, 5, 6, 1, 2 it returns
       3 (index of 6) */
    static int findPivot(int arr[], int low, int high)
    {
        // base cases
        if (high < low)
            return -1;
        if (high == low)
            return low;

        /* low + (high - low)/2; */
        int mid = (low + high)/2;
        if (mid < high && arr[mid] > arr[mid + 1])
            return mid;
        if (mid > low && arr[mid] < arr[mid - 1])
            return (mid-1);
        if (arr[low] >= arr[mid])
            return findPivot(arr, low, mid-1);
        return findPivot(arr, mid + 1, high);
    }

    /* Standard Binary Search function */
    static int binarySearch(int arr[], int low, int high, int key)
    {
        if (high < low)
            return -1;

        /* low + (high - low)/2; */
        int mid = (low + high)/2;
        if (key == arr[mid])
            return mid;
        if (key > arr[mid])
            return binarySearch(arr, (mid + 1), high, key);
        return binarySearch(arr, low, (mid -1), key);
    }

    /*
    1) Find middle point mid = (l + h)/2
    2) If key is present at middle point, return mid.
    3) Else If arr[l..mid] is sorted
        a) If key to be searched lies in range from arr[l]
            to arr[mid], recur for arr[l..mid].
        b) Else recur for arr[mid+1..h]
    4) Else (arr[mid+1..h] must be sorted)
        a) If key to be searched lies in range from arr[mid+1]
            to arr[h], recur for arr[mid+1..h].
        b) Else recur for arr[l..mid]
    */
    // Returns index of key in arr[l..h]
    // if key is present, otherwise returns -1
    static int search(int arr[], int l, int h, int key)
    {
        if (l > h)
            return -1;

        int mid = (l+h)/2;
        if (arr[mid] == key)
            return mid;

        /* If arr[l...mid] first subarray is sorted */
        if (arr[l] <= arr[mid])
        {
            /* As this subarray is sorted, we
               can quickly check if key lies in
               half or other half */
            if (key >= arr[l] && key <= arr[mid])
                return search(arr, l, mid-1, key);
            /*If key not lies in first half subarray,
           Divide other half  into two subarrays,
           such that we can quickly check if key lies
           in other half */
            return search(arr, mid+1, h, key);
        }

        /* If arr[l..mid] first subarray is not sorted,
           then arr[mid... h] must be sorted subarry*/
        if (key >= arr[mid] && key <= arr[h])
            return search(arr, mid+1, h, key);

        return search(arr, l, mid-1, key);
    }

}
