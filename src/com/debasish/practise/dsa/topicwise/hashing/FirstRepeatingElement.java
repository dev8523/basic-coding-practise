package com.debasish.practise.dsa.topicwise.hashing;

import java.util.HashMap;
import java.util.Map;

/**
 * @author debasishsahoo
 * <p>
 * Problem Description
 * <p>
 * Given an integer array A of size N, find the first repeating element in it.
 * <p>
 * We need to find the element that occurs more than once and whose index of first occurrence is smallest.
 * <p>
 * If there is no repeating element, return -1.
 * <p>
 * Example Input
 * <p>
 * Input 1:
 * <p>
 * A = [10, 5, 3, 4, 3, 5, 6]
 * Input 2:
 * <p>
 * A = [6, 10, 5, 4, 9, 120]
 * <p>
 * Example Output
 * <p>
 * Output 1:
 * <p>
 * 5
 * Output 2:
 * <p>
 * -1
 * <p>
 * Example Explanation
 * <p>
 * Explanation 1:
 * <p>
 * 5 is the first element that repeats
 * Explanation 2:
 * <p>
 * There is no repeating element, output -1
 */
public class FirstRepeatingElement {
    public int solve(int[] A) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            if (!(frequencyMap.containsKey(A[i]))) {
                frequencyMap.put(A[i], 1);
                continue;
            }
            count = frequencyMap.get(A[i]);
            frequencyMap.put(A[i], count + 1);
        }
        for (int i = 0; i < A.length; i++) {
            if (frequencyMap.get(A[i]) > 1) {
                return A[i];
            }
        }
        return -1;
    }
}
