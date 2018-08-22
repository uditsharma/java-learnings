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
 * @since 20 Feb, 2018 11:03 PM
 */
public class NextGreaterElement {
    public static void main(String[] args) {
        int arr[] = {4, 5, 2, 25};

        new NextGreaterElement().printNGE(arr);
    }

    void printNGE(int[] arr) {
        if (arr != null && arr.length > 0) {
            Stack<Integer> stack = new Stack<>();
            stack.push(arr[0]);
            for (int i = 1; i < arr.length; i++) {
                int next = arr[i];
                while (!stack.isEmpty() && stack.peek() < next) {
                    System.out.println(stack.pop() + " ----> " + next);
                }
                stack.push(next);
            }
            while (!stack.isEmpty()) {
                System.out.println(stack.pop() + " ----> -1");

            }
        }
    }
}
