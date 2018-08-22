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
 * @since 08 Jan, 2018 10:49 AM
 */
public class SticklerThief {
    public static void main(String[] args) {
        int arr[] = {5, 5, 10, 100, 10, 5};
        int moneyToStole = new SticklerThief().moneyToStole(arr);
        System.out.println("moneyToStole = " + moneyToStole);
    }

    int moneyToStole(int[] arr) {
        if (arr != null) {
            int size = arr.length;
            if (size == 1) {
                return arr[0];
            }
            if (size == 2) {
                return Math.max(arr[0], arr[1]);
            }
            int d[] = new int[size];
            d[0] = arr[0];
            d[1] = Math.max(arr[0], arr[1]);
            for (int i = 2; i < size; i++) {
                d[i] = Math.max(arr[i] + d[i - 2], d[i - 1]);
            }
            return d[size - 1];
        }
        return 0;
    }
}
