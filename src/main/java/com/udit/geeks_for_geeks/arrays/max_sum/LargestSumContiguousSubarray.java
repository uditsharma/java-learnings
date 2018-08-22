package com.udit.geeks_for_geeks.arrays.max_sum;

/**
 * @author Udit Sharma.
 * @since 09 Apr, 2018 2:38 PM
 */
public class LargestSumContiguousSubarray {
    public static void main(String[] args) {
        int[] input = {-2, -3, -4, -1, -2, -1, -5, -3};
        int maxSum = 0, maxSumEndingHere = 0;
        for (int i = 0; i < input.length; i++) {
            maxSumEndingHere = maxSumEndingHere + input[i];
            if (maxSumEndingHere < 0) {
                maxSumEndingHere = 0;
            } else if (maxSumEndingHere > maxSum) {
                maxSum = maxSumEndingHere;
            }
        }

        System.out.println("maxSum = " + maxSum);
    }
}
