package com.debasish.practise.dsa.topicwise.sorting;

import java.util.Arrays;

/**
 * @author debasishsahoo
 * <p>
 * Problem Description
 * <p>
 * Given an integer array A, find if an integer p exists in the array such that the number of integers greater than p in the array equals to p.
 * <p>
 * Input Format
 * <p>
 * First and only argument is an integer array A.
 * <p>
 * Output Format
 * <p>
 * Return 1 if any such integer p is found else return -1.
 * <p>
 * Example Input
 * <p>
 * Input 1:
 * <p>
 * A = [3, 2, 1, 3]
 * Input 2:
 * <p>
 * A = [1, 1, 3, 3]
 * <p>
 * Example Output
 * <p>
 * Output 1:
 * <p>
 * 1
 * Output 2:
 * <p>
 * -1
 * <p>
 * Example Explanation
 * <p>
 * Explanation 1:
 * <p>
 * For integer 2, there are 2 greater elements in the array. So, return 1.
 * <p>
 * Explanation 2:
 * <p>
 * There is no such integer exists.
 */
public class NobleInteger {
    public int solve(int[] A) {
        Arrays.sort(A);
        int count = 1;
        if (A[A.length - 1] == 0) return 1;
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] == A.length - i - 1 && A[i] != A[i + 1]) {
                return 1;
            }
        }
        return -1;
    }
}
