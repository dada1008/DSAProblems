package com.opensource.dada.problems.hackerrank;

/**
 * Joseph and Jane are making a contest for apes. During the process,
 * they have to communicate frequently with each other.
 * Since they are not completely human, they cannot speak properly.
 * They have to transfer messages using postcards of small sizes.
 * To save space on the small postcards, they devise a string compression algorithm:
 *
 * If a character, , occurs  times in a row, then it will be represented by ,
 * where  is the value of . For example, if the substring is a sequence of  'a' ("aaaa"),
 * it will be represented as "a4".
 *
 * If a character, , occurs exactly one time in a row, then it will be simply represented as .
 * For example, if the substring is "a", then it will be represented as "a".
 *
 * Help Joseph to compress a message, msg.
 *
 * Input
 *
 * The only line of input contains a string, msg.
 *
 * Output
 *
 * Print the string msg as a compressed message.
 *
 * Constraints
 *
 * msg consists of lowercase English characters () only.
 * Sample Input #00
 *
 * abcaaabbb
 * Sample Output #00
 *
 * abca3b3
 * Sample Input #01
 *
 * abcd
 * Sample Output #01
 *
 * abcd
 * Sample Input #02
 *
 * aaabaaaaccaaaaba
 * Sample Output #02
 *
 * a3ba4c2a4ba
 * Explanation
 * Sample Case #00: msg = "". Here, the first  characters occur exactly once,
 * and the rest of them occur  times in a sequence.
 *
 * Sample Case #01: msg = "". As there is no multiple consecutive occurrence of any character,
 * the compressed message will be same as original one.
 *
 * Sample Case #02: msg = "". In the first 3 occurrences, 'a' is repeated  times,
 * while in the last occurrence, there is only one 'a'. Also,'c' occurs two times,
 * and 'b' occurs one time in both occurrences.
 */
public class StringCompression {
    public static void main(String[] args) {
        compress("abcaaabbb");//abca3b3
        compress("abcd");//abcd
        compress("aaabaaaaccaaaaba");//a3ba4c2a4ba
        compress("BABABA");//BABABA
        compress("AAABBB");//A3B3
    }

    static String compress(String s) {
        if (s==null || s.isEmpty()) {
            return s;
        }

        StringBuilder alteredString = new StringBuilder();
        char[] chars = s.toCharArray();
        char lastChar = '1';
        int count = 0;
        for (int i=0; i< chars.length; i++) {
            if(chars[i]==lastChar){
                count++;
            } else {
                if(count>1) {
                    alteredString.append(count);
                }
                alteredString.append(chars[i]);
                count=1;
            }
            lastChar = chars[i];
        }
        if(count>1) {
            alteredString.append(count);
        }
        System.out.println("String:'"+s+"' compressed String:"+alteredString);

        return alteredString.toString();
    }
}
