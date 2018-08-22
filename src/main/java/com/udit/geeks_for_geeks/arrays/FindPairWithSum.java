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
 * @since 17 Jan, 2018 10:02 AM
 */
public class FindPairWithSum {
    public static void main(String[] args) {
        int A[] = {1, 4, 45, 6, 10, -8};
        Pair pair = new FindPairWithSum().find(A, 2);
        if (pair != null) {
            System.out.println("Pair [" + pair.start + "], [" + pair.end + "]");
        } else {
            System.out.println(" No Such Pair !! ");
        }
    }

    Pair find(int[] arr, int sum) {
        if (arr != null && arr.length > 1) {
            int size = arr.length;
            sort(arr, 0, size - 1);
            int start = 0, end = size - 1;
            while (start < end) {
                if (arr[start] + arr[end] == sum) {
                    return new Pair(start, end);
                }
                if (arr[end] + arr[start] > sum) {
                    end--;
                } else {
                    start++;
                }
            }
        }
        return null;
    }

    private void sort(int[] arr, int start, int end) {
        if (start < end) {
            int partition = partition(arr, start, end);
            sort(arr, start, partition - 1);
            sort(arr, partition + 1, end);
        }
    }

    private int partition(int[] arr, int start, int end) {
        int pivot = arr[end];
        int i = start - 1;
        for (int j = start; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[end];
        arr[end] = temp;
        return i + 1;
    }

    class Pair {
        private final int start;
        private final int end;

        public Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
