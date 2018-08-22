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
 * @since 16 Jan, 2018 9:43 PM
 */
public class LexicographicallySmallestArrayBySwap {

    public static void main(String[] args) {
        int arr[] = {7, 6, 9, 2, 1};
        new LexicographicallySmallestArrayBySwap().find(arr, 4);
        System.out.println("arr.toString() = " + Arrays.toString(arr));
    }

    void find(int[] arr, int k) {
        if (arr != null && arr.length > 1) {
            int size = arr.length;
            for (int i = 0; i < size && k > 0; i++) {
                int pos = i;
                for (int j = i + 1; j < size; j++) {
                    if (j - i > k) {
                        break;
                    }
                    if (arr[j] < arr[pos]) {
                        pos = j;
                    }
                }
                for (int j = pos; j > i; j--) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
                k = k - (pos - 1);
            }
        }
    }
}
