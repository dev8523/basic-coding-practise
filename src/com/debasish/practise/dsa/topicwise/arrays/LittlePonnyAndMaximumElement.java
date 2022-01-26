package com.debasish.practise.dsa.topicwise.arrays;

/**
 * Problem Description
 * <p>
 * Little Ponny is given an array, A, of N integers. In a particular operation, he can set any element of the array equal to -1.
 * <p>
 * He wants your help for finding out the minimum number of operations required such that the maximum element of the resulting array is B. If it is not possible then return -1.
 * <p>
 * Example Input
 * <p>
 * Input 1:
 * <p>
 * A = [2, 4, 3, 1, 5]
 * B = 3
 * <p>
 * Input 2:
 * <p>
 * A = [1, 4, 2]
 * B = 3
 * <p>
 * Example Output
 * <p>
 * Output 1: 2
 * <p>
 * Output 2: -1
 */
public class LittlePonnyAndMaximumElement {
    public class Solution {
        public int solve(int[] A, int B) {
            int cnt = 0, flag = 0;
            for (int i = 0; i < A.length; i++) {
                if (A[i] == B) flag = 1;
                if (A[i] > B) cnt++;
            }
            if (flag == 1) return cnt;
            return -1;
        }
    }
}
