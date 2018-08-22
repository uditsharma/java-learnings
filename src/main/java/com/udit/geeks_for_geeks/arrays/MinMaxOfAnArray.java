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
 * @since 10 Jan, 2018 4:37 PM
 */
public class MinMaxOfAnArray {

    public static void main(String[] args) {
        int arr[] = {1000, 11, 445, 1, 330, 3000};
        MinMax minMaxOfArray = new MinMaxOfAnArray().getMinMaxOfArray(arr);
        if (minMaxOfArray != null) {
            System.out.println("minMaxOfArray.min = " + minMaxOfArray.min);
            System.out.println("minMaxOfArray.max = " + minMaxOfArray.max);
        }

        MinMax minMaxOfArray2 = new MinMaxOfAnArray().getMinMaxByTournamentMethod(arr, 0, arr.length - 1);
        if (minMaxOfArray2 != null) {
            System.out.println("minMaxOfArray.min = " + minMaxOfArray2.min);
            System.out.println("minMaxOfArray.max = " + minMaxOfArray2.max);
        }
    }

    public MinMax getMinMaxOfArray(int arr[]) {
        if (arr != null) {
            int size = arr.length;
            MinMax minMax = new MinMax();
            if (size == 1) {
                minMax.min = arr[0];
                minMax.max = arr[0];
            }
            if (arr[0] > arr[1]) {
                minMax.max = arr[0];
                minMax.min = arr[1];
            }
            if (size > 2) {
                for (int i = 2; i < size; i++) {
                    if (arr[i] < minMax.min) {
                        minMax.min = arr[i];
                    } else if (arr[i] > minMax.max) {
                        minMax.max = arr[i];
                    }
                }
            }
            return minMax;
        }
        return null;
    }

    public MinMax getMinMaxByTournamentMethod(int[] arr, int start, int end) {
        MinMax minMax = new MinMax();
        if (end - start >= 0) {
            if (end - start > 1) {
                int mid = (start + end) / 2;
                MinMax minMax1 = getMinMaxByTournamentMethod(arr, start, mid);
                MinMax minMax2 = getMinMaxByTournamentMethod(arr, mid + 1, end);
                minMax.min = (minMax1.min < minMax2.min) ? minMax1.min : minMax2.min;
                minMax.max = (minMax1.max > minMax2.max) ? minMax1.max : minMax2.max;
            } else if (end - start == 0) {
                minMax.min = arr[start];
                minMax.max = arr[start];
            } else if (arr[start] > arr[start + 1]) {
                minMax.max = arr[start];
                minMax.min = arr[start + 1];
            } else {
                minMax.max = arr[start + 1];
                minMax.min = arr[start];
            }
        }
        return minMax;
    }

    public MinMax findMinMaxByComparingInPair(int[] arr) {
        return null;
    }

    class MinMax {
        int min;
        int max;
    }
}
