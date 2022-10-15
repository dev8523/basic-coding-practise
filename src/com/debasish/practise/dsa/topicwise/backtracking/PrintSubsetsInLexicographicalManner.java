package com.debasish.practise.dsa.topicwise.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Problem Description
 * Given a set of distinct integers A, return all possible subsets.
 *
 * NOTE:
 *
 * Elements in a subset must be in non-descending order.
 * The solution set must not contain duplicate subsets.
 * Also, the subsets should be sorted in ascending ( lexicographic ) order.
 * The list is not necessarily sorted.
 *
 *
 * Problem Constraints
 * 1 <= |A| <= 16
 * INTMIN <= A[i] <= INTMAX
 *
 *
 * Input Format
 * First and only argument of input contains a single integer array A.
 *
 *
 *
 * Output Format
 * Return a vector of vectors denoting the answer.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 * A = [1]
 * Input 2:
 *
 * A = [1, 2, 3]
 *
 *
 * Example Output
 * Output 1:
 *
 * [
 *     []
 *     [1]
 * ]
 * Output 2:
 *
 * [
 *  []
 *  [1]
 *  [1, 2]
 *  [1, 2, 3]
 *  [1, 3]
 *  [2]
 *  [2, 3]
 *  [3]
 * ]
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  You can see that these are all possible subsets.
 * Explanation 2:
 *
 * You can see that these are all possible subsets.
 */
public class PrintSubsetsInLexicographicalManner {

    /**
     * TC: O(no. function calls * TC per fun) + O(sorting) = O(2^N+1 * 1) = O(2^N) + O(N^2 * 2^N)
     * SC: O(N)
     */
    private static void generateSubsets(List<Integer> input,
                                        int index,
                                        ArrayList<ArrayList<Integer>> result,
                                        ArrayList<Integer> subsets) {

        if (index < 0 || index >= input.size()) {
            return;
        }

        // case 1 - choosing the current value
        // DO Step
        subsets.add(input.get(index));

        result.add(new ArrayList<>(subsets));

        // Recur Step
        generateSubsets(input, index + 1, result, subsets);

        // UNDO Step
        subsets.remove(subsets.size() - 1);

        // case 2 - Not Choosing current value
        generateSubsets(input, index + 1, result, subsets);
    }

    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int index = 0;

        // Since values are required in lexicographical order lets sort given collection
        Collections.sort(A);
        result.add(new ArrayList<>());
        generateSubsets(A, index, result, new ArrayList<>());
        return result;
    }
}
