package com.opensource.dada.problems.pattern.slidingWindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** Priblem:
 * You are given with an array of 1s and 0s. And you are given with an integer M,
 * which signifies number of flips allowed.
 * Find the position of zeros which when flipped will produce maximum continuous series of 1s.
 *
 * For this problem, return the indices of maximum continuous series of 1s in order.
 *
 * Example:
 *
 * Input :
 * Array = {1 1 0 1 1 0 0 1 1 1 }
 * M = 1
 *
 * Output :
 * [0, 1, 2, 3, 4]
 *
 * If there are multiple possible solutions, return the sequence which has the minimum start index.
 */
public class MaxContinuousSeriesOf1s {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

    public static void test1() {
        List<Integer> A = Arrays.asList(1,1,0,1,1,0,0,1,1,1);
        int B =2;

        List<Integer> res = maxoneMy(A,B);
        System.out.println("Result: "+res);
    }

    public static void test2() {
        List<Integer> A = Arrays.asList(0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1);
        int B =2;

        List<Integer> res = maxoneMyPractice(A,B);
        System.out.println("Result: "+res);//6
    }

    public static void test3() {
        List<Integer> A = Arrays.asList(0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1);
        int B =3;
        List<Integer> res = maxoneMyPractice(A,B);
        System.out.println("Result: "+res);//9
    }

    public static List<Integer> maxoneMyPractice(List<Integer> list, int k) {
        int start =0, end = 0, windowStart = 0, maxZeroRepeat =0;
        for (int windowEnd = 0; windowEnd < list.size(); windowEnd++) {
            int num = list.get(windowEnd);
            if (num==0) {
                maxZeroRepeat++;
            }
            if (maxZeroRepeat > k) {
                int leftNum = list.get(windowStart);
                if (leftNum==0) {
                    maxZeroRepeat--;
                }
                windowStart++;
            }

            if ((end - start) < (windowEnd - windowStart)) {
                end = windowEnd;
                start = windowStart;
            }
        }

        List<Integer> res = new ArrayList<>();
        for (int i=start; i<=end;i++) {
            res.add(i);
        }
        return res;
    }
    public static List<Integer> maxoneMy(List<Integer> A, int B) {

        int left =0, right =0, len =0, count0 =0, start=0, end =0;
        while (right < A.size()) {
            if(count0<=B) {
                if (A.get(right)==0) {
                    count0++;
                }
                right++;
            }
            if(count0>B){
                if (A.get(left)==0) {
                    count0--;
                }
                left++;
            }
            if ((right-left)>len) {
                len = right - left;
                start = left;
                end = right;
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i=start; i<end;i++) {
            res.add(i);
        }
        return res;
    }
    public static List<Integer> maxone(List<Integer> a, int b) {

        /**
         * pointer i and j
         * i = j = 0
         * iterate till i < N:
         *         if(Number_of_Zeros_in_Current_range > M) :
         *                 increment j and reduce range till Number_of_Zeros_in_current_range < M
         *         else :
         *                 add element in range and update all variables
         */
        int n=a.size();
        int count0=0;

        int l=0,r=0;
        int len=0;
        int si=0,di=0;
        while(r<n){
            if(count0<=b){
                if(a.get(r)==0){
                    count0++;
                }
                r++;
            }
            if(count0>b){
                if(a.get(l)==0){
                    count0--;
                }
                l++;
            }
            if(r-l>len){
                si=l;
                di=r;
                len=r-l;
            }
        }

        ArrayList<Integer> ls=new ArrayList<>();
        for(int i=si;i<di;i++){
            ls.add(i);
        }
        return ls;
    }
}
