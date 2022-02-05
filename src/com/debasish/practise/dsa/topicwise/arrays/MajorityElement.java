package com.debasish.practise.dsa.topicwise.arrays;

import java.util.Arrays;

/**
 * @author debasishsahoo
 * <p>
 * Problem Description
 * <p>
 * Given an array of size n, find the majority element. The majority element is the element that appears more than floor(n/2) times.
 * You may assume that the array is non-empty and the majority element always exist in the array.
 * <p>
 * Example :
 * <p>
 * Input : [2, 1, 2]
 * Return  : 2 which occurs 2 times which is greater than 3/2.
 */
public class MajorityElement {

    // Brute-force approach in TC : O(N ^ 2) & SC : O(1)
    public int majorityElement(final int[] A) {
        for (int i = 0; i < A.length; i++) {
            int count = 0;
            for (int j = 0; j < A.length; j++) {
                if (A[i] == A[j]) {
                    count++;
                }
            }
            if (count > (A.length / 2)) return A[i];
        }
        return 0;
    }

    // Sorting approach in TC : O(N logN) and SC : O(1)
    public int majorityElementBySorting(final int[] A) {
        if (A.length == 1) return A[0];
        Arrays.sort(A); // O(N log N)
        int count = 1;
        for (int i = 1; i < A.length; i++) {
            if (A[i - 1] == A[i]) count++;
            else count = 1;
            if (count > (A.length / 2)) return A[i];
        }
        return count;
    }
}
