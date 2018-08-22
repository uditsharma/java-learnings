package com.udit.geeks_for_geeks.arrays;

import java.util.*;

/**
 * @author Udit Sharma.
 * @since 10 Apr, 2018 10:41 PM
 */
public class PairWithPositiveAndNegative {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberOfTestCases = sc.nextInt();
        for (int i = 0; i < numberOfTestCases; i++) {
            int size = sc.nextInt();
            int arr[] = new int[size];
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int j = 0; j < size; j++) {
                arr[j] = sc.nextInt();
            }
            System.out.println();
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < size; j++) {
                int key = Math.abs(arr[j]);
                Integer val = map.get(key);
                if (val == null) {
                    map.put(key, arr[j]);
                } else {
                    int sum = val + arr[j];
                    if (sum == 0) {
                        list.add(key);
                    }
                }
            }
            Collections.sort(list);
            if (list.isEmpty()) {
                System.out.print(0);
            } else {
                list.forEach(value -> {
                    System.out.print(-value + " " + value + " ");
                });
            }
        }
    }
}
