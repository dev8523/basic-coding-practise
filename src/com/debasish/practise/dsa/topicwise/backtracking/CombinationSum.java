package com.debasish.practise.dsa.topicwise.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

/**
 * Problem Description
 * Given an array of candidate numbers A and a target number B, find all unique combinations in A where the candidate numbers sums to B.
 *
 * The same repeated number may be chosen from A unlimited number of times.
 *
 * Note:
 *
 * 1) All numbers (including target) will be positive integers.
 *
 * 2) Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
 *
 * 3) The combinations themselves must be sorted in ascending order.
 *
 * 4) CombinationA > CombinationB iff (a1 > b1) OR (a1 = b1 AND a2 > b2) OR ... (a1 = b1 AND a2 = b2 AND ... ai = bi AND ai+1 > bi+1)
 *
 * 5) The solution set must not contain duplicate combinations.
 *
 *
 *
 * Problem Constraints
 * 1 <= |A| <= 20
 *
 * 1 <= A[i] <= 50
 *
 * 1 <= B <= 500
 *
 *
 *
 * Input Format
 * The first argument is an integer array A.
 *
 * The second argument is integer B.
 *
 *
 *
 * Output Format
 * Return a vector of all combinations that sum up to B.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 * A = [2, 3]
 * B = 2
 * Input 2:
 *
 * A = [2, 3, 6, 7]
 * B = 7
 *
 *
 * Example Output
 * Output 1:
 *
 * [ [2] ]
 * Output 2:
 *
 * [ [2, 2, 3] , [7] ]
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 * All possible combinations are listed.
 * Explanation 2:
 *
 * All possible combinations are listed.
 */
public class CombinationSum {
    public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B) {
        ArrayList<Integer> current = new ArrayList<>();
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        Collections.sort(A);
        ArrayList<Integer> uniqueCandidates = new ArrayList<>();

        // we can use HashSet as well here.
        for (int i = 0; i < A.size(); i++) {
            if (i == 0 || !Objects.equals(A.get(i), A.get(i - 1))) {
                uniqueCandidates.add(A.get(i));
            }
        }
        combinationRecur(uniqueCandidates, 0, current, 0, B, ans);
        return ans;
    }

    /**
     * Using BACKTRACKING.
     * <p>
     * TC: O(2^N)
     * SC: O(N)
     *
     * @param uniqueCandidates input arr
     * @param idx              index
     * @param current          current element that we are considering
     * @param currentSum       holds current sum
     * @param target           given target
     * @param ans              ans list
     */
    private void combinationRecur(ArrayList<Integer> uniqueCandidates, int idx,
                                  ArrayList<Integer> current,
                                  int currentSum,
                                  int target,
                                  ArrayList<ArrayList<Integer>> ans) {

        // If currentSum is greater than target, then don't CHOOSE.
        if (currentSum > target) return;

        // CHOOSE
        if (currentSum == target) ans. add(new ArrayList<>(current));

        for (int i = idx; i < uniqueCandidates.size(); i++) {

            // Include in current list - DO
            current.add(uniqueCandidates.get(i));
            currentSum += uniqueCandidates.get(i);

            // recur call with current i index.
            combinationRecur(uniqueCandidates, i, current, currentSum, target, ans);

            // Don't include in current list - UNDO
            current.remove(uniqueCandidates.get(i));
            currentSum -= uniqueCandidates.get(i);
        }
    }
}
