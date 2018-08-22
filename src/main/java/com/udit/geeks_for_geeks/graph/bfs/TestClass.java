package com.udit.geeks_for_geeks.graph.bfs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Udit Sharma.
 * @since 03 Apr, 2018 10:04 PM
 */
class TestClass {
    private final int nodes;
    private final LinkedList<Integer> adjListArray[];
    public TestClass(int nodes) {
        this.nodes = nodes;
        this.adjListArray = new LinkedList[nodes];
        for (int i = 0; i < nodes; i++) {
            this.adjListArray[i] = new LinkedList<>();
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int nodes = scanner.nextInt();

        TestClass graph = new TestClass(nodes);
        for (int i = 0; i < nodes - 1; ) {
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

        int levelX = scanner.nextInt();

        graph.levelNodes(0, levelX);
    }

    public void addEdge(int src, int dest, int weight) {
        this.adjListArray[src].addFirst(dest);
        this.adjListArray[dest].addFirst(src);
    }

    public void levelNodes(int start, int level) {
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(start);
        int[] levels = new int[nodes];
        Map<Integer, Integer> levelCount = new HashMap<>();
        boolean[] visited = new boolean[nodes];
        for (int i = 0; i < nodes; i++) {
            levels[i] = 1;
        }

        visited[start] = true;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            LinkedList<Integer> edges = adjListArray[node];
            if (edges != null && !edges.isEmpty()) {
                for (Integer neighbour : edges) {
                    if (!visited[neighbour]) {
                        queue.add(neighbour);
                        visited[neighbour] = true;
                        int neighbourLevel = levels[node] + 1;
                        levels[neighbour] = neighbourLevel;
                        Integer numberOfNodesAtLevel = levelCount.get(neighbourLevel);
                        if (numberOfNodesAtLevel == null) {
                            numberOfNodesAtLevel = 0;
                        }
                        numberOfNodesAtLevel = numberOfNodesAtLevel + 1;
                        levelCount.put(neighbourLevel, numberOfNodesAtLevel);
                    }
                }
            }
        }
        System.out.println(levelCount.get(level));
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