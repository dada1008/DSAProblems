package com.opensource.dada.problems.pattern.slidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Problem:
 * Given a string and a pattern, find all anagrams of the pattern in the given string.
 *
 * Anagram is actually a Permutation of a string. For example, “abc” has the following six anagrams:
 * 1. abc
 * 2. acb
 * 3. bac
 * 4. bca
 * 5. cab
 * 6. cba
 * Write a function to return a list of starting indices of the anagrams of the pattern in the given string.
 *
 * Example 1:
 * Input: String="ppqp", Pattern="pq"
 * Output: [1, 2]
 * Explanation: The two anagrams of the pattern in the given string are "pq" and "qp".
 *
 * Example 2:
 * Input: String="abbcabc", Pattern="abc"
 * Output: [2, 3, 4]
 * Explanation: The three anagrams of the pattern in the given string are "bca", "cab", and "abc".
 */
public class StringAnagrams {
    public static void main(String[] args) {
        System.out.println("Result:"+findStringAnagrams("ppqp", "pq"));
        System.out.println("Result:"+findStringAnagrams("abbcabc", "abc"));
    }

    public static List<Integer> findStringAnagrams(String str, String pattern) {
        List<Integer> resultIndices = new ArrayList<>();
        char[] strChars = str.toCharArray();
        char[] patternChars = pattern.toCharArray();
        if (strChars.length < patternChars.length) {
            return List.of();
        }
        Map<Character, Integer> charCountMap = new HashMap<>();
        for (int i = 0; i < patternChars.length; i++) {
            int count = charCountMap.getOrDefault(patternChars[i],0);
            charCountMap.put(patternChars[i],++count);
        }

        int windowStart =0, matched= 0;
        for (int windowEnd = 0; windowEnd < strChars.length; windowEnd++) {
            char rightChar = strChars[windowEnd];
            if (charCountMap.containsKey(rightChar)) {
                int count = charCountMap.get(rightChar);
                charCountMap.put(rightChar, --count);
                if (count==0) {
                    matched++;
                }
            }
            if (matched==charCountMap.size()) {
                resultIndices.add(windowStart);
            }
            if (windowEnd >= patternChars.length -1) {
                char leftChar = strChars[windowStart++];
                if (charCountMap.containsKey(leftChar)) {
                    int count = charCountMap.get(leftChar);
                    if (count==0) {
                        matched--;
                    }
                    charCountMap.put(leftChar, ++count);
                }
            }
        }
        return resultIndices;
    }
}
