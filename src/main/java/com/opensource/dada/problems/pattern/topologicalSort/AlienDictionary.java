package com.opensource.dada.problems.pattern.topologicalSort;

import java.util.*;

/**
 * Problem:
 *
 * There is a dictionary containing words from an alien language for which
 * we don’t know the ordering of the characters.
 * Write a method to find the correct order of characters in the alien language.
 *
 * Example 1:
 *
 * Input: Words: ["ba", "bc", "ac", "cab"]
 * Output: bac
 * Explanation: Given that the words are sorted lexicographically by the rules of the alien language, so
 * from the given words we can conclude the following ordering among its characters:
 *
 * 1. From "ba" and "bc", we can conclude that 'a' comes before 'c'.
 * 2. From "bc" and "ac", we can conclude that 'b' comes before 'a'
 *
 * From the above two points, we can conclude that the correct character order is: "bac"
 * Example 2:
 *
 * Input: Words: ["cab", "aaa", "aab"]
 * Output: cab
 * Explanation: From the given words we can conclude the following ordering among its characters:
 *
 * 1. From "cab" and "aaa", we can conclude that 'c' comes before 'a'.
 * 2. From "aaa" and "aab", we can conclude that 'a' comes before 'b'
 *
 * From the above two points, we can conclude that the correct character order is: "cab"
 * Example 3:
 *
 * Input: Words: ["ywx", "wz", "xww", "xz", "zyy", "zwz"]
 * Output: ywxz
 * Explanation: From the given words we can conclude the following ordering among its characters:
 *
 * 1. From "ywx" and "wz", we can conclude that 'y' comes before 'w'.
 * 2. From "wz" and "xww", we can conclude that 'w' comes before 'x'.
 * 3. From "xww" and "xz", we can conclude that 'w' comes before 'z'
 * 4. From "xz" and "zyy", we can conclude that 'x' comes before 'z'
 * 5. From "zyy" and "zwz", we can conclude that 'y' comes before 'w'
 *
 * From the above five points, we can conclude that the correct character order is: "ywxz"
 */
public class AlienDictionary {
    public static String findOrder(String[] words) {
        if (words==null || words.length== 0) {
            return "";
        }
        // a. Initialize the graph
        // count of incoming edges for every vertex
        Map<Character, Integer> inDegree = new HashMap<>();
        // adjacency list graph
        Map<Character, List<Character>> graph = new HashMap<>();
        for (String word: words) {
            for (char c: word.toCharArray() ) {
                inDegree.put(c, 0);
                graph.put(c, new ArrayList<>());
            }
        }
        // b. Build the graph
        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i];
            String w2 = words[i + 1]; // find ordering of characters from adjacent words
            for (int j = 0; j < Math.min(w1.length(), w2.length()); j++) {
                char parent = w1.charAt(j), child = w2.charAt(j);
                if (parent != child) { // if the two characters are different
                    graph.get(parent).add(child); // put the child into it's parent's list
                    inDegree.put(child, inDegree.get(child) + 1); // increment child's inDegree
                    // only the first different character between the two words will help us find the order
                    break;
                }
            }
        }
        // c. Find all sources i.e., all vertices with 0 in-degrees
        Queue<Character> sources = new LinkedList<>();
        for (Map.Entry<Character, Integer> entry : inDegree.entrySet()) {
            if (entry.getValue() == 0)
                sources.add(entry.getKey());
        }
        // d. For each source, add it to the sortedOrder and subtract one from all of its children's in-degree
        // if a child's in-degree becomes zero, add it to the sources queue
        StringBuilder sortedOrder = new StringBuilder();
        while (!sources.isEmpty()) {
            Character vertex = sources.poll();
            sortedOrder.append(vertex);
            List<Character> children = graph.get(vertex); // get the node's children to decrement their in-degree
            for (Character child : children) {
                inDegree.put(child, inDegree.get(child) - 1);
                if (inDegree.get(child) == 0)
                    sources.add(child);
            }
        }
        // if sortedOrder doesn't contain all characters, there is a cyclic dependency between characters
        // will not be able to find the correct ordering of the characters
        if (sortedOrder.length() != inDegree.size())
            return "";
        return sortedOrder.toString();
    }
    public static void main(String[] args) {
        String result = findOrder(new String[] { "ba", "bc", "ac", "cab" });
        System.out.println("Character order: " + result);//bac
        result = findOrder(new String[] { "cab", "aaa", "aab" });
        System.out.println("Character order: " + result);//cab
        result = findOrder(new String[] { "ywx", "wz", "xww", "xz", "zyy", "zwz" });
        System.out.println("Character order: " + result);//ywxz
    }
}
