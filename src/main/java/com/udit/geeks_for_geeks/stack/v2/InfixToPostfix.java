package com.udit.geeks_for_geeks.stack.v2;

import java.util.Stack;

public class InfixToPostfix {

    public static void main(String[] args) {
        String postFix = new InfixToPostfix().convert("A + B * C - D / E");
        String postFix1 = new InfixToPostfix().convert("A * B - ( C - D ) + E");
        System.out.println("postFix = " + postFix);
        System.out.println("postFix1 = " + postFix1);
    }

    public String convert(String expr) {
        if (expr != null && !expr.trim().isEmpty()) {
            StringBuilder builder = new StringBuilder();
            Stack<Character> operands = new Stack<>();
            char[] input = expr.toCharArray();
            for (char ch : input) {
                if (!Character.isWhitespace(ch)) {
                    if (Character.isLetterOrDigit(ch)) {
                        builder.append(ch);
                    } else if ('(' == ch) {
                        operands.push(ch);
                    } else if (')' == ch) {
                        while (!operands.isEmpty() && !(operands.peek() == '(')) {
                            builder.append(operands.pop());
                        }
                        if (operands.isEmpty()) {
                            throw new IllegalArgumentException("Invalid Expression " + expr);
                        } else {
                            operands.pop();
                        }
                    } else {
                        while (!operands.empty() && operands.peek() != '(' && (precedence(ch) <= precedence(operands.peek()))) {
                            builder.append(operands.pop());
                        }
                        operands.push(ch);
                    }
                }
            }
            while (!operands.isEmpty()) {
                builder.append(operands.pop());
            }
            return builder.toString();
        }
        return null;
    }

    public int precedence(char ch) {
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

}
