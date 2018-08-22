/* * Copyright 2017 Autodesk, Inc. All Rights Reserved.
 *
 * This computer source code and related instructions and comments 
 * are the unpublished confidential and proprietary information of Autodesk, Inc. 
 * and are protected under applicable copyright and trade secret law.  
 * They may not be disclosed to, copied or used by any third party without the prior 
 * written consent of Autodesk, Inc.
 */

package com.udit.geeks_for_geeks.arrays;

import java.util.Arrays;

/**
 * @author Udit Sharma.
 * @since 13 Jan, 2018 12:48 PM
 */
public class ProductArray {
    public static void main(String[] args) {
        ProductArray pa = new ProductArray();
        int arr[] = {10, 3, 5, 6, 2};
        int n = arr.length;
        System.out.println("The product array is : ");
        pa.prodArray(arr);
    }

    public void prodArray(int[] arr) {
        if (arr != null) {
            int size = arr.length;
            int[] prod = new int[size];
            int i = 0, temp = 1;
            for (i = 0; i < size; i++) {
                prod[i] = 1;
            }
            for (i = 0; i < size; i++) {
                prod[i] = temp;
                temp = temp * arr[i];
            }
            temp = 1;
            for (i = size - 1; i >= 0; i--) {
                prod[i] = temp * prod[i];
                temp = temp * arr[i];
            }
            System.out.println(Arrays.toString(prod));
        }
    }
}
