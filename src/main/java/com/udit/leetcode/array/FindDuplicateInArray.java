package com.udit.leetcode.array;

import java.util.Arrays;

//https://leetcode.com/problems/find-the-duplicate-number
public class FindDuplicateInArray {
    //Complexity Analyses :-> nlogn to sort + o(n)
    int find(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return nums[i];
            }
        }
        return -1;
    }

    int find2(int[] A) {
        int hair = A[0], tortoise = A[0];
        do {
            hair = A[A[hair]];
            tortoise = A[tortoise];
        } while (hair != tortoise);
        int ptr1 = tortoise;
        int ptr2 = A[0];
        while (ptr1 != ptr2) {
            ptr1 = A[ptr1];
            ptr2 = A[ptr2];
        }
        return ptr1;
    }

    public static void main(String[] args) {
     int[] A = {1,2,3,4,5,5};
        int i = new FindDuplicateInArray().find2(A);
        System.out.println("i = " + i);
    }
}
