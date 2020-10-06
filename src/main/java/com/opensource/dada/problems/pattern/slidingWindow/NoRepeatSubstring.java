package com.opensource.dada.problems.pattern.slidingWindow;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Problem:
 * Given a string, find the length of the longest substring which has no repeating characters.
 *
 * Example 1:
 *
 * Input: String="aabccbb"
 * Output: 3
 * Explanation: The longest substring without any repeating characters is "abc".
 * Example 2:
 *
 * Input: String="abbbb"
 * Output: 2
 * Explanation: The longest substring without any repeating characters is "ab".
 * Example 3:
 *
 * Input: String="abccde"
 * Output: 3
 * Explanation: Longest substrings without any repeating characters are "abc" & "cde".
 */
public class NoRepeatSubstring {
    public static void main(String[] args) {
        System.out.println("Result:"+findLength("aabccbb"));//3
        System.out.println("Result:"+findLength("abbbb"));//2
        System.out.println("Result:"+findLength("abccde"));//3
    }

    static int findLength(String str) {
        char[] arr = str.toCharArray();
        int start = 0, end = 0, windowStart = 0;
        Map<Character, Integer> uniqueChars = new HashMap<>();
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            char ch = arr[windowEnd];
            if (uniqueChars.containsKey(ch)) {
                Integer index = uniqueChars.get(ch);
                //If we found repeated char, then we need to
                // start by leaving that earlier char start index
                // hence index + 1
                windowStart = Math.max(windowStart, index+1);
            }
            uniqueChars.put(ch, windowEnd);
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
