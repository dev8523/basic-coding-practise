package com.debasish.practise.dsa.topicwise.hashing;

import java.util.HashSet;
import java.util.Set;

/**
 * @author debasishsahoo
 * <p>
 * Problem Description
 * <p>
 * Given an array of integers A, find and return whether the given array contains a non-empty subarray with a sum equal to 0.
 * <p>
 * If the given array contains a sub-array with sum zero return 1 else return 0.
 * <p>
 * Example Input
 * <p>
 * Input 1:
 * <p>
 * A = [1, 2, 3, 4, 5]
 * Input 2:
 * <p>
 * A = [-1, 1]
 * <p>
 * Example Output
 * <p>
 * Output 1:
 * <p>
 * 0
 * Output 2:
 * <p>
 * 1
 * <p>
 * Example Explanation
 * <p>
 * Explanation 1:
 * <p>
 * No subarray has sum 0.
 * Explanation 2:
 * <p>
 * The array has sum 0.
 */
public class SubArrayWith0Sum {
    public int solve(int[] A) {
        // 1. Create prefix_sum and store in set.
        // 2. Check if set already contains the prefix_sum it means we return true else add to the set.
        Set<Long> set = new HashSet<>();
        long prefix_sum = 0;
        set.add(0L);
        for (int i = 0; i < A.length; i++) {
            prefix_sum = prefix_sum + A[i];
            if (set.contains(prefix_sum)) return 1;
            else set.add(prefix_sum);
        }
        return 0;
    }
}
