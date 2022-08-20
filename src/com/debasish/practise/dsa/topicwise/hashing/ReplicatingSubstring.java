package com.debasish.practise.dsa.topicwise.hashing;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem Description
 * <p>
 * Given a string B, find if it is possible to re-order the characters of the string B so that it can be represented as a concatenation of A similar strings.
 * <p>
 * Eg: B = aabb and A = 2, then it is possible to re-arrange the string as "abab" which is a concatenation of 2 similar strings "ab".
 * <p>
 * If it is possible, return 1, else return -1.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * <p>
 * 1 <= Length of string B <= 1000
 * <p>
 * 1 <= A <= 1000
 * <p>
 * All the alphabets of S are lower case (a - z)
 * <p>
 * <p>
 * <p>
 * Input Format
 * <p>
 * First argument is an integer A.
 * Second argument is a string B.
 * <p>
 * <p>
 * <p>
 * Output Format
 * <p>
 * Your function should return 1 if it is possible to re-arrange the characters of the string B so that it can be represented as a concatenation of A similar strings. If it is not, return -1.
 * <p>
 * <p>
 * <p>
 * Example Input
 * <p>
 * Input 1:
 * <p>
 * A = 2
 * B = "bbaabb"
 * Input 2:
 * <p>
 * A = 1
 * B = "bc"
 * <p>
 * <p>
 * Example Output
 * <p>
 * Output 1:
 * <p>
 * 1
 * Output 2:
 * <p>
 * 1
 * <p>
 * <p>
 * Example Explanation
 * <p>
 * Explanation 1:
 * <p>
 * We can re-order the given string into "abbabb".
 * Explanation 2:
 * <p>
 * String "bc" is already arranged.
 */
public class ReplicatingSubstring {
    public int solve(int A, String B) {
        // In this question, every char should come as a multiple of A.

        // So approach is using frequency map, we can:
        // Step-1: Create freqMap<char, charCount>
        // Step-2: Check if every char should come as a multiple of A.

        // Worst case TC: O(N), SC: O(N)
        Map<Character, Integer> freqMap = new HashMap<>();
        // create freqMap
        for (char c : B.toCharArray()) {
            if (freqMap.containsKey(c)) {
                freqMap.put(c, freqMap.get(c) + 1);
            } else {
                freqMap.put(c, 1);
            }
        }
        // using keySet() for iteration over keys
        for (char c : freqMap.keySet()) {
            if (freqMap.get(c) % A != 0) {
                return -1;
            }
        }
        return 1;
    }
}
