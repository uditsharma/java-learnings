package com.udit.geeks_for_geeks.stack.v2;

public class PreOrderWithStack {
    public class Node {
        int value;
        Node right;
        Node left;

        public Node(int value) {
            this.value = value;
        }
    }

    public class BinarySearchTree {
        Node root;

        public void add(int val) {
            Node node = new Node(val);
            if (root == null) {
                root = node;
            } else {
                Node temp = root;

            }
        }
    }
}
