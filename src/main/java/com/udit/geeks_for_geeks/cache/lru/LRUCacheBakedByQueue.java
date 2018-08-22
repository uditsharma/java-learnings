package com.udit.geeks_for_geeks.cache.lru;

import java.util.HashMap;
import java.util.Map;

public class LRUCacheBakedByQueue {
    Node head;
    Node tail;
    Map<String, Node> keyVsNode = new HashMap<>();
    int capacity;

    public LRUCacheBakedByQueue(int capacity) {
        this.capacity = capacity;
    }

    public static void main(String[] args) {
        LRUCacheBakedByQueue cache = new LRUCacheBakedByQueue(5);
        cache.set("udit1", 1);
        cache.set("udit2", 2);
        cache.set("udit3", 3);
        cache.set("udit4", 4);
        cache.set("udit5", 5);
        cache.get("udit1");
        cache.get("udit2");
        cache.get("udit3");
        cache.set("udit6", 6);

        System.out.println(cache.get("udit1"));
        System.out.println(cache.get("udit2"));
        System.out.println(cache.get("udit3"));
        System.out.println(cache.get("udit4"));

    }

    public void set(String key, int value) {
        Node node = keyVsNode.get(key);
        if (node != null) {
            deQueue(node);
            node.value = value;
            enQueue(node.key, node.value);
        } else {
            if (keyVsNode.size() >= capacity) {
                deQueue(head);
            }
            enQueue(key, value);
        }
    }

    private void deQueue(Node node) {
        keyVsNode.remove(node.key);
        if (node.next != null) {
            node.next.pre = node.pre;
        } else {
            tail = node.pre;
        }
        if (node.pre != null) {
            node.pre.next = node.next;
        } else {
            head = node.next;
        }
    }

    private void enQueue(String key, int value) {
        Node node = new Node(key, value);
        keyVsNode.put(key, node);
        if (tail == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            node.pre = tail;
            tail = node;
        }
    }

    public int get(String key) {
        Node node = keyVsNode.get(key);
        if (node != null) {
            deQueue(node);
            enQueue(node.key, node.value);
            return node.value;
        }
        return -1;
    }

    class Node {
        String key;
        int value;
        Node pre;
        Node next;

        public Node(String key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
