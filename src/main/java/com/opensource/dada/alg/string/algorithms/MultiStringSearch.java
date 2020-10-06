package com.opensource.dada.alg.string.algorithms;

import com.opensource.dada.ds.trie.Trie;

import java.util.*;

public class MultiStringSearch {
    public static void main(String[] args) {
        String bigString = "this is a big string";
        List<String> smallStrings = List.of("this","yo","is","a","bigger", "string", "kappa");
        //Result: [true, false, true, true, false, true, false]
        System.out.println("Result:"+multiStringSearch1(bigString, smallStrings));
        System.out.println("Result:"+multiStringSearchUsingSuffixTrie(bigString, smallStrings));
        System.out.println("Result:"+multiStringSearchUsingTrie(bigString, smallStrings));

    }

    //Approach 1 start
    //Complexity time: O(bns), space: O(n)
    //where b is length of big String, n is no. of small strings, s is length of largest small String
    static List<Boolean> multiStringSearch1(String bigString, List<String> smallStrings) {
        List<Boolean> result = new ArrayList<>();
        for (String smallString: smallStrings) {
            result.add(isInBigString(bigString, smallString));
        }
        return result;
    }

    private static boolean isInBigString(String bigString, String smallString) {
        for (int i = 0; i < bigString.length(); i++) {
            if (i+smallString.length() > bigString.length()) {
                break;
            }
            if (isInBigStringHelper(bigString, smallString, i)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isInBigStringHelper(String bigString, String smallString, int i) {
        int leftBigIndex = i;
        int rightBigIndex = i + smallString.length() -1;
        int leftSmallIndex = 0;
        int rightSmallIndex = smallString.length() -1;

        while (leftBigIndex <= rightBigIndex) {
            if (bigString.charAt(leftBigIndex) != smallString.charAt(leftSmallIndex)
                    || bigString.charAt(rightBigIndex) != smallString.charAt(rightSmallIndex)
            ) {
                return false;
            }
            leftBigIndex++;
            rightBigIndex--;
            leftSmallIndex++;
            rightSmallIndex--;
        }
        return true;
    }
    //Approach 1 end

    //Approach 2 start
    //Using suffix trie
    //Complexity time: O(b^2 + ns), space: O(b^2 +n)
    //where b is length of big String, n is no. of small strings, s is length of largest small String
    static List<Boolean> multiStringSearchUsingSuffixTrie(String bigString, List<String> smallStrings) {
        ModifiedSuffixTrie suffixTrie = new ModifiedSuffixTrie(bigString);
        List<Boolean> result = new ArrayList<>();
        for (String smallString: smallStrings) {
            result.add(suffixTrie.contains(smallString));
        }
        return result;
    }
    //Approach 2 end

    //Approach 3 start
    //Using suffix trie
    //Complexity time: O(ns + bs), space: O(ns)
    //where b is length of big String, n is no. of small strings, s is length of largest small String
    static List<Boolean> multiStringSearchUsingTrie(String bigString, List<String> smallStrings) {
        Trie trie = new Trie();
        List<Boolean> result = new ArrayList<>();
        for (String smallString: smallStrings) {
            trie.add(smallString);
        }
        Map<String, Boolean> containedStrings = new LinkedHashMap<>();
        for (int i = 0; i < bigString.length(); i++) {
            findSmallStringsIn(bigString, i, trie, containedStrings);
        }
        for (String smallString: smallStrings) {
            result.add(containedStrings.containsKey(smallString));
        }
        return result;
    }

    private static void findSmallStringsIn(String bigString, int startIndex, Trie trie,
                                           Map<String, Boolean> containedStrings) {
        Map currentNode = trie.getRoot();
        for (int i = startIndex; i < bigString.length(); i++) {
            char currentChar = bigString.charAt(i);
            currentNode = (Map) currentNode.get(currentChar);
            if(currentNode==null) {
                break;
            }
            if (currentNode.containsKey(Trie.endSymbol)){
                containedStrings.put((String)currentNode.get(Trie.endSymbol), true);
            }
        }
    }
    //Approach 3 end
}
