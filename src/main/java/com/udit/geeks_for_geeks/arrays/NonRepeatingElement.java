package com.udit.geeks_for_geeks.arrays;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author Udit Sharma.
 * @since 10 Apr, 2018 1:55 AM
 */
public class NonRepeatingElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberOfTesCases = sc.nextInt();
        for (int i = 0; i < numberOfTesCases; i++) {
            int inputSize = sc.nextInt();
            int[] input = new int[inputSize];
            for (int j = 0; j < inputSize; j++) {
                input[j] = sc.nextInt();
            }
            Set<Integer> set = new LinkedHashSet<>();
            for (int j = 0; j < inputSize; j++) {
                int data = input[j];
                boolean add = set.add(data);
                if (!add) {
                    set.remove(data);
                }
            }
            System.out.println(set.isEmpty() ? 0 : set.iterator().next());
        }
    }
}
