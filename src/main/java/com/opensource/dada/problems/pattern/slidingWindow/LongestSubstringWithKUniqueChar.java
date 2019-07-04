package com.opensource.dada.problems.pattern.slidingWindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Problem: https://www.geeksforgeeks.org/find-the-longest-substring-with-k-unique-characters-in-a-given-string/
 */
public class LongestSubstringWithKUniqueChar {
    public static void main(String[] args) {
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

}
