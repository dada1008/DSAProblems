package com.opensource.dada.problems.pattern.topologicalSort;

import java.util.*;

/**
 * Problem:
 * Topological Sort of a directed graph (a graph with unidirectional edges) is a linear ordering
 * of its vertices such that for every directed edge (U, V) from vertex U to vertex V,
 * U comes before V in the ordering.
 * <p>
 * Given a directed graph, find the topological ordering of its vertices.
 * <p>
 * Example 1:
 * <p>
 * Input: Vertices=4, Edges=[3, 2], [3, 0], [2, 0], [2, 1]
 * Output: Following are the two valid topological sorts for the given graph:
 * 1) 3, 2, 0, 1
 * 2) 3, 2, 1, 0
 * <p>
 * Example 2:
 * <p>
 * Input: Vertices=5, Edges=[4, 2], [4, 3], [2, 0], [2, 1], [3, 1]
 * Output: Following are all valid topological sorts for the given graph:
 * 1) 4, 2, 3, 0, 1
 * 2) 4, 3, 2, 0, 1
 * 3) 4, 3, 2, 1, 0
 * 4) 4, 2, 3, 1, 0
 * 5) 4, 2, 0, 3, 1
 * <p>
 * Input: Vertices=7, Edges=[6, 4], [6, 2], [5, 3], [5, 4], [3, 0], [3, 1], [3, 2], [4, 1]
 * Output: Following are all valid topological sorts for the given graph:
 * 1) 5, 6, 3, 4, 0, 1, 2
 * 2) 6, 5, 3, 4, 0, 1, 2
 * 3) 5, 6, 4, 3, 0, 2, 1
 * 4) 6, 5, 4, 3, 0, 1, 2
 * 5) 5, 6, 3, 4, 0, 2, 1
 * 6) 5, 6, 3, 4, 1, 2, 0
 * <p>
 * There are other valid topological ordering of the graph too.
 */
public class TopologicalSort {
    /**
     * Time complexity: O(V+E), where ‘V’ is the total number of vertices and ‘E’
     * is the total number of edges in the graph.
     * Space complexity: O(V+E), since we are storing all of the edges
     * for each vertex in an adjacency list.
     */
    public static List<Integer> sort(int vertices, int[][] edges) {
        List<Integer> sortedOrder = new ArrayList<>();
        if (vertices <= 0) {
            return sortedOrder;
        }
        // a. Initialize the graph
        // count of incoming edges for every vertex
        Map<Integer, Integer> indegreeMap = new HashMap<>();
        // adjacency list graph
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < vertices; i++) {
            indegreeMap.put(i, 0);
            graph.put(i, new ArrayList<>());
        }
        // b. Build the graph
        for (int i = 0; i < edges.length; i++) {
            int parent = edges[i][0];
            int child = edges[i][1];
            // put the child into it's parent's list
            graph.get(parent).add(child);
            // increment child's inDegree
            indegreeMap.put(child, indegreeMap.get(child) + 1);
        }
        // c. Find all sources i.e., all vertices with 0 in-degrees
        Queue<Integer> sources = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : indegreeMap.entrySet()) {
            if (entry.getValue() == 0) {
                sources.add(entry.getKey());
            }
        }

        // d. For each source, add it to the sortedOrder and subtract one from
        // all of its children's in-degrees
        // if a child's in-degree becomes zero, add it to the sources queue
        while (!sources.isEmpty()) {
            int vertex = sources.poll();
            sortedOrder.add(vertex);
            // get the node's children to decrement their in-degrees
            List<Integer> children = graph.get(vertex);

            for (int child : children) {
                indegreeMap.put(child, indegreeMap.get(child) - 1);
                if (indegreeMap.get(child) == 0) {
                    sources.add(child);
                }
            }
        }

        // topological sort is not possible as the graph has a cycle
        if (sortedOrder.size() != vertices) {
            return new ArrayList<>();
        }

        return sortedOrder;
    }

    public static void main(String[] args) {
        List<Integer> result = sort(4,
                new int[][]{new int[]{3, 2},
                        new int[]{3, 0},
                        new int[]{2, 0},
                        new int[]{2, 1}});
        System.out.println(result);
        result = sort(5, new int[][]{
                new int[]{4, 2},
                new int[]{4, 3},
                new int[]{2, 0},
                new int[]{2, 1},
                new int[]{3, 1}});
        System.out.println(result);
        result = sort(7, new int[][]{
                new int[]{6, 4},
                new int[]{6, 2},
                new int[]{5, 3},
                new int[]{5, 4},
                new int[]{3, 0},
                new int[]{3, 1},
                new int[]{3, 2},
                new int[]{4, 1}
        });
        System.out.println(result);
        //This example has cycle frm vertex 5 to 2;
        result = sort(7, new int[][]{
                new int[]{6, 4},
                new int[]{6, 2},
                new int[]{5, 3},
                new int[]{5, 4},
                new int[]{3, 0},
                new int[]{3, 1},
                new int[]{3, 2},
                new int[]{4, 1},
                new int[]{2, 5}
        });
        System.out.println(result);

        result = findOrder(3,
                new int[][]{
                        new int[]{0, 1},
                        new int[]{1, 2}
                });
        System.out.println(result);
        result = findOrder(3,
                new int[][]{new int[]{0, 1}, new int[]{1, 2}, new int[]{2, 0}});
        System.out.println(result);

        result = findOrder(6, new int[][]{new int[]{2, 5},
                new int[]{0, 5}, new int[]{0, 4},
                new int[]{1, 4}, new int[]{3, 2},
                new int[]{1, 3}});
        System.out.println(result);
    }

    /**
     * Problem:
     *
     * Tasks Scheduling Order
     *
     * There are ‘N’ tasks, labeled from ‘0’ to ‘N-1’.
     * Each task can have some prerequisite tasks which need to be completed before
     * it can be scheduled. Given the number of tasks and a list of prerequisite pairs,
     * write a method to find the ordering of tasks we should pick to finish all tasks.
     *
     * Example 1:
     *
     * Input: Tasks=3, Prerequisites=[0, 1], [1, 2]
     * Output: [0, 1, 2]
     * Explanation: To execute task '1', task '0' needs to finish first.
     * Similarly, task '1' needs to finish
     * before '2' can be scheduled. A possible scheduling of tasks is: [0, 1, 2]
     * Example 2:
     *
     * Input: Tasks=3, Prerequisites=[0, 1], [1, 2], [2, 0]
     * Output: []
     * Explanation: The tasks have cyclic dependency, therefore they cannot be scheduled.
     * Example 3:
     *
     * Input: Tasks=6, Prerequisites=[2, 5], [0, 5], [0, 4], [1, 4], [3, 2], [1, 3]
     * Output: [0 1 4 3 2 5]
     * Explanation: A possible scheduling of tasks is: [0 1 4 3 2 5]
     *
     */
    public static List<Integer> findOrder(int tasks, int[][] prerequisites) {
        return sort(tasks, prerequisites);
    }
}
