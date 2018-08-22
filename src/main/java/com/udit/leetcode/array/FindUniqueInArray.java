package com.udit.leetcode.array;

//https://leetcode.com/problems/single-number
public class FindUniqueInArray {
    int findSingleNumber1(int A[]) {
        int value = 0;
        for (int a : A) {
            value = value ^ a;
        }
        return value;
    }

    int findSingleNumber2(int[] A) {
        int oldValue = A[0], sum = 0, sumToReduce = 0, value = 0;
        for (int a : A) {
            sum = sum + a;
            value = value ^ a;
            if (value < oldValue) {
                sumToReduce = sumToReduce + 3 * a;
            }
            oldValue = value;
        }
        return sum - sumToReduce;
    }

    public static void main(String[] args) {
        int[] A = {2,2,3,2};
        int i = new FindUniqueInArray().findSingleNumber2(A);
        System.out.println("i = " + i);
    }
}
