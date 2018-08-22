package com.udit.java;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author Udit Sharma.
 * @since 05 Apr, 2018 8:06 AM
 */
public class ComparatorSample {
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
                return Integer.compare(this.index, o.index);
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Node node = (Node) o;

            if (index != node.index) return false;
            return value == node.value;
        }

        @Override
        public int hashCode() {
            int result = index;
            result = 31 * result + value;
            return result;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "index=" + index +
                    ", value=" + value +
                    '}';
        }
    }

    public static void main(String[] args) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(1, 3));
        queue.add(new Node(1, 2));
        queue.add(new Node(2, 3));
        queue.add(new Node(1, 3));
        System.out.println(Arrays.toString(queue.toArray()));


        PriorityQueue<Node> nodes = new PriorityQueue<>();
        nodes.add(new Node(1, 0));
        nodes.add(new Node(2, 1));
        nodes.add(new Node(2, 3));
        //nodes.add(new Node(2, 1));
        while (!nodes.isEmpty()) {
            System.out.println(nodes.poll());
        }

    }
}
