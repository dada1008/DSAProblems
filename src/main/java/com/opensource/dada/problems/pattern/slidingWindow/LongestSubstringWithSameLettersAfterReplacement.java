package com.opensource.dada.problems.pattern.slidingWindow;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Problem:
 * Given a string with lowercase letters only, if you are allowed to replace no more than ‘k’ letters
 * with any letter, find the length of the longest substring having the same letters after replacement.
 * <p>
 * Example 1:
 * Input: String="aabccbb", k=2
 * Output: 5
 * Explanation: Replace the two 'c' with 'b' to have a longest repeating substring "bbbbb".
 * <p>
 * Example 2:
 * Input: String="abbcb", k=1
 * Output: 4
 * Explanation: Replace the 'c' with 'b' to have a longest repeating substring "bbbb".
 * <p>
 * Example 3:
 * Input: String="abccde", k=1
 * Output: 3
 * Explanation: Replace the 'b' or 'd' with 'c' to have the longest repeating substring "ccc".
 */
public class LongestSubstringWithSameLettersAfterReplacement {
    public static void main(String[] args) {
        System.out.println("Result:" + findLength("aabccbb", 2));//5
        System.out.println("Result:" + findLength("abbcb", 1));//4
        System.out.println("Result:" + findLength("abccde", 1));//3
    }

    static int findLength(String str, int k) {
        char[] arr = str.toCharArray();
        int start = 0, end = 0, windowStart = 0, maxRepeatedCount = 0;
        Map<Character, Integer> uniqueChars = new HashMap<>();
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            char rightChar = arr[windowEnd];
            Integer count = uniqueChars.get(rightChar);
            if (count == null) {
                count = 0;
            }
            uniqueChars.put(rightChar, ++count);
            maxRepeatedCount = Math.max(maxRepeatedCount, count);
            if ((windowEnd - windowStart + 1 - maxRepeatedCount) > k) {
                char leftChar = arr[windowStart];
                Integer leftCount = uniqueChars.get(leftChar);
                uniqueChars.put(leftChar, --leftCount);
                windowStart++;
            }
            if ((end - start) < (windowEnd - windowStart)) {
                end = windowEnd;
                start = windowStart;
            }
        }
        char[] resultArr = Arrays.copyOfRange(arr, start, end + 1);
        System.out.println("Result size:" + resultArr.length + " arr:" + Arrays.toString(resultArr));
        return resultArr.length;
    }
}
