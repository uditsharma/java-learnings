package com.udit.geeks_for_geeks.graph;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @author Udit Sharma.
 * @since 07 Apr, 2018 1:26 PM
 */
public class LongestPath {
    private int nodes;
    private LinkedList<Edge>[] neighbours;

    public LongestPath(int nodes) {
        this.nodes = nodes;
        this.neighbours = new LinkedList[nodes];
        for (int i = 0; i < nodes; i++) {
            this.neighbours[i] = new LinkedList<>();
        }
    }

    public static void main(String[] args) {
        LongestPath g = new LongestPath(6);
        g.addEdge(0, 1, 5);
        g.addEdge(0, 2, 3);
        g.addEdge(1, 3, 6);
        g.addEdge(1, 2, 2);
        g.addEdge(2, 4, 4);
        g.addEdge(2, 5, 2);
        g.addEdge(2, 3, 7);
        g.addEdge(3, 5, 1);
        g.addEdge(3, 4, -1);
        g.addEdge(4, 5, -2);

        g.findLongestPath(1);

    }

    public void addEdge(int src, int dest, int weight) {
        this.neighbours[src].add(new Edge(dest, weight));
    }

    public Stack<Integer> sort() {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[nodes];
        for (int i = 0; i < nodes; i++) {
            if (!visited[i]) {
                topoSort(i, stack, visited);
            }
        }
        return stack;
    }

    private void topoSort(int i, Stack<Integer> stack, boolean[] visited) {
        visited[i] = true;
        LinkedList<Edge> neighbours = this.neighbours[i];
        for (Edge edge : neighbours) {
            if (!visited[edge.target]) {
                topoSort(edge.target, stack, visited);
            }
        }
        stack.push(i);
    }

    void findLongestPath(int src) {
        Stack<Integer> stack = sort();
        int[] dist = new int[nodes];
        for (int i = 0; i < nodes; i++) {
            dist[i] = -(Integer.MAX_VALUE);
        }
        dist[src] = 0;
        while (!stack.isEmpty()) {
            Integer source = stack.pop();
            LinkedList<Edge> neighbours = this.neighbours[source];
            for (Edge edge : neighbours) {
                if (dist[source] + edge.weight > dist[edge.target]) {
                    dist[edge.target] = dist[source] + edge.weight;
                }
            }
        }

        for (int i = 0; i < nodes; i++) {
            System.out.println(src + " -> " + i + " : " + dist[i]);
        }
    }

    public static class Edge {
        int target;
        int weight;

        public Edge(int node, int weight) {
            this.target = node;
            this.weight = weight;
        }
    }
}
