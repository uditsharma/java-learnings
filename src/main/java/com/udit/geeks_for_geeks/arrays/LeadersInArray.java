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
 * @since 08 Jan, 2018 8:29 PM
 */
public class LeadersInArray {
    public static void main(String[] args) {
        int arr[] = {16, 17, 4, 3, 5, 2};
        new LeadersInArray().leaders(arr);
    }

    // Leader = if it is greater then all the element from it's right.
    void findLeaders(int arr[]) {
        if (arr != null && arr.length > 0) {
            int size = arr.length;
            for (int i = 0; i < size; i++) {
                boolean isLeader = true;
                for (int k = i; k < size && isLeader; k++) {
                    isLeader = arr[i] > arr[k];
                }
                if (isLeader) {
                    System.out.println(arr[i]);
                }
            }
        }
    }

    //O(n)
    private void leaders(int[] arr) {
        if (arr != null) {
            int size = arr.length;
            int max = 0;
            for (int k = size - 1; k >= 0; k--) {
                if (arr[k] > max) {
                    max = arr[k];
                    System.out.println(max);
                }
            }
        }
    }
}
