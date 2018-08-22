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
 * @since 12 Jan, 2018 10:21 PM
 */
public class KthLargestElement {
    public static void main(String[] args) {
        int[] arr = {16, 3, 10, 8, 7, 9, 5, 2, 4, 1};

        System.out.println("arr.toString() = " + new KthLargestElement().bubbleSort(arr, 5));
    }

    // you can do by making max heap and getMax ktimes.

    int bubbleSort(int[] arr, int kth) {
        int KthElement = 0;
        if (arr != null && arr.length > 1) {
            int n = arr.length;
            boolean swapped = true;
            int k = 0;
            while (n > 0 && swapped && k < kth) {
                swapped = false;
                for (int i = 0; i < n - 1; i++) {
                    if (arr[i] > arr[i + 1]) {
                        int temp = arr[i];
                        arr[i] = arr[i + 1];
                        arr[i + 1] = temp;
                        swapped = true;
                    }
                    KthElement = arr[n - 1];
                }
                k++;
                n--;
            }
        }
        return KthElement;
    }
}
