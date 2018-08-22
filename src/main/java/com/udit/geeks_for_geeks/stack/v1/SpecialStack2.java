/* * Copyright 2017 Autodesk, Inc. All Rights Reserved.
 *
 * This computer source code and related instructions and comments 
 * are the unpublished confidential and proprietary information of Autodesk, Inc. 
 * and are protected under applicable copyright and trade secret law.  
 * They may not be disclosed to, copied or used by any third party without the prior 
 * written consent of Autodesk, Inc.
 */

package com.udit.geeks_for_geeks.stack.v1;

/**
 * @author Udit Sharma.
 * @since 16 Feb, 2018 11:39 PM
 */
public class SpecialStack2 {
    DLLNode head;
    DLLNode mid;
    int size = 0;

    public static void main(String[] args) {
        SpecialStack2 ob = new SpecialStack2();
        ob.push(11);
        ob.push(22);
        ob.push(33);
        ob.push(44);
        ob.push(55);
        ob.push(66);
        ob.push(77);
        System.out.println("Middle Element is " + ob.findMiddle());
        ob.deleteMiddle();
        System.out.println("Middle Element is " + ob.findMiddle());
        ob.deleteMiddle();
        System.out.println("Middle Element is " + ob.findMiddle());
        ob.deleteMiddle();
        System.out.println("Middle Element is " + ob.findMiddle());
        ob.deleteMiddle();
        System.out.println("Middle Element is " + ob.findMiddle());
        ob.deleteMiddle();
        System.out.println("Middle Element is " + ob.findMiddle());
        ob.deleteMiddle();
    }

    void push(int data) {
        DLLNode node = new DLLNode(data);
        node.next = head;
        size++;
        if (size == 1) {
            mid = node;
        } else {
            head.prev = node;
            if (size % 2 != 0) {
                mid = mid.prev;
            }
        }
        head = node;
    }

    int findMiddle() {
        return mid != null ? mid.data : -1;
    }

    int pop() {
        if (size > 0) {
            int poppedData = head.data;
            head = head.next;
            if (head != null) {
                head.prev = null;
            }
            size--;
            if (size % 2 == 0) {
                mid = mid.next;
            }
            return poppedData;
        }
        return -1;
    }

    void deleteMiddle() {
        if (size > 0) {
            DLLNode prev = mid.prev;
            DLLNode next = mid.next;
            if (prev != null) {
                prev.next = next;
            }
            if (next != null) {
                next.prev = prev;
            }
            size--;
            if (size % 2 == 0) {
                mid = mid.next;
            } else {
                mid = mid.prev;
            }
        }
    }
}
