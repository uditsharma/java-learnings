/* * Copyright 2017 Autodesk, Inc. All Rights Reserved.
 *
 * This computer source code and related instructions and comments 
 * are the unpublished confidential and proprietary information of Autodesk, Inc. 
 * and are protected under applicable copyright and trade secret law.  
 * They may not be disclosed to, copied or used by any third party without the prior 
 * written consent of Autodesk, Inc.
 */

package com.udit.geeks_for_geeks.arrays;

/**
 * @author Udit Sharma.
 * @since 15 Jan, 2018 9:42 PM
 */
public class ElementAtIndexAfterRotation {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};

        // No. of rotations
        int rotations = 2;

        // Ranges according to 0-based indexing
        int[][] ranges = {{0, 2}, {0, 3}};

        int index = 1;
        System.out.println(new ElementAtIndexAfterRotation().find(arr, ranges, index));
    }

    int find(int[] arr, int rotations[][], int index) {
        if (arr != null && arr.length > 1) {
            int rotation = rotations.length;
            for (int i = rotation - 1; i >= 0; i--) {
                int left = rotations[i][0];
                int right = rotations[i][1];
                if (index >= left && index <= right) {
                    if (index == left) {
                        index = right;
                    } else {
                        index--;
                    }
                }
            }
            return arr[index];
        }
        return -1;
    }
}
