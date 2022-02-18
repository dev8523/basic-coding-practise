package com.debasish.practise.dsa.topicwise.recursion;

/**
 * @author debasishsahoo
 * <p>
 * Problem Description
 * <p>
 * Given a number A, we need to find sum of its digits using recursion.
 * <p>
 * Example Input
 * <p>
 * Input 1:
 * <p>
 * A = 46
 * Input 2:
 * <p>
 * A = 11
 * <p>
 * Example Output
 * <p>
 * Output 1:
 * <p>
 * 10
 * Output 2:
 * <p>
 * 2
 */
public class SumOfDigits {
    public int sum(int A) {
        if (A < 10) return A;
        return A % 10 + sum(A / 10);
    }
}
