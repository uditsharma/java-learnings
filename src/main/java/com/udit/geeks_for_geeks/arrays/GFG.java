package com.udit.geeks_for_geeks.arrays;/*package whatever //do not write package name here */

import java.util.Scanner;

class GFG {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numOfCases;
        long inputNum, smallerPal, biggerPal, outputNum, tempPal;
        boolean isOddDigit;
        numOfCases = scan.nextInt();
        for (int i = 0; i < numOfCases; i++) {
            inputNum = scan.nextLong();
            if (String.valueOf(inputNum).length() % 2 == 1) {
                isOddDigit = true;
            } else {
                isOddDigit = false;
            }
            tempPal = getTempPal(inputNum, isOddDigit);

            if (tempPal > inputNum) {
                biggerPal = tempPal;
                smallerPal = getSmallerPal(tempPal, isOddDigit);
            } else if (tempPal < inputNum) {
                biggerPal = getBiggerPal(tempPal, isOddDigit);
                smallerPal = tempPal;
            } else {
                biggerPal = getBiggerPal(tempPal, isOddDigit);
                smallerPal = getSmallerPal(tempPal, isOddDigit);
            }
            if (biggerPal - inputNum < inputNum - smallerPal) {
                outputNum = biggerPal;
            } else {
                outputNum = smallerPal;
            }
            System.out.println(outputNum);
        }
    }

    static long getTempPal(long inputNum, boolean isOddDigit) {
        int inputLength, startIndex, tempLength;
        long tempPal, resultNum;
        String tempString, resultString;
        inputLength = String.valueOf(inputNum).length();
        if (inputLength == 1) {
            resultNum = inputNum;
        } else {
            tempPal = inputNum / ((int) Math.pow(10, inputLength / 2));
            tempString = String.valueOf(tempPal);
            tempLength = tempString.length();
            resultString = tempString;
            if (isOddDigit) {
                startIndex = 1;
            } else {
                startIndex = 0;
            }
            for (int i = startIndex; i < tempLength; i++) {
                resultString += tempString.substring(tempLength - i - 1, tempLength - i);
            }
            resultNum = Long.parseLong(resultString);
        }
        return resultNum;
    }

    static long getSmallerPal(long tempPal, boolean isOddDigit) {
        int halfLength;
        long smallerPal;
        halfLength = String.valueOf(tempPal).length() / 2;
        if (tempPal < 10) {
            smallerPal = tempPal - 1;
        } else if (checkPal(tempPal - 2)) {
            smallerPal = tempPal - 2;
        } else {
            smallerPal = getTempPal(tempPal - ((long) Math.pow(10, halfLength)), isOddDigit);
        }
        return smallerPal;
    }

    static long getBiggerPal(long tempPal, boolean isOddDigit) {
        int halfLength;
        long biggerPal;
        halfLength = String.valueOf(tempPal).length() / 2;
        if (tempPal < 9) {
            biggerPal = tempPal + 1;
        } else if (checkPal(tempPal + 2)) {
            biggerPal = tempPal + 2;
        } else {
            biggerPal = getTempPal(tempPal + ((long) Math.pow(10, halfLength)), isOddDigit);
        }
        return biggerPal;
    }

    static boolean checkPal(long num) {
        boolean isPal = true;
        int length, halfLength;
        String numStr;
        numStr = String.valueOf(num);
        length = numStr.length();
        halfLength = numStr.length() / 2;
        for (int i = 0; i < halfLength; i++) {
            if (numStr.charAt(i) != numStr.charAt(length - i - 1)) {
                isPal = false;
            }
        }
        return isPal;
    }

}