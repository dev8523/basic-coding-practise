package com.debasish.practise.dsa.topicwise.sorting;

import java.util.Arrays;

/**
 * @author debasishsahoo
 * <p>
 * Problem Description
 * <p>
 * Given an integer array A of size N. Return 1 if the array can be rearranged to form an arithmetic progression, otherwise, return 0.
 * <p>
 * A sequence of numbers is called an arithmetic progression if the difference between any two consecutive elements is the same.
 * <p>
 * Input Format
 * <p>
 * First and only argument is an integer array A of size N.
 * <p>
 * Output Format
 * <p>
 * Return 1 if the array can be rearranged to form an arithmetic progression, otherwise, return 0
 * <p>
 * Example Input
 * <p>
 * Input 1:
 * <p>
 * A = [3, 5, 1]
 * Input 2:
 * <p>
 * A = [2, 4, 1]
 * <p>
 * Example Output
 * <p>
 * Output 1:
 * <p>
 * 1
 * Output 2:
 * <p>
 * 0
 * <p>
 * Example Explanation
 * <p>
 * Explanation 1:
 * <p>
 * We can reorder the elements as [1,3,5] or [5,3,1] with differences 2 and -2 respectively, between each consecutive elements.
 * Explanation 2:
 * <p>
 * There is no way to reorder the elements to obtain an arithmetic progression.
 */
public class ArithmeticProgression {
    public int solve(int[] A) {
        Arrays.sort(A);
        int diff = A[1] - A[0];
        for (int i = 1; i < A.length; i++) {
            if (A[i] - A[i - 1] != diff) return 0;
            else continue;
        }
        return 1;
    }
}
