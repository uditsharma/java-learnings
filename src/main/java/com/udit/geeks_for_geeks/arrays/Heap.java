/* * Copyright 2017 Autodesk, Inc. All Rights Reserved.
 *
 * This computer source code and related instructions and comments 
 * are the unpublished confidential and proprietary information of Autodesk, Inc. 
 * and are protected under applicable copyright and trade secret law.  
 * They may not be disclosed to, copied or used by any third party without the prior 
 * written consent of Autodesk, Inc.
 */

package com.udit.geeks_for_geeks.arrays;

import java.util.Arrays;

/**
 * @author Udit Sharma.
 * @since 11 Jan, 2018 10:09 AM
 */
public class Heap {

    int maxSize = 0;
    int size = 0;
    int[] nodes;

    public Heap(int maxSize) {
        this.maxSize = maxSize;
        this.nodes = new int[maxSize];
        Arrays.fill(nodes, -1);
        this.size = 0;
    }

    public static void main(String[] args) {
    /*Heap heap = new Heap(10);
    heap.insert(33);
    heap.insert(3);
    heap.insert(31);
    heap.insert(12);
    heap.insert(45);

    int size = heap.size;
    for (int i = 0; i < size; i++) {
      System.out.println("heap = " + heap.deleteMin());
    }*/
        int[] arr = {16, 3, 10, 8, 7, 9, 5, 2, 4, 1};
        //new Heap(12).buildHeap(arr);
        new Heap(12).sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public boolean insert(int x) {
        if (size + 1 < maxSize) {
            this.nodes[size] = x;
            int i = size;
            while (i > 0 && nodes[i] < nodes[i / 2]) {
                int temp = nodes[i];
                nodes[i] = nodes[i / 2];
                nodes[i / 2] = temp;
                i = i / 2;
            }
            size++;
            return true;
        }
        return false;
    }

    public int deleteMin() {
        if (size > 0) {
            int min = nodes[0];
            nodes[0] = nodes[size - 1];
            size--;
            int i = 0;
            while (size > 1 && ((2 * i + 1) <= size - 1)) {
                int child = 2 * i + 1;
                if (child < size - 1 && nodes[child] > nodes[child + 1]) {
                    child = child + 1;
                }
                if (nodes[child] < nodes[i]) {
                    int temp = nodes[child];
                    nodes[child] = nodes[i];
                    nodes[i] = temp;
                    i = child;
                } else {
                    break;
                }
            }
            return min;
        }
        return -1;
    }

    public void heapiFy(int[] arr, int i) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int lastIndex = arr.length - 1;
        int min = i;
        if (left <= lastIndex && arr[left] < arr[i]) {
            min = left;
        }
        if (right <= lastIndex && arr[right] < arr[min]) {
            min = right;
        }
        if (min != i) {
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
            heapiFy(arr, min);
        }
    }

    public void maxHeapify(int[] arr, int size, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = left + 1;
        if (left < size && arr[left] > arr[largest]) {
            largest = left;
        }
        if (right < size && arr[right] > arr[largest]) {
            largest = right;
        }
        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            maxHeapify(arr, size, largest);
        }
    }

    public void sort(int[] arr) {
        if (arr != null && arr.length > 1) {
            int length = arr.length;
            for (int i = (length / 2 - 1); i > 0; i--) {
                maxHeapify(arr, length, i);
            }
            for (int i = 0; i < length; i++) {
                int temp = arr[length - (i + 1)];
                arr[length - (i + 1)] = arr[0];
                arr[0] = temp;
                maxHeapify(arr, length - (i + 1), 0);
            }
        }

    }

    public void buildHeap(int arr[]) {
        if (arr != null && arr.length > 1) {
            int length = arr.length;
            for (int i = length / 2; i >= 0; i--) {
                heapiFy(arr, i);
            }
        }
    }
}
