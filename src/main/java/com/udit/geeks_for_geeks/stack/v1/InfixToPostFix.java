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
 * @since 20 Feb, 2018 6:44 AM
 */
public class InfixToPostFix {

    public static void main(String[] args) {
        String exp = "a+b*(c^d-e)^(f+g*h)-i";
        System.out.println(new InfixToPostFix().convert(exp));
    }

    // A utility function to return precedence of a given operator
    // Higher returned value means higher precedence
    int Prec(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;

            case '*':
            case '/':
                return 2;

            case '^':
                return 3;
        }
        return -1;
    }

    public String convert(String exp) {
        StringBuilder result = new StringBuilder();
        if (exp != null && exp.length() > 0) {
            Stack<Character> stack = new Stack<>();

            int length = exp.length();
            for (int i = 0; i < length; i++) {
                char ch = exp.charAt(i);
                if (Character.isLetterOrDigit(ch)) {
                    result.append(ch);
                } else if ('(' == ch) {
                    stack.push(ch);
                } else if (')' == ch) {
                    while (!stack.isEmpty() && stack.peek() != '(') {
                        result.append(stack.pop());
                    }
                    if (stack.isEmpty()) {
                        throw new IllegalArgumentException("Invalid Expression");
                    } else {
                        stack.pop();
                    }
                } else {
                    while (!stack.isEmpty() && Prec(stack.peek()) >= Prec(ch)) {
                        result = result.append(stack.pop());
                    }
                    stack.push(ch);
                }
            }
            while (!stack.isEmpty()) {
                result.append(stack.pop());
            }
        }
        return result.toString();
    }
}
