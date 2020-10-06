package com.opensource.dada.problems.hackerrank.BNYMellan;

import java.util.Arrays;
import java.util.List;

public class BalancedSalesArray {
    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1,2,3,3);
        System.out.println("1. "+balancedSum(list1));//2

        List<Integer> list2 = Arrays.asList(1,2,1);
        System.out.println("2. "+balancedSum(list2));//1
    }

    /*
     * Complete the 'balancedSum' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY sales as parameter.
     */

    public static int balancedSum(List<Integer> sales) {
        // Write your code here
        int leftSum = 0;
        int rightSum = 0;
        for (int i=1;i<sales.size();i++) {
            leftSum+=sales.get(i);
        }

        for (int i=1;i<sales.size();i++) {
            leftSum-=sales.get(i-1);
            rightSum+=sales.get(i);
            if (leftSum==rightSum) {
                return i;
            }
        }
        return -1;
    }
}
