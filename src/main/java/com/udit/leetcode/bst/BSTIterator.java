package com.udit.leetcode.bst;

import sun.reflect.generics.tree.Tree;

import java.util.Stack;

public class BSTIterator {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null) {
            stack.push(curr);
            curr = curr.left;
        }
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        TreeNode curr = stack.pop();
        TreeNode node = curr.right;
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
        return curr.val;
    }

    public static void main(String[] args) {

    }
}