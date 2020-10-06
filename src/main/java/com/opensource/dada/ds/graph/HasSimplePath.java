package com.opensource.dada.ds.graph;

import java.util.Iterator;
import java.util.LinkedList;

public class HasSimplePath {
    //prints BFS traversal from a given source s
    static boolean isReachable(Graph graph, Node<Integer> node_s, Node<Integer> node_d) {
        LinkedList<Integer> temp;

        // Mark all the vertices as not visited(By default set
        // as false)
        boolean visited[] = new boolean[graph.getNodes().size()];

        // Create a queue for BFS
        LinkedList<Node<Integer>> queue = new LinkedList<>();

        // Mark the current node as visited and enqueue it
        visited[node_s.getValue()] = true;
        queue.add(node_s);

        // 'i' will be used to get all adjacent vertices of a vertex
        Iterator<Node<Integer>> i;
        while (queue.size() != 0) {
            // Dequeue a vertex from queue and print it
            Node<Integer> s = queue.poll();

            Node<Integer> n;
            i = s.getAdjacentNodes().keySet().iterator();

            // Get all adjacent vertices of the dequeued vertex s
            // If a adjacent has not been visited, then mark it
            // visited and enqueue it
            while (i.hasNext()) {
                n = i.next();

                // If this adjacent node is the destination node,
                // then return true
                if (n .equals(node_d))
                    return true;

                // Else, continue to do BFS
                if (!visited[n.getValue()]) {
                    visited[n.getValue()] = true;
                    queue.add(n);
                }
            }
        }

        // If BFS is complete without visited d
        return false;
    }

    public static void main(String[] args) {
        // Create a graph given in the above diagram
        Node<Integer> node0 = new Node<>(0);
        Node<Integer> node1 = new Node<>(1);
        Node<Integer> node2 = new Node<>(2);
        Node<Integer> node3 = new Node<>(3);

        node0.addDestination(node1,0);
        node0.addDestination(node2,0);
        node1.addDestination(node2,0);
        node2.addDestination(node0,0);
        node2.addDestination(node3,0);
        node3.addDestination(node3,0);

        Graph graph = new Graph();

        graph.addNode(node0);
        graph.addNode(node1);
        graph.addNode(node2);
        graph.addNode(node3);

        int u = 1;
        int v = 3;
        if (isReachable(graph, node1, node3))
            System.out.println("There is a path from " + u +" to " + v);
        else
            System.out.println("There is no path from " + u +" to " + v);;

        u = 3;
        v = 1;
        if (isReachable(graph, node3, node1))
            System.out.println("There is a path from " + u +" to " + v);
        else
            System.out.println("There is no path from " + u +" to " + v);;
    }
}
