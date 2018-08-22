package com.udit.geeks_for_geeks.graph;


import java.util.*;

/**
 * @author Udit Sharma.
 * @since 08 Apr, 2018 12:19 PM
 */
public class ConnectedComponent {
    Graph graph;

    public ConnectedComponent(int nodes) {
        this.graph = new Graph(nodes);
    }

    public static void main(String[] args) {
        ConnectedComponent g = new ConnectedComponent(5);
        g.addEdge(1, 0);
        g.addEdge(0, 2);
        g.addEdge(2, 1);
        g.addEdge(0, 3);
        g.addEdge(3, 4);

        System.out.println("Following are strongly connected components " +
                "in given graph ");
        g.printSSC();
        g.printSSC2();

    }

    public void addEdge(int src, int dest) {
        this.graph.addEdge(src, dest);
    }

    void printSSC2() {
        Stack<Integer> stack = new Stack<>();
        int numberOfNodes = graph.nodes;
        boolean[] visited = new boolean[numberOfNodes];
        for (int i = 0; i < numberOfNodes; i++) {
            if (!visited[i]) {
                visit(i, stack, visited);
            }
        }

        Graph transposedGraph = graph.transpose();
        for (int i = 0; i < this.graph.nodes; i++) {
            visited[i] = false;
        }
        for (int i = 0; i < this.graph.nodes; i++) {
            if (!visited[i]) {
                transposedGraph.dfsUtil(i, visited);
                System.out.println();
            }
        }

    }

    void printSSC() {
        Stack<Integer> stack = new Stack<>();
        int numberOfNodes = graph.nodes;
        boolean[] visited = new boolean[numberOfNodes];
        for (int i = 0; i < numberOfNodes; i++) {
            if (!visited[i]) {
                visit(i, stack, visited);
            }
        }

        Graph transposedGraph = graph.transpose();

        int[] componentId = new int[numberOfNodes];

        while (!stack.isEmpty()) {
            Integer u = stack.pop();
            assign(u, u, componentId, transposedGraph);
        }
        Map<Integer, Set<Integer>> componentIdVsNodes = new HashMap<>();
        for (int i = 0; i < numberOfNodes; i++) {
            Set<Integer> componentMembers = componentIdVsNodes.computeIfAbsent(componentId[i], k -> new HashSet<>());
            componentMembers.add(i);
        }

        componentIdVsNodes.forEach((componentKey, componentMembers) -> System.out.println(componentKey + " : {" + componentMembers.toString() + " } "));
    }

    private void assign(Integer node, Integer root, int[] componentId, Graph transposedGraph) {
        if (!(componentId[node] > 0)) {
            componentId[node] = root + 1;
            LinkedList<Integer> neighbours = transposedGraph.neighbours[node];
            for (int neighbour : neighbours) {
                assign(neighbour, root, componentId, transposedGraph);
            }
        }
    }

    private void visit(int i, Stack<Integer> stack, boolean[] visited) {
        visited[i] = true;
        LinkedList<Integer> neighbours = this.graph.neighbours[i];
        for (int neighbour : neighbours) {
            if (!visited[neighbour]) {
                visited[neighbour] = true;
                visit(neighbour, stack, visited);
            }
        }
        stack.push(i);
    }
}
