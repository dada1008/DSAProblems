package com.opensource.dada.problems.leetcode;

/*
 *
 * [125] Valid Palindrome
 *
 * https://leetcode.com/problems/valid-palindrome/description/
 *
 * algorithms
 * Easy (41.04%)
 * Likes:    3522
 * Dislikes: 5117
 * Total Accepted:    1.2M
 * Total Submissions: 3M
 * Testcase Example:  '"A man, a plan, a canal: Panama"'
 *
 * A phrase is a palindrome if, after converting all uppercase letters into
 * lowercase letters and removing all non-alphanumeric characters, it reads the
 * same forward and backward. Alphanumeric characters include letters and
 * numbers.
 * 
 * Given a string s, return true if it is a palindrome, or false otherwise.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: s = "A man, a plan, a canal: Panama"
 * Output: true
 * Explanation: "amanaplanacanalpanama" is a palindrome.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "race a car"
 * Output: false
 * Explanation: "raceacar" is not a palindrome.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: s = " "
 * Output: true
 * Explanation: s is an empty string "" after removing non-alphanumeric
 * characters.
 * Since an empty string reads the same forward and backward, it is a
 * palindrome.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= s.length <= 2 * 10^5
 * s consists only of printable ASCII characters.
 * 
 * 
 */


class ValidPalindrome {
    public static void main(String[] args) {
        String input = "A man, a plan, a canal: Panama";
        boolean result = isPalindrome(input);
        System.out.println("Input: "+input+" Result:"+result);

        input = "race a car";
        result = isPalindrome(input);
        System.out.println("Input: "+input+" Result:"+result);

        input = " ";
        result = isPalindrome(input);
        System.out.println("Input: "+input+" Result:"+result);

    }
    public static boolean isPalindrome(String s) {
        int start = 0, end = s.length() -1;
        while(start<=end) {
            char startChar = s.charAt(start);
            char endChar = s.charAt(end);
            if(!Character.isAlphabetic(startChar)) {
                start++;
                continue;
            }
            if(!Character.isAlphabetic(endChar)) {
                end--;
                continue;
            }
            if(Character.isUpperCase(startChar)) {
                startChar = Character.toLowerCase(startChar);
            }
            if(Character.isUpperCase(endChar)) {
                endChar = Character.toLowerCase(endChar);
            }
            start++;
            end--;
            if(startChar != endChar) {
                return false;
            }
        }
        return true;
    }
}