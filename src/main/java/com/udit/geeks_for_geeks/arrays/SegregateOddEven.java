/* * Copyright 2017 Autodesk, Inc. All Rights Reserved.
 *
 * This computer source code and related instructions and comments 
 * are the unpublished confidential and proprietary information of Autodesk, Inc. 
 * and are protected under applicable copyright and trade secret law.  
 * They may not be disclosed to, copied or used by any third party without the prior 
 * written consent of Autodesk, Inc.
 */

package com.udit.geeks_for_geeks.arrays;

import java.util.Arrays;

/**
 * @author Udit Sharma.
 * @since 13 Jan, 2018 1:05 PM
 */
public class SegregateOddEven {
    public static void main(String[] args) {
        int arr[] = {12, 34, 45, 9, 8, 90, 3, 2, 3, 4, 6, 6, 6, 6, 6, 6, 6, 8, 199};
        new SegregateOddEven().segregateEvenOdd(arr);
    }

    void segregateEvenOdd(int[] arr) {
        if (arr != null) {
            int size = arr.length;
            int left = 0, right = size - 1;
            while (left < right) {
                if (arr[left] % 2 != 0) {
                    int temp = arr[right];
                    arr[right] = arr[left];
                    arr[left] = temp;
                    right--;
                } else {
                    left++;
                }
            }
            System.out.println("arr = " + Arrays.toString(arr));
        }
    }
}
