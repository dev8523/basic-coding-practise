package com.debasish.practise.dsa.topicwise.backtracking;

/**
 * Problem Description
 * Given a array of integers A of size N and an integer B.
 *
 * Return number of non-empty subsequences of A of size B having sum <= 1000.
 *
 *
 *
 * Problem Constraints
 * 1 <= N <= 20
 *
 * 1 <= A[i] <= 1000
 *
 * 1 <= B <= N
 *
 *
 *
 * Input Format
 * The first argument given is the integer array A.
 *
 * The second argument given is the integer B.
 *
 *
 *
 * Output Format
 * Return number of subsequences of A of size B having sum <= 1000.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *     A = [1, 2, 8]
 *     B = 2
 * Input 2:
 *
 *     A = [5, 17, 1000, 11]
 *     B = 4
 *
 *
 * Example Output
 * Output 1:
 *
 * 3
 * Output 2:
 *
 * 0
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  {1, 2}, {1, 8}, {2, 8}
 * Explanation 1:
 *
 *  No valid subsequence
 */
public class Sixlets {
    public int solve(int[] A, int B) {
        return getAns(A, B, 0, 0, 0);
    }

    /**
     * TC: O(2^N)
     * SC: O(1)
     */
    private int getAns(int[] A, int B, int size, int sum, int i) {
        if (sum > 1000) return 0;
        if (size == B) return 1;
        if (i == A.length) return 0;
        return getAns(A, B, size + 1, sum + A[i], i + 1) // CHOOSE
                +
                getAns(A, B, size, sum, i + 1); // NOT CHOOSE
    }
}
