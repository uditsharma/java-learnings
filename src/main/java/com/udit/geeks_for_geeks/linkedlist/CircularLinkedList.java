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
 * @since 28 Jan, 2018 1:16 PM
 */
public class CircularLinkedList {
    private Node head;

    public void push(int data) {
        Node node = new Node(data);
        if (head == null) {
            head = node;
            node.next = head;
        } else {
            Node curr = head;
            while (curr.next != head) {
                curr = curr.next;
            }
            node.next = head;
            head = node;
            curr.next = head;
        }
    }

    public void append(int data) {
        Node node = new Node(data);
        if (head == null) {
            head = node;
            node.next = head;
        } else {
            Node curr = head;
            while (curr.next != head) {
                curr = curr.next;
            }
            node.next = head;
            curr.next = node;
        }
    }

}
