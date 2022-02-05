package com.debasish.practise.dsa.topicwise.arrays;

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

}
