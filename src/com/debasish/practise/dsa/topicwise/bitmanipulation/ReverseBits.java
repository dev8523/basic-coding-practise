package com.debasish.practise.dsa.topicwise.bitmanipulation;

/**
 * @author debasishsahoo
 * <p>
 * Problem Description
 * <p>
 * Reverse the bits of an 32 bit unsigned integer A.
 * <p>
 * Input Format
 * <p>
 * First and only argument of input contains an integer A.
 * <p>
 * Output Format
 * <p>
 * Return a single unsigned integer denoting the decimal value of reversed bits.
 * <p>
 * Example Input
 * <p>
 * Input 1:
 * <p>
 * 0
 * Input 2:
 * <p>
 * 3
 * <p>
 * Example Output
 * <p>
 * Output 1:
 * <p>
 * 0
 * Output 2:
 * <p>
 * 3221225472
 * <p>
 * Example Explanation
 * <p>
 * Explanation 1:
 * <p>
 * 00000000000000000000000000000000
 * =>      00000000000000000000000000000000
 * Explanation 2:
 * <p>
 * 00000000000000000000000000000011
 * =>      11000000000000000000000000000000
 */
public class ReverseBits {
    public long reverse(long a) {
        if (a == 0) return 0;
        long ans = 0;
        for (int i = 0; i < 32; i++) {
            if ((a & (1L << i)) > 0) {
                ans = ans | 1L << (31 - i);
            }
        }
        return ans;
    }
}
