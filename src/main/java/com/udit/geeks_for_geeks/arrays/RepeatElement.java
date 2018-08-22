/* * Copyright 2017 Autodesk, Inc. All Rights Reserved.
 *
 * This computer source code and related instructions and comments 
 * are the unpublished confidential and proprietary information of Autodesk, Inc. 
 * and are protected under applicable copyright and trade secret law.  
 * They may not be disclosed to, copied or used by any third party without the prior 
 * written consent of Autodesk, Inc.
 */

package com.udit.geeks_for_geeks.arrays;

import static java.lang.Math.abs;

/**
 * @author Udit Sharma.
 * @since 13 Jan, 2018 4:12 PM
 */
public class RepeatElement {

    public static void main(String[] args) {
        RepeatElement repeat = new RepeatElement();
        int arr[] = {4, 2, 4, 5, 2, 3, 1};
        int arr_size = arr.length;
        repeat.printDuplicates(arr);
        repeat.printDuplicate2(arr);
    }

    /**
     * @see <a href="https://www.geeksforgeeks.org/find-the-two-repeating-elements-in-a-given-array/"></a>
     */
    void printDuplicates(int[] arr) {
        if (arr != null && arr.length > 1) {
            int size = arr.length;
            int sumOfArray = 0, prodOfArray = 1;
            for (int i = 0; i < size; i++) {
                sumOfArray = sumOfArray + arr[i];
                prodOfArray = prodOfArray * arr[i];
            }
            int n = size - 2;
            int factOfN = fact(n);
            int xPlusY = sumOfArray - (n * (n + 1) / 2);
            int prodOfXandY = prodOfArray / factOfN;

            int xMinusY = (int) Math.sqrt((xPlusY * xPlusY) - 4 * prodOfXandY);

            System.out.println(" X = " + (xPlusY + xMinusY) / 2);
            System.out.println(" y = " + (xPlusY - xMinusY) / 2);
        }
    }

    int fact(int n) {
        return (n == 0) ? 1 : n * fact(n - 1);
    }

    void printDuplicate2(int arr[]) {
        if (arr != null && arr.length > 1) {
            int size = arr.length;
            for (int i = 0; i < size; i++) {
                if (arr[abs(arr[i])] > 0) {
                    arr[abs(arr[i])] = -arr[abs(arr[i])];
                } else {
                    System.out.println("arr[i] = " + abs(arr[i]));
                }
            }
        }
    }


}
