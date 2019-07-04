package com.opensource.dada.problems.pattern.kWayMerge;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Problem: https://www.geeksforgeeks.org/find-k-pairs-smallest-sums-two-arrays/
 *          https://leetcode.com/problems/find-k-pairs-with-smallest-sums/
 */
public class FindKSmallestPairs {
    public static void main(String[] args) {
        test1();
        //test2();
    }

    static void test1() {
        /**
         * Input: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
         * Output: [1,1],[1,1]
         * Explanation: The first 2 pairs are returned from the sequence:
         *              [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
         */
        System.out.println("1. Smallest pairs: "+kSmallestPairs(new int[]{1,1,2},new int[]{1,2,3},2));
    }

    static void test2() {
        /**
         * Input: nums1 = [1,2], nums2 = [3], k = 3
         * Output: [1,3],[2,3]
         * Explanation: All possible pairs are returned from the sequence: [1,3],[2,3]
         */
        System.out.println("2. Smallest pairs: "+kSmallestPairs(new int[]{1,2},new int[]{3},3));
    }

    public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int nlen1 = nums1.length, nlen2 = nums2.length;
        List<List<Integer>> res = new ArrayList<>();
        if(nlen1==0 || nlen2==0 || k==0) {
            return res;
        }
        PriorityQueue<List<Integer>> queue = new PriorityQueue<>((a, b) -> a.get(0)+a.get(1)-b.get(0)-b.get(1));

        for(int i=0; i<nlen1 && i<k ; i++) {
            queue.offer(List.of(nums1[i], nums2[0], 0));
        }

        while(k-- > 0 && !queue.isEmpty()){
            List<Integer> cur = queue.poll();
            res.add(List.of(cur.get(0),cur.get(1)));
            if(cur.get(2)==nums2.length-1) {
                continue;
            }
            queue.offer(List.of(cur.get(0), nums2[cur.get(2)+1], cur.get(2)+1));
        }
        return res;

    }
}
