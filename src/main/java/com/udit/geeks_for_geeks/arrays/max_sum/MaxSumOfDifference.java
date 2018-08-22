package com.udit.geeks_for_geeks.arrays.max_sum;

import java.util.Arrays;

/**
 * @author Udit Sharma.
 * @since 11 Apr, 2018 9:18 AM
 */
public class MaxSumOfDifference {
    public static void main(String[] args) {
        int a[] = {1, 2, 4, 8};
        Arrays.sort(a);
        int[] b = new int[a.length];
        int size = a.length;
        for (int j = 0, head = 0, tail = size - 1; j < size; j++) {
            if (j % 2 == 0) {
                b[j] = a[head];
                head++;
            } else {
                b[j] = a[tail];
                tail--;
            }
        }
        int maxSum = 0;
        for (int index = 0; index < size - 1; index++) {
            maxSum = maxSum + Math.abs((b[index] - b[index + 1]));
        }
        maxSum = maxSum + Math.abs(b[size - 1] - b[0]);
        System.out.println(maxSum);
    }
}
