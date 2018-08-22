package com.udit.geeks_for_geeks.arrays;

/**
 * @author Udit Sharma.
 * @since 03 Jan, 2018 11:30 PM
 */

import java.util.HashSet;
import java.util.Set;

class ArrayRotation {
    public static void main(String[] args) {
    }

    void rotate(int[] arr, int d) {
        if (arr != null && arr.length > 0) {
            int size = arr.length;
            Set<Integer> visitedIndex = new HashSet<>();
            int index = 0;
            int prevValue = arr[index];
            while (!visitedIndex.contains(index)) {
                int targetedIndex = (index + d) % (size);
                prevValue = arr[targetedIndex];
                arr[targetedIndex] = arr[index];
                index = targetedIndex;
            }
        }
    }

    public void juglingAlgoToRotate(int[] arr, int d) {
        if (arr != null && arr.length > 0) {
            int size = arr.length, j, k, temp;
            if (d > size) {
                d = d % size;
            }
            int gcd = gcd(size, d);
            for (int i = 0; i < d; i++) {
                j = i;
                temp = arr[i];
                while (true) {
                    k = j + d;
                    if (k >= size) {
                        k = k - size;
                    }
                    if (k == i) {
                        break;
                    }
                    arr[j] = arr[k];
                    j = k;
                }
                arr[j] = temp;
            }
        }
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }

    void leftRotateReverseAlgo(int[] arr, int d) {
        if (arr != null && arr.length > 1) {
            int size = arr.length;
            if (d > 0 && (d % size != 0)) {
                d = d % size;
                reverse(arr, 0, d - 1);
                reverse(arr, d, size - 1);
                reverse(arr, 0, size - 1);
            }
        }
    }

    void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    void printArray(int arr[]) {
        if (arr != null && arr.length > 0) {
            int size = arr.length;
            for (int anArr : arr) {
                System.out.print(anArr + " ");
            }
        }
    }

    public void rotateArr(Integer[] arr, int k) {
        if (k >= arr.length) {
            k -= arr.length;
        }
        if (arr == null || arr.length < 2 || k == 0) {
            return;
        }
        rotateArr(arr, k, arr.length);
    }

    private void rotateArr(Integer[] arr, int k, int n) {
        if (n <= 0) {
            return;
        }
        int cur = arr[--n];
        k = (arr.length + k - 1) % arr.length;
        rotateArr(arr, k, n);
        arr[k] = cur;
    }
}