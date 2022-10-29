package com.debasish.practise.dsa.topicwise.dp;

/**
 * Problem Description
 * Given two strings A and B. Find the longest common subsequence ( A sequence which does not need to be contiguous), which is common in both the strings.
 * <p>
 * You need to return the length of such longest common subsequence.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= Length of A, B <= 1005
 * <p>
 * <p>
 * <p>
 * Input Format
 * First argument is a string A.
 * Second argument is a string B.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return an integer denoting the length of the longest common subsequence.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = "abbcdgf"
 * B = "bbadcgf"
 * Input 2:
 * <p>
 * A = "aaaaaa"
 * B = "ababab"
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * 5
 * Output 2:
 * <p>
 * 3
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * The longest common subsequence is "bbcgf", which has a length of 5.
 * Explanation 2:
 * <p>
 * The longest common subsequence is "aaa", which has a length of 3.
 */
public class LongestCommonSubsequence {
    /**
     * Memoization/Top Down approach:
     * TC - O(mn)
     * SC - O(mn)
     */
    public static class LCSUsingTopDown {
        String A, B;

        public int solve(String A, String B) {
            this.A = A;
            this.B = B;
            int[][] dp = new int[A.length()][B.length()];
            return solve(A.length() - 1, B.length() - 1, dp);
        }

        public int solve(int i, int j, int[][] dp) {
            if (i < 0 || j < 0) {
                return 0;
            }
            if (dp[i][j] != 0) return dp[i][j];

            if (A.charAt(i) == B.charAt(j)) {
                return dp[i][j] = 1 + solve(i - 1, j - 1, dp);
            } else {
                return dp[i][j] = Math.max(solve(i, j - 1, dp), solve(i - 1, j, dp));
            }
        }
    }

    /**
     * Tabulation/Bottom Up approach:
     * TC: O(mn)
     * SC: O(mn)
     */
    static class LCSUsingBottomUp {
        public int solve(String A, String B) {
            int m = A.length(), n = B.length();
            int[][] dp = new int[m + 1][n + 1];
            int i, j;
            for (i = 0; i <= m; i++) {
                for (j = 0; j <= n; j++) {
                    //Base condition
                    if (i == 0 || j == 0)
                        dp[i][j] = 0;
                    else if (A.charAt(i - 1) == B.charAt(j - 1))
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    else
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
            return dp[m][n];
        }
    }

    /**
     * Tabulation/Bottom Up space optimized:
     * TC: O(mn)
     * SC: O(min(m,n))
     */
    static class LCSUsingBottomUpWithOptimisedSpace {
        public int solve(String A, String B) {
            String rowString = A, colString = B;
            if (A.length() > B.length()) {
                rowString = A;
                colString = B;
            }
            int[][] dp = new int[2][colString.length() + 1];
            int prev = 0, curr = 1;
            for (int i = 1; i <= rowString.length(); i++) {
                for (int j = 1; j <= colString.length(); j++) {
                    if (A.charAt(i - 1) == B.charAt(j - 1)) {
                        dp[curr][j] = 1 + dp[prev][j - 1];
                    } else {
                        dp[curr][j] = Math.max(dp[prev][j], dp[curr][j - 1]);
                    }
                }
                if (curr == 1) {
                    curr = 0;
                    prev = 1;
                } else {
                    curr = 1;
                    prev = 0;
                }
            }
            return dp[prev][colString.length()];
        }
    }
}
