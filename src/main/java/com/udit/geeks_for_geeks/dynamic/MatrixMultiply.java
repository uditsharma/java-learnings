package com.udit.geeks_for_geeks.dynamic;

/**
 * @author Udit Sharma.
 * @since 17 Apr, 2018 11:13 PM
 */
public class MatrixMultiply {

    public static void main(String[] args) {
        int[] p = {30, 35, 15, 5, 10, 20, 25};
        int[] p2 = {5, 10, 3, 12, 5, 50, 6};
        new MatrixMultiply().matrixChainOrder(p, 0, 5);
        new MatrixMultiply().matrixChainOrder(p2, 0, 5);
    }

    int matrixChainOrder(int[] p, int Ai, int Aj) {
        int n = p.length - 1;
        int m[][] = new int[n][n];
        int s[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            m[i][i] = 0;
        }
        for (int length = 2; length <= n; length++) {
            for (int i = 0; i < n - length + 1; i++) {
                int j = i + length - 1;
                m[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int Cij = m[i][k] + m[k + 1][j] + p[i] * p[k + 1] * p[j + 1];
                    if (Cij < m[i][j]) {
                        m[i][j] = Cij;
                        s[i][j] = k;
                    }
                }
            }
        }
        printOptimalSolution(s, Ai, Aj);
        return 0;
    }

    private void printOptimalSolution(int[][] s, int ai, int aj) {
        if (ai == aj) {
            System.out.print("A" + ai);
        } else {
            System.out.print("(");
            printOptimalSolution(s, ai, s[ai][aj]);
            printOptimalSolution(s, s[ai][aj] + 1, aj);
            System.out.print(")");
        }
    }
}
