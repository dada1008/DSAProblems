package com.opensource.dada.problems.pattern.topologicalSort;

import java.util.*;

public class SequenceReconstruction  {
    //Time & Space complexity: O(V+N)
    public static boolean canConstruct(int[] originalSeq, int[][] sequences) {
        List<Integer> sortedOrder = new ArrayList<>();
        if (originalSeq.length <= 0) {
            return false;
        }
        // a. Initialize the graph
        // count of incoming edges for every vertex
        Map<Integer, Integer> inDegree = new HashMap<>();
        // adjacency list graph
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] seq: sequences) {
            for (int i = 0; i < seq.length; i++) {
                inDegree.putIfAbsent(seq[i], 0);
                graph.putIfAbsent(seq[i], new ArrayList<>());
            }
        }
        // b. Build the graph
        for (int[] seq : sequences) {
            for (int i = 1; i < seq.length; i++) {
                int parent = seq[i - 1];
                int child = seq[i];
                // put the child into it's parent's list
                graph.get(parent).add(child);
                // increment child's inDegree
                inDegree.put(child, inDegree.get(child) + 1);
            }
        }
        // if we don't have ordering rules for all the numbers
        // we'll not able to uniquely construct the sequence
        if (inDegree.size() != originalSeq.length) {
            return false;
        }
        // c. Find all sources i.e., all vertices with 0 in-degrees
        Queue<Integer> sources = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : inDegree.entrySet()) {
            if (entry.getValue() == 0) {
                sources.add(entry.getKey());
            }
        }
        // d. For each source, add it to the sortedOrder and subtract one from all of its children's in-d
        // if a child's in-degree becomes zero, add it to the sources queue
        while (!sources.isEmpty()) {
            if (sources.size() > 1) {
                // more than one sources mean, there is more than one way to reconstruct the sequence
                return false;
            }
            if (originalSeq[sortedOrder.size()] != sources.peek()) {
                // the next source (or number) is different from the original sequence
                return false;
            }
            int vertex = sources.poll();
            sortedOrder.add(vertex);
            // get the node's children to decrement their in-degree
            List<Integer> children = graph.get(vertex);
            for (int child : children) {
                inDegree.put(child, inDegree.get(child) - 1);
                if (inDegree.get(child) == 0)
                    sources.add(child);
            }
        }
        // if sortedOrder's size is not equal to original sequence's size,
        // there is no unique way to construct
        return sortedOrder.size() == originalSeq.length;
    }
    public static void main(String[] args) {
        boolean result = canConstruct(new int[] { 1, 2, 3, 4 },
                new int[][] { new int[] { 1, 2 }, new int[] { 2, 3 }, new int[] { 3, 4 } });
        System.out.println("Can we uniquely construct the sequence: " + result);//true
        result = canConstruct(new int[] { 1, 2, 3, 4 },
                new int[][] { new int[] { 1, 2 }, new int[] { 2, 3 }, new int[] { 2, 4 } });
        System.out.println("Can we uniquely construct the sequence: " + result);//false
        result = canConstruct(new int[] { 3, 1, 4, 2, 5 },
                new int[][] { new int[] { 3, 1, 5 }, new int[] { 1, 4, 2, 5 } });
        System.out.println("Can we uniquely construct the sequence: " + result);//true
    }
}
