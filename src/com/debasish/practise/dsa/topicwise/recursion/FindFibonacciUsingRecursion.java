package com.debasish.practise.dsa.topicwise.recursion;

/**
 * @author debasishsahoo
 * <p>
 * Problem Description
 * The Fibonacci numbers are the numbers in the following integer sequence.
 * <p>
 * 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, ……..
 * <p>
 * In mathematical terms, the sequence Fn of Fibonacci numbers is defined by the recurrence relation:
 * <p>
 * Fn = Fn-1 + Fn-2
 * <p>
 * Given a number A, find and return the Ath Fibonacci Number.
 * <p>
 * Given that F0 = 0 and F1 = 1.
 */
public class FindFibonacciUsingRecursion {
    public int findAthFibonacci(int A) {
        if (A <= 1) return A;
        return findAthFibonacci(A - 1) + findAthFibonacci(A - 2);
    }
}
