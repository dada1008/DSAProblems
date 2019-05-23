package com.opensource.dada.problems.hackerrank;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/** Problem:
 * https://www.hackerrank.com/challenges/minimum-distances/problem
 */
public class MinimumDistances {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

    static void test1() {
        int[] a = {3,2,1,2,3};
        int result = minimumDistances(a);
        System.out.println("Result: "+result+" for Array:"+ Arrays.toString(a));//2
    }

    static void test2() {
        int[] a = {7,1,3,4,1,7};
        int result = minimumDistances(a);
        System.out.println("Result: "+result+" for Array:"+ Arrays.toString(a));//3
    }

    static void test3() {
        int[] a = {3,2,1,4,5};
        int result = minimumDistances(a);
        System.out.println("Result: "+result+" for Array:"+ Arrays.toString(a));//-1
    }

    static int minimumDistances(int[] a) {
        int minDistance = Integer.MAX_VALUE;
        Map<Integer, Integer> num2IndexMap = new HashMap<>();
        for (int i=0; i< a.length; i++) {
            int num = a[i];
            Integer index = num2IndexMap.remove(num);
            if (index==null) {
                num2IndexMap.put(num, i);
            } else {
                int dist = i - index;
                if (dist < minDistance) {
                    minDistance = dist;
                }
            }
        }
        if (minDistance==Integer.MAX_VALUE) {
            minDistance = -1;
        }
        return minDistance;
    }
}
