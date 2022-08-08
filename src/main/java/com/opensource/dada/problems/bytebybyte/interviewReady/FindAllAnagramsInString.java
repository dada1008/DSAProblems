package com.opensource.dada.problems.bytebybyte.interviewReady;

import com.opensource.dada.problems.pattern.slidingWindow.StringAnagrams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Problem: https://leetcode.com/problems/find-all-anagrams-in-a-string/
 * <p>
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
 * <p>
 * Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.
 * <p>
 * The order of output does not matter.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * s: "cbaebabacd" p: "abc"
 * <p>
 * Output:
 * [0, 6]
 * <p>
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".
 * Example 2:
 * <p>
 * Input:
 * s: "abab" p: "ab"
 * <p>
 * Output:
 * [0, 1, 2]
 * <p>
 * Explanation:
 * The substring with start index = 0 is "ab", which is an anagram of "ab".
 * The substring with start index = 1 is "ba", which is an anagram of "ab".
 * The substring with start index = 2 is "ab", which is an anagram of "ab".
 */
public class FindAllAnagramsInString {
    public static void main(String[] args) {
        System.out.println(findAnagrams("cbaebabacd", "abc"));//[0, 6]
        System.out.println(findAnagrams("abab", "ab"));//[0, 1, 2]
    }

    public static List<Integer> findAnagrams(String s, String p) {
        return findAnagrams1(s, p);
    }

    //My 1st attempt
    public static List<Integer> findAnagrams1(String s, String p) {
        List<Integer> result = new ArrayList<>();
        Map<Character, Integer> pMap = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            Integer count = pMap.getOrDefault(c, 0);
            pMap.put(c, count + 1);
        }

        int start = 0;
        while (start < s.length() - p.length() + 1) {
            char c = s.charAt(start);
            if (pMap.containsKey(c) && isAnagram(s, start, start + p.length(), pMap)) {
                result.add(start);
            }
            start++;
        }
        return result;
    }

    public static boolean isAnagram(String s, int start, int end, Map<Character, Integer> pMap) {
        Map<Character, Integer> map = new HashMap<>(pMap);
        for (int i = start; i < end; i++) {
            char c = s.charAt(i);
            int count = map.getOrDefault(c, 0);
            if (count <= 0) {
                return false;
            }
            map.put(c, count - 1);
        }
        return true;
    }

    //Optimized solution
    public static List<Integer> findAnagrams2(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if (s == null || s.length() == 0 || p == null || p.length() == 0) {
            return list;
        }
        // Character hash.
        int[] hash = new int[256];
        // Record each character in "p" to a hash.
        for (char c : p.toCharArray()) {
            hash[c]++;
        }
        // Initialize count to "p"'s length.
        int left = 0, right = 0, count = p.length();
        while (right < s.length()) {
        // Move right each time if the character exists in p's hash
        // Decrease the count current hash value greater than 1
        // means the character exists in p.
            if (hash[s.charAt(right++)]-- >= 1) {
                count--;
            }
        // When the count is zero, this means we found the
        // right anagram. Add window's left to result list.
            if (count == 0) {
                list.add(left);
            }
            if (right - left == p.length() && hash[s.charAt(left++)]++ >= 0) {
                count++;
            }
        }
        return list;
    }

    public static List<Integer> findAnagrams3(String s, String p) {
        return StringAnagrams.findStringAnagrams(s, p);
    }


}
