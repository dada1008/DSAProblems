package com.opensource.dada.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Find the intersection of two sorted arrays.
 * OR in other words,
 * Given 2 sorted arrays, find all the elements which occur in both the arrays.
 *
 * Example :
 *
 * Input :
 *     A : [1 2 3 3 4 5 6]
 *     B : [3 3 5]
 *
 * Output : [3 3 5]
 *
 * Input :
 *     A : [1 2 3 3 4 5 6]
 *     B : [3 5]
 *
 * Output : [3 5]
 */
public class IntersectionOfSortedArrays {
    public static void main(String[] args) {
        List<Integer> A = Arrays.asList(1,2,3,3,4,5,6);
        List<Integer> B = Arrays.asList(3, 3, 5);

        List<Integer> res = intersect(A,B);
        System.out.println("1. Result:"+res);

        A = Arrays.asList(1,2,3,3,4,5,6);
        B = Arrays.asList(3, 5);

        res = intersect(A,B);
        System.out.println("2. Result:"+res);

    }

    public static List<Integer> intersect(final List<Integer> A, final List<Integer> B) {
        List<Integer> res = new ArrayList<>();

        int indexA = 0;
        int indexB = 0;

        while(indexA<A.size() && indexB < B.size()) {

            int valueA = A.get(indexA);
            int valueB = B.get(indexB);
            if (valueA==valueB) {
                res.add(valueA);
                indexA++;
                indexB++;
            } else if(valueA > valueB) {
                indexB++;
            } else {
                indexA++;
            }
        }

        return res;
    }
}
