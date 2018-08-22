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
 * @since 16 Feb, 2018 10:03 AM
 */
public class Stack_Using_Array {
    int size;
    int[] arr;
    int curr = -1;

    public Stack_Using_Array(int size) {
        this.size = size;
        arr = new int[size];
    }

    void push(int data) {
        if (size > curr) {
            arr[++curr] = data;
        }
        throw new IndexOutOfBoundsException("Stack is full");
    }

    int peek() {
        if (curr > 0) {
            return arr[curr];
        }
        return -1;
    }

    int pop() {
        if (curr > 0) {
            return arr[curr--];
        }
        return -1;
    }
}
