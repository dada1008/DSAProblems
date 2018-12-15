package com.opensource.dada.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Given two sorted integer arrays A and B, merge B into A as one sorted array.
 *
 *  Note: You have to modify the array A to contain the merge of A and B.
 *  Do not output anything in your code.
 * TIP: C users, please malloc the result into a new array and return the result.
 * If the number of elements initialized in A and B are m and n respectively,
 * the resulting size of array A after your code is executed should be m + n
 *
 * Example :
 *
 * Input :
 *          A : [1 5 8]
 *          B : [6 9]
 *
 * Modified A : [1 5 6 8 9]
 */
public class MergeTwoSortedLists {
    public static void main(String[] args) {
        /**
         * A : [ 1, 4, 5, 8, 10 ]
         * B : [ 6, 9, 15 ]
         * C : [ 2, 3, 6, 6 ]
         */
        List<Integer> A = Arrays.asList(1, 4, 5, 8, 10);
        List<Integer> B = Arrays.asList(6, 9, 15);

        merge(A, B);
        System.out.println("1-mergedList: "+A);

        /**
         * Input : A = [ 5, 8, 10, 15 ]
         *         B = [ 6, 9, 15, 78, 89 ]
         *         C = [ 2, 3, 6, 6, 8, 8, 10 ]
         */

        A = Arrays.asList(5, 8, 10, 15);
        B = Arrays.asList(6, 9, 15, 78, 89);

        merge(A, B);
        System.out.println("2-mergedList: "+A);
    }

    public static void merge(List<Integer> a, List<Integer> b) {
        int i = 0, j = 0;
        List<Integer> mergedList = new ArrayList<>();
        while (i < a.size() && j < b.size())
        {
            int num_a = a.get(i);
            int num_b = b.get(j);
            if(num_a < num_b) {
                mergedList.add(num_a);
                i++;
            } else {
                mergedList.add(num_b);
                j++;
            }
        }

        while (i < a.size()) {
            int num = a.get(i);
            mergedList.add(num);
            i++;
        }

        while (j < b.size()) {
            int num = b.get(j);
            mergedList.add(num);
            j++;
        }

        a.clear();
        a.addAll(mergedList);
    }
}
