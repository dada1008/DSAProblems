package com.opensource.dada.problems;

import java.util.Arrays;

public class MinimumNumberOfJumps {
    public static void main(String[] args) {
        int[] array = {3, 4, 2, 1, 2, 3, 7, 1, 1, 1, 3};
        System.out.println("1. Result:"+findMinNoOfJumps1(array));//4
        System.out.println("2. Result:"+findMinNoOfJumps2(array));//4
    }

    //Complexity: time: O(n^2), space: O(n)
    static int findMinNoOfJumps1(int[] array) {
        int[] jumps = new int[array.length];
        Arrays.fill(jumps, Integer.MAX_VALUE);
        jumps[0] = 0;
        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < i; j++) {
                if (array[j]+j >= i) {
                    jumps[i] = Math.min(jumps[j]+1, jumps[i]);
                }
            }
        }
        return jumps[jumps.length -1];
    }

    //Complexity: time: O(n), space: O(1)
    static int findMinNoOfJumps2(int[] array) {
        if (array==null || array.length==0) {
            return 0;
        }
        int jumps = 0;
        int maxReach = array[0];
        int steps = array[0];
        for (int i = 1; i < array.length -1; i++) {
            maxReach = Math.max(maxReach, i + array[i]);
            steps--;
            if (steps==0) {
                jumps++;
                steps = maxReach - i;
            }
        }
        return jumps + 1;
    }
}
