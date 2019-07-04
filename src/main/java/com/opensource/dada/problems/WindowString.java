package com.opensource.dada.problems;

import java.util.HashMap;
import java.util.Map;

/** Problem:
 * Given a string S and a string T,
 * find the minimum window in S which will contain all the characters in T in linear time complexity.
 * Note that when the count of a character C in T is N,
 * then the count of C in minimum window in S should be at least N.
 *
 * Example :
 *
 * S = "ADOBECODEBANC"
 * T = "ABC"
 * Minimum window is "BANC"
 *
 * Note:
 * If there is no such window in S that covers all characters in T, return the empty string ''.
 * If there are multiple such windows, return the first occurring minimum window ( with minimum start index ).
 */
public class WindowString {

    public static void main(String[] args) {
        test1();
    }

    static void test1(){
        System.out.println("Result:"+minWindow("aa", "aa"));
    }
    public static String minWindow(String S, String T) {
        char s1[] = S.toCharArray();
        char s2[] = T.toCharArray();
        int countS2[] = new int[256];
        for (int i = 0; i < s2.length; i++)
            countS2[s2[i]]++;

        int countS1[] = new int[256];
        int start = 0;
        int count = 0;
        int maxEnd = 0;
        int maxStart = 0;
        int minLength = Integer.MAX_VALUE;
        boolean found = false;
        for (int end = 0; end < s1.length; end++) {
            char x = s1[end];

            if (countS1[x] < countS2[x])
                count++;

            countS1[x]++;

            if (count == s2.length)
                found = true;

            while (count == s2.length && countS1[s1[start]] > countS2[s1[start]]) {

                countS1[s1[start]]--;
                start++;
                if (end - start + 1 < minLength) {
                    maxEnd = end;
                    maxStart = start;
                    minLength = end - start + 1;
                }

            }
        }
        if (found)
            return S.substring(maxStart, maxEnd + 1);

        return "";
        /*System.out.println(start+" "+maxEnd);*/
    }

    //More accurate method
    public String minWindow2(String s, String t) {

        if (s.length() == 0 || t.length() == 0) {
            return "";
        }

        // Dictionary which keeps a count of all the unique characters in t.
        Map<Character, Integer> dictT = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            int count = dictT.getOrDefault(t.charAt(i), 0);
            dictT.put(t.charAt(i), count + 1);
        }

        // Number of unique characters in t, which need to be present in the desired window.
        int required = dictT.size();

        // Left and Right pointer
        int l = 0, r = 0;

        // formed is used to keep track of how many unique characters in t
        // are present in the current window in its desired frequency.
        // e.g. if t is "AABC" then the window must have two A's, one B and one C.
        // Thus formed would be = 3 when all these conditions are met.
        int formed = 0;

        // Dictionary which keeps a count of all the unique characters in the current window.
        Map<Character, Integer> windowCounts = new HashMap<>();

        // ans list of the form (window length, left, right)
        int[] ans = {-1, 0, 0};

        while (r < s.length()) {
            // Add one character from the right to the window
            char c = s.charAt(r);
            int count = windowCounts.getOrDefault(c, 0);
            windowCounts.put(c, count + 1);

            // If the frequency of the current character added equals to the
            // desired count in t then increment the formed count by 1.
            if (dictT.containsKey(c) && windowCounts.get(c).intValue() == dictT.get(c).intValue()) {
                formed++;
            }

            // Try and contract the window till the point where it ceases to be 'desirable'.
            while (l <= r && formed == required) {
                c = s.charAt(l);
                // Save the smallest window until now.
                if (ans[0] == -1 || r - l + 1 < ans[0]) {
                    ans[0] = r - l + 1;
                    ans[1] = l;
                    ans[2] = r;
                }

                // The character at the position pointed by the
                // `Left` pointer is no longer a part of the window.
                windowCounts.put(c, windowCounts.get(c) - 1);
                if (dictT.containsKey(c) && windowCounts.get(c).intValue() < dictT.get(c).intValue()) {
                    formed--;
                }

                // Move the left pointer ahead, this would help to look for a new window.
                l++;
            }

            // Keep expanding the window once we are done contracting.
            r++;
        }

        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
    }
}
