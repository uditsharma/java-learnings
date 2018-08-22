package com.udit.geeks_for_geeks.arrays;

import java.util.Scanner;

/**
 * @author Udit Sharma.
 * @since 09 Apr, 2018 11:26 PM
 */
public class ClosestPalindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberOfTesCases = sc.nextInt();
        for (int i = 0; i < numberOfTesCases; i++) {
            int number = sc.nextInt();
            int closestPalindrome = new ClosestPalindrome().closestPalindrome(number);
            System.out.println(closestPalindrome);
        }
    }

    int closestPalindrome(int number) {
        if (number < 10) {
            return number - 1;
        } else if (numberIsAll9(number)) {
            return number + 2;
        } else if (numberIsAll9(number - 2)) {
            return number - 2;
        } else if (numberIsAll9(number - 1)) {
            return number - 1;
        } else {
            int[] digits = convertToDigit(number);
            int length = digits.length;
            int mid = length / 2;
            int left = mid - 1;
            int right = (length % 2 == 0) ? mid : mid + 1;
            while (left >= 0 && digits[left] == digits[right]) {
                left--;
                right++;
            }

            boolean incrementMiddleElement = false;
            if (left < 0) {
                incrementMiddleElement = true;
            }
            while (left >= 0) {
                digits[right] = digits[left];
                left--;
                right++;
            }
            if (incrementMiddleElement) {
                int carry = 1;
                if (length / 2 != 0) {
                    digits[mid] = digits[mid] + 1;
                    carry = digits[mid] / 10;
                    digits[mid] = digits[mid] % 10;
                }
                left = mid - 1;
                right = left / 2 == 0 ? mid : mid + 1;
                while (left >= 0) {
                    digits[left] = digits[left] + carry;
                    carry = digits[left] / 10;
                    digits[left] = digits[left] % 10;
                    digits[right] = digits[left];
                    right++;
                    left--;
                }
            }
            StringBuilder builder = new StringBuilder();
            for (int digit : digits) {
                builder.append(digit);
            }

            return Integer.parseInt(builder.toString());
        }
    }

    private int[] convertToDigit(int number) {
        String numberString = Integer.toString(number);
        int length = numberString.length();
        int[] digits = new int[length];
        for (int i = length - 1; i >= 0; i--) {
            digits[i] = number % 10;
            number = number / 10;
        }
        return digits;
    }

    private boolean numberIsAll9(int number) {
        while (number > 0) {
            int divisor = number % 10;
            if (divisor != 9) {
                return false;
            }
            number = number / 10;
        }
        return true;
    }
}
