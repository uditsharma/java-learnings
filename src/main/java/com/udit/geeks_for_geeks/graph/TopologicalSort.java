package com.udit.geeks_for_geeks.graph;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @author Udit Sharma.
 * @since 07 Apr, 2018 12:30 PM
 */
public class TopologicalSort {
    int nodes;
    LinkedList<Integer>[] neighbours;

    public TopologicalSort(int nodes) {
        this.nodes = nodes;
        this.neighbours = new LinkedList[nodes];
        for (int i = 0; i < nodes; i++) {
            this.neighbours[i] = new LinkedList<>();
        }
    }

    public static void main(String[] args) {
// Create a graph given in the above diagram
        TopologicalSort g = new TopologicalSort(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);

        System.out.println("Following is a Topological " +
                "sort of the given graph");
        g.sort();
    }

    void addEdge(int v, int w) {
        this.neighbours[v].add(w);
    }

    public void sort() {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[nodes];
        for (int i = 0; i < nodes; i++) {
            if (!visited[i]) {
                topoSort(i, stack, visited);
            }
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " , ");
        }
    }

    private void topoSort(int i, Stack<Integer> stack, boolean[] visited) {
        visited[i] = true;
        LinkedList<Integer> neighbours = this.neighbours[i];
        for (int neighbour : neighbours) {
            if (!visited[neighbour]) {
                topoSort(neighbour, stack, visited);
            }
        }
        stack.push(i);
    }
}
