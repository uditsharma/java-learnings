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
 * @since 16 Jan, 2018 11:10 PM
 */
public class LexoSmallestByRotation {
    public static void main(String[] args) {
        String S = "DCACBCAA";
        int n = 8;
        int print = new LexoSmallestByRotation().print(S.toCharArray());
        for (int i = 0; i < n; i++) {
            System.out.print(S.charAt(print) + " , ");
            print = (print + 1) % n;

        }
    }

    int print(char[] str) {
        int min = 0;
        if (str != null && str.length > 1) {
            int size = str.length;
            for (int i = 1; i < size; i++) {
                if (isSmallest(str, min, i)) {
                    min = i;
                }
            }
        }
        return min;
    }

    boolean isSmallest(char[] str, int x, int y) {
        int length = str.length;
        for (int i = 0; i < length; i++) {
            if (str[x] < str[y]) {
                return false;
            } else if (str[x] > str[y]) {
                return true;
            }
            x = (x + 1) % length;
            y = (y + 1) % length;
        }
        return false;
    }
}
