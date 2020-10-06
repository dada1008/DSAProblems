package com.opensource.dada.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LargeRange {
    public static void main(String[] args) {
        System.out.println("Result:"+Arrays.toString(
                largeRange(new int[] {1, 11, 3, 0 ,15, 5, 2, 4, 10 ,7, 12, 6})
        ));//[0,7]
    }

    static int[] largeRange(int[] array) {
        int[] bestRange = new int[2];
        int longestLength = 0;
        Map<Integer, Boolean> nums = new HashMap<>();
        for (int num: array) {
            nums.put(num, true);
        }
        for (int i = 0; i < array.length; i++) {
            int num = array[i];
            if (!nums.containsKey(num)) {
                continue;
            }
            nums.put(num, false);
            int currentLength = 0;
            int left = num - 1;
            int right = num + 1;
            while (nums.containsKey(left)) {
                nums.put(left, false);
                currentLength++;
                left--;
            }
            while (nums.containsKey(right)) {
                nums.put(right, false);
                currentLength++;
                right++;
            }
            if (currentLength > longestLength) {
                longestLength = currentLength;
                bestRange[0] = left + 1;
                bestRange[1] = right - 1;
            }
        }

        return bestRange;
    }
}
