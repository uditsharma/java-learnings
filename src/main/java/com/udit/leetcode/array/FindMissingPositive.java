package com.udit.leetcode.array;

public class FindMissingPositive {

    public int firstMissingPositive(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] == i + 1 || (nums[i] > nums.length) || nums[i] <= 0) {
                i++;
            } else if (nums[i] != nums[nums[i] - 1]) {
                int temp = nums[i];
                nums[i] = nums[temp-1];
                nums[temp-1] = temp;
            } else {
                i++;
            }
        }
        i = 0;
        while (i < nums.length && nums[i] == i + 1) {
            i++;
        }
        return i + 1;
    }

    public static void main(String[] args) {
        int[]A = {3,4,-1,1};
        int i = new FindMissingPositive().firstMissingPositive(A);
        System.out.println("i = " + i);
    }

}
