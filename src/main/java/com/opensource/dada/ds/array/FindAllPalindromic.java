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
public class FindAllPalindromic {

    public static void main(String[] args) {
        findAllPalindrome("google");
        findAllPalindrome("abaaa");
        findAllPalindrome("geek");
    }

    private static void findAllPalindrome(String input) {
        Set<String> set = new HashSet<>();
        for(int i=0;i<input.length();i++) {
            //Find all odd length palindrome with input[i] as mid point
            expand(input,i,i,set);

            //Find all even length palindrome with input[i] and input[i+1] as mid point
            expand(input,i,i+1,set);
        }
        System.out.println("Palindrome set:"+set);
    }

    private static void expand(String input, int low, int high, Set<String> set) {
        while ((low>=0) && (high<input.length()) && (input.charAt(low)==input.charAt(high))) {
            // push all palindromes into the set
            set.add(input.substring(low, high+1));
            // expand in both directions
            low--;
            high++;
        }
    }

}
