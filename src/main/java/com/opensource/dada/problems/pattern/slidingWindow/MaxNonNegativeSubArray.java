package com.opensource.dada.problems.pattern.slidingWindow;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/** Problem:
 * Find out the maximum sub-array of non negative numbers from an array.
 * The sub-array should be continuous. That is, a sub-array created by choosing the second
 * and fourth element and skipping the third element is invalid.
 *
 * Maximum sub-array is defined in terms of the sum of the elements in the sub-array.
 * Sub-array A is greater than sub-array B if sum(A) > sum(B).
 *
 * Example:
 *
 * A : [1, 2, 5, -7, 2, 3]
 * The two sub-arrays are [1, 2, 5] [2, 3].
 * The answer is [1, 2, 5] as its sum is larger than [2, 3]
 * NOTE: If there is a tie, then compare with segment's length and return segment which has maximum length
 * NOTE 2: If there is still a tie, then return the segment with minimum starting index
 */
public class MaxNonNegativeSubArray {
    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 5, -7, 2, 3);
        /*System.out.println("list:"+list+" result:"+maxset(list));

        list = List.of(-1,-1,-1,-1,-1);
        System.out.println("list:"+list+" result:"+maxset(list));

        list = List.of(1967513926, 1540383426, -1303455736, -521595368);
        System.out.println("list:"+list+" result:"+maxset(list));*/
        (new HashMap<>()).getOrDefault("10",0);
        list = List.of(756898537, -1973594324, -2038664370, -184803526, 1424268980);
        System.out.println("list:"+list+" result:"+maxset(list));


    }

    public static ArrayList<Integer> maxset(List<Integer> A) {
        if(A==null || A.isEmpty()) {
            return new ArrayList<>(A);
        }
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> tempList = new ArrayList<>();
        long tempSum =0, maxSum = 0;
        for (int i=0;i<A.size();i++) {
            long val = A.get(i);
            if(val< 0) {
                if(tempSum == maxSum) {
                    if(tempList.size() == list.size() && !tempList.isEmpty()) {
                        if(tempList.get(0)<list.get(0)) {
                            list = tempList;
                        }
                    } else if(tempList.size() > list.size()) {
                        list = tempList;
                    }
                } else if(tempSum > maxSum) {
                    maxSum = tempSum;
                    list = tempList;
                }
                tempSum = 0;
                tempList = new ArrayList<>();
            } else {
                tempSum+=val;
                tempList.add(i);
            }
        }
        if(tempSum >0 ) {
            if(tempSum == maxSum) {
                if(tempList.size() == list.size() && !tempList.isEmpty()) {
                    if(tempList.get(0)<list.get(0)) {
                        list = tempList;
                    }
                } else if(tempList.size() > list.size()) {
                    list = tempList;
                }
            } else if(tempSum > maxSum) {
                maxSum = tempSum;
                list = tempList;
            }
        }
        ArrayList<Integer> resultList = new ArrayList<>();
        for (int i:list) {
            resultList.add(A.get(i));
        }
        return resultList;
    }
}
