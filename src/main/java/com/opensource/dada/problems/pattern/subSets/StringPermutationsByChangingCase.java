package com.opensource.dada.problems.pattern.subSets;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem: https://www.geeksforgeeks.org/permute-string-changing-case/
 *          https://leetcode.com/problems/letter-case-permutation/
 *
 * Given a string, find all of its permutations preserving the character sequence but changing case.
 *
 * Example 1:
 *
 * Input: "ad52"
 * Output: "ad52", "Ad52", "aD52", "AD52"
 * Example 2:
 *
 * Input: "ab7c"
 * Output: "ab7c", "Ab7c", "aB7c", "AB7c", "ab7C", "Ab7C", "aB7C", "AB7C"
 */
public class StringPermutationsByChangingCase {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
    }
    public static void test1() {
        permute("ABC");
    }

    public static void test2() {
        permute("a1b2");//["a1b2", "a1B2", "A1b2", "A1B2"]
    }

    public static void test3() {
        permute("3z4");//["3z4", "3Z4"]
    }

    public static void test4() {
        permute("12345");//["12345"]
    }

    // Function to generate permutations
    static void permute(String input)
    {
        letterCasePermutationHelper(input.toCharArray(), 0);
        System.out.println("");
    }

    static void letterCasePermutationHelper(char[] chars, int index) {
        if (index == chars.length) {
            System.out.print(new String(chars));
            System.out.print(" ");
        }
        else {
            if (Character.isLetter(chars[index])) {
                chars[index] = Character.toLowerCase(chars[index]);
                letterCasePermutationHelper(chars, index+1);
                chars[index] = Character.toUpperCase(chars[index]);
            }

            letterCasePermutationHelper(chars, index+1);
        }
    }

    static List<String>  findLetterCaseStringPermutations(String str) {
        List<String> permutations = new ArrayList<>();
        if (str==null || str.isEmpty()) {
            return permutations;
        }

        permutations.add(str);
        // process every character of the string one by on
        for (int i = 0; i < str.length(); i++) {
            // only process characters, skip digits
            if (Character.isLetter(str.charAt(i))) {
                // we will take all existing permutations and change the letter case appropriately
                int n = permutations.size();
                for (int j = 0; j < n; j++) {
                    char[] chars = permutations.get(j).toCharArray();
                    // if the current character is in upper case change it to lower case or vice versa
                    if (Character.isUpperCase(chars[i])) {
                        chars[i] = Character.toLowerCase(chars[i]);
                    } else {
                        chars[i] = Character.toUpperCase(chars[i]);
                    }
                    permutations.add(String.valueOf(chars));
                }
            }
        }
        return permutations;
    }
}
