package com.opensource.dada.problems.pattern.subSets;

import java.util.List;

/**
 * Problem: https://www.geeksforgeeks.org/permute-string-changing-case/
 *          https://leetcode.com/problems/letter-case-permutation/
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
}
