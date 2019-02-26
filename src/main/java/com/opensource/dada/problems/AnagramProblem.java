package com.opensource.dada.problems;

/** Problem: 1
 * Two strings,  and , are called anagrams if they contain all the same characters in the same frequencies. For example, the anagrams of CAT are CAT, ACT, TAC, TCA, ATC, and CTA.
 *
 * Complete the function in the editor. If  and  are case-insensitive anagrams, print "Anagrams"; otherwise, print "Not Anagrams" instead.
 *
 * Input Format
 *
 * The first line contains a string denoting .
 * The second line contains a string denoting .
 *
 * Constraints
 *
 * Strings  and  consist of English alphabetic characters.
 * The comparison should NOT be case sensitive.
 * Output Format
 *
 * Print "Anagrams" if  and  are case-insensitive anagrams of each other; otherwise, print "Not Anagrams" instead.
 *
 * Sample Input 0
 *
 * anagram
 * margana
 * Sample Output 0
 *
 * Anagrams
 * Explanation 0
 *
 * Character	Frequency: anagram	Frequency: margana
 * A or a	3	3
 * G or g	1	1
 * N or n	1	1
 * M or m	1	1
 * R or r	1	1
 * The two strings contain all the same letters in the same frequencies, so we print "Anagrams".
 *
 * Sample Input 1
 *
 * anagramm
 * marganaa
 * Sample Output 1
 *
 * Not Anagrams
 * Explanation 1
 *
 * Character	Frequency: anagramm	Frequency: marganaa
 * A or a	3	4
 * G or g	1	1
 * N or n	1	1
 * M or m	2	1
 * R or r	1	1
 * The two strings don't contain the same number of a's and m's, so we print "Not Anagrams".
 *
 * Sample Input 2
 *
 * Hello
 * hello
 * Sample Output 2
 *
 * Anagrams
 * Explanation 2
 *
 * Character	Frequency: Hello	Frequency: hello
 * E or e	1	1
 * H or h	1	1
 * L or l	2	2
 * O or o	1	1
 * The two strings contain all the same letters in the same frequencies, so we print "Anagrams".
 */

import java.util.*;

/** Problem: 2
 * Given an array of strings, find all anagram pairs in the given array.
 * Example:
 *
 * Input: arr[] =  {"geeksquiz", "geeksforgeeks", "abcd",
 *                  "forgeeksgeeks", "zuiqkeegs"};
 * Output: (geeksforgeeks, forgeeksgeeks), (geeksquiz, zuiqkeegs)
 */

/** Problem: 3
 * Two words are anagrams of one another if their letters can be rearranged to form the other word.
 *
 * In this challenge, you will be given a string. You must split it into two contiguous substrings,
 * then determine the minimum number of characters to change to make the two substrings into anagrams
 * of one another.
 *
 * For example, given the string 'abccde', you would break it into two parts: 'abc' and 'cde'.
 * Note that all letters have been used, the substrings are contiguous and their lengths are equal.
 * Now you can change 'a' and 'b' in the first substring to 'd' and 'e' to have 'dec' and 'cde'
 * which are anagrams. Two changes were necessary.
 */
public class AnagramProblem {

    public static void main(String[] args) {
        System.out.println("Welcome to Anagram problems:");

        System.out.println("1. "+isAnagram("anagram","margana"));
        System.out.println("2. "+isAnagram("saw","was"));
        System.out.println("3. "+isAnagram("cat","act"));
        System.out.println("4. "+isAnagram("anagramm","marganaa"));
        System.out.println("5. "+isAnagram("Hello","hello"));

        String arr[] =  {"geeksquiz", "geeksforgeeks", "abcd",
                "forgeeksgeeks", "zuiqkeegs"};
        findAllAnagramPair(arr);

        String[] anagramStr = {"aaabbb","ab","abc","mnop","xyyx","xaxbbbxx"};
        for (String str: anagramStr) {
            int count = anagram(str);
            System.out.println(str+":"+count);
        }
    }

    //Problem:1
    public static boolean isAnagram(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        s1 = s1.toLowerCase();
        s2 = s2.toLowerCase();

        int summ = 0;
        int [] temp = new int [26];
        //char 'a' value is 97, so if we minus 97 from char value it will give array index in between 0-25.
        for (int i = 0; i < s1.length(); i++){
            summ += ++temp [s1.charAt(i)-97] <= 0 ? -1 : 1;
            summ += --temp [s2.charAt(i)-97] >= 0 ? -1 : 1;
        }

        return summ == 0;
    }

    //Problem:2
    public static void findAllAnagramPair(String[] arr) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str: arr) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortStr = new String(charArray);
            List<String> anagramList = map.get(sortStr);
            if(anagramList==null) {
                anagramList = new ArrayList<>();
                map.put(sortStr,anagramList);
            }
            anagramList.add(str);
        }
        System.out.println("Print Anagram pair:"+map.values());
    }

    //Problem:3
    static int anagram(String s) {
        char[] charArr = s.toCharArray();
        if(charArr.length%2!=0) {
            return -1;
        }
        int mid = charArr.length/2;
        char[] charArr1 = Arrays.copyOfRange(charArr,0,mid);
        char[] charArr2 = Arrays.copyOfRange(charArr, mid, charArr.length);
        return anagramSol2(charArr1, charArr2);
    }

    private static int anagramSol1(char[] charArr1, char[] charArr2) {
        Arrays.sort(charArr1);
        Arrays.sort(charArr2);
        int changeCount = 0;
        for(int i=0; i<charArr1.length; i++) {
            if(charArr1[i]!=charArr2[i]) {
                changeCount++;
            }
        }
        return changeCount;
    }

    //better solution
    static int anagramSol2(char[] charArr1, char[] charArr2) {
            int count = 0;

            // store the count of character
            int char_count[] = new int[26];

            // iterate though the first String and update
            // count
            for (int i = 0; i < charArr1.length; i++)
                char_count[charArr1[i] - 'a']++;

            // iterate through the second string
            // update char_count.
            // if character is not found in char_count
            // then increase count
            for (int i = 0; i < charArr2.length; i++)
                if (char_count[charArr2[i] - 'a']-- <= 0)
                    count++;

            return count;
    }

    /** Problem: 4
     * Print a single integer denoting the minimum number of characters which must be deleted
     * to make the two strings anagrams of each other.
     *
     * Sample Input
     *
     * cde
     * abc
     * Sample Output
     *
     * 4
     * Explanation
     *
     * We delete the following characters from our two strings to turn them into anagrams of each other:
     *
     * Remove d and e from cde to get c.
     * Remove a and b from abc to get c.
     * We had to delete  characters to make both strings anagrams.
     */

    static int makingAnagrams(String s1, String s2) {
        char[] charArr1 = s1.toCharArray();
        char[] charArr2 = s2.toCharArray();

        int char_count1[] = new int[26];
        int char_count2[] = new int[26];

        for (int i = 0; i < charArr1.length; i++) {
            char_count1[charArr1[i] - 'a']++;
        }

        for (int i = 0; i < charArr2.length; i++) {
            char_count2[charArr2[i] - 'a']++;
        }

        int count = 0;
        for (int i = 0; i < 26; i++) {
            count += Math.abs(char_count1[i] -
                    char_count2[i]);
        }
        return count;
    }
}
