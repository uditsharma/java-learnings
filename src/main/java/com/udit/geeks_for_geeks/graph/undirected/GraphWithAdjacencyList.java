package com.udit.geeks_for_geeks.graph.undirected;


import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class GraphWithAdjacencyList {
    private final int nodes;
    private final LinkedList<Integer> adjListArray[];

    public GraphWithAdjacencyList(int nodes) {
        this.nodes = nodes;
        this.adjListArray = new LinkedList[nodes];
        for (int i = 0; i < nodes; i++) {
            this.adjListArray[i] = new LinkedList<Integer>();
        }
    }

    // Driver program to test above functions
    public static void main(String args[]) {
        // create the graph given in above figure
        int V = 5;
        GraphWithAdjacencyList graph = new GraphWithAdjacencyList(V);
        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        // print the adjacency list representation of
        // the above graph
        graph.bfs(2);


        GraphWithAdjacencyList g = new GraphWithAdjacencyList(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println();
        g.dfs(2);
    }

    public void addEdge(int src, int dest) {
        this.adjListArray[src].addFirst(dest);
        this.adjListArray[dest].addFirst(src);
    }

    // A utility function to print the adjacency list
    // representation of graph
    void printGraph() {
        for (int v = 0; v < nodes; v++) {
            System.out.println("Adjacency list of vertex " + v);
            System.out.print("head");
            for (Integer pCrawl : this.adjListArray[v]) {
                System.out.print(" -> " + pCrawl);
            }
            System.out.println("\n");
        }
    }

    public void bfs(int node) {
        boolean visited[] = new boolean[nodes];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        visited[node] = true;
        while (!queue.isEmpty()) {
            Integer vertex = queue.poll();
            System.out.print(vertex + " ,");
            LinkedList<Integer> neighbours = adjListArray[vertex];
            if (neighbours != null) {
                for (Integer data : neighbours) {
                    if (!visited[data]) {
                        visited[data] = true;
                        queue.add(data);
                    }
                }
            }
        }
    }

    public void dfs(int node) {
        boolean visited[] = new boolean[nodes];
        Stack<Integer> vertex = new Stack<>();
        visited[node] = true;
        vertex.push(node);
        while (!vertex.isEmpty()) {
            Integer data = vertex.peek();
            List<Integer> neighbours = adjListArray[data];
            boolean allNeighboursVisited = true;
            if (neighbours != null && !neighbours.isEmpty()) {
                for (int neighbour : neighbours) {
                    if (!visited[neighbour]) {
                        allNeighboursVisited = false;
                        visited[neighbour] = true;
                        vertex.add(neighbour);
                    }
                }
            }
            if (allNeighboursVisited) {
                System.out.print(vertex.pop() + " , ");
            }
        }

        for (int i = 0; i < nodes; i++) {
            if (!visited[i]) {
                vertex.push(i);
                visited[i] = true;

                while (!vertex.isEmpty()) {
                    Integer data = vertex.peek();
                    List<Integer> neighbours = adjListArray[data];
                    boolean allNeighboursVisited = true;
                    if (neighbours != null && !neighbours.isEmpty()) {
                        for (int neighbour : neighbours) {
                            if (!visited[neighbour]) {
                                allNeighboursVisited = false;
                                visited[neighbour] = true;
                                vertex.add(neighbour);
                            }
                        }
                    }
                    if (allNeighboursVisited) {
                        System.out.print(vertex.pop() + " , ");
                    }
                }
            }
        }
    }

}
