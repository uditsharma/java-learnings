package com.udit.geeks_for_geeks.graph.undirected;


import java.util.LinkedList;
import java.util.Queue;

public class GraphWithAdjacencyMatrix {
    int vertices;
    int adjacencyMatrix[][];

    public GraphWithAdjacencyMatrix(int vertices) {
        this.vertices = vertices;
        adjacencyMatrix = new int[vertices][vertices];
    }

    public static void main(String[] args) {
        int number_of_vertices = 6;
        int number_of_edges = 5;
        GraphWithAdjacencyMatrix g = new GraphWithAdjacencyMatrix(number_of_vertices);
        //input set 1
        g.insert(1, 6);
        g.insert(2, 6);
        g.insert(3, 6);
        g.insert(4, 6);
        g.insert(5, 6);
        //input set 2
        /*graph.insert(1, 6);
        graph.insert(2, 3);
        graph.insert(2, 4);
        graph.insert(4, 3);
        graph.insert(5, 3);*/

        int vertex = g.sink();

        // returns 0 based indexing of vertex. returns
        // -1 if no sink exits.
        // returns the vertex number-1 if sink is found
        if (vertex >= 0)
            System.out.println("Sink found at vertex "
                    + (vertex + 1));
        else
            System.out.println("No Sink");
    }

    public void insert(int source, int destination) {
        // make adjacency_matrix[i][j] = 1 if there is
        // an edge from i to j
        adjacencyMatrix[source - 1][destination - 1] = 1;
    }

    public int sink() {
        int possibleSink = 0, i = 0, j = 0;
        for (; i < vertices && j < vertices; ) {
            if (adjacencyMatrix[i][j] == 0) {
                j++;
            } else {
                i++;
            }
        }
        if (i > vertices || !isSink(i)) {
            return -1;
        }
        return i;
    }

    private boolean isSink(int index) {
        for (int i = 0; i < vertices; i++) {
            if (adjacencyMatrix[i][index] == 0 && i != index) {
                return false;
            }
            if (adjacencyMatrix[index][i] == 1) {
                return false;
            }
        }
        return true;
    }

    public void bfs(int node) {
        Queue<Integer> queue = new LinkedList<>();
        boolean visited[] = new boolean[vertices];
        queue.add(node);
        visited[node] = true;
        while (!queue.isEmpty()) {
            Integer data = queue.poll();
            System.out.print(data + " ,");

        }

    }
}
