/* * Copyright 2017 Autodesk, Inc. All Rights Reserved.
 *
 * This computer source code and related instructions and comments 
 * are the unpublished confidential and proprietary information of Autodesk, Inc. 
 * and are protected under applicable copyright and trade secret law.  
 * They may not be diclosed to, copied or used by any third party without the prior
 * written consent of Autodesk, Inc.
 */

package com.udit.geeks_for_geeks.arrays;

/**
 * @author Udit Sharma.
 * @since 10 Jan, 2018 12:07 PM
 */
public class CountInversion {
    public static void main(String[] args) {
        int arr[] = new int[]{1, 20, 6, 4, 5};
        int numberOfInversionBruteForce = new CountInversion().countNumberOfInversionBruteForce(arr);
        int numberInversionByMergeSort = new CountInversion().countNumberInversionByMergeSort(arr);
        System.out.println("numberOfInversionBruteForce = " + numberOfInversionBruteForce);
        System.out.println("numberInversionByMergeSort = " + numberInversionByMergeSort);
    }

    private int countNumberOfInversionBruteForce(int[] arr) {
        int numberOfInversion = 0;
        if (arr != null && arr.length > 1) {
            int size = arr.length;
            for (int i = 0; i < size - 1; i++) {
                for (int j = i + 1; j < size; j++) {
                    if (arr[j] < arr[i]) {
                        numberOfInversion++;
                    }
                }
            }
        }
        return numberOfInversion;
    }

    public int countNumberInversionByMergeSort(int[] arr) {
        if (arr != null && arr.length > 0) {
            return mergeSort(arr, new int[arr.length], 0, arr.length - 1);
        }
        return 0;
    }

    private int mergeSort(int arr[], int temp[], int start, int end) {
        int count = 0;
        if (end > start) {
            int mid = (start + end) / 2;
            count = count + mergeSort(arr, temp, start, mid);
            count = count + mergeSort(arr, temp, mid + 1, end);
            count = count + merge(arr, temp, start, mid + 1, end);
        }
        return count;
    }

    private int merge(int[] arr, int[] temp, int start, int mid, int end) {
        int i = start, j = mid, k = start;
        int inversionCount = 0;
        while (i < mid && j <= end) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
                inversionCount = inversionCount + (mid - i);
            }
        }
        if (i == mid) {
            //copy the second array
            while (j <= end) {
                temp[k++] = arr[j++];
            }
        } else {
            while (i < mid) {
                temp[k++] = arr[i++];
            }
        }
        for (i = start; i <= end; i++) {
            arr[i] = temp[i];
        }
        return inversionCount;
    }

    private int inversionInMerge(int[] left, int[] right) {
        int i = 0, j = 0, numberOfInversion = 0;
        while (i < left.length && j < right.length) {
            if (left[i] > right[j]) {
                numberOfInversion++;
                j++;
            } else {
                i++;
            }
        }
        return numberOfInversion;
    }
}
