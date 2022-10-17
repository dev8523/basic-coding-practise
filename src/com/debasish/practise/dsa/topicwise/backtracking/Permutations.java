package com.debasish.practise.dsa.topicwise.backtracking;

import java.util.ArrayList;

/**
 * Problem Description
 * Given an integer array A of size N denoting collection of numbers , return all possible permutations.
 *
 * NOTE:
 *
 * No two entries in the permutation sequence should be the same.
 * For the purpose of this problem, assume that all the numbers in the collection are unique.
 * Return the answer in any order
 * WARNING: DO NOT USE LIBRARY FUNCTION FOR GENERATING PERMUTATIONS.
 * Example : next_permutations in C++ / itertools.permutations in python.
 * If you do, we will disqualify your submission retroactively and give you penalty points.
 *
 *
 * Problem Constraints
 * 1 <= N <= 9
 *
 *
 *
 * Input Format
 * Only argument is an integer array A of size N.
 *
 *
 *
 * Output Format
 * Return a 2-D array denoting all possible permutation of the array.
 *
 *
 *
 * Example Input
 * A = [1, 2, 3]
 *
 *
 * Example Output
 * [ [1, 2, 3]
 *   [1, 3, 2]
 *   [2, 1, 3]
 *   [2, 3, 1]
 *   [3, 1, 2]
 *   [3, 2, 1] ]
 *
 *
 * Example Explanation
 * All the possible permutation of array [1, 2, 3].
 */
public class Permutations {

    /**
     * Using BACKTRACKING
     * TC: O(N! * N)
     * SC: O(N)
     */
    private static void generatePermutations(ArrayList<ArrayList<Integer>> resList,
                                             ArrayList<Integer> tempList,
                                             ArrayList<Integer> A) {
        // BASE condition
        if (tempList.size() == A.size()) {
            resList.add(new ArrayList<>(tempList));
            return;
        }

        for (int i = 0; i < A.size(); i++) {
            if (tempList.contains(A.get(i))) continue;
            // DO step
            tempList.add(A.get(i));

            // Recursion call for next index elements : solving sub-problem
            generatePermutations(resList, tempList, A);

            // UNDO step - restore original condition
            tempList.remove(tempList.size() - 1);
        }
    }

    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
        // parameter required are - start index, input array and
        // temp placeholder
        ArrayList<ArrayList<Integer>> resList = new ArrayList<>();
        generatePermutations(resList, new ArrayList<Integer>(), A);
        return resList;
    }
}
