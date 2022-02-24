package com.debasish.practise.dsa.topicwise.hashing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author debasishsahoo
 * <p>
 * Problem Description
 * <p>
 * You are given an array of N integers, A1, A2 ,…, AN and an integer B. Return the of count of distinct numbers in all windows of size B.
 * <p>
 * Formally, return an array of size N-B+1 where i'th element in this array contains number of distinct elements in sequence Ai, Ai+1 ,..., Ai+B-1.
 * <p>
 * NOTE: if B > N, return an empty array.
 * <p>
 * Example Input
 * <p>
 * Input 1:
 * <p>
 * A = [1, 2, 1, 3, 4, 3]
 * B = 3
 * <p>
 * Input 2:
 * <p>
 * A = [1, 1, 2, 2]
 * B = 1
 * <p>
 * Example Output
 * <p>
 * Output 1:
 * <p>
 * [2, 3, 3, 2]
 * <p>
 * Output 2:
 * <p>
 * [1, 1, 1, 1]
 * <p>
 * Example Explanation
 * <p>
 * Explanation 1:
 * <p>
 * A=[1, 2, 1, 3, 4, 3] and B = 3
 * All windows of size B are
 * [1, 2, 1]
 * [2, 1, 3]
 * [1, 3, 4]
 * [3, 4, 3]
 * So, we return an array [2, 3, 3, 2].
 * <p>
 * Explanation 2:
 * <p>
 * Window size is 1, so the output array is [1, 1, 1, 1].
 */
public class FindDistinctNumbersInWindow {

    // TC : O(N * B) and SC : O(N) => Compiler will give TLE error
    public int[] dNumsBruteForce(int[] A, int B) {
        int N = A.length;
        int[] ans = new int[N - B + 1];
        for (int i = 0; i <= N - B; i++) { // outer loop will iterate over all the starting elements of the sliding window.
            int j = B + i - 1; // Ending index of the subarray.
            Set<Integer> set = new HashSet<>();
            for (int k = i; k <= j; k++) { // iterates over each elements of each sliding window
                set.add(A[k]);
            }
            ans[i] = set.size();
        }
        return ans;
    }

    public int[] dNums(int[] A, int B) {
        int N = A.length;
        int[] ans = new int[N - B + 1];
        //System.out.println(N - B + 1);
        Map<Integer, Integer> freqMap = new HashMap<>();
        int count = 0;
        for (int i = 0; i < B; i++) {
            if (freqMap.containsKey(A[i])) {
                freqMap.put(A[i], freqMap.get(A[i]) + 1);
            } else {
                freqMap.put(A[i], 1);
                count++;
            }
        }
        ans[0] = count;
        for (int i = B; i < N; i++) {
            int j = i - B;
            if (freqMap.get(A[j]) == 1) {
                count--;
            }
            freqMap.put(A[j], freqMap.get(A[j]) - 1);
            if (freqMap.containsKey(A[i]) && freqMap.get(A[i]) >= 1) {
                freqMap.put(A[i], freqMap.get(A[i]) + 1);
            } else {
                freqMap.put(A[i], 1);
                count++;
            }
            ans[j + 1] = count;
        }
        return ans;
    }
}
