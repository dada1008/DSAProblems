package com.opensource.dada.problems.pattern.slidingWindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Problem: https://www.geeksforgeeks.org/find-the-longest-substring-with-k-unique-characters-in-a-given-string/
 *
 * Given a string, find the length of the longest substring in it with no more than K distinct characters.
 *
 * Example 1:
 *
 * Input: String="araaci", K=2
 * Output: 4
 * Explanation: The longest substring with no more than '2' distinct characters is "araa".
 * Example 2:
 *
 * Input: String="araaci", K=1
 * Output: 2
 * Explanation: The longest substring with no more than '1' distinct characters is "aa".
 * Example 3:
 *
 * Input: String="cbbebi", K=3
 * Output: 5
 * Explanation: The longest substrings with no more than '3' distinct characters are "cbbeb" & "bbebi".
 */
public class LongestSubstringWithKUniqueChar {
    public static void main(String[] args) {
        test1();
        test2();
    }

    public static void test1() {
        String input = null;
        String output = null;
        int k = 0;

        input = "aabbcc";
        k = 1;
        output = findLongestSubStringWithKUniqueCharactors(input, k);//aa
        System.out.println("Input:"+input+" output:"+output);

        input = "aabbcc";
        k = 2;
        output = findLongestSubStringWithKUniqueCharactors(input, k);//aabb
        System.out.println("Input:"+input+" output:"+output);

        input = "aabbcc";
        k = 3;
        output = findLongestSubStringWithKUniqueCharactors(input, k);//aabbcc
        System.out.println("Input:"+input+" output:"+output);

        input = "aaabbb";
        k = 3;
        output = findLongestSubStringWithKUniqueCharactors(input, k);
        System.out.println("Input:"+input+" output:"+output);
    }

    public static void test2() {
        String input = null;
        String output = null;
        int k = 0;

        input = "aabbcc";
        k = 1;
        output = findLongestSubStringWithKDistinctChars(input, k);//aa
        System.out.println("Input:"+input+" output:"+output);

        input = "aabbcc";
        k = 2;
        output = findLongestSubStringWithKDistinctChars(input, k);//aabb
        System.out.println("Input:"+input+" output:"+output);

        input = "aabbcc";
        k = 3;
        output = findLongestSubStringWithKDistinctChars(input, k);//aabbcc
        System.out.println("Input:"+input+" output:"+output);

        input = "aaabbb";
        k = 3;
        output = findLongestSubStringWithKDistinctChars(input, k);
        System.out.println("Input:"+input+" output:"+output);

        input = "araaci";
        k = 2;
        output = findLongestSubStringWithKDistinctChars(input, k);
        System.out.println("Input:"+input+" output:"+output);

        input = "araaci";
        k = 1;
        output = findLongestSubStringWithKDistinctChars(input, k);
        System.out.println("Input:"+input+" output:"+output);

        input = "cbbebi";
        k = 3;
        output = findLongestSubStringWithKDistinctChars(input, k);
        System.out.println("Input:"+input+" output:"+output);
    }

    static String findLongestSubStringWithKUniqueCharactors(String input, int k) {
        int uniqueCount = 0;
        int left =0, right = 0, start=0, end=0;
        Set<Character> uniqueChars = new HashSet<>();
        int[] count = new int[26];
        while(right<input.length()) {
            char c = input.charAt(right);
            if(uniqueChars.add(c)) {
                count[c-'a']=1;
            } else {
                count[c-'a']++;
            }
            right++;
            while(uniqueChars.size()>k) {
                c = input.charAt(left);
                count[c-'a']--;
                if(count[c-'a']==0) {
                    uniqueChars.remove(c);
                }
                left++;
            }
            if(end - start < right - left) {
                start = left;
                end = right;
            }
        }
        if (uniqueChars.size()<k) {
            System.out.print("Not enough unique characters: ");
            return null;
        }
        return input.substring(start,end);
    }
    // rewritten just for practice
    static String findLongestSubStringWithKDistinctChars(String input, int k) {

        int start =0, end = 0, windowStart = 0;
        Map<Character, Integer> uniqueMap = new HashMap<>();
        for (int windowEnd = 0; windowEnd < input.length(); windowEnd++) {
            char c = input.charAt(windowEnd);
            Integer count = uniqueMap.get(c);
            if (count==null || count==0) {
                count = 0;
            }
            uniqueMap.put(c,++count);
            while (uniqueMap.size() >k) {
                char ch = input.charAt(windowStart);
                Integer count2 = uniqueMap.get(ch);
                count2--;
                uniqueMap.put(ch,count2);
                if (count2==0) {
                    uniqueMap.remove(ch);
                }
                windowStart++;
            }
            if ((end - start) < ((windowEnd - windowStart))) {
                end = windowEnd;
                start = windowStart;
            }
        }
        if (uniqueMap.size()<k) {
            System.out.print("Not enough unique characters: ");
            return null;
        }
        return input.substring(start, end+1);
    }

}
