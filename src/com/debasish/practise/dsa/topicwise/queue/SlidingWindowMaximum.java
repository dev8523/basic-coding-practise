package com.debasish.practise.dsa.topicwise.queue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * Problem Description
 * Given an array of integers A. There is a sliding window of size B, moving from the very left of the array to the very right. You can only see the B numbers in the window. Each time the sliding window moves rightwards by one position. You have to find the maximum for each window.
 * <p>
 * Return an array C, where C[i] is the maximum value in the array from A[i] to A[i+B-1].
 * <p>
 * Refer to the given example for clarity.
 * <p>
 * NOTE: If B > length of the array, return 1 element with the max of the array.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= |A|, B <= 106
 * <p>
 * <p>
 * <p>
 * Input Format
 * The first argument given is the integer array A.
 * <p>
 * The second argument given is the integer B.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return an array C, where C[i] is the maximum value of from A[i] to A[i+B-1].
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = [1, 3, -1, -3, 5, 3, 6, 7]
 * B = 3
 * Input 2:
 * <p>
 * A = [1, 2, 3, 4, 2, 7, 1, 3, 6]
 * B = 6
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * [3, 3, 5, 5, 6, 7]
 * Output 2:
 * <p>
 * [7, 7, 7, 7]
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * Window position     | Max
 * --------------------|-------
 * [1 3 -1] -3 5 3 6 7 | 3
 * 1 [3 -1 -3] 5 3 6 7 | 3
 * 1 3 [-1 -3 5] 3 6 7 | 5
 * 1 3 -1 [-3 5 3] 6 7 | 5
 * 1 3 -1 -3 [5 3 6] 7 | 6
 * 1 3 -1 -3 5 [3 6 7] | 7
 * Explanation 2:
 * <p>
 * Window position     | Max
 * --------------------|-------
 * [1 2 3 4 2 7] 1 3 6 | 7
 * 1 [2 3 4 2 7 1] 3 6 | 7
 * 1 2 [3 4 2 7 1 3] 6 | 7
 * 1 2 3 [4 2 7 1 3 6] | 7
 */
public class SlidingWindowMaximum {
    /**
     * Using {@link Deque}
     * TC: O(N), SC: O(N)
     */
    public static int[] slidingMaximum(final int[] A, int B) {
        if (A == null || B <= 0) {
            return new int[0];
        }
        int n = A.length;
        int[] r = new int[n - B + 1];
        int ri = 0;
        // store index
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < A.length; i++) {
            // remove numbers out of range B
            while (!q.isEmpty() && q.peek() < i - B + 1) {
                q.poll();
            }
            // remove smaller numbers in B range as they are useless
            while (!q.isEmpty() && A[q.peekLast()] < A[i]) {
                q.pollLast();
            }
            // q contains index... r contains content
            q.offer(i);
            if (i >= B - 1) {
                r[ri++] = A[q.peek()];
            }
        }
        return r;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(slidingMaximum(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
    }
}
