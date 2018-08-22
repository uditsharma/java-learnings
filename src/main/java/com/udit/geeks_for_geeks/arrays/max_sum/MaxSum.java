/* * Copyright 2017 Autodesk, Inc. All Rights Reserved.
 *
 * This computer source code and related instructions and comments 
 * are the unpublished confidential and proprietary information of Autodesk, Inc. 
 * and are protected under applicable copyright and trade secret law.  
 * They may not be disclosed to, copied or used by any third party without the prior 
 * written consent of Autodesk, Inc.
 */

package com.udit.geeks_for_geeks.arrays.max_sum;

/**
 * @author Udit Sharma.
 * @since 17 Jan, 2018 7:28 AM
 */
public class MaxSum {
    public static void main(String[] args) {
        int arr[] = new int[]{10, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int i = new MaxSum().find(arr);
        System.out.println("i = " + i);
    }

    int find(int[] arr) {
        int maxSum = 0;
        if (arr != null) {
            int length = arr.length;
            int max = arr[0], pos = 0;
            for (int i = 1; i < length; i++) {
                if (arr[i] > max) {
                    max = arr[i];
                    pos = i;
                }
            }
            int rotations = length - (pos + 1);
            for (int i = 0; i < length; i++) {
                int index = (i + rotations) % length;
                maxSum = maxSum + index * arr[i];
            }
        }
        return maxSum;
    }
}
