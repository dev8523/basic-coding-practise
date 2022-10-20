package com.debasish.practise.dsa.topicwise.dp;

/**
 * Problem Description
 * You are climbing a staircase and it takes A steps to reach the top.
 * <p>
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * <p>
 * Return the number of distinct ways modulo 1000000007
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= A <= 105
 * <p>
 * <p>
 * <p>
 * Input Format
 * The first and the only argument contains an integer A, the number of steps.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return an integer, representing the number of ways to reach the top.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = 2
 * Input 2:
 * <p>
 * A = 3
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * 2
 * Output 2:
 * <p>
 * 3
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * Distinct ways to reach top: [1, 1], [2].
 * Explanation 2:
 * <p>
 * Distinct ways to reach top: [1 1 1], [1 2], [2 1].
 */
public class Stairs {
    /**
     * DP Solution. Using Tabulation.
     * TC: O(N)
     * SC: O(1)
     */
    public int climbStairs(int A) {
        int x = 1;
        int y = 1;
        int mod = 1000000007;

        for (int i = 2; i <= A; i++) {
            // Doing mod everytime, so that value won't overflow.
            int z = (x % mod + y % mod) % mod;
            x = y;
            y = z;
        }
        return y % mod;
    }
}
