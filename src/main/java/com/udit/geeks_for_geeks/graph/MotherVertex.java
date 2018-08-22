package com.udit.geeks_for_geeks.graph;


import java.util.LinkedList;

/**
 * @author Udit Sharma.
 * @since 09 Apr, 2018 8:06 AM
 */
public class MotherVertex {
    public static void main(String[] args) {
        Graph g = new Graph(7);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(4, 1);
        g.addEdge(6, 4);
        g.addEdge(5, 6);
        g.addEdge(5, 2);
        g.addEdge(6, 0);
        int motherVertex = new MotherVertex().findMotherVertex(g);
        System.out.println("motherVertex = " + motherVertex);
    }

    public int findMotherVertex(Graph graph) {
        boolean[] visited = new boolean[graph.nodes];
        int possibleMotherVertex = 0;
        for (int i = 0; i < graph.nodes; i++) {
            if (!visited[i]) {
                possibleMotherVertex = i;
                graph.dfsUtil(i, visited);
            }
        }
        for (int i = 0; i < graph.nodes; i++) {
            visited[i] = false;
        }
        graph.dfsUtil(possibleMotherVertex, visited);
        for (int i = 0; i < graph.nodes; i++) {
            if (!visited[i]) {
                return -1;
            }
        }
        return possibleMotherVertex;
    }

    public static class Graph {
        int nodes;
        LinkedList<Integer>[] neighbours;

        public Graph(int nodes) {
            this.nodes = nodes;
            this.neighbours = new LinkedList[nodes];
            for (int i = 0; i < nodes; i++) {
                this.neighbours[i] = new LinkedList<>();
            }
        }

        public void addEdge(int src, int dest) {
            this.neighbours[src].add(dest);
        }

        public void dfsUtil(int node, boolean[] visited) {
            visited[node] = true;
            LinkedList<Integer> neighbours = this.neighbours[node];
            for (int neighbour : neighbours) {
                if (!visited[neighbour]) {
                    dfsUtil(neighbour, visited);
                }
            }
        }
    }
}
