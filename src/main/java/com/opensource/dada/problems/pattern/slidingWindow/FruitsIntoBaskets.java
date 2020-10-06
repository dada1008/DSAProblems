package com.opensource.dada.problems.pattern.slidingWindow;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Problem:
 * Given an array of characters where each character represents a fruit tree,
 * you are given two baskets and your goal is to put maximum number of fruits in each basket.
 * The only restriction is that each basket can have only one type of fruit.
 *
 * You can start with any tree, but once you have started you can’t skip a tree.
 * You will pick one fruit from each tree until you cannot,
 * i.e., you will stop when you have to pick from a third fruit type.
 *
 * Write a function to return the maximum number of fruits in both the baskets.
 *
 * Example 1:
 * Input: Fruit=['A', 'B', 'C', 'A', 'C']
 * Output: 3
 * Explanation: We can put 2 'C' in one basket and one 'A' in the other from the subarray ['C', 'A', 'C']
 *
 * Example 2:
 * Input: Fruit=['A', 'B', 'C', 'B', 'B', 'C']
 * Output: 5
 * Explanation: We can put 3 'B' in one basket and two 'C' in the other basket.
 * This can be done if we start with the second letter: ['B', 'C', 'B', 'B', 'C']
 */
public class FruitsIntoBaskets {
    public static void main(String[] args) {
        test1();
        test2();
    }

    public static void test1() {
        char[] chars = {'A', 'B', 'C', 'A', 'C'};
        int length = findLength(chars, 2);
        System.out.println("Length:"+length);//3
    }
    public static void test2() {
        char[] chars = {'A', 'B', 'C', 'B', 'B', 'C'};
        int length = findLength(chars, 2);
        System.out.println("Length:"+length);//5
    }

    static int findLength(char[] arr, int basketSize) {
        int start = 0, end = 0, windowStart = 0;
        Map<Character, Integer> uniqueChars = new HashMap<>();
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            char leftChar = arr[windowEnd];
            Integer count = uniqueChars.get(leftChar);
            if (count==null || count==0) {
                count = 0;
            }
            uniqueChars.put(leftChar, ++count);
            while (uniqueChars.size()>basketSize) {
                char rightChar = arr[windowStart];
                Integer rightCharCount = uniqueChars.get(rightChar);
                rightCharCount--;
                if (rightCharCount==0) {
                    uniqueChars.remove(rightChar);
                } else {
                    uniqueChars.put(rightChar, rightCharCount);
                }
                windowStart++;
            }
            if ((end - start) < (windowEnd - windowStart)) {
                end = windowEnd;
                start = windowStart;
            }
        }
        char[] resultArr = Arrays.copyOfRange(arr, start, end+1);
        System.out.println("Result size:"+resultArr.length+" arr:"+Arrays.toString(resultArr));
        return resultArr.length;
    }
}
