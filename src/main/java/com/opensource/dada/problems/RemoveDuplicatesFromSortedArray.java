package com.opensource.dada.problems;

import java.util.Arrays;
import java.util.List;

public class RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {
        Integer[] arr = {1,1,2};
        int result = removeDuplicates(Arrays.asList(arr));
        System.out.println("result: "+result);
    }
    public static int removeDuplicates(List<Integer> a) {
        int n = a.size();
        if (n == 0 || n == 1)
            return n;

        // To store index of next unique element
        int j = 0;

        // Doing same as done in Method 1
        // Just maintaining another updated index i.e. j
        for (int i = 0; i < n-1; i++) {
            int i1 = a.get(i);
            int i2 = a.get(i+1);
            if (i1 != i2) {
                a.set(j++,i1);
            }
        }
        int n1 = a.get(n-1);
        a.set(j++,n1);

        return j;
    }
}
