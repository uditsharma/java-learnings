/* * Copyright 2017 Autodesk, Inc. All Rights Reserved.
 *
 * This computer source code and related instructions and comments 
 * are the unpublished confidential and proprietary information of Autodesk, Inc. 
 * and are protected under applicable copyright and trade secret law.  
 * They may not be disclosed to, copied or used by any third party without the prior 
 * written consent of Autodesk, Inc.
 */

package com.udit.geeks_for_geeks.linkedlist;

/**
 * @author Udit Sharma.
 * @since 28 Jan, 2018 12:06 PM
 */
public class DoublyLinkedList {
    private DoublyListNode head;

    public static void main(String[] args) {
/* Start with the empty list */
        DoublyLinkedList dll = new DoublyLinkedList();

        // Insert 6. So linked list becomes 6->NULL
        dll.append(6);

        // Insert 7 at the beginning. So linked list becomes 7->6->NULL
        dll.push(7);

        // Insert 1 at the beginning. So linked list becomes 1->7->6->NULL
        dll.push(1);

        // Insert 4 at the end. So linked list becomes 1->7->6->4->NULL
        dll.append(4);

        // Insert 8, after 7. So linked list becomes 1->7->8->6->4->NULL
        dll.insertAfter(8, dll.head.next);

        System.out.println("Created DLL is: ");
        dll.print(dll.head);
    }

    public void push(int data) {
        DoublyListNode newNode = new DoublyListNode(data);
        newNode.next = head;
        if (head != null) {
            head.prev = newNode;
        }
        head = newNode;
    }

    public void insertAfter(int data, DoublyListNode prevNode) {
        if (prevNode != null) {
            DoublyListNode nodeToInsert = new DoublyListNode(data);
            nodeToInsert.next = prevNode.next;
            nodeToInsert.prev = prevNode;
            prevNode.next = nodeToInsert;
            if (nodeToInsert.next != null) {
                nodeToInsert.next.prev = nodeToInsert;
            }
        }
    }

    public void append(int data) {
        DoublyListNode nodeToInsert = new DoublyListNode(data);
        if (head == null) {
            head = nodeToInsert;
        } else {
            DoublyListNode node = head;
            while (node.next != null) {
                node = node.next;
            }
            node.next = nodeToInsert;
            nodeToInsert.prev = node;
        }
    }

    public void insertBefore(DoublyListNode node, int data) {
        DoublyListNode nodeToInsert = new DoublyListNode(data);
        if (node.prev != null) {
            node.prev.next = nodeToInsert;
        }
        nodeToInsert.next = node;
        nodeToInsert.prev = node.prev;
        node.prev = nodeToInsert;
    }

    public void print(DoublyListNode node) {
        DoublyListNode last = null;
        System.out.println("Traversal in forward Direction");

        while (node != null) {
            System.out.print(node.getData() + " -> ");
            last = node;
            node = node.next;
        }

        System.out.println("Traversal in reverse direction");

        while (last != null) {
            System.out.print(last.getData() + " <- ");
            last = last.prev;
        }
    }
}