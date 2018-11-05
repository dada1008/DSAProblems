package com.opensource.dada.alg.search;

public class InterpolationSearch {
    public static void main(String[] args) {
        System.out.println("Binary search");
        int[] arr = {1,2,4,6,8,9,15,18,20,25,30};
        int foundIndex = interpolationSearch(arr,25);
        System.out.println("Index of 25: "+foundIndex);
        foundIndex = interpolationSearch(arr,5);
        System.out.println("Index of 5: "+foundIndex);
    }

    public static int interpolationSearch(int[] arr, int searchValue) {
        int min =0;
        int max = arr.length -1;
        while (min<=max) {

            // Prevent division by zero.
            if (arr[min] == arr[max])
            {
                // This must be the item if it's in the array).
                if (arr[min] == searchValue) {
                    return min;
                }
                return -1;
            }

            //find the dividing item
            int mid = min + (max - min)*((searchValue-arr[min])/(arr[max] - arr[min]));

            // If mid is out of bounds, then the target isn't in the array.
            if ((mid < min) || (mid > max)) {
                return -1;
            }

            // See if we need to search the left or right half.
            if (arr[mid] < searchValue) {
                min = mid + 1;
            } else if (arr[mid] > searchValue) {
                max = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
