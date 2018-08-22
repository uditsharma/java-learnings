package com.udit.geeks_for_geeks.graph;

import java.util.LinkedList;

/**
 * @author Udit Sharma.
 * @since 08 Apr, 2018 3:19 PM
 */
public class Graph {
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

    public Graph transpose() {
        Graph graph = new Graph(nodes);
        for (int i = 0; i < nodes; i++) {
            LinkedList<Integer> neighbours = this.neighbours[i];
            for (int neighbour : neighbours) {
                graph.addEdge(neighbour, i);
            }
        }
        return graph;
    }

    public void dfsUtil(int u, boolean[] visited) {
        visited[u] = true;
        System.out.print(u + " , ");
        LinkedList<Integer> neighbours = this.neighbours[u];
        for (int neighbour : neighbours) {
            if (!visited[neighbour]) {
                dfsUtil(neighbour, visited);
            }
        }
    }
}
