package com.udit.geeks_for_geeks.arrays;

import java.util.Scanner;

/**
 * @author Udit Sharma.
 * @since 10 Apr, 2018 11:38 PM
 */
public class MaxTipCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberOfTestCases = sc.nextInt();
        for (int i = 0; i < numberOfTestCases; i++) {
            int numberOfOrder = sc.nextInt();
            int maxOrderForRahul = sc.nextInt();
            int maxOrderForAnkit = sc.nextInt();
            int[] rahulsTip = new int[numberOfOrder];
            int[] ankitsTip = new int[numberOfOrder];
            for (int k = 0; k < numberOfOrder; k++) {
                rahulsTip[k] = sc.nextInt();
            }
            for (int k = 0; k < numberOfOrder; k++) {
                ankitsTip[k] = sc.nextInt();
            }
            int maxTipCollected = 0, rahuCurrentOrder = 0, ankitCurrentOrder = 0;
            for (int k = 0; k < numberOfOrder; k++) {
                if (rahulsTip[k] >= ankitsTip[k] && rahuCurrentOrder != maxOrderForRahul) {
                    maxTipCollected = maxTipCollected + rahulsTip[k];
                    rahuCurrentOrder++;
                } else if (ankitCurrentOrder != maxOrderForAnkit) {
                    maxTipCollected = maxTipCollected + ankitsTip[k];
                    ankitCurrentOrder++;
                }
            }
            System.out.println(maxTipCollected);
        }
    }
}
