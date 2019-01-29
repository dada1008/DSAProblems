package com.opensource.dada.ds.hash;

import java.util.*;

/** Problem:
 * You are given a string, S, and a list of words, L, that are all of the same length.
 *
 * Find all starting indices of substring(s) in S that is a concatenation of each word in L
 * exactly once and without any intervening characters.
 *
 * Example :
 *
 * S: "barfoothefoobarman"
 * L: ["foo", "bar"]
 * You should return the indices: [0,9].
 * (order does not matter).
 */
public class SubstringConcatenationWithWordList {
    public static void main(String[] args) {
        String s = "barfoothefoobarman";
        List<String> list = Arrays.asList("foo", "bar");
        ArrayList<Integer> res = findSubstring(s, list);
        System.out.println("1. Result: "+res);
        //Output : 0 9

        s = "catbatatecatatebat";
        list = Arrays.asList("cat", "ate", "bat");
        res = findSubstring(s, list);
        System.out.println("2. Result: "+res);
        //Output : 0 3 9

        s = "abcdababcd";
        list = Arrays.asList("ab", "ab", "cd");
        res = findSubstring(s, list);
        System.out.println("3. Result: "+res);
        //Output : 0 2 4

        s = "abcdababcd";
        list = Arrays.asList("ab", "ab");
        res = findSubstring(s, list);
        System.out.println("4. Result: "+res);
        //Output : 4
    }

    public static ArrayList<Integer> findSubstring(String A, final List<String> B) {
        ArrayList<Integer> res = new ArrayList<>();
        int totalStringListCharCount = 0;
        for(String s: B) {
            totalStringListCharCount += s.length();
        }

        int left = 0, right = totalStringListCharCount;
        boolean found = false;
        int currentStrIndex = 0;
        while (right <= A.length()) {
            //Set<String> set = new HashSet<>(B);
            String currentStr = A.substring(left,right);
            int count = B.size();
            for(String s: B) {
                if(currentStr.contains(s)) {
                    currentStr = currentStr.replaceFirst(s,"_");
                    count--;
                    //set.remove(s);
                } else {
                    break;
                }
            }
            if(count==0) {
                res.add(left);
            }
            left++;
            right++;
        }
        return res;
    }
}
