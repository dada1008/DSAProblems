package com.opensource.dada.problems;

import java.util.HashMap;
import java.util.Map;

public class LongestSubStringWithOutDuplication {
    public static void main(String[] args) {
        System.out.println("Result:"+findLongestSubStringWithOutDuplication("clementisacap"));
    }

    //Complexity time: O(n), space:O(min(n, a))
    static String findLongestSubStringWithOutDuplication(String str) {
        Map<Character, Integer> lastSeen = new HashMap<>();
        int[] longest = {0, 1};
        int startIndex = 0;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (lastSeen.containsKey(ch)) {
                startIndex = Math.max(startIndex, lastSeen.get(ch) +1);
            }
            if (longest[1] - longest[0] < i + 1 - startIndex) {
                longest = new int[]{startIndex, i + 1};
            }
            lastSeen.put(ch, i);
        }
        return str.substring(longest[0], longest[1]);
    }
}
