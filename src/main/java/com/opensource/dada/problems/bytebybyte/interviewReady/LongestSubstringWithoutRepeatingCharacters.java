package com.opensource.dada.problems.bytebybyte.interviewReady;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem: https://leetcode.com/problems/longest-substring-without-repeating-characters/
 *
 * Given a string s, find the length of the longest substring without repeating characters.
 *
 * Example 1:
 *
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 *
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 *
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * Example 4:
 *
 * Input: s = ""
 * Output: 0
 *
 * Constraints:
 *
 * 0 <= s.length <= 5 * 104
 * s consists of English letters, digits, symbols and spaces.
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));//3
        System.out.println(lengthOfLongestSubstring("bbbbb"));//1
        System.out.println(lengthOfLongestSubstring("pwwkew"));//3
        System.out.println(lengthOfLongestSubstring(""));//0
        System.out.println(lengthOfLongestSubstring(" "));//1
        System.out.println(lengthOfLongestSubstring("au"));//2
    }

    public static int lengthOfLongestSubstring(String s) {
        //return lengthOfLongestSubstring1(s);
        return lengthOfLongestSubstring2(s);
    }
    //My 1st attempt
    public static int lengthOfLongestSubstring1(String s) {
        if(s==null) {
            return 0;
        }
        Map<Character, Integer> char2LastIdx = new HashMap<>();
        int startIdx = 0;
        int maxEndIdx = s.length();
        int maxStartIdx = 0;
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int tempLength = i - startIdx;
            if (tempLength > maxLength) {
                maxLength = tempLength;
                maxStartIdx = startIdx;
                maxEndIdx = i;
            }
            if(char2LastIdx.containsKey(c)) {
                startIdx = i;
            } else {
                char2LastIdx.put(c,i);
            }
        }
        System.out.println("Max length str:"+s.substring(maxStartIdx,maxEndIdx));
        return maxEndIdx - maxStartIdx;
    }

    //Optimized solution
    public static int lengthOfLongestSubstring2(String s) {
        int maxLength = 0, start = 0;
        int maxEndIdx = s.length();
        int maxStartIdx = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0; j < s.length(); j++) {
            if (map.containsKey(s.charAt(j))) {
                start = Math.max(map.get(s.charAt(j)), start);
            }
            int tempLength = j + 1 - start;
            if (tempLength > maxLength) {
                maxLength = tempLength;
                maxStartIdx = start;
                maxEndIdx = j + 1;
            }
            map.put(s.charAt(j), j + 1);
        }
        System.out.println("Max length str:"+s.substring(maxStartIdx,maxEndIdx));
        return maxLength;
    }
}
