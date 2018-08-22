package com.udit.geeks_for_geeks.dynamic;

import java.util.Arrays;

/**
 * @author Udit Sharma.
 * @since 26 Apr, 2018 12:07 PM
 */
public class EggDrop {

    public static void main(String[] args) {
        int trial = new EggDrop().eggDrop(2, 10);

        System.out.println(trial);
    }

    public int eggDrop(int eggs, int floors) {
        int[][] trials = new int[eggs + 1][floors + 1];

        for (int i = 0; i <= eggs; i++) {
            Arrays.fill(trials[i], -1);
        }

        for (int i = 1; i <= eggs; i++) {

            trials[i][0] = 0;
            trials[i][1] = 1;
        }

        for (int i = 1; i <= floors; i++) {
            trials[1][i] = i;
            trials[0][i] = 0;
        }
        return eggDrop(eggs, floors, trials);
    }

    public int eggDrop(int eggs, int floors, int[][] trials) {
        if (trials[eggs][floors] != -1) {
            return trials[eggs][floors];
        }

        int min = Integer.MAX_VALUE;
        int res;
        for (int k = 1; k <= floors; k++) {
            res = Math.max(eggDrop(eggs - 1, k - 1, trials), eggDrop(eggs, floors - k, trials));
            if (res < min) {
                min = res;
            }
        }
        trials[eggs][floors] = min + 1;
        return min + 1;
    }
}
