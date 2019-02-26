package com.opensource.dada.problems;

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
        List<Integer> A = Arrays.asList(1,1,0,1,1,0,0,1,1,1);
        int B =2;

        List<Integer> res = maxoneMy(A,B);
        System.out.println("Result: "+res);
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
