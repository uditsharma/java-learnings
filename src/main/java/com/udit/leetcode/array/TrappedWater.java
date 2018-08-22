package com.udit.leetcode.array;

import java.util.Stack;

import static java.lang.Math.max;
import static java.lang.Math.min;
import static java.lang.Math.nextAfter;

public class TrappedWater {
    void bruteForceMethod(int[] height) {
        int ans = 0;
        int size = height != null ? height.length : 0;

        for (int i = 1; i < size - 1; i++) {
            int max_left = 0, max_right = 0;
            for (int j = i; j >= 0; j--) { //Search the left part for max bar size
                max_left = max(max_left, height[j]);
            }
            for (int j = i; j < size; j++) { //Search the right part for max bar size
                max_right = max(max_right, height[j]);
            }
            ans += min(max_left, max_right) - height[i];
        }
        System.out.println(ans);
    }

    void efficientBruteForce(int[] height) {
        int ans = 0;
        int size = height != null ? height.length : 0;

        if (size > 0) {
            int[] max_left = new int[size];
            int[] max_right = new int[size];
            max_left[0] = height[0];
            for (int i = 1; i < size; i++) {
                max_left[i] = Math.max(max_left[i - 1], height[i]);
            }
            max_right[size - 1] = height[size - 1];
            for (int j = size - 2; j >= 0; j--) {
                max_right[j] = Math.max(max_right[j + 1], height[j]);
            }
            for (int i = 1; i < size - 1; i++) {
                ans += min(max_left[i], max_right[i]) - height[i];
            }
            System.out.println(ans);
        }
    }

    void trappedWater(int[] height) {
        int ans = 0;
        if (height != null && height.length > 2) {
            Stack<Integer> index = new Stack<>();
            int length = height.length;
            for (int rightWall = 0; rightWall < length; rightWall++) {
                while (!index.isEmpty() && height[rightWall] > height[index.peek()]) {
                    int bottomFloor = index.pop();
                    if (index.isEmpty()) {
                        break;
                    }
                    Integer leftWall = index.peek();
                    int distance = rightWall - leftWall - 1;
                    int boundedHeight = Math.min(height[rightWall], height[leftWall]) - height[bottomFloor];
                    ans = ans + distance * boundedHeight;
                }
                index.push(rightWall);
            }
        }
        System.out.println(ans);
    }

    void trappedWaterWithPointer(int[] height) {
        int ans = 0;
        if (height != null && height.length > 2) {
            int left = 0, right = height.length - 1, max_left = 0, max_right = 0;
            while (left < right) {
                if (height[left] < height[right]) {
                    if (height[left] >= max_left) {
                        max_left = height[left];
                    } else {
                        ans = ans + max_left - height[left];
                    }
                    left++;
                } else {
                    if (height[right] >= max_right) {
                        max_right = height[right];
                    } else {
                        ans = ans + max_right - height[right];
                    }
                    right--;
                }
            }
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        int[] heights = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        new TrappedWater().bruteForceMethod(heights);
        new TrappedWater().efficientBruteForce(heights);
        new TrappedWater().trappedWater(heights);
        new TrappedWater().trappedWaterWithPointer(heights);
    }
}
