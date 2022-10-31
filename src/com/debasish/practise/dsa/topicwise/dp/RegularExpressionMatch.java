package com.debasish.practise.dsa.topicwise.dp;

/**
 * Problem Description
 * Implement wildcard pattern matching with support for ' ? ' and ' * ' for strings A and B.
 *
 * ' ? ' : Matches any single character.
 * ' * ' : Matches any sequence of characters (including the empty sequence).
 * The matching should cover the entire input string (not partial).
 *
 *
 *
 * Problem Constraints
 * 1 <= length(A), length(B) <= 104
 *
 *
 *
 * Input Format
 * The first argument of input contains a string A.
 * The second argument of input contains a string B.
 *
 *
 *
 * Output Format
 * Return 1 if the patterns match else return 0.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = "aaa"
 *  B = "a*"
 * Input 2:
 *
 *  A = "acz"
 *  B = "a?a"
 *
 *
 * Example Output
 * Output 1:
 *
 *  1
 * Output 2:
 *
 *  0
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  Since '*' matches any sequence of characters. Last two 'a' in string A will be match by '*'.
 *  So, the pattern matches we return 1.
 * Explanation 2:
 *
 *  '?' matches any single character. First two character in string A will be match.
 *  But the last character i.e 'z' != 'a'. Return 0.
 */
public class RegularExpressionMatch {
    /**
     * DP solution using tabulation
     * TC : O(N)
     * SC : O(N)
     */
    public int isMatch(final String A, final String B) {
        boolean[][] dp = new boolean[A.length() + 1][B.length() + 1];
        dp[0][0] = true;
        if (B.charAt(0) == '*') {
            dp[0][1] = true;
        }
        for (int i = 0; i < B.length(); ++i) {
            if (B.charAt(i) == '*') {
                dp[0][i + 1] = dp[0][i];
                for (int j = 0; j < A.length(); ++j) {
                    dp[j + 1][i + 1] = dp[j][i] || dp[j + 1][i] || dp[j][i + 1];
                }
            } else if (B.charAt(i) == '?') {
                for (int j = A.length() - 1; j >= 0; --j) {
                    dp[j + 1][i + 1] = dp[j][i];
                }
            } else {
                for (int j = 0; j < A.length(); ++j) {
                    if (B.charAt(i) == A.charAt(j)) {
                        dp[j + 1][i + 1] = dp[j][i];
                    }
                }
            }
        }
        return dp[A.length()][B.length()] ? 1 : 0;
    }
}
