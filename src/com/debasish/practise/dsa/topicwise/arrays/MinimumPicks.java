package com.debasish.practise.dsa.topicwise.arrays;

/**
 * @author debasishsahoo
 * <p><p>
 * Problem Description
 * <p>
 * You are given an array of integers A of size N.
 * Return the difference between the maximum among all even numbers of A and the minimum among all odd numbers in A.
 * <p>
 * Example Input
 * <p>
 * Input 1:
 * <p>
 * A = [0, 2, 9]
 * <p>
 * Input 2:
 * <p>
 * A = [5, 17, 100, 1]
 * <p>
 * Example Output
 * <p>
 * Output 1:
 * <p>
 * -7
 * <p>
 * Output 2:
 * <p>
 * 99
 * <p>
 * Example Explanation
 * <p>
 * Explanation 1:
 * <p>
 * Maximum of all even numbers = 2
 * Minimum of all odd numbers = 9
 * ans = 2 - 9 = -7
 * Explanation 2:
 * <p>
 * Maximum of all even numbers = 100
 * Minimum of all odd numbers = 1
 * ans = 100 - 1 = 99
 */
public class MinimumPicks {
    public int solve(int[] A) {
        int maxEvenEle = Integer.MIN_VALUE;
        int minOddEle = Integer.MAX_VALUE;
        for (int i = 0; i < A.length; i++) {
            if ((A[i] & 1) == 0) { // check if each element is even
                if (A[i] > maxEvenEle) {
                    maxEvenEle = A[i];
                }
            } else {
                if (A[i] < minOddEle) {
                    minOddEle = A[i];
                }
            }
        }
        return maxEvenEle - minOddEle;
    }
}
