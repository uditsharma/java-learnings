package com.udit.geeks_for_geeks.graph.dfs;


import java.util.LinkedList;
import java.util.Stack;

/**
 * @author Udit Sharma.
 * @since 07 Apr, 2018 10:30 AM
 */
public class GraphDfs {
    private int nodes;
    private LinkedList<Integer>[] neighbours;

    public GraphDfs(int nodes) {
        this.nodes = nodes;
        neighbours = new LinkedList[nodes];
        for (int i = 0; i < nodes; i++) {
            neighbours[i] = new LinkedList<Integer>();
        }
    }

    public static void main(String[] args) {
        GraphDfs g = new GraphDfs(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println();
        g.iterativeDFS(2);
        System.out.println();
        g.DFSRecursive();
    }

    public void addEdge(int src, int dest) {
        this.neighbours[src].add(dest);
    }

    public void iterativeDFS(int node) {
        boolean[] visited = new boolean[nodes];
        Stack<Integer> stack = new Stack<>();
        stack.push(node);
        visited[node] = true;
        while (!stack.isEmpty()) {
            int data = stack.peek();
            boolean allNeighbourVisited = true;
            LinkedList<Integer> neighbours = this.neighbours[data];
            for (int neighbor : neighbours) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    allNeighbourVisited = false;
                    stack.push(neighbor);
                }
            }
            if (allNeighbourVisited) {
                System.out.print(stack.pop() + " , ");
            }
        }
        for (int i = 0; i < nodes; i++) {
            if (!visited[i]) {
                stack.push(i);
                visited[i] = true;

                while (!stack.isEmpty()) {
                    int data = stack.peek();
                    boolean allNeighbourVisited = true;
                    LinkedList<Integer> neighbours = this.neighbours[data];
                    for (int neighbor : neighbours) {
                        if (!visited[neighbor]) {
                            visited[neighbor] = true;
                            allNeighbourVisited = false;
                            stack.push(neighbor);
                        }
                    }
                    if (allNeighbourVisited) {
                        System.out.print(stack.pop() + " , ");
                    }
                }
            }
        }
    }

    public void DFSRecursive() {
        boolean[] visited = new boolean[nodes];
        for (int i = 0; i < nodes; i++) {
            if (!visited[i]) {
                _recursiveDfs(i, visited);
            }
        }
    }

    private void _recursiveDfs(int i, boolean[] visited) {
        visited[i] = true;
        LinkedList<Integer> neighbours = this.neighbours[i];
        for (int neighbour : neighbours) {
            if (!visited[neighbour]) {
                _recursiveDfs(neighbour, visited);
            }
        }
        System.out.print(i + " , ");
    }

}
