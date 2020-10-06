package com.opensource.dada.alg.dynamicprogramming;

import java.util.Arrays;

public class WaterArea {
    public static void main(String[] args) {
        int[] array = {0, 8, 0, 0, 5, 0, 0, 10, 0, 0, 1, 1, 0, 3};
        System.out.println("Result:"+findWaterArea(array));//48
    }

    static int findWaterArea(int[] array) {
        int[] maxes = new int[array.length];
        int leftMax = 0;
        for (int i = 0; i < array.length; i++) {
            int height = array[i];
            maxes[i] = leftMax;
            leftMax = Math.max(height, leftMax);
        }
        int rightMax = 0;
        for (int i = array.length -1; i >=0 ; i--) {
            int height = array[i];
            int minHeight = Math.min(maxes[i], rightMax);
            if (height < minHeight) {
                maxes[i] = minHeight - height;
            } else {
                maxes[i] = 0;
            }
            rightMax = Math.max(height, rightMax);
        }
        return Arrays.stream(maxes).sum();
    }
}
