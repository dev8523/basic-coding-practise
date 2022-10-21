package com.debasish.practise.dsa.topicwise.dp;

/**
 * Problem Description
 * Given an integer A. Return minimum count of numbers, sum of whose squares is equal to A.
 *
 *
 *
 * Problem Constraints
 * 1 <= A <= 105
 *
 *
 *
 * Input Format
 * First and only argument is an integer A.
 *
 *
 *
 * Output Format
 * Return an integer denoting the minimum count.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = 6
 * Input 2:
 *
 *  A = 5
 *
 *
 * Example Output
 * Output 1:
 *
 *  3
 * Output 2:
 *
 *  2
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  Possible combinations are : (12 + 12 + 12 + 12 + 12 + 12) and (12 + 12 + 22).
 *  Minimum count of numbers, sum of whose squares is 6 is 3.
 * Explanation 2:
 *
 *  We can represent 5 using only 2 numbers i.e. 12 + 22 = 5
 */
public class MinimumNoOfSquares {
    /**
     * DP Solution, using Memoization
     * TC: O(N*sqrt(N))
     * SC: O(N) - dp array
     */
    public int countMinSquares(int A) {
        if (A <= 0)
            return 0;
        int[] dp = new int[A + 1];

        for (int i = 1; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        for (int i = 1; i <= A; i++) {

            // for every no we are checking from 1 to sqrt(i).
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], 1 + dp[i - (j * j)]);
            }
        }

        return dp[A];
    }
}
