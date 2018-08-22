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
 * @since 22 Feb, 2018 12:37 AM
 */
public class PostFixEvaluate {

    public static void main(String[] args) {
    /*String exp = "231*+9-";
    System.out.println(new GFG().evaluate(exp));

    Scanner sc = new Scanner(System.in);
    int numberOfTestCase = sc.nextInt();
    for (int i = 0; i < numberOfTestCase; i++) {
      System.out.println(evaluate(sc.next()));

    }*/
    }

    int evaluate(String expr) {
        if (expr != null && !expr.trim().isEmpty()) {
            char[] chars = expr.toCharArray();
            int length = chars.length;
            Stack<Integer> operands = new Stack<>();

            for (int i = 0; i < length; i++) {
                char token = chars[i];
                if (token != ' ') {
                    if (Character.isDigit(token)) {
                        operands.push(token - '0');
                    } else {
                        if (operands.size() > 1) {
                            Integer a = operands.pop();
                            Integer b = operands.pop();
                            int value = op(b, a, token);
                            operands.push(value);
                        } else {
                            throw new IllegalArgumentException("Invalid Postfix expression " + expr);
                        }
                    }
                }
            }
            return operands.pop();
        }
        return -1;
    }

    int op(int a, int b, char op) {
        switch (op) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '/':
                return a / b;
            case '*':
                return a * b;
        }
        throw new IllegalArgumentException("Invalid Operator " + op);
    }

}
