package com.debasish.practise.dsa.topicwise.dp;

/**
 * 0-1 Knapsack II
 * Problem Description
 * Given two integer arrays A and B of size N each which represent values and weights associated with N items respectively.
 *
 * Also given an integer C which represents knapsack capacity.
 *
 * Find out the maximum value subset of A such that sum of the weights of this subset is smaller than or equal to C.
 *
 * NOTE: You cannot break an item, either pick the complete item, or don’t pick it (0-1 property).
 *
 *
 *
 * Problem Constraints
 * 1 <= N <= 500
 *
 * 1 <= C, B[i] <= 106
 *
 * 1 <= A[i] <= 50
 *
 *
 *
 * Input Format
 * First argument is an integer array A of size N denoting the values on N items.
 *
 * Second argument is an integer array B of size N denoting the weights on N items.
 *
 * Third argument is an integer C denoting the knapsack capacity.
 *
 *
 *
 * Output Format
 * Return a single integer denoting the maximum value subset of A such that sum of the weights of this subset is smaller than or equal to C.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [6, 10, 12]
 *  B = [10, 20, 30]
 *  C = 50
 * Input 2:
 *
 *  A = [1, 3, 2, 4]
 *  B = [12, 13, 15, 19]
 *  C = 10
 *
 *
 * Example Output
 * Output 1:
 *
 *  22
 * Output 2:
 *
 *  0
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  Taking items with weight 20 and 30 will give us the maximum value i.e 10 + 12 = 22
 * Explanation 2:
 *
 *  Knapsack capacity is 10 but each item has weight greater than 10 so no items can be considered in the knapsack therefore answer is 0.
 */
public class ZeroOrOneKnapsackII {
    /**
     * Logic:
     * <p>
     * 1) In each iteration we require precomputed results for length = len - 1.  //Predictable
     * 2) In each iteration we require precomputed results for capacity derived from C - weights[N-1]; //This can not be predicted
     * 3) That means For calculating results of [N]th row we only need to carry result for [N-1]th row having [C+1] columns and not the entire matrix.
     * <p>
     * TC = O(C*N)
     * SC = O(C)
     */
    public int solve(int[] A, int[] B, int C) {
        int N = A.length;
        int[] prev = new int[C + 1];
        int[] curr = new int[C + 1];

        for (int l = 1; l <= N; l++) {
            for (int c = 1; c <= C; c++) {
                curr[c] = prev[c];

                if (B[l - 1] <= c) {
                    curr[c] = Math.max(curr[c], A[l - 1] + prev[c - B[l - 1]]);
                }
            }

            prev = curr;
            curr = new int[C + 1];
        }

        return prev[C];
    }
}
