package com.opensource.dada.problems.hackerrank;

/**
 * You are given a string containing characters  and  only.
 * Your task is to change it into a string such that there are no matching adjacent characters.
 * To do this, you are allowed to delete zero or more characters in the string.
 *
 * Your task is to find the minimum number of required deletions.
 *
 * For example, given the string , remove an  at positions  and  to make  in  deletions.
 *
 * Function Description
 *
 * Complete the alternatingCharacters function in the editor below.
 * It must return an integer representing the minimum number of deletions to make the alternating string.
 *
 * alternatingCharacters has the following parameter(s):
 *
 * s: a string
 * Input Format
 *
 * The first line contains an integer , the number of queries.
 * The next  lines each contain a string .
 *
 * Constraints
 *
 * Each string  will consist only of characters  and
 * Output Format
 *
 * For each query, print the minimum number of deletions required on a new line.
 *
 * Sample Input
 *
 * 5
 * AAAA
 * BBBBB
 * ABABABAB
 * BABABA
 * AAABBB
 * Sample Output
 *
 * 3
 * 4
 * 0
 * 0
 * 4
 * Explanation
 *
 * The characters marked red are the ones that can be deleted so that
 * the string doesn't have matching consecutive characters.
 *
 */
public class AlternatingCharacters {
    public static void main(String[] args) {
        alternatingCharacters("AAAA");//3
        alternatingCharacters("BBBBB");//4
        alternatingCharacters("ABABABAB");//0
        alternatingCharacters("BABABA");//0
        alternatingCharacters("AAABBB");//4
    }

    static int alternatingCharacters(String s) {
        if (s==null || s.isEmpty()) {
            return 0;
        }
        int noOfRemoval = 0;
        StringBuilder alteredString = new StringBuilder();
        char[] chars = s.toCharArray();
        char lastChar = '1';
        for (int i=0; i< chars.length; i++) {
            if(chars[i]==lastChar){
                noOfRemoval++;
            } else {
                alteredString.append(chars[i]);
            }
            lastChar = chars[i];
        }

        System.out.println("String:["+s+"] "+noOfRemoval+" deletions altered String:"+alteredString);
        return noOfRemoval;
    }
}
