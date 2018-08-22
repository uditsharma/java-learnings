package com.udit.geeks_for_geeks.arrays.max_sum;

/**
 * @author Udit Sharma.
 * @since 16 Apr, 2018 9:55 PM
 */
public class MaxSumDivisibleByK {
    public static void main(String[] args) {
        int A[] = {2, 7, 6, 1, 4, 5};
        int K = 3;
        int maxSum = 0, maxSumSoFar = 0;
        for (int i = 0; i < A.length; i++) {
            maxSumSoFar = maxSumSoFar + A[i];
            if (maxSumSoFar < 0) {
                maxSumSoFar = 0;
            } else if (maxSum < maxSumSoFar) {
                if (maxSumSoFar % K == 0) {
                    maxSum = maxSumSoFar;
                }
            }
        }
        System.out.println("maxSum = " + maxSum);
    }
}
