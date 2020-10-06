package com.opensource.dada.problems.hackerrank.BNYMellan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberListProblem {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>(Arrays.asList(10,20,5,30,4,20,60));
        updateList(list1);//10,20,30,60

        List<Integer> list2 = new ArrayList<>(Arrays.asList(40,8,6,22,9,7,50));
        updateList(list2);//40,50

    }

    public static void updateList(List<Integer> list) {
        // Implement this method as per the required logic
        updateListRecursive(list);
        System.out.println(list);
    }

    public static void updateListRecursive(List<Integer> list) {
        // Implement this method as per the required logic
        for (int i=1;i<list.size()-1;i++) {
            int leftNum = list.get(i-1);
            Integer num = list.get(i);
            int rightNum = list.get(i+1);
            if (leftNum > num && rightNum > num) {
                list.remove(i);
                updateListRecursive(list);
                break;
            }
        }
    }
}
