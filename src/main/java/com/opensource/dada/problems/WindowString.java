package com.opensource.dada.problems;

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

    }

    public String minWindow(String S, String T) {
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
}
