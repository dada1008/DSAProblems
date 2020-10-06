package com.opensource.dada.problems.hackerrank.BNYMellan;

import java.util.ArrayList;
import java.util.List;

public class SrinkingNumberLine {
    /*
     * Complete the 'minimize' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY point
     *  2. INTEGER k
     */

    public static int minimize(List<Integer> point, int k) {
        if (point == null || point.isEmpty()) {
            return -1;
        }
        int initialIncrement = point.get(0)+k;
        int initialDecrement = point.get(0)-k;
        int increment = getMini(point, k, 1,initialIncrement , initialIncrement);
        int decrement = getMini(point, k, 1, initialDecrement, initialDecrement);

        return Math.min(increment, decrement);
    }

    public static int getMini(List<Integer> point, int k, int i, int min, int max) {
        if (i >= point.size()) {
            return max - min;
        }

        int initialIncrement = point.get(i)+k;
        int initialDecrement = point.get(i)-k;

        int minIncrement = Math.min(min, initialIncrement);
        int maxIncrement = Math.max(max, initialIncrement);
        int increment = getMini(point, k, i + 1, minIncrement, maxIncrement);

        int minDecrement = Math.min(min, initialDecrement);
        int maxDecrement = Math.max(max, initialDecrement);
        int decrement = getMini(point, k, i + 1, minDecrement, maxDecrement);

        return Math.min(increment, decrement);
    }

    public static int minimize2(List<Integer> point, int k) {
        if (point == null || point.isEmpty()) {
            return -1;
        }
        List<Integer> list = new ArrayList<>();
        return getMini2(point, k, 0, list);
    }

    public static int getMini2(List<Integer> point, int k, int index, List<Integer> list) {
        if (index >= point.size()) {
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < list.size(); i++) {
                min = Math.min(min, list.get(i));
                max = Math.max(max, list.get(i));
            }
            return max - min;
        }

        list.add(point.get(index) + k);
        int incre = getMini2(point, k, index + 1, list);
        list.remove(list.size() - 1);

        list.add(point.get(index) - k);
        int decre = getMini2(point, k, index + 1, list);
        list.remove(list.size() - 1);

        return Math.min(incre, decre);
    }

    public static void main(String[] args) {

        System.out.println(minimize(List.of(-3, 0, 1), 3)); //3
        System.out.println(minimize2(List.of(-3, 0, 1), 3)); //3

        System.out.println(minimize(List.of(4, 7, -7), 5)); //4
        System.out.println(minimize2(List.of(4, 7, -7), 5)); //4

        System.out.println(minimize(List.of(-100000, 100000), 100000)); //0
        System.out.println(minimize2(List.of(-100000, 100000), 100000)); //0

    }
}
