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
 * @since 14 Jan, 2018 3:13 PM
 */
public class QuickSort {

    public static void main(String[] args) {
        int arr1[] = {10, 7, 8, 9, 1, 5};
        int arr2[] = {10, 7, 8, 9, 1, 5};
        int arr3[] = {10, 7, 8, 9, 1, 5};
        int n = arr1.length;

        QuickSort ob = new QuickSort();
        ob.quickSort1(arr1, 0, n - 1);
        ob.quickSort2(arr2, 0, n - 1);
        ob.quickSort3(arr3, 0, n - 1);

        System.out.println("sorted array");
        ob.printArray(arr1);
        ob.printArray(arr2);
        ob.printArray(arr3);
    }

    public void quickSort2(int[] arr, int start, int end) {
        while (start < end) {
            int pivotIndex = partition(arr, start, end);
            quickSort2(arr, start, pivotIndex - 1);
            start = start + 1;
        }
    }

    public void quickSort3(int[] arr, int low, int high) {
        while (low < high) {
            int pi = partition(arr, low, high);
            if (pi - low > high - pi) {
                quickSort3(arr, pi + 1, high);
                high = pi - 1;
            } else {
                quickSort3(arr, low, pi - 1);
                low = pi + 1;
            }
        }
    }

    public void quickSort1(int[] arr, int start, int end) {
        if (start < end) {
            int pivotIndex = partition(arr, start, end);
            quickSort1(arr, start, pivotIndex - 1);
            quickSort1(arr, pivotIndex + 1, end);
        }
    }

    private int partition(int[] arr, int start, int end) {
        int i = start - 1;
        int x = arr[end];
        for (int j = start; j < end; j++) {
            if (arr[j] <= x) {
                i++;
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        //swap arr[end] with arr[i+1] ;
        int temp = arr[end];
        arr[end] = arr[i + 1];
        arr[i + 1] = temp;
        return i + 1;
    }

    void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
