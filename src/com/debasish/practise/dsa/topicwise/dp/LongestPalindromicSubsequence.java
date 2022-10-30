package com.debasish.practise.dsa.topicwise.dp;

/**
 * Problem Description
 * Given a string A. Find the longest palindromic subsequence (A subsequence which does not need to be contiguous and is a palindrome).
 *
 * You need to return the length of longest palindromic subsequence.
 *
 *
 *
 * Problem Constraints
 * 1 <= length of(A) <= 103
 *
 *
 *
 * Input Format
 * First and only integer is a string A.
 *
 *
 *
 * Output Format
 * Return an integer denoting the length of longest palindromic subsequence.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = "bebeeed"
 * Input 2:
 *
 *  A = "aedsead"
 *
 *
 * Example Output
 * Output 1:
 *
 *  4
 * Output 2:
 *
 *  5
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  The longest palindromic subsequence is "eeee", which has a length of 4.
 * Explanation 2:
 *
 *  The longest palindromic subsequence is "aedea", which has a length of 5.
 */
public class LongestPalindromicSubsequence {
    /**
     * DP approach using memoization:
     * TC: O(N^2)
     * SC: O(N^2)
     */
    public int LPS(String A) {
        int N = A.length();
        int[][] dp = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++)
            for (int j = 1; j <= N; j++) {
                if (A.charAt(i - 1) == A.charAt(N - j)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        return dp[N][N];
    }
}
