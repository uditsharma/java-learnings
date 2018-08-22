package com.udit.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindDuplicate {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> duplicate = new ArrayList<>();
        if (nums != null && nums.length > 0) {
            for (int i = 0; i < nums.length; i++) {
                int index = Math.abs(nums[i]) - 1;
                if (nums[index] < 0) {
                    duplicate.add(index + 1);
                }
                nums[index] = -nums[index];
            }
        }
        return duplicate;
    }

    public static void main(String[] args) {
        int[] A = {7, 3, 2, 7, 8, 2, 3, 1};

        List<Integer> duplicates = new FindDuplicate().findDuplicates(A);
        System.out.println("duplicates.toArray() = " + Arrays.toString(duplicates.toArray()));
    }
}
