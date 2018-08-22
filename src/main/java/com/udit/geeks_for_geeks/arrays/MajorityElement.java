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
 * @since 10 Jan, 2018 4:14 PM
 */
public class MajorityElement {
    public static void main(String[] args) {

    }

    boolean isMajority(int[] arr, int x) {
        if (arr != null) {
            int length = arr.length;
            int nTimes = length / 2;
            int presentTimes = 0;
            for (int anArr : arr) {
                if (anArr == x) {
                    presentTimes++;
                }
            }
            return presentTimes > nTimes;
        }
        return false;
    }
}
