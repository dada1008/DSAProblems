package com.opensource.dada.ds.graph;

import java.util.*;

/**
 * Problem:
 * /*
 * Build Order: You are given a list of projects and a list of dependencies (which is a list of pairs of
 * projects, where the second project is dependent on the first project). All of a project's dependencies
 * must be built before the project is. Find a build order that will allow the projects to be built. If there is no valid build order, return an error.
 * <p>
 * EXAMPLE
 * Input:
 * projects: a, b, c, d, e, f
 * dependencies: (a, d), (f, b), (b, d), (f, e), (d, c), (f,a)
 * <p>
 * Output: f, e, a, b, d, c
 */
public class PrintDependencies {

    static class Node {
        String data;
        boolean visited;
        List<Node> neighbours;

        Node(String data) {
            this.data = data;
            this.neighbours = new ArrayList<>();
        }

        public void addneighbours(Node neighbourNode) {
            this.neighbours.add(neighbourNode);
        }

        public List<Node> getNeighbours() {
            return neighbours;
        }

        public void setNeighbours(List<Node> neighbours) {
            this.neighbours = neighbours;
        }

        public String toString() {
            return data;
        }
    }

    static Stack<Node> stack = new Stack<>();

    // Recursive toplogical Sort
    public static void toplogicalSort(Node node)
    {
        List<Node> neighbours=node.getNeighbours();
        for (int i = 0; i < neighbours.size(); i++) {
            Node n=neighbours.get(i);
            if(n!=null && !n.visited)
            {
                toplogicalSort(n);
                n.visited=true;
            }
        }
        stack.push(node);
    }

    public static void main(String[] args) {
        Node node_a =new Node("a");
        Node node_b =new Node("b");
        Node node_c =new Node("c");
        Node node_d =new Node("d");
        Node node_e =new Node("e");
        Node node_f =new Node("f");

        //dependencies: (a, d), (f, b), (b, d), (f, e), (d, c), (f,a)
        node_a.addneighbours(node_d);
        node_f.addneighbours(node_b);
        node_b.addneighbours(node_d);
        node_f.addneighbours(node_e);
        node_d.addneighbours(node_c);
        node_f.addneighbours(node_a);

        System.out.println("Topological Sorting Order:");
        toplogicalSort(node_f);

        // Print contents of stack
        Stack<Node> resultStack=stack;
        //f, e, a, b, d, c
        while (!resultStack.empty()) {
            System.out.println(resultStack.pop().toString());
        }
    }

    private static class Vertex{
        String name;
        ArrayList<Vertex> dependencies;

        private Vertex(String name){
            this.name = name;
            this.dependencies = new ArrayList<Vertex>();
        }
    }

    private static class Graph{
        ArrayList<Vertex> vertices;
        HashMap<String, Vertex> vertexLookup;

        private Graph(){
            this.vertices = new ArrayList<Vertex>();
            this.vertexLookup = new HashMap<String, Vertex>();
        }

        private Vertex getVertex(String libName){
            Vertex v = this.vertexLookup.get(libName);
            if(v == null){
                v = new Vertex(libName);
                //v.name = libName;
                this.vertexLookup.put(libName, v);
                this.vertices.add(v);
            }
            return v;
        }
    }
    //(EDIT: Didn't describe this, but the original code returns null if there is a cycle)
    public static List<String> getDependencyLoadOrder(List<List<String>> libraries){
        //build the graph
        Graph g = new Graph();
        for(List<String> dependency : libraries){
            Iterator<String> iter = dependency.iterator();
            String libName = iter.next();
            Vertex v = g.getVertex(libName);
            while(iter.hasNext()){
                libName = iter.next();
                Vertex child = g.getVertex(libName);
                v.dependencies.add(child);
            }
        }

        //construct the list for return
        ArrayList<String> results = new ArrayList<String>(g.vertices.size());
        HashMap<String, State> loadState = new HashMap<String, State>();
        try{
            for(int i = 0; i < g.vertices.size(); i++){
                tryLoad(g.vertices.get(i), results, loadState );
            }
        }
        catch(IllegalArgumentException e){
            return null;
        }
        return results;
    }

    enum State{
        LOADED, LOADING, NOT_LOADED
    }
    private static void tryLoad(Vertex v, ArrayList<String> results, HashMap<String, State> loadState ){
        State state = loadState.get(v.name);
        if(state == State.LOADING){
            throw new IllegalArgumentException();
        }
        if(state == State.LOADED){
            return;
        }
        loadState.put(v.name, State.LOADING);
        for(Vertex child : v.dependencies){
            tryLoad(child, results, loadState);
        }
        results.add(v.name);
        loadState.put(v.name, State.LOADED);
    }
}
