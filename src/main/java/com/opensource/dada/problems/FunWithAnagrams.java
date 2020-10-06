package com.opensource.dada.problems;

import com.opensource.dada.ds.list.LinkedListNode;

import java.math.BigInteger;
import java.util.*;

/**
 * Problem:
 * https://fizzbuzzer.com/2353-2/
 *
 * Fun with Anagrams
 * Given an array of strings, remove each string that is an anagram of an earlier string,
 * then return the remaining array in sorted order.
 *
 * Example
 * str = ['code', 'doce', 'ecod', 'framer', 'frame']
 *
 * code and doce are anagrams. Remove doce from the array and keep the first occurrence code in the array.
 * code and ecod are anagrams. Remove ecod from the array and keep the first occurrence code in the array.
 * code and framer are not anagrams. Keep both strings in the array.
 * framer and frame are not anagrams due to the extra r in framer. Keep both strings in the array.
 * Order the remaining strings in ascending order: ['code','frame','framer'].
 *
 */

public class FunWithAnagrams {
    public static void main(String[] args) {

        List<String> input = new ArrayList<>(List.of("code", "edoc", "doce", "framer", "frame"));
        List<String> result = funWithAnagrams(input);
        System.out.println("Result:"+result);//code, framer, frame
    }

    /*
     * Complete the 'funWithAnagrams' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts STRING_ARRAY text as parameter.
     */

    public static List<String> funWithAnagrams(List<String> text) {
        if (text == null || text.isEmpty() || text.size() == 1) {
            return text;
        }
        Set<Integer> removeIndexs = new LinkedHashSet<>();
        for (int i = 0; i < text.size(); i++) {
            String s1 = text.get(i);
            for (int j = i + 1; j < text.size(); j++) {
                String s2 = text.get(j);
                if (isAnagram(s1, s2)) {
                    removeIndexs.add(j);
                }
            }
        }
        for (int i = text.size() - 1; i >= 0; i--) {
            if (removeIndexs.contains(i)) {
                text.remove(i);
            }
        }
        Collections.sort(text);
        return text;
    }

    public static boolean isAnagram(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        s1 = s1.toLowerCase();
        s2 = s2.toLowerCase();
        int summ = 0;
        int[] temp = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            summ += ++temp[s1.charAt(i) - 'a'] <= 0 ? -1 : 1;
            summ += --temp[s2.charAt(i) - 'a'] >= 0 ? -1 : 1;
        }
        return summ == 0;
    }
}
