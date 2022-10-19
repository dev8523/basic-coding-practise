package com.debasish.practise.dsa.topicwise.dp;

/**
 * Problem Description
 * Given a positive integer A, write a program to find the Ath Fibonacci number.
 *
 * In a Fibonacci series, each term is the sum of the previous two terms and the first two terms of the series are 0 and 1. i.e. f(0) = 0 and f(1) = 1. Hence, f(2) = 1, f(3) = 2, f(4) = 3 and so on.
 *
 * NOTE: 0th term is 0. 1th term is 1 and so on.
 *
 *
 *
 * Problem Constraints
 * 0 <= A <= 44
 *
 *
 *
 * Input Format
 * First and only argument is an integer A.
 *
 *
 *
 * Output Format
 * Return an integer denoting the Ath Fibonacci number.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = 4
 * Input 2:
 *
 *  A = 6
 *
 *
 * Example Output
 * Output 1:
 *
 *  3
 * Output 2:
 *
 *  8
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  Terms of Fibonacci series are: 0, 1, 1, 2, 3, 5, 8, 13, 21 and so on.
 *  0th term is 0 So, 4th term of Fibonacci series is 3.
 * Explanation 2:
 *
 *  6th term of Fibonacci series is 8.
 */
public class FindFibonacci {
    /**
     * TC: O(N) - using memoization in DP.
     * SC: O(N) - recursion stack space
     */
    public static int findAthFibonacciUsingMemoization(int A) {
        int[] fib = new int[A + 1]; //  fib[i] denotes the i'th fibonacci number
        fib[0] = 0;
        fib[1] = 1;
        for (int i = 2; i <= A; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        return fib[A];
    }

    /**
     * TC: O(2^N)
     * SC: O(N) - recursion stack space
     */
    public int findAthFibonacci(int A) {
        if (A <= 1) return A;
        return findAthFibonacci(A - 1) + findAthFibonacci(A - 2);
    }
}
