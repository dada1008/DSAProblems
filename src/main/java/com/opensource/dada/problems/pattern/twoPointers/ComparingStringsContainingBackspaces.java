package com.opensource.dada.problems.pattern.twoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Problem:
 *
 * Given two strings containing backspaces (identified by the character ‘#’), check if the two strings are equal.
 *
 * Example 1:
 *
 * Input: str1="xy#z", str2="xzz#"
 * Output: true
 * Explanation: After applying backspaces the strings become "xz" and "xz" respectively.
 * Example 2:
 *
 * Input: str1="xy#z", str2="xyz#"
 * Output: false
 * Explanation: After applying backspaces the strings become "xz" and "xy" respectively.
 * Example 3:
 *
 * Input: str1="xp#", str2="xyz##"
 * Output: true
 * Explanation: After applying backspaces the strings become "x" and "x" respectively.
 * In "xyz##", the first '#' removes the character 'z' and the second '#' removes the character 'y'.
 * Example 4:
 *
 * Input: str1="xywrrmp", str2="xywrrmu#p"
 * Output: true
 * Explanation: After applying backspaces the strings become "xywrrmp" and "xywrrmp" respectively.
 */
public class ComparingStringsContainingBackspaces {
    public static void main(String[] args) {
        System.out.println("Result:"+compare("xy#z", "xzz#"));//true
        System.out.println("Result:"+compare("xy#z", "xyz#"));//false
        System.out.println("Result:"+compare("xp#", "xyz##"));//true
        System.out.println("Result:"+compare("xywrrmp", "xywrrmu#p"));//true
    }
    static boolean compare(String str1, String str2) {
        return compare2(str1, str2);
    }

    private static boolean compare1(String str1, String str2) {
        List<Character> str1Chars = convert(str1);
        List<Character> str2Chars = convert(str2);
        return str1Chars.equals(str2Chars);
    }

    static List<Character> convert(String str) {
        int hashCount = 0;
        List<Character> chars = new ArrayList<>();
        for (int i = str.length()-1; i>=0; i--) {
            char c = str.charAt(i);
            if (c=='#') {
                hashCount++;
            } else if (hashCount==0) {
                chars.add(c);
            } else {
                hashCount--;
            }
        }
        //Collections.reverse(chars);
        return chars;
    }

    //This is better than compare1 as it happens in single pass using 2 pointers
    private static boolean compare2(String str1, String str2) {
        int index1 = str1.length() -1, index2 = str2.length()-1;
        while (index1>=0 && index2>=0) {
            index1 = getValidIndex(str1, index1);
            index2 = getValidIndex(str2, index2);
            if (index1 <0 || index2 <0 || str1.charAt(index1)!=str2.charAt(index2)) {
                return false;
            }
            index1--;
            index2--;
        }
        return true;
    }

    static int getValidIndex(String str, int index) {
        int hashCount = 0;
        while (index >=0) {
            char c = str.charAt(index);
            if (c=='#') {
                hashCount++;
            } else if (hashCount>0) {
                hashCount--;
            } else {
                break;
            }
            index--;
        }
        return index;
    }
}
