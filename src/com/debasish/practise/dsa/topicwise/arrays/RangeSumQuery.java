package com.debasish.practise.dsa.topicwise.arrays;

/**
 * Problem Description
 * You are given an integer array A of length N.
 * You are also given a 2D integer array B with dimensions M x 2, where each row denotes a [L, R] query.
 * For each query, you have to find the sum of all elements from L to R indices in A (1 - indexed).
 * More formally, find A[L] + A[L + 1] + A[L + 2] +... + A[R - 1] + A[R] for each query.
 * <p>
 * Input Format
 * The first argument is the integer array A.
 * The second argument is the 2D integer array B.
 * <p>
 * Output Format
 * Return an integer array of length M where ith element is the answer for ith query in B.
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * A = [1, 2, 3, 4, 5]
 * B = [[1, 4], [2, 3]]
 * <p>
 * Input 2:
 * <p>
 * A = [2, 2, 2]
 * B = [[1, 1], [2, 3]]
 * <p>
 * Example Output
 * Output 1:
 * [10, 5]
 * <p>
 * Output 2:
 * <p>
 * [2, 4]
 * <p>
 * Example Explanation
 * Explanation 1:
 * The sum of all elements of A[1 ... 4] = 1 + 2 + 3 + 4 = 10.
 * The sum of all elements of A[2 ... 3] = 2 + 3 = 5.
 * <p>
 * Explanation 2:
 * <p>
 * The sum of all elements of A[1 ... 1] = 2 = 2.
 * The sum of all elements of A[2 ... 3] = 2 + 2 = 4.
 */
public class RangeSumQuery {
    public long[] rangeSum(int[] A, int[][] B) {
        int N = A.length;
        int M = B.length;
        long[] outputArr = new long[M];
        // create the prefix sum array
        long[] ps = new long[N];
        ps[0] = A[0];
        for (int i = 1; i < N; i++) {
            ps[i] = ps[i - 1] + A[i];
        }
        int L = 0;
        int R = 0;
        for (int i = 0; i < M; i++) {
            L = B[i][0];
            R = B[i][1];
            L--; // convert to 0 index based indexing
            R--; // convert to 0 index based indexing
            long sum = ps[R];
            if (L > 0) {
                sum = sum - ps[L - 1];
            }
            outputArr[i] = sum;
        }
        return outputArr;
    }
}
