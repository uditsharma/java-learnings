package com.udit.geeks_for_geeks.dynamic;

/**
 * @author Udit Sharma.
 * @since 16 Apr, 2018 11:16 PM
 */
public class CutRod {

    public static void main(String[] args) {
        int[] price = {1, 5, 8, 9, 10, 17, 17, 20, 24, 30};
        int rodLength = 10;
        int i = new CutRod().maxRevenueTopDown(price, rodLength);
        int k = new CutRod().maxRevenueBottomUp(price, rodLength);
        System.out.println(i);
        System.out.println(k);
    }

    public int maxRevenueTopDown(int[] price, int rodLength) {
        int[] revenue = new int[rodLength + 1];
        for (int i = 0; i < rodLength + 1; i++) {
            revenue[i] = -Integer.MAX_VALUE;
        }
        return _maxRevenueTopDown(price, revenue, rodLength);
    }

    private int _maxRevenueTopDown(int[] price, int[] revenue, int rodLength) {
        if (revenue[rodLength] > 0) {
            return revenue[rodLength];
        }
        int rev = 0;
        if (rodLength != 0) {
            rev = -Integer.MAX_VALUE;
            for (int length = 1; length <= rodLength; length++) {
                rev = Math.max(rev, price[length - 1] + _maxRevenueTopDown(price, revenue, rodLength - length));
            }
        }
        revenue[rodLength] = rev;
        return rev;
    }

    public int maxRevenueBottomUp(int[] price, int length) {
        int[] revenue = new int[length + 1];
        revenue[0] = 0;
        int q = 0;
        for (int i = 1; i <= length; i++) {
            q = -Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                q = Math.max(q, price[j] + revenue[i - (j + 1)]);
            }
            revenue[i] = q;
        }
        return revenue[length];
    }
}
