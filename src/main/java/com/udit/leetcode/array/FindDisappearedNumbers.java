package com.udit.leetcode.array;

import java.util.ArrayList;
import java.util.List;

public class FindDisappearedNumbers {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> missingNumbers = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0) {
                nums[index] = -nums[index];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                missingNumbers.add(i + 1);
            }
        }
        return missingNumbers;
    }

    public static void main(String[] args) {
        int[] A = {4,3,2,7,8,2,3,1};
        List<Integer> values = new FindDisappearedNumbers().findDisappearedNumbers(A);
        System.out.println("values = " + values);

    }
}
