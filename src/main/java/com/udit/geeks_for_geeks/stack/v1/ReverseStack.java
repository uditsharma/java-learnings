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
 * @since 26 Feb, 2018 10:51 PM
 */
public class ReverseStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println("stack = " + stack);
        new ReverseStack().reverse(stack);
        System.out.println("stack = " + stack);
    }

    void reverse(Stack<Integer> st) {
        if (!st.isEmpty()) {
            int val = st.pop();
            reverse(st);
            insertAtBottom(st, val);
        }
    }

    private void insertAtBottom(Stack<Integer> st, int val) {
        if (st.isEmpty()) {
            st.push(val);
        } else {
            int data = st.pop();
            insertAtBottom(st, val);
            st.push(data);
        }
    }
}
