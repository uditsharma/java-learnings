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
 * @since 29 Jan, 2018 10:44 PM
 */
public class SwapNodesInLinkedList {
    LinkedList linkedList = new LinkedList();

    public static void main(String[] args) {

        SwapNodesInLinkedList swapNodesInLinkedList = new SwapNodesInLinkedList();
        swapNodesInLinkedList.linkedList.append(10);
        swapNodesInLinkedList.linkedList.append(15);
        swapNodesInLinkedList.linkedList.append(12);
        swapNodesInLinkedList.linkedList.append(13);
        swapNodesInLinkedList.linkedList.append(20);
        swapNodesInLinkedList.linkedList.append(4);

        swapNodesInLinkedList.linkedList.printList();

        swapNodesInLinkedList.swap(10, 13);
        System.out.println();
        swapNodesInLinkedList.linkedList.printList();
    }

    void swap(int key1, int key2) {
        Node head = linkedList.head;
        if (head != null) {
            Node nodeKey1 = head, prevKey1 = null;
            while (nodeKey1 != null && nodeKey1.data != key1) {
                prevKey1 = nodeKey1;
                nodeKey1 = nodeKey1.next;
            }
            Node nodeKey2 = head, prevKey2 = null;
            while (nodeKey2 != null && nodeKey2.data != key2) {
                prevKey2 = nodeKey2;
                nodeKey2 = nodeKey2.next;
            }
            if (nodeKey1 != null && nodeKey2 != null) {
                if (prevKey1 != null) {
                    prevKey1.next = nodeKey2;
                } else {
                    linkedList.head = nodeKey2;
                }
                if (prevKey2 != null) {
                    prevKey2.next = nodeKey1;
                } else {
                    linkedList.head = nodeKey1;
                }
                Node temp = nodeKey2.next;
                nodeKey2.next = nodeKey1.next;
                nodeKey1.next = temp;
            }
        }
    }
}
