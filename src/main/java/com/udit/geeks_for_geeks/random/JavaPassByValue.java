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
 * @since 24 Feb, 2018 4:20 PM
 */
public class JavaPassByValue {
    public static void main(String[] args) {

        Balloon red = new Balloon("Red"); //memory reference 50
        Balloon blue = new Balloon("Blue"); //memory reference 100

        swap(red, blue);
        System.out.println("red color=" + red.getColor());
        System.out.println("blue color=" + blue.getColor());

        foo(blue);
        System.out.println("blue color=" + blue.getColor());

    }

    private static void foo(Balloon balloon) { //baloon=100
        balloon.setColor("Red"); //baloon=100
        balloon = new Balloon("Green"); //baloon=200
        balloon.setColor("Blue"); //baloon = 200
    }

    //Generic swap method
    public static void swap(Object o1, Object o2) {
        Object temp = o1;
        o1 = o2;
        o2 = temp;
    }
}
