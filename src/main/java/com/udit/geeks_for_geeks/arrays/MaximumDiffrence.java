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
 * @since 13 Jan, 2018 10:11 AM
 */
public class MaximumDiffrence {
    public static void main(String[] args) {
        MaximumDiffrence maxdif = new MaximumDiffrence();
        int arr[] = {1, 2, 90, 10, 110};
        int size = arr.length;
        System.out.println("MaximumDifference is " + maxdif.findMaxDiff(arr));
    }

    /**
     * @see <a hre="https://www.geeksforgeeks.org/maximum-difference-between-two-elements/"> Link</a>
     */

    public int findMaxDiff(int[] arr) {
        if (arr != null && arr.length > 0) {
            int maxDiff = arr[1] - arr[0];
            int min = arr[0];
            int length = arr.length;
            for (int i = 1; i < length; i++) {
                if (arr[i] - min > maxDiff) {
                    maxDiff = arr[i] - min;
                }
                if (arr[i] < min) {
                    min = arr[i];
                }
            }
            return maxDiff;
        }
        return 0;
    }

}
