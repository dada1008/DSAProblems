package com.opensource.dada.problems.pattern.modifiedBinarySearch;

/**
 * Problem 1: https://www.geeksforgeeks.org/find-position-element-sorted-array-infinite-numbers/
 * Problem 2: https://www.careercup.com/question?id=9652667
 */
public class SearchInSortedInfiniteArray {
    public static void main(String[] args) {
        problem1();
        problem2();
    }

    static void problem1() {
        int arr[] = new int[]{3, 5, 7, 9, 10, 90,
                100, 130, 140, 160, 170};
        int ans = findPos(arr, 10);
        System.out.println("Problem 1 Ans:" + ans);//4
    }

    // Method takes an infinite size array and a key to be
    // searched and returns its position if found else -1.
    // We don't know size of arr[] and we can assume size to be
    // infinite in this function.
    // NOTE THAT THIS FUNCTION ASSUMES arr[] TO BE OF INFINITE SIZE
    // THEREFORE, THERE IS NO INDEX OUT OF BOUND CHECKING
    static int findPos(int arr[], int key) {
        int l = 0, h = 1;
        int val = arr[0];

        // Find h to do binary search
        while (val < key) {
            l = h;     // store previous high
            //check that 2*h doesn't exceeds array
            //length to prevent ArrayOutOfBoundException
            if (2 * h < arr.length - 1)
                h = 2 * h;
            else
                h = arr.length - 1;

            val = arr[h]; // update new val
        }

        // at this point we have updated low
        // and high indices, thus use binary
        // search between them
        return binarySearch(arr, l, h, key);
    }

    // Simple binary search algorithm
    static int binarySearch(int arr[], int l, int r, int x) {
        if (r >= l) {
            int mid = l + (r - l) / 2;
            if (arr[mid] == x)
                return mid;
            if (arr[mid] > x)
                return binarySearch(arr, l, mid - 1, x);
            return binarySearch(arr, mid + 1, r, x);
        }
        return -1;
    }

    static void problem2() {
        int arr[] = new int[]{0,0,0,0,0,0,1,1,1,1,1};
        int ans = getMid0And1(arr, 0, arr.length-1);
        System.out.println("Problem 2 Ans:" + ans);//5
    }

    static int getMid0And1(int[] array, int startIndex, int endIndex) {

        if (startIndex == endIndex)
            return -1;
        if (startIndex + 1 == endIndex && array[startIndex] == 0 && array[endIndex] == 1)
            return startIndex;
        int mid = startIndex + (endIndex - startIndex) / 2;

        if (array[mid] == 0)
            return getMid0And1(array, mid, endIndex);
        else
            return getMid0And1(array, startIndex, mid);

    }
}
