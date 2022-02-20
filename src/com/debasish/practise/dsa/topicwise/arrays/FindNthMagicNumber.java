package com.debasish.practise.dsa.topicwise.arrays;

/**
 * @author debasishsahoo
 * <p>
 * Problem Description
 * <p>
 * Given an integer A, find and return the Ath magic number.
 * <p>
 * A magic number is defined as a number which can be expressed as a power of 5 or sum of unique powers of 5.
 * <p>
 * First few magic numbers are 5, 25, 30(5 + 25), 125, 130(125 + 5), ….
 * <p>
 * Example Input
 * <p>
 * Example Input 1:
 * <p>
 * A = 3
 * <p>
 * Example Input 2:
 * <p>
 * A = 10
 * <p>
 * Example Output
 * <p>
 * Example Output 1:
 * <p>
 * 30
 * Example Output 2:
 * <p>
 * 650
 * <p>
 * Example Explanation
 * <p>
 * Explanation 1:
 * <p>
 * A in increasing order is [5, 25, 30, 125, 130, ...]
 * 3rd element in this is 30
 * Explanation 2:
 * <p>
 * In the sequence shown in explanation 1, 10th element will be 650.
 */
public class FindNthMagicNumber {
    public int solve(int A) {
        double ans = 0;
        int power = 1;
        while (A > 0) {
            if ((A & 1) == 1) {
                ans = ans + Math.pow(5, power);
            }
            power++;
            A = A >> 1;
        }
        return (int) ans;
    }
}
