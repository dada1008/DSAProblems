package com.opensource.dada.ds.hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/** Problem:
 * Find the largest continuous sequence in a array which sums to zero.
 *
 * Example:
 *
 *
 * Input:  {1 ,2 ,-2 ,4 ,-4}
 * Output: {2 ,-2 ,4 ,-4}
 *
 *  NOTE : If there are multiple correct answers, return the sequence which occurs first in the array.
 */
public class LargestContinuousSequenceZeroSum {
    public static void main(String[] args) {
        List<Integer> A = Arrays.asList(1 ,2 ,-2 ,4 ,-4);
        ArrayList<Integer> res = lszero(A);
        System.out.println("1. Result: "+res);
        //Result: [2, -2, 4, -4]

        A = Arrays.asList(15, -2, 2, -8, 1, 7, 10, 23);
        res = lszero(A);
        System.out.println("2. Result: "+res);
        //Result: [-2, 2, -8, 1, 7]

        A = Arrays.asList(1, 2, 3);
        res = lszero(A);
        System.out.println("3. Result: "+res);
        //Result: []

        A = Arrays.asList(1, 0, 3);
        res = lszero(A);
        System.out.println("4. Result: "+res);
        //Result: [0]

        A = Arrays.asList(1, 2, -1, 1, 3, -1, 1, 4);
        res = lszero(A);
        System.out.println("5. Result: "+res);
        //Result: [-1 1]

    }

    public static ArrayList<Integer> lszero(List<Integer> A) {
        ArrayList<Integer> ans = new ArrayList<Integer>();

        int sum = 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int start = 0;
        //int end = 0;
        int length = 0;
        for (int i = 0; i < A.size(); i++){
            sum += A.get(i);
            if (map.containsKey(sum)){
                int last = map.get(sum);
                if (i - last > length){
                    start = last;
                    length = i - last;
                }
            }else{
                map.put(sum, i);
            }
        }

        for (int i = 0; i < length; i++){
            ans.add(A.get(start + 1 + i));
        }

        return ans;
    }

    // This is implemented my me, which fails in some cases
    public static ArrayList<Integer> lszeroOld(List<Integer> A) {
        ArrayList<Integer> res = new ArrayList<>();
        int total = 0;
        for(Integer num: A) {
            total +=num;
        }
        if(total ==0) {
            res.addAll(A);
            return res;
        }
        int left =0, right = A.size() -1;
        int subTotal = 0;
        boolean found = false;
        while (left <=right) {
            if(left==right && A.get(left)==0) {
                found = true;
                break;
            }
            int tempSub = subTotal;
            tempSub += A.get(left);
            int subtract1 = total - tempSub;
            if(subtract1==0) {
                left++;
                found = true;
                break;
            }
            tempSub = subTotal;
            tempSub += A.get(right);
            int subtract2 = total - tempSub;
            if(subtract2==0) {
                right--;
                found = true;
                break;
            }
            subTotal = subTotal + A.get(left) + A.get(right);
            left++;
            right--;
        }

        if(found) {
            for (int i = left; i <= right; i++) {
                res.add(A.get(i));
            }
        }
        return res;
    }
}
