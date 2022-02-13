package com.debasish.practise.dsa.topicwise.hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author debasishsahoo
 * <p>
 * Problem Description
 * <p>
 * Given two integer array A and B of size N and M respectively. Your task is to find all the common elements in both the array.
 * <p>
 * NOTE:
 * <p>
 * Each element in the result should appear as many times as it shows in both arrays.
 * The result can be in any order.
 * <p>
 * Input Format
 * <p>
 * First argument is an integer array A of size N.
 * <p>
 * Second argument is an integer array B of size M.
 * <p>
 * Output Format
 * <p>
 * Return an integer array denoting the common elements.
 * <p>
 * Example Input
 * <p>
 * Input 1:
 * <p>
 * A = [1, 2, 2, 1]
 * B = [2, 3, 1, 2]
 * Input 2:
 * <p>
 * A = [2, 1, 4, 10]
 * B = [3, 6, 2, 10, 10]
 * <p>
 * Example Output
 * <p>
 * Output 1:
 * <p>
 * [1, 2, 2]
 * Output 2:
 * <p>
 * [2, 10]
 * <p>
 * Example Explanation
 * <p>
 * Explanation 1:
 * <p>
 * Elements (1, 2, 2) appears in both the array. Note 2 appears twice in both the array.
 * Explantion 2:
 * <p>
 * Elements (2, 10) appears in both the array.
 */
public class FindCommonElements {
    // TC: O(N) and SC: O(N)
    public int[] solve(int[] A, int[] B) {
        // 1. First find the frequencyMap of A array.
        // 2. Check each element of B is present in the frequencyMap of A.
        // 3. If key/element is present then add to the list and decrement once the count as the element is once visited.
        // 4. Perform this for every element of B, once we get the count for any element as 0 from frequencyMap, remove that from the frequencyMap.
        // 5. Create an ans array of the list.size() and put all elements from the list to this ans[] and return the ans[].
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            if (!(frequencyMap.containsKey(A[i]))) {
                frequencyMap.put(A[i], 0);
            }
            count = frequencyMap.get(A[i]);
            frequencyMap.replace(A[i], count + 1);
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < B.length; i++) {
            int val = B[i];
            if (frequencyMap.containsKey(val)) {
                list.add(val);
                frequencyMap.replace(val, frequencyMap.get(val) - 1);
                if (frequencyMap.get(val) == 0) {
                    frequencyMap.remove(val);
                }
            }
        }
        int[] ans = new int[list.size()];
        int i = 0;
        while (i < list.size()) {
            ans[i] = list.get(i);
            i++;
        }
        return ans;
    }
}
