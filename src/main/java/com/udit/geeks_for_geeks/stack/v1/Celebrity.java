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
 * @since 21 Feb, 2018 7:26 PM
 */
public class Celebrity {

    int MATRIX[][] = {{0, 0, 1, 0}, {0, 0, 1, 0}, {0, 0, 0, 0}, {0, 0, 1, 0}};

    public static void main(String[] args) {
        int n = 4;
        int result = new Celebrity().findCelebrity(n);
        if (result == -1) {
            System.out.println("No Celebrity");
        } else {
            System.out.println("Celebrity ID " + result);
        }
    }

    // Returns true if a knows b, false otherwise
    boolean knows(int a, int b) {
        boolean res = (MATRIX[a][b] == 1) ? true : false;
        return res;
    }

    int findCelebrity(int n) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            stack.push(i);
        }
        while (stack.size() > 1) {
            int a = stack.pop();
            int b = stack.pop();
            if (knows(a, b)) {
                stack.push(b);
            } else {
                stack.push(a);
            }
        }
        int possibleCelebrity = stack.pop();
        boolean knows = true;
        for (int i = 0; i < n; i++) {
            if (i != possibleCelebrity && knows(possibleCelebrity, i)) {
                knows = false;
            }
        }
        return knows ? possibleCelebrity : -1;
    }
}
