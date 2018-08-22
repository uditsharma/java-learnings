/* * Copyright 2017 Autodesk, Inc. All Rights Reserved.
 *
 * This computer source code and related instructions and comments 
 * are the unpublished confidential and proprietary information of Autodesk, Inc. 
 * and are protected under applicable copyright and trade secret law.  
 * They may not be disclosed to, copied or used by any third party without the prior 
 * written consent of Autodesk, Inc.
 */

package com.udit.geeks_for_geeks.stack.v1;

import java.util.Stack;

/**
 * @author Udit Sharma.
 * @since 26 Feb, 2018 11:02 PM
 */
public class SortStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(4);
        stack.push(3);
        stack.push(1);
        stack.push(2);
        System.out.println("stack = " + stack);
        new SortStack().sort(stack);
        System.out.println("stack = " + stack);
    }

    void sort(Stack<Integer> st) {
        if (!st.isEmpty()) {
            int val = st.pop();
            sort(st);
            insertSortedWay(st, val);
        }
    }

    private void insertSortedWay(Stack<Integer> st, int val) {
        if (st.isEmpty() || st.peek() <= val) {
            st.push(val);
        } else if (st.peek() > val) {
            int data = st.pop();
            insertSortedWay(st, val);
            st.push(data);
        }
    }
}
