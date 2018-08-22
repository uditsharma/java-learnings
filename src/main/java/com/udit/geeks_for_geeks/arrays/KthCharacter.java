package com.udit.geeks_for_geeks.arrays;

import java.util.Scanner;

/**
 * @author Udit Sharma.
 * @since 10 Apr, 2018 9:26 PM
 * <p>
 * https://practice.geeksforgeeks.org/problems/find-k-th-character-in-string/0
 */
public class KthCharacter {

    public static String convertToBinary(int number) {
        StringBuilder binaryString = new StringBuilder();
        while (number > 1) {
            int remainder = number % 2;
            number = number / 2;
            binaryString.insert(0, remainder);
        }
        binaryString.insert(0, number);
        return binaryString.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfTestCases = scanner.nextInt();
        for (int i = 0; i < numberOfTestCases; i++) {
            int number = scanner.nextInt();
            int kthChar = scanner.nextInt();
            int numberOfIteration = scanner.nextInt();
            int powerOf2 = (int) Math.pow(2, numberOfIteration);
            int lengthOfDigitsInterested = (int) Math.ceil((float) kthChar / powerOf2);
            String binary = convertToBinary(number);
            String digitsInterested = binary.substring(0, lengthOfDigitsInterested);
            for (int j = 0; j < numberOfIteration; j++) {
                StringBuilder builder = new StringBuilder();
                for (char ch : digitsInterested.toCharArray()) {
                    if (ch == '0') {
                        builder.append("01");
                    } else {
                        builder.append("10");
                    }
                }
                digitsInterested = builder.toString();
            }
            System.out.println(digitsInterested.charAt(kthChar));
        }
    }
}
