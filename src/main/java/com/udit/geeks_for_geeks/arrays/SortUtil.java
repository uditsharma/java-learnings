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
 * @since 04 Jan, 2018 9:33 PM
 */
public class SortUtil {
    public static void main(String[] args) {
        int[] a = {1, -90, -98, -9, 89};
        //new SortUtil().selectionSort(a);
        new SortUtil().insertionSort(a);
        System.out.println(Arrays.toString(a));
        //Arrays.sort();
    }

    public void selectionSort(int[] arr) {
        if (arr != null && arr.length > 1) {
            int size = arr.length, i = 0;
            while (i < size) {
                int min = i;
                for (int j = i + 1; j < arr.length; j++) {
                    if (arr[j] < arr[min]) {
                        min = j;
                    }
                }
                int temp = arr[min];
                arr[min] = arr[i];
                arr[i] = temp;
                i++;
            }
        }
    }

    public void insertionSort(int[] arr) {
        if (arr != null && arr.length > 1) {
            int size = arr.length;
            for (int i = 1; i < size; i++) {
                int curr = arr[i];
                int j = i;
                while (j > 0 && curr < arr[j - 1]) {
                    arr[j] = arr[j - 1];
                    j--;
                }
                arr[j] = curr;
            }
        }
    }
}
