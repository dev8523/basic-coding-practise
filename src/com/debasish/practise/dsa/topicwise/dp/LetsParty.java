package com.debasish.practise.dsa.topicwise.dp;

import java.util.Arrays;

/**
 * Problem Description
 *
 * In Danceland, one person can party either alone or can pair up with another person.
 *
 * Can you find in how many ways they can party if there are A people in Danceland?
 *
 * Note: Return your answer modulo 10003, as the answer can be large.
 *
 *
 *
 * Problem Constraints
 *
 * 1 <= A <= 105
 *
 *
 *
 * Input Format
 *
 * Given only argument A of type Integer, number of people in Danceland.
 *
 *
 *
 * Output Format
 *
 * Return an integer denoting the number of ways people of Danceland can party.
 *
 *
 *
 * Example Input
 *
 * Input 1:
 *
 *  A = 3
 * Input 2:
 *
 *  A = 5
 *
 *
 * Example Output
 *
 * Output 1:
 *
 *  4
 * Output 2:
 *
 *  26
 *
 *
 * Example Explanation
 *
 * Explanation 1:
 *
 *  Let suppose three people are A, B, and C. There are only 4 ways to party
 *  (A, B, C) All party alone
 *  (AB, C) A and B party together and C party alone
 *  (AC, B) A and C party together and B party alone
 *  (BC, A) B and C party together and A
 *  here 4 % 10003 = 4, so answer is 4.
 *
 * Explanation 2:
 *
 *  Number of ways they can party are: 26.
 */
public class LetsParty {


    /**
     * Explanation in 3 Parts
     *
     * 1) Base case
     * 2) Recursive Relation
     * 3) Solutions
     *
     * Base Cases:
     * 1) One person can only dance alone
     * i.e. When A == 1 return 1
     * 2) Two people can dance as
     * (A, B) individually, (AB) paired
     * i.e. When A == 2 return 2
     *
     * Recursive Relation
     * For any A except for base cases we can say that
     * new person who will join after (A - 1) people will join in either individually or will pair up with one of the remaining people
     *
     * Case1: joins individually
     * When (A)th person join individually to (A - 1) people then no equation changes.
     * Therefore number of distinct ways for this case is = dp[A - 1];
     *
     * Case2: joins as a pair
     * (A)th person can form pair with all (A - 1) people. In fact he will form pair with all (A - 1) people to form all distinct ways.
     *
     * Suppose there are 4 people = {P1, P2, P3, P4}
     * P4 forms pair with P1 = {P1P4}, remaining people are {P2, P3}, i.e. 2 people.
     * In how many distinct ways this 2 remaining people can dance = dp[A - 2];
     *
     * Like this P4 will form pair with first P1, then P2, then P3.
     * Therefore, number of distinct ways are
     *  (Number of people last person can form pair with i.e. A-1) * (Number of ways in which A-2 people can dance = dp[A - 2]);
     *
     * Resultant DP Relation = Case1 + Case2
     * dp[i] = dp[i - 1] + ((i - 1) * dp[i - 2]);
     */

    /**
     * DP solution using Memoization approach
     * TC: O(N) - iterating once
     * SC: O(N) - DP array and recursion stack space
     */
    public int solve(int A) {
        int[] dp = new int[A + 1];
        Arrays.fill(dp, -1);
        return noOfWays(A, dp);
    }

    public int noOfWays(int A, int[] dp) {
        if (A == 1 || A == 2) {
            return A;
        }
        if (dp[A] != -1) {
            return dp[A];
        }

        int mod = 10003;

        dp[A] = (noOfWays(A - 1, dp) % mod
                + (noOfWays(A - 2, dp) % mod
                * (A - 1) % mod) % mod) % mod;

        return dp[A];
    }
}
