package com.opensource.dada.problems.pattern.twoPointers;

/**
 * Problem: https://leetcode.com/articles/backspace-string-compare/
 */
public class BackspaceStringCompare {
    public static void main(String[] args) {

        test1();
        test2();
        test3();
        test4();
    }

    static void test1() {
        /**
         * Input: S = "ab#c", T = "ad#c"
         * Output: true
         * Explanation: Both S and T become "ac".
         */
        String str1 = "ab#c";
        String str2 = "ad#c";
        System.out.println("Input str1: "+str1+" str2: "+str2+" output:"+backspaceStringCompare(str1, str2));
    }
    static void test2() {
        /**
         * Input: S = "ab##", T = "c#d#"
         * Output: true
         * Explanation: Both S and T become "".
         */
        String str1 = "ab##";
        String str2 = "c#d#";
        System.out.println("Input str1: "+str1+" str2: "+str2+" output:"+backspaceStringCompare(str1, str2));
    }
    static void test3() {
        /**
         * Input: S = "a##c", T = "#a#c"
         * Output: true
         * Explanation: Both S and T become "c".
         */
        String str1 = "a##c";
        String str2 = "#a#c";
        System.out.println("Input str1: "+str1+" str2: "+str2+" output:"+backspaceStringCompare(str1, str2));
    }
    static void test4() {
        /**
         * Input: S = "a#c", T = "b"
         * Output: false
         * Explanation: S becomes "c" while T becomes "b".
         */
        String str1 = "a#c";
        String str2 = "b";
        System.out.println("Input str1: "+str1+" str2: "+str2+" output:"+backspaceStringCompare(str1, str2));
    }

    static boolean backspaceStringCompare(String str1, String str2) {
        int i=str1.length()-1, j=str2.length()-1;
        int skip1=0, skip2=0;
        while ( i >=0 || j >=0) {
            // Find position of next possible char in str1
            i = nextNonSkipChar(str1, i);

            // Find position of next possible char in str2
            j = nextNonSkipChar(str2, j);

            // If two actual characters are different
            if (i >= 0 && j >= 0 && str1.charAt(i)!=str2.charAt(j)) {
                return false;
            }
            // If expecting to compare char vs nothing
            if ((i >= 0) != (j >= 0)) {
                return false;
            }
            i--;
            j--;
        }

        return true;
    }

    static int nextNonSkipChar(String str, int s) {
        int skip = 0;
        while (s >= 0) {
            // if current char is #, we need to skip next character
            if (str.charAt(s) == '#') {
                skip++;
                s--;
            }
            // if current character is not #, but we still have some characters
            // need to be skipped
            else if (skip > 0) {
                skip--;
                s--;
            }
            // in case this is the character we cannot skip
            else break;
        }
        return s;
    }

}
