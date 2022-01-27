package com.debasish.practise.dsa.topicwise.bitmanipulation;

/**
 * @author debasishsahoo
 * <p>
 * Problem Description
 * <p>
 * Given two binary strings, return their sum (also a binary string).
 * <p>
 * Example:
 * <p>
 * a = "100"
 * <p>
 * b = "11"
 * <p>
 * Return a + b = "111".
 */
public class AddBinaryStrings {
    public String addBinary(String A, String B) {
        StringBuilder sb = new StringBuilder();
        int sum = 0;
        int base = 2;
        int digit = 0;
        int i = A.length() - 1, j = B.length() - 1;
        while (i >= 0 || j >= 0) {
            if (i >= 0) {
                sum = sum + (A.charAt(i) - '0');
            }
            if (j >= 0) {
                sum = sum + (B.charAt(j) - '0');
            }
            digit = sum % base + '0';
            sb.append(digit);
            sum = sum / base;
            i--;
            j--;
        }
        if (sum == 1)
            sb.append(digit);
        return sb.reverse().toString();
    }
}
