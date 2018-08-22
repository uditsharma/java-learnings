package com.udit.leetcode.array;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1, maxArea = 0;
        while (left < right) {
            maxArea = Math.max(Math.min(height[left], height[right]) * (right - left), maxArea);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 4, 3};
        int area = new ContainerWithMostWater().maxArea(A);
        System.out.println("area = " + area);
    }
}
