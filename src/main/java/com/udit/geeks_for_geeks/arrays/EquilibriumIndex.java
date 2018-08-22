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
 * @since 13 Jan, 2018 5:27 PM
 */
public class EquilibriumIndex {
    public static void main(String[] args) {
        EquilibriumIndex equi = new EquilibriumIndex();
        int arr[] = {-7, 1, 5, 2, -4, 3, 0};
        int arr_size = arr.length;
        System.out.println(equi.equilibrium(arr));
    }

    /**
     * @see <a href="https://www.geeksforgeeks.org/equilibrium-index-of-an-array/"></a>
     */
    int equilibrium(int[] arr) {
        if (arr != null && arr.length > 2) {
            int size = arr.length, totalSum = 0;
            for (int i = 0; i < size; i++) {
                totalSum = totalSum + arr[i];
            }
            int leftSum = 0;
            for (int i = 1; i < size - 1; i++) {
                leftSum = arr[i - 1] + leftSum;
                int rightSum = totalSum - leftSum - arr[i];
                if (rightSum == leftSum) {
                    return i;
                }
            }
        }
        return -1;
    }
}
