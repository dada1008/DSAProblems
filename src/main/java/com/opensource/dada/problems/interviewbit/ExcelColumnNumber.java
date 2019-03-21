package com.opensource.dada.problems.interviewbit;

/**Problem:
 * Given a column title as appears in an Excel sheet, return its corresponding column number.
 *
 * Example:
 *
 *     A -> 1
 *
 *     B -> 2
 *
 *     C -> 3
 *
 *     ...
 *
 *     Z -> 26
 *
 *     AA -> 27
 *
 *     AB -> 28
 */
public class ExcelColumnNumber {
    public static void main(String[] args) {
        //System.out.println("Z -> expected: 26, actual:"+titleToNumber("Z"));

        System.out.println("AA -> expected: 27, actual:"+titleToNumber("AA"));
        System.out.println("AB -> expected: 28, actual:"+titleToNumber("AB"));
        System.out.println("AAA -> expected: 703, actual:"+titleToNumber("AAA"));
    }

    public static int titleToNumber(String A) {
        int result = 0;
        System.out.println("'A':"+((int)'A'));
        char[] chars = A.toCharArray();
        for (int i=0; i<chars.length; i++) {
            int val = chars[i]-'A' +1;
            result = (result*26) + val;
        }

        return result;
    }
}
