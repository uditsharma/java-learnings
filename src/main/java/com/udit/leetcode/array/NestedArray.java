package com.udit.leetcode.array;

public class NestedArray {
    public int arrayNesting(int[] nums) {
        int result = 0;
        if (nums != null && nums.length > 0) {
            int length = nums.length;
            for (int i = 0; i < length; i++) {
                int count = 0;
                int start = nums[i];
                do {
                    start = nums[start];
                    count++;
                } while (start != nums[i]);
                result = Math.max(result, count);
            }
        }
        return result;
    }

    public int betterArrayNesting(int[] nums) {
        int result = 0;
        if (nums != null && nums.length > 0) {
            int length = nums.length;
            boolean[] visited = new boolean[length];
            for (int i = 0; i < length; i++) {
                int count = 0;
                int start = nums[i];
                if (!visited[i]) {
                    do {
                        start = nums[start];
                        count++;
                        visited[start] = true;
                    } while (start != nums[i]);
                    result = Math.max(result, count);
                }
            }
        }
        return result;
    }


    public int arrayNesting2(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int start = nums[i], count = 0;
            do {
                start = nums[start];
                count++;
            }
            while (start != nums[i]);
            res = Math.max(res, count);

        }
        return res;
    }

    public static void main(String[] args) {
        int[] A = new int[]{5, 4, 0, 3, 1, 6, 2};
        NestedArray nestedArray = new NestedArray();
        int i = nestedArray.arrayNesting(A);
        int i1 = nestedArray.arrayNesting2(A);
        int i2 = nestedArray.betterArrayNesting(A);
        System.out.println("i = " + i);
        System.out.println("i1 = " + i1);
        System.out.println("i2 = " + i2);
    }
}
