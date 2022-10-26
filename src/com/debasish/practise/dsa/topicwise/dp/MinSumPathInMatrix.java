package com.debasish.practise.dsa.topicwise.dp;

/**
 * Problem Description
 * Given a M x N grid A of integers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 *
 * Return the minimum sum of the path.
 *
 * NOTE: You can only move either down or right at any point in time.
 *
 *
 *
 * Problem Constraints
 * 1 <= M, N <= 2000
 *
 * -1000 <= A[i][j] <= 1000
 *
 *
 *
 * Input Format
 * First and only argument is a 2-D grid A.
 *
 *
 *
 * Output Format
 * Return an integer denoting the minimum sum of the path.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [
 *        [1, 3, 2]
 *        [4, 3, 1]
 *        [5, 6, 1]
 *      ]
 * Input 2:
 *
 *  A = [
 *        [1, -3, 2]
 *        [2, 5, 10]
 *        [5, -5, 1]
 *      ]
 *
 *
 * Example Output
 * Output 1:
 *
 *  8
 * Output 2:
 *
 *  -1
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  The path will be: 1 -> 3 -> 2 -> 1 -> 1.
 * Input 2:
 *
 *  The path will be: 1 -> -3 -> 5 -> -5 -> 1.
 */
public class MinSumPathInMatrix {
    /**
     * DP approach:
     * As we are visiting single cell multiple time - It has overlapping sub-problem.
     * We are using smaller substructure to get the answer of bigger sub-problem.
     * <p>
     * TC: O(M * N)
     * SC: O(M * N)
     */
    public int minPathSum(int[][] A) {
        int[][] dp = new int[A.length][A[0].length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = A[i][j];
                } else if (i == 0) {
                    dp[i][j] = A[i][j] + dp[i][j - 1];
                } else if (j == 0) {
                    dp[i][j] = A[i][j] + dp[i - 1][j];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + A[i][j];
                }
            }
        }
        return dp[A.length - 1][A[0].length - 1];
    }
}
