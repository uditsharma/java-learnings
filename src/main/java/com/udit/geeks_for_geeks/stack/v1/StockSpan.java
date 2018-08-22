/* * Copyright 2017 Autodesk, Inc. All Rights Reserved.
 *
 * This computer source code and related instructions and comments 
 * are the unpublished confidential and proprietary information of Autodesk, Inc. 
 * and are protected under applicable copyright and trade secret law.  
 * They may not be disclosed to, copied or used by any third party without the prior 
 * written consent of Autodesk, Inc.
 */

package com.udit.geeks_for_geeks.stack.v1;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author Udit Sharma.
 * @since 20 Feb, 2018 2:46 PM
 */
public class StockSpan {
    public static void main(String[] args) {
        int price[] = {10, 4, 5, 90, 120, 80};
        new StockSpan().bruteForce(price);
        new StockSpan().efficientSpanning(price);
    }

    void bruteForce(int[] arr) {
        if (arr != null && arr.length > 0) {
            int size = arr.length;
            int span[] = new int[size];
            span[0] = 1;
            for (int i = 1; i < size; i++) {
                int j = i;
                int price = arr[i];
                int sum = 0;
                for (; j >= 0 && arr[j] <= price; j--) {
                    sum++;
                }
                span[i] = sum;
            }
            System.out.println(Arrays.toString(span));
        }
    }

    void efficientSpanning(int[] price) {
        if (price != null && price.length > 0) {
            Stack<Integer> stack = new Stack<>();
            stack.push(0);
            int size = price.length;
            int span[] = new int[size];
            span[0] = 1;
            for (int i = 1; i < size; i++) {
                while (!stack.isEmpty() && price[stack.peek()] <= price[i]) {
                    stack.pop();
                }
                int sum = stack.isEmpty() ? i + 1 : i - stack.peek();
                span[i] = sum;
                stack.push(i);
            }
            System.out.println(Arrays.toString(span));
        }
    }
}
