package com.opensource.dada.problems.pattern.slidingWindow;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Problem:
 * Given a string and a pattern, find the smallest substring in the given string
 * which has all the characters of the given pattern.
 *
 * Example 1:
 *
 * Input: String="aabdec", Pattern="abc"
 * Output: "abdec"
 * Explanation: The smallest substring having all characters of the pattern is "abdec"
 * Example 2:
 *
 * Input: String="abdabca", Pattern="abc"
 * Output: "abc"
 * Explanation: The smallest substring having all characters of the pattern is "abc".
 * Example 3:
 *
 * Input: String="adcad", Pattern="abc"
 * Output: ""
 * Explanation: No substring in the given string has all characters of the pattern.
 *
 * Solution #
 * This problem follows the Sliding Window pattern and has a lot of similarities with Permutation
 * in a String with one difference. In this problem, we need to find a substring having
 * all characters of the pattern which means that the required substring can have some
 * additional characters and doesn’t need to be a permutation of the pattern.
 * Here is how we will manage these differences:
 *
 * 1. We will keep a running count of every matching instance of a character.
 * 2. Whenever we have matched all the characters, we will try to shrink the window from the beginning,
 *    keeping track of the smallest substring that has all the matching characters.
 * 3. We will stop the shrinking process as soon as we remove a matched character from the sliding window.
 *    One thing to note here is that we could have redundant matching characters,
 *    e.g., we might have two ‘a’ in the sliding window when we only need one ‘a’.
 *    In that case, when we encounter the first ‘a’, we will simply shrink the window without
 *    decrementing the matched count. We will decrement the matched count when the second ‘a’
 *    goes out of the window.
 */
public class SmallestWindowContainingSubstring {
    public static void main(String[] args) {
        System.out.println("Result: "+ findSubString("aabdec", "abc"));//abdec
        System.out.println("Result: "+ findSubString("abdabca", "abc"));//abc
        System.out.println("Result: "+ findSubString("adcad", "abc"));//""
    }
    static String findSubString(String str, String pattern) {
        char[] strChars = str.toCharArray();
        char[] patternChars = pattern.toCharArray();
        if (strChars.length < patternChars.length) {
            return null;
        }
        Map<Character, Integer> charCountMap = new HashMap<>();
        for (int i = 0; i < patternChars.length; i++) {
            int count = charCountMap.getOrDefault(patternChars[i],0);
            charCountMap.put(patternChars[i],++count);
        }

        int windowStart =0, matched= 0, start = 0, minLength = str.length() + 1;
        for (int windowEnd = 0; windowEnd < strChars.length; windowEnd++) {
            char rightChar = strChars[windowEnd];
            if (charCountMap.containsKey(rightChar)) {
                int count = charCountMap.get(rightChar);
                charCountMap.put(rightChar, --count);
                if (count>=0) {
                    matched++;
                }
            }
            while (matched== patternChars.length) {
                if (minLength > windowEnd - windowStart + 1) {
                    minLength = windowEnd - windowStart + 1;
                    start = windowStart;
                }
                char leftChar = strChars[windowStart++];
                if (charCountMap.containsKey(leftChar)) {
                    int count = charCountMap.get(leftChar);
                    if (count == 0) {
                        matched--;
                    }
                    charCountMap.put(leftChar, ++count);
                }
            }
        }

        String result = "";
        if (minLength <= strChars.length) {
            result = str.substring(start, start + minLength);
        }
        return result;
    }
}
