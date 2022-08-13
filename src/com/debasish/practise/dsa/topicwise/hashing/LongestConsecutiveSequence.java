package com.debasish.practise.dsa.topicwise.hashing;

import java.util.HashSet;
import java.util.Set;

/**
 * Problem Description
 * Given an unsorted integer array A of size N.
 * <p>
 * Find the length of the longest set of consecutive elements from array A.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= N <= 106
 * <p>
 * -106 <= A[i] <= 106
 * <p>
 * <p>
 * <p>
 * Input Format
 * First argument is an integer array A of size N.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return an integer denoting the length of the longest set of consecutive elements from the array A.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = [100, 4, 200, 1, 3, 2]
 * Input 2:
 * <p>
 * A = [2, 1]
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * 4
 * Output 2:
 * <p>
 * 2
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * The set of consecutive elements will be [1, 2, 3, 4].
 * Explanation 2:
 * <p>
 * The set of consecutive elements will be [1, 2].
 */
public class LongestConsecutiveSequence {
    /**
     * Using Hashing. TC: O(N), SC: O(1)
     */
    public int longestConsecutive(final int[] A) {
        int N = A.length;
        Set<Integer> set = new HashSet<>();
        // Insert elements into the HashSet.
        for (int i = 0; i < N; i++) {
            set.add(A[i]);
        }
        int ans = 0;
        for (int i = 0; i < N; i++) {
            if (set.contains(A[i] - 1)) {
                continue;
            } else {
                int c = 1;
                for (int j = A[i] + 1; ; j++) {
                    if (set.contains(j)) c++;
                    else {
                        ans = Math.max(ans, c);
                        break;
                    }
                }
            }
        }
        return ans;
    }
}
