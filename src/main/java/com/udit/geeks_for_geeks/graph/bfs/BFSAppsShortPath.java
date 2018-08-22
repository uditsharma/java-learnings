package com.udit.geeks_for_geeks.graph.bfs;

import java.util.LinkedList;

/**
 * @author Udit Sharma.
 * @since 03 Apr, 2018 7:42 AM
 */
public class BFSAppsShortPath {
    private final int nodes;
    private final LinkedList<Edge> adjListArray[];
    public BFSAppsShortPath(int nodes) {
        this.nodes = nodes;
        this.adjListArray = new LinkedList[nodes];
        for (int i = 0; i < nodes; i++) {
            this.adjListArray[i] = new LinkedList<>();
        }
    }

    public static void main(String[] args) {


        BFSAppsShortPath graph = new BFSAppsShortPath(5);
        graph.addEdge(0, 1, 1);
        graph.addEdge(0, 2, 1);
        graph.addEdge(0, 3, 0);

        graph.addEdge(1, 4, 0);
        graph.addEdge(2, 3, 0);
        graph.addEdge(3, 4, 0);

        graph.shortPath(0);
    }

    public void addEdge(int src, int dest, int weight) {
        this.adjListArray[src].addFirst(new Edge(dest, weight));
        this.adjListArray[dest].addFirst(new Edge(src, weight));
    }

    public void shortPath(int start) {
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(start);
        int[] distance = new int[nodes];
        for (int i = 0; i < nodes; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        distance[start] = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            LinkedList<Edge> edges = adjListArray[node];
            if (edges != null && !edges.isEmpty()) {
                for (Edge neighbour : edges) {
                    if (distance[neighbour.node] > distance[node] + neighbour.distance) {
                        distance[neighbour.node] = distance[node] + neighbour.distance;

                        if (neighbour.distance == 0) {
                            queue.addFirst(neighbour.node);
                        } else {
                            queue.addLast(neighbour.node);
                        }
                    }
                }
            }
        }
        for (int i = 0; i < distance.length; i++) {
            System.out.println(start + " --> " + i + "  = " + distance[i]);
        }
    }

    private class Edge {
        int node;
        int distance;

        public Edge(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }

}
