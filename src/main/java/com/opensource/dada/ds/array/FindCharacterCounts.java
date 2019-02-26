package com.opensource.dada.ds.array;

import java.util.HashSet;
import java.util.Set;

/** Problem:
 *Given a string of lowercase ASCII characters, find all distinct continuous palindromic sub-strings of it.
 * Examples:
 *
 * Input: str = "abaaa"
 * Output:  Below are 5 palindrome sub-strings
 * a
 * aa
 * aaa
 * aba
 * b
 *
 *
 * Input: str = "geek"
 * Output:  Below are 4 palindrome sub-strings
 * e
 * ee
 * g
 * k
 */
public class FindCharacterCounts {

    public static void main(String[] args) {
        findCharCounts("google");
        findCharCounts("abaaa");
        findCharCounts("geek");
    }

    public static void findCharCounts(String input) {
        withOutHashMap(input);
    }

    static final int MAX_CHAR = 256;
    private static void withOutHashMap(String str) {
        // Create an array of size 256 i.e. ASCII_SIZE
        int count[] = new int[MAX_CHAR];

        int len = str.length();

        // Initialize count array index
        for (int i = 0; i < len; i++)
            count[str.charAt(i)]++;

        // Create an array of given String size
        char ch[] = new char[str.length()];
        for (int i = 0; i < len; i++) {
            ch[i] = str.charAt(i);
            int find = 0;
            for (int j = 0; j <= i; j++) {

                // If any matches found
                if (str.charAt(i) == ch[j])
                    find++;
            }

            if (find == 1)
                System.out.println("Number of Occurrence of " +
                        str.charAt(i) + " is:" + count[str.charAt(i)]);
        }
    }

}
