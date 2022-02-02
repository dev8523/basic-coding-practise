package com.debasish.practise.dsa.topicwise.modulararithmetic;

/**
 * @author debasishsahoo
 * <p>
 * Problem Description
 * <p>
 * Given two integers A and B, find the greatest possible positive M, such that A % M = B % M.
 * <p>
 * Input Format
 * <p>
 * The first argument given is the integer, A.
 * The second argument given is the integer, B.
 * <p>
 * Output Format
 * <p>
 * Return an integer denoting greatest possible positive M.
 * <p>
 * Example Input
 * <p>
 * Input 1:
 * <p>
 * A = 1
 * B = 2
 * Input 2:
 * <p>
 * A = 5
 * B = 10
 * <p>
 * Example Output
 * <p>
 * Output 1:
 * <p>
 * 1
 * Output 2:
 * <p>
 * 5
 * <p>
 * Example Explanation
 * <p>
 * Explanation 1:
 * <p>
 * 1 is the largest value of M such that A % M == B % M.
 * Explanation 2:
 * <p>
 * For M = 5, A % M = 0 and B % M = 0.
 * <p>
 * No value greater than M = 5, satisfies the condition.
 */
public class GreatestPossibleM {
    public int solve(int A, int B) {
        return Math.abs(A - B);
    }
}
