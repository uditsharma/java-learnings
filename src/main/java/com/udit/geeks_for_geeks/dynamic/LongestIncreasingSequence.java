package com.udit.geeks_for_geeks.dynamic;

import java.util.Arrays;

/**
 * @author Udit Sharma.
 * @since 20 Apr, 2018 4:30 PM
 */
public class LongestIncreasingSequence {

    public static void main(String[] args) {
        int A[] = {2, 5, 3, 7, 11, 8, 10, 13, 6};

        int length = new LongestIncreasingSequence().printWithDP(A);
        System.out.println(length);
        new LongestIncreasingSequence().printLCIS(A);

    }

    public int printWithDP(int[] A) {
        if (A == null || A.length == 0) {
            return -1;
        }
        if (A.length == 1) {
            return 1;
        }
        int[] DP = new int[A.length];
        DP[0] = 1;
        int maxLength = -1;
        for (int i = 1; i < A.length; i++) {
            DP[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (DP[i] < DP[j] + 1 && A[j] < A[i]) {
                    DP[i] = DP[j] + 1;
                }
            }
            if (maxLength < DP[i]) {
                maxLength = DP[i];
            }
        }
        return maxLength;
    }

    public int printWithNLogN(int[] A) {
        if (A == null || A.length == 0) {
            return -1;
        }
        if (A.length == 1) {
            return 1;
        }

        int[] S = new int[A.length];
        S[0] = A[0];
        int length = 1;
        for (int i = 1; i < A.length; i++) {
            if (A[i] < S[0]) {
                S[0] = A[i];
            } else if (S[length - 1] < A[i]) {
                S[length++] = A[i];
            } else {
                int index = findIndex(S, 0, length - 1, A[i]);
                S[index] = A[i];
            }
        }
        return length;
    }

    private int findIndex(int[] S, int left, int right, int key) {
        int index = 0;
        while (left < right) {
            int middle = (left + right) / 2;
            index = middle;
            if (key > S[middle]) {
                if (middle + 1 <= right && S[middle + 1] >= key) {
                    return middle + 1;
                } else {
                    left = middle + 1;
                }
            } else {
                if (middle - 1 >= left && S[left] < key) {
                    return middle;
                } else {
                    right = middle - 1;
                }
            }
        }
        return index;
    }

    public void printLCIS(int[] A) {
        int[] C = new int[A.length];
        int[] S = new int[A.length];
        Arrays.fill(C, 0);
        Arrays.fill(S, -1);
        int length = 1;
        for (int i = 1; i < A.length; i++) {
            if (A[i] < A[C[0]]) {
                C[0] = i;
            } else if (A[C[length - 1]] < A[i]) {
                S[i] = C[length - 1];
                C[length++] = i;
            } else {
                int pos = findIndex2(A, C, 0, length - 1, A[i]);
                S[i] = C[pos - 1];
                C[pos] = i;
            }
        }
        for (int i = C[length - 1]; i >= 0; i = S[i]) {
            System.out.print(A[i] + " ,");
        }
    }

    private int findIndex2(int[] A, int[] C, int left, int right, int key) {
        while (left < right) {
            int middle = (left + right) / 2;
            if (key > A[C[middle]]) {
                if (middle + 1 <= right && A[C[middle + 1]] >= key) {
                    return middle + 1;
                } else {
                    left = left + 1;
                }
            } else {
                if (middle - 1 >= left && A[C[middle - 1]] < key) {
                    return middle;
                } else {
                    right = middle - 1;
                }
            }
        }
        return -1;
    }
}
