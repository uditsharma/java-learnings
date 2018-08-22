package com.udit.geeks_for_geeks.arrays;

/**
 * @author Udit Sharma.
 * @since 09 Apr, 2018 10:19 PM
 */
public class NextIntegerPalindrome {
    public static void main(String[] args) {
        int num[] = {9, 4, 1, 8, 7, 9, 7, 8, 3, 2, 2};
        new NextIntegerPalindrome().findNextPalindrome(num);
    }

    void findNextPalindrome(int[] digits) {
        if (digits != null) {
            int length = digits.length;
            if (all9(digits)) {
                for (int i = 0; i < length + 1; i++) {
                    System.out.print(i == 0 || i == length ? 1 : 0);
                }
            } else {
                int mid = length / 2;
                int left = mid - 1;
                int right = (length % 2 == 0) ? mid : mid + 1;
                while (left >= 0 && digits[left] == digits[right]) {
                    left--;
                    right++;
                }
                boolean incrementMiddleElement = false;
                if (left < 0 || digits[left] < digits[right]) {
                    incrementMiddleElement = true;
                }
                while (left >= 0) {
                    digits[right++] = digits[left--];
                }
                if (incrementMiddleElement) {
                    int carry = 1;
                    if (left % 2 != 0) {
                        digits[mid] = digits[mid] + 1;
                        carry = digits[mid] / 10;
                        digits[mid] = digits[mid] % 10;
                    }
                    left = mid - 1;
                    right = (length % 2 == 0) ? mid : mid + 1;
                    while (left >= 0) {
                        digits[left] = digits[left] + carry;
                        carry = digits[left] / 10;
                        digits[left] = digits[left] % 10;
                        digits[right] = digits[left];
                        left--;
                        right++;
                    }
                }
                System.out.println();
                for (int i = 0; i < digits.length; i++) {
                    System.out.print(digits[i]);
                }
            }
        }
    }

    private boolean all9(int[] digits) {
        for (int digit : digits) {
            if (digit != 9) {
                return false;
            }
        }
        return true;
    }
}
