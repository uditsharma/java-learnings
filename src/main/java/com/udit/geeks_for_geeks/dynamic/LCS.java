package com.udit.geeks_for_geeks.dynamic;

/**
 * @author Udit Sharma.
 * @since 20 Apr, 2018 5:04 AM
 */
public class LCS {
    public static void main(String[] args) {
        String X = "ABCBDAB";
        String Y = "BDCABA";
        int i = new LCS().printLCSLength(X, Y);
        System.out.println(i);
        int dynamic = new LCS().printLCSDynamic(X, Y);
        System.out.println(dynamic);
    }

    int printLCSLength(String X, String Y) {
        if (X == null || Y == null || X.isEmpty() || Y.isEmpty()) {
            return 0;
        }
        if (X.charAt(0) == Y.charAt(0)) {
            return 1 + printLCSLength(X.substring(1), Y.substring(1));
        } else {
            return Math.max(printLCSLength(X.substring(1), Y), printLCSLength(X, Y.substring(1)));
        }
    }

    int printLCSDynamic(String X, String Y) {
        int m = X.length();
        int n = Y.length();
        int[][] B = new int[m][n];
        int[][] C = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    C[i][j] = 0;
                } else if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                    C[i][j] = C[i - 1][j - 1] + 1;
                } else if (C[i - 1][j] >= C[i][j - 1]) {
                    C[i][j] = C[i - 1][j];
                } else {
                    C[i][j] = C[i][j - 1];
                }
            }
        }
        _print(X, Y, C);
        return C[m][n];
    }

    private void _print(String X, String Y, int[][] C) {
        int i = X.length();
        int j = Y.length();
        int maxLengthOfLcs = C[i][j];
        int temp = maxLengthOfLcs;
        char[] lcs = new char[maxLengthOfLcs];
        while (i > 0 && j > 0) {
            if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                lcs[maxLengthOfLcs - 1] = X.charAt(i - 1);
                i--;
                j--;
                maxLengthOfLcs--;
            } else if (C[i - 1][j] >= C[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }
        System.out.print("LCS of " + X + " and " + Y + " is ");
        for (int k = 0; k < temp; k++)
            System.out.print(lcs[k]);
    }
}
