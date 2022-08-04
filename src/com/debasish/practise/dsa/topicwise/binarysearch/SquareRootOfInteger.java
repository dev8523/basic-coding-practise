package com.debasish.practise.dsa.topicwise.binarysearch;

/**
 * Problem Description
 * Given an integer A.
 * <p>
 * Compute and return the square root of A.
 * <p>
 * If A is not a perfect square, return floor(sqrt(A)).
 * <p>
 * DO NOT USE SQRT FUNCTION FROM THE STANDARD LIBRARY.
 * <p>
 * NOTE: Do not use the sqrt function from the standard library. Users are expected to solve this in O(log(A)) time.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 0 <= A <= 1010
 * <p>
 * <p>
 * <p>
 * Input Format
 * The first and only argument given is the integer A.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return floor(sqrt(A))
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * 11
 * Input 2:
 * <p>
 * 9
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * 3
 * Output 2:
 * <p>
 * 3
 * <p>
 * <p>
 * Example Explanation
 * Explanation:
 * <p>
 * When A = 11 , square root of A = 3.316. It is not a perfect square so we return the floor which is 3.
 * When A = 9 which is a perfect square of 3, so we return 3.
 */
public class SquareRootOfInteger {
    /**
     * Using binary search. TC: O(log N), SC: O(1)
     */
    public int sqrt(int A) {
        if (A == 0) return 0;
        int low = 1, high = A, ans = 0;
        while (low <= high) {
            // int mid = (low + high) / 2;
            int mid = low + (high - low) / 2; // Same condition as above, safer to use this as this will
            // not give us overflow issue.
            if (mid <= (A / mid)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }
}
