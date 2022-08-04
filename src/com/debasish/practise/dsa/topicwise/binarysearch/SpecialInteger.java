package com.debasish.practise.dsa.topicwise.binarysearch;

/**
 * Problem Description
 * Given an array of integers A and an integer B, find and return the maximum value K such that there is no subarray in A of size K with the sum of elements greater than B.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= |A| <= 100000
 * 1 <= A[i] <= 10^9
 * <p>
 * 1 <= B <= 10^9
 * <p>
 * <p>
 * <p>
 * Input Format
 * The first argument given is the integer array A.
 * <p>
 * The second argument given is integer B.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return the maximum value of K (sub array length).
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = [1, 2, 3, 4, 5]
 * B = 10
 * Input 2:
 * <p>
 * A = [5, 17, 100, 11]
 * B = 130
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * 2
 * Output 2:
 * <p>
 * 3
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * Constraints are satisfied for maximal value of 2.
 * Explanation 2:
 * <p>
 * Constraints are satisfied for maximal value of 3.
 */
public class SpecialInteger {
    /**
     * Brute force: Linear search would take O(N^3) TC.
     * Brute force: Binary Search would take O(N*logN) TC.
     * <p>
     * Efficient approach:
     * Using sliding window and 2 pointers approach. We can solve this in
     * TC: O(N), SC: O(1)
     */
    public static int solve(int[] A, int B) {
        int ans = A.length;
        int sum = 0;
        int start = 0;
        // Loop till A.length
        for (int end = 0; end < A.length; end++) {
            // Sliding window from left
            sum += A[end];
            while (sum > B) {

                // Sliding window from right
                sum -= A[start];
                start++;

                // Storing sub-array size - 1
                // for which sum was greater than B
                ans = Math.min(ans, end - start + 1);

                // Sum will be 0 if start>end
                // because all elements are positive
                // start>end only when A[end]>B i.e,
                // there is an array element with
                // value greater than k, so sub-array
                // sum cannot be less than k.
                if (sum == 0)
                    break;
            }

            if (sum == 0) {
                ans = -1;
                break;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(solve(new int[]{1, 2, 3, 4, 5}, 10));
    }
}
