package com.opensource.dada.ds.graph;

import java.util.*;

/**
 *
 * The core idea of the Dijkstra algorithm is to continuously eliminate longer paths
 * between the starting node and all possible destinations.
 *
 * To keep track of the process, we need to have two distinct sets of nodes, settled and unsettled.
 *
 * Settled nodes are the ones with a known minimum distance from the source.
 * The unsettled nodes set gathers nodes that we can reach from the source,
 * but we don't know the minimum distance from the starting node.
 *
 * Here's a list of steps to follow in order to solve the SPP with Dijkstra:
 *
 * Set distance to startNode to zero.
 * Set all other distances to an infinite value.
 * We add the startNode to the unsettled nodes set.
 * While the unsettled nodes set is not empty we:
 * Choose an evaluation node from the unsettled nodes set,
 * the evaluation node should be the one with the lowest distance from the source.
 * Calculate new distances to direct neighbors by keeping the lowest distance at each evaluation.
 * Add neighbors that are not yet settled to the unsettled nodes set.
 * These steps can be aggregated into two stages, Initialization and Evaluation.
 * Let's see how does that apply to our sample graph:
 */
public class Dijkstra {
    public static Graph calculateShortestPathFromSource(Graph graph, Node<String> source) {
        source.setDistance(0);

        Set<Node<String>> settledNodes = new HashSet<>();
        Set<Node<String>> unsettledNodes = new HashSet<>();

        unsettledNodes.add(source);

        while (unsettledNodes.size() != 0) {
            Node<String> currentNode = getLowestDistanceNode(unsettledNodes);
            unsettledNodes.remove(currentNode);
            for (Map.Entry< Node<String>, Integer> adjacencyPair:
                    currentNode.getAdjacentNodes().entrySet()) {
                Node adjacentNode = adjacencyPair.getKey();
                Integer edgeWeight = adjacencyPair.getValue();
                if (!settledNodes.contains(adjacentNode)) {
                    calculateMinimumDistance(adjacentNode, edgeWeight, currentNode);
                    unsettledNodes.add(adjacentNode);
                }
            }
            settledNodes.add(currentNode);
        }
        return graph;
    }

    private static void calculateMinimumDistance(Node<String> evaluationNode, Integer edgeWeigh, Node<String> sourceNode) {
        Integer sourceDistance = sourceNode.getDistance();
        if (sourceDistance + edgeWeigh < evaluationNode.getDistance()) {
            evaluationNode.setDistance(sourceDistance + edgeWeigh);
            List<Node<String>> shortestPath = new LinkedList<>(sourceNode.getShortestPath());
            shortestPath.add(sourceNode);
            evaluationNode.setShortestPath(shortestPath);
        }
    }

    private static Node<String> getLowestDistanceNode(Set<Node<String>> unsettledNodes) {
        Node<String> lowestDistanceNode = null;
        int lowestDistance = Integer.MAX_VALUE;
        for (Node<String> node : unsettledNodes) {
            int nodeDistance = node.getDistance();
            if (nodeDistance < lowestDistance) {
                lowestDistance = nodeDistance;
                lowestDistanceNode = node;
            }
        }
        return lowestDistanceNode;
    }

    public static void main(String[] args) {
        Node<String> nodeA = new Node("A");
        Node<String> nodeB = new Node("B");
        Node<String> nodeC = new Node("C");
        Node<String> nodeD = new Node("D");
        Node<String> nodeE = new Node("E");
        Node<String> nodeF = new Node("F");

        nodeA.addDestination(nodeB, 10);
        nodeA.addDestination(nodeC, 15);

        nodeB.addDestination(nodeD, 12);
        nodeB.addDestination(nodeF, 15);

        nodeC.addDestination(nodeE, 10);

        nodeD.addDestination(nodeE, 2);
        nodeD.addDestination(nodeF, 1);

        nodeF.addDestination(nodeE, 5);

        Graph graph = new Graph();

        graph.addNode(nodeA);
        graph.addNode(nodeB);
        graph.addNode(nodeC);
        graph.addNode(nodeD);
        graph.addNode(nodeE);
        graph.addNode(nodeF);

        graph = Dijkstra.calculateShortestPathFromSource(graph, nodeA);
    }
}
