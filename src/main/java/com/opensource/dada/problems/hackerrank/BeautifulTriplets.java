package com.opensource.dada.problems.hackerrank;

import java.util.HashSet;
import java.util.Set;

/** Problem:
 * https://www.hackerrank.com/challenges/beautiful-triplets/problem
 */
public class BeautifulTriplets {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

    static void test1() {
        int d = 1;
        int[] arr = {2,2,3,4,5};
        System.out.println("Output: "+beautifulTriplets2(d,arr));//3
    }
    static void test2() {
        int d = 3;
        int[] arr = {1,2,4,5,7,8,10};
        System.out.println("Output: "+beautifulTriplets2(d,arr));//3
    }
    static void test3() {
        int d = 3;
        int[] arr = {1, 6, 7, 7, 8, 10, 12, 13, 14, 19};
        System.out.println("Output: "+beautifulTriplets2(d,arr));//2
    }
    static int beautifulTriplets(int d, int[] arr) {

        if (arr==null || arr.length<3) {
            return 0;
        }
        int count = 0;
        int i=0;
        while (i< arr.length-2) {
            int j=i+1;
            while (j< arr.length-1 && arr[j]-arr[i]<=d) {
                int k = j+1;
                while (k< arr.length && arr[k]-arr[j]<=d) {
                    if (arr[j]-arr[i]==d && d==arr[k]-arr[j]) {
                        count++;
                    }
                    k++;
                }
                j++;
            }
            i++;
        }

        return count;
    }
//More efficient O(n) complexity way
    static int beautifulTriplets2(int d, int[] arr) {

        if (arr==null || arr.length<3) {
            return 0;
        }

        Set<Integer> set = new HashSet<>();
        for (int val: arr) {
            set.add(val);
        }
        int count = 0;
        for (int val: arr) {
            if(set.contains(val+d) && set.contains(val+d+d)) {
                count++;
            }
        }

        return count;
    }
}
