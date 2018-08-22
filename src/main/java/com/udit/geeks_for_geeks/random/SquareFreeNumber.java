/* * Copyright 2017 Autodesk, Inc. All Rights Reserved.
 *
 * This computer source code and related instructions and comments 
 * are the unpublished confidential and proprietary information of Autodesk, Inc. 
 * and are protected under applicable copyright and trade secret law.  
 * They may not be disclosed to, copied or used by any third party without the prior 
 * written consent of Autodesk, Inc.
 */

package com.udit.geeks_for_geeks.random;

/**
 * @author Udit Sharma.
 * @since 29 Jan, 2018 11:25 PM
 */
public class SquareFreeNumber {

    public static void main(String[] args) {
        boolean squareFree = new SquareFreeNumber().isSquareFree(2310);
        System.out.println("squareFree = " + squareFree);
    }

    boolean isSquareFree(int number) {
        if (number % 2 == 0) {
            number = number / 2;
            if (number % 2 == 0) {
                return false;
            }
        }
        // we are doing i+2 becasue number is odd and it
        for (int i = 3; i < Math.sqrt(number); i = i + 2) {
            if (number % i == 0) {
                number = number / i;
            }
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
