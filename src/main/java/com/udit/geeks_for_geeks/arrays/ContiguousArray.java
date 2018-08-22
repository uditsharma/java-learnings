package com.udit.geeks_for_geeks.arrays;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Udit Sharma.
 * @since 10 Apr, 2018 1:43 AM
 */
public class ContiguousArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberOfTesCases = sc.nextInt();
        for (int i = 0; i < numberOfTesCases; i++) {
            int inputSize = sc.nextInt();
            int[] input = new int[inputSize];
            for (int j = 0; j < inputSize; j++) {
                input[j] = sc.nextInt();
            }
            Arrays.sort(input);
            boolean isContiguous = true;
            for (int j = 0; j < inputSize - 1; j++) {
                if (!(input[j] == input[j + 1] || input[j] + 1 == input[j + 1])) {
                    isContiguous = false;
                    break;
                }
            }
            System.out.println(isContiguous ? "Yes" : "No");
        }
    }
}
