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
 * @since 15 Jan, 2018 10:43 AM
 */
public class HammingDistanceInArray {
    public static void main(String[] args) {
        int arr[] = {2, 4, 6, 8};
        int maxHammingDistance = new HammingDistanceInArray().maxHammingDistance(arr);
        System.out.println("maxHammingDistance = " + maxHammingDistance);
    }

    int maxHammingDistance(int[] arr) {
        int maxHammingDistance = 0;
        if (arr != null && arr.length > 1) {
            int temp[] = new int[2 * arr.length];
            System.arraycopy(arr, 0, temp, 0, arr.length);
            System.arraycopy(arr, 0, temp, arr.length, arr.length);
            for (int i = 1; i < (arr.length + 1); i++) {
                int tempDistance = 0;
                int k = i;
                for (int j = 0; j < arr.length; j++) {
                    if (arr[j] != temp[k++]) {
                        tempDistance++;
                    }
                }
                maxHammingDistance = Math.max(maxHammingDistance, tempDistance);
            }
        }
        return maxHammingDistance;
    }
}
