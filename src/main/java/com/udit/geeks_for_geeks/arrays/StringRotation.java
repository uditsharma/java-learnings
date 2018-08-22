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
 * @since 15 Jan, 2018 2:12 PM
 */
public class StringRotation {
    public static void main(String[] args) {
        String str1 = "AACD";
        String str2 = "ACDA";
        boolean isRotation = new StringRotation().isRotation(str1, str2);
        System.out.println("isRotation = " + isRotation);
    }

    boolean isRotation(String input, String inputToCompare) {
        if (input != null && !input.trim().isEmpty() && inputToCompare != null && !inputToCompare.trim().isEmpty()) {
            String str = input + input;
            return isSubString(str, inputToCompare);
        }
        return false;
    }

    private boolean isSubString(String str, String inputToCompare) {
        char[] inputToCheck = inputToCompare.toCharArray();
        char[] input = str.toCharArray();
        int i = 0, j = 0;
        while (i < (str.length()) && j < inputToCompare.length()) {
            if (input[i] == inputToCheck[j]) {
                j++;
            } else if (input[i] == inputToCheck[0]) {
                j = 1;
            }
            i++;
        }
        return j == inputToCompare.length();
    }


}
