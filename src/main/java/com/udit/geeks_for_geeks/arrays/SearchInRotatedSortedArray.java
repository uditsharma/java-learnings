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
 * @since 14 Jan, 2018 12:01 PM
 */
public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        int arr1[] = {11, 1, 2, 3, 5, 6, 7, 8, 9, 10};
        SearchInRotatedSortedArray ob = new SearchInRotatedSortedArray();
        int i = ob.pivotIndex(arr1, 0, arr1.length - 1);
        System.out.println("i = " + i);
        int i1 = ob.search1(arr1, 12);
        System.out.println("i1 = " + i1);
        int i2 = ob.search1(arr1, 11);
        System.out.println("i2 = " + i2);
        int i3 = ob.search2(arr1, 0, arr1.length - 1, 1);
        System.out.println("i3 = " + i3);
    }

    int pivotIndex(int[] arr, int start, int end) {
        System.out.println("search in " + start + " , " + end);
        if (end < start) {
            return -1;
        }

        int mid = (start + end) / 2;
        if (mid < end && arr[mid] > arr[mid + 1]) {
            return mid;
        }
        if (mid > start && arr[mid - 1] > arr[mid]) {
            return mid - 1;
        }
        if (arr[start] >= arr[mid]) {
            return pivotIndex(arr, start, mid - 1);
        }
        return pivotIndex(arr, mid + 1, end);
    }

    int search1(int[] arr, int x) {
        int i = pivotIndex(arr, 0, arr.length - 1);
        if (i == -1) {
            return binarySearch(arr, 0, arr.length - 1, x);
        } else {
            if (arr[i] == x) {
                return i;
            }
            if (x >= arr[0]) {
                return binarySearch(arr, 0, i - 1, x);
            } else {
                return binarySearch(arr, i + 1, arr.length - 1, x);
            }
        }
    }

    int binarySearch(int[] arr, int start, int end, int x) {
        if (end > start) {
            int mid = (start + end) / 2;
            if (arr[mid] == x) {
                return mid;
            }
            if (x > arr[mid]) {
                return binarySearch(arr, mid + 1, end, x);
            } else {
                return binarySearch(arr, start, mid - 1, x);
            }
        }
        return -1;
    }

    int search2(int[] arr, int start, int end, int key) {
        if (arr != null) {
            int mid = (start + end) / 2;
            if (arr[mid] == key) {
                return mid;
            }
            if (arr[start] <= arr[mid]) {
                if (key >= arr[start] && key < arr[mid]) {
                    return search2(arr, start, mid - 1, key);
                } else {
                    return search2(arr, mid + 1, end, key);
                }
            } else {
                if (key > arr[mid] && key <= arr[end]) {
                    return search2(arr, mid + 1, end, key);
                } else {
                    return search2(arr, start, mid - 1, key);
                }
            }
        }
        return -1;
    }
}
