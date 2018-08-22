package com.udit.hacker_earth.graph;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Optional;
import java.util.function.Supplier;

/**
 * @author Udit Sharma.
 * @since 04 Apr, 2018 2:52 PM
 */
public class LearningGraph {

    private static InputReader in;
    private static PrintWriter out;

    static class InputReader {

        private InputStream stream;
        private byte[] buf = new byte[8192];
        private int curChar, snumChars;
        private SpaceCharFilter filter;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int snext() {
            if (snumChars == -1)
                throw new InputMismatchException();
            if (curChar >= snumChars) {
                curChar = 0;
                try {
                    snumChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (snumChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }

        public int nextInt() {
            int c = snext();
            while (isSpaceChar(c))
                c = snext();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = snext();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = snext();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public long nextLong() {
            int c = snext();
            while (isSpaceChar(c))
                c = snext();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = snext();
            }
            long res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = snext();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public int[] nextIntArray(int n) {
            int a[] = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = nextInt();
            return a;
        }

        public String readString() {
            int c = snext();
            while (isSpaceChar(c))
                c = snext();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = snext();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        public boolean isSpaceChar(int c) {
            if (filter != null)
                return filter.isSpaceChar(c);
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);
        }
    }

    public static class Node implements Comparable<Node> {
        int index;
        int value;

        public Node(int index, int value) {
            this.index = index;
            this.value = value;
        }

        @Override
        public int compareTo(Node o) {
            if (this.value != o.value) {
                return -Integer.compare(this.value, o.value);
            } else {
                return -Integer.compare(this.index, o.index);
            }
        }
    }

    private final int nodes;
    private final ArrayList<Node> adjListArray[];

    public LearningGraph(int nodes) {
        this.nodes = nodes;
        this.adjListArray = new ArrayList[nodes];
        for (int i = 0; i < nodes; i++) {
            this.adjListArray[i] = new ArrayList<>();
        }
    }

    public static int printKthElement(ArrayList<Node> neighbours, int k) {
        if (neighbours.size() < k) {
            return -1;
        }
        Collections.sort(neighbours);
        return neighbours.get(k - 1).index;
    }

    public void addEdge(Node src, Node dest) {
        this.adjListArray[src.index].add(dest);
        this.adjListArray[dest.index].add(src);
    }

    public static void main(String[] args) throws Throwable {

        in = new InputReader(System.in);
        out = new PrintWriter(System.out);

        int numberOfNodes = in.nextInt(), numberOfEdges = in.nextInt(), k = in.nextInt();

        int[] nodes = in.nextIntArray(numberOfNodes);
        ArrayList<Node>[]  graph = new ArrayList[numberOfNodes];
        for (int i = 0; i < numberOfNodes; i++) {
            graph[i] = new ArrayList<Node>();
        }

        for (int i = 0; i < numberOfEdges; i++) {
            int src = in.nextInt() - 1, dest = in.nextInt() - 1;
            graph[src].add(new Node(dest + 1, nodes[dest]));
            graph[dest].add(new Node(src + 1, nodes[src]));
        }

        for (int i = 0; i < numberOfNodes; i++) {
            if(k <= graph[i].size()) {
                out.println(printKthElement(graph[i], k));
            } else {
                out.println(-1);
            }
        }

        out.close();

        Optional.of("a").orElseThrow((Supplier<Throwable>) () -> new Exception("Invalid"));
    }


}
