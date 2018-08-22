package com.udit.hacker_earth.graph;


import java.util.*;

/**
 * @author Udit Sharma.
 * @since 04 Apr, 2018 7:09 AM
 */
public class EdgeExistence {

    public boolean isThereAnEdge(int src, int dest) {
        LinkedList<Integer> edgeNodes = adjListArray[src];
        for (Integer edge : edgeNodes) {
            if (edge == dest) {
                return true;
            }
        }
        return false;
    }

    private class Edge {
        int node;
        int distance;

        public Edge(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }

    private final int nodes;
    private final LinkedList<Integer> adjListArray[];

    public EdgeExistence(int nodes) {
        this.nodes = nodes;
        this.adjListArray = new LinkedList[nodes];
        for (int i = 0; i < nodes; i++) {
            this.adjListArray[i] = new LinkedList<>();
        }
    }

    public void addEdge(int src, int dest, int weight) {
        this.adjListArray[src].addFirst(dest);
        this.adjListArray[dest].addFirst(src);
    }


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String nodes = scanner.nextLine();
        String[] split = nodes.split(" ");
        int numberOfNodes = Integer.parseInt(split[0]);
        int numberOfEdges = Integer.parseInt(split[1]);

        EdgeExistence graph = new EdgeExistence(numberOfNodes);
        for (int i = 0; i < numberOfEdges; ) {
            String edge = scanner.nextLine();
            if (edge == null || edge.trim().isEmpty()) {
                continue;
            }
            String[] edgeNodes = edge.split(" ");
            int src = Integer.parseInt(edgeNodes[0]);
            int dest = Integer.parseInt(edgeNodes[1]);
            graph.addEdge(src - 1, dest - 1, 0);
            i++;
        }

        int numberOfQuery = scanner.nextInt();
        List<String> queryResponse = new LinkedList<>();
        for (int i = 0; i < numberOfQuery; ) {
            String edge = scanner.nextLine();
            if (edge == null || edge.trim().isEmpty()) {
                continue;
            }
            String[] edgeNodes = edge.split(" ");
            int src = Integer.parseInt(edgeNodes[0]);
            int dest = Integer.parseInt(edgeNodes[1]);
            boolean thereAnEdge = graph.isThereAnEdge(src-1, dest-1);
            queryResponse.add(thereAnEdge ? "YES" : "NO");
            i++;
        }

        for (String s : queryResponse) {
            System.out.println(s);
        }
    }
}
