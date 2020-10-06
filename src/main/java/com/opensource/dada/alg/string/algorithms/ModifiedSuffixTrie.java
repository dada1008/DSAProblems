package com.opensource.dada.alg.string.algorithms;

import java.util.HashMap;
import java.util.Map;

public class ModifiedSuffixTrie {
    private Map<Character, Map> root = new HashMap<>();
    private char endSymbol = '*';

    public ModifiedSuffixTrie() {
    }
    public ModifiedSuffixTrie(String str) {
        populateModifiedSuffixTrieFrom(str);
    }

    /*public void add(String str) {
        Map node = root;
        for (int i = 0; i < str.length(); i++) {
            if (node.containsKey(str.charAt(i)))
                node = (Map) node.get(str.charAt(i));
            else {
                node.put(str.charAt(i), new HashMap<Character, Map>());
                node = (Map) node.get(str.charAt(i));
            }
        }
        node.put(endSymbol, str);
    }*/

    public void populateModifiedSuffixTrieFrom(String str) {
        for (int i = 0; i < str.length(); i++) {
            insertSubStringStartingAt(i, str);
        }
    }

    public void insertSubStringStartingAt(int index, String str) {
        Map node = root;
        for (int i = index; i < str.length(); i++) {
            if (node.containsKey(str.charAt(i)))
                node = (Map) node.get(str.charAt(i));
            else {
                node.put(str.charAt(i), new HashMap<Character, Map>());
                node = (Map) node.get(str.charAt(i));
            }
        }
    }

    /** Function to check if hash trie contains a given word **/
    public boolean contains(String str) {
        Map<Character, Map> currentNode = root;
        for (int i = 0; i < str.length(); i++) {
            if (currentNode.containsKey(str.charAt(i)))
                currentNode = currentNode.get(str.charAt(i));
            else
                return false;
        }
        return true;
    }

    public Map<Character, Map> getRoot() {
        return root;
    }

    @Override
    public String toString() {
        return "ModifiedSuffixTrie{" +
                "root=" + root +
                '}';
    }
}
