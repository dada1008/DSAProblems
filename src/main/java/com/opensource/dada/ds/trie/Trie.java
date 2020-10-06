package com.opensource.dada.ds.trie;

import java.util.HashMap;
import java.util.Map;

public class Trie {
    private Map<Character, Map> root = new HashMap<>();
    public static char endSymbol = '*';

    public void add(String str) {
        Map node = root;
        for (int i = 0; i < str.length(); i++) {
            if (node.containsKey(str.charAt(i)))
                node = (Map) node.get(str.charAt(i));
            else {
                node.put(str.charAt(i), new HashMap<Character, Map>());
                node = (Map) node.get(str.charAt(i));
            }
        }
        /** end of string **/
        node.put(endSymbol, str);
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
        return currentNode.containsKey(endSymbol) ? true : false;
    }

    public Map<Character, Map> getRoot() {
        return root;
    }

    @Override
    public String toString() {
        return "Trie{" +
                "root=" + root +
                '}';
    }
}
