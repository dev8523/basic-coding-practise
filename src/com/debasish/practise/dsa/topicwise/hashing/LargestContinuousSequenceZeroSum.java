package com.debasish.practise.dsa.topicwise.hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Problem Description
 * Given an array A of N integers.
 * <p>
 * Find the largest continuous sequence in a array which sums to zero.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= N <= 106
 * <p>
 * -107 <= A[i] <= 107
 * <p>
 * <p>
 * <p>
 * Input Format
 * Single argument which is an integer array A.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return an array denoting the longest continuous sequence with total sum of zero.
 * <p>
 * NOTE : If there are multiple correct answers, return the sequence which occurs first in the array.
 * <p>
 * <p>
 * <p>
 * Example Input
 * A = [1,2,-2,4,-4]
 * <p>
 * <p>
 * Example Output
 * [2,-2,4,-4]
 * <p>
 * <p>
 * Example Explanation
 * [2,-2,4,-4] is the longest sequence with total sum of zero.
 */
public class LargestContinuousSequenceZeroSum {

    /**
     * Using prefix sum and hashing. TC: O(N), SC: O(N)
     */
    public int[] lszero(int[] A) {
        if (A.length == 0) return new int[]{};
        Map<Integer, Integer> map = new HashMap<>();
        int lengthOfSubArray = 0;
        int l = 0;
        int r = -1;
        int[] ps = new int[A.length];
        ps[0] = A[0];
        for (int i = 1; i < A.length; i++) {
            ps[i] = ps[i - 1] + A[i];
        }
        map.put(0, -1); // before entering the for loop
        // you need to add map(0 with -1) as if sub array starts from first index itself.
        for (int i = 0; i < A.length; i++) {
            if (!map.containsKey(ps[i])) {
                map.put(ps[i], i);
            }
            int left_index = map.get(ps[i]) + 1; // Left index of the subarry that we need.
            int right_index = i;
            int cur_length = right_index - left_index + 1;
            if (cur_length > lengthOfSubArray) { // In this condition, we update the ans.
                l = left_index;
                r = right_index;
                lengthOfSubArray = cur_length;
            }
        }
        List<Integer> list = new ArrayList<>(); // Taking list as we need a dynamic array size.
        for (int i = l; i <= r; i++) {
            list.add(A[i]);
        }
        // Put all the elements from the list into the ans[].
        int[] ans = new int[list.size()];
        int i = 0;
        while (i < list.size()) {
            ans[i] = list.get(i);
            i++;
        }
        return ans;
    }
}
