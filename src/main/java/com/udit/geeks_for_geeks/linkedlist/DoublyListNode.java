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
 * @since 28 Jan, 2018 12:16 PM
 */
public class DoublyListNode {
    DoublyListNode next;
    DoublyListNode prev;
    private int data;

    public DoublyListNode(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }
}
