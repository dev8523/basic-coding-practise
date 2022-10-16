package com.debasish.practise.dsa.topicwise.backtracking;

import java.util.*;

/**
 * Problem Description
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
 *
 *
 *
 * Given an integer A, return all distinct solutions to the n-queens puzzle.
 *
 * Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.
 * The final list should be generated in such a way that the indices of the queens in each list should be in reverse lexicographical order.
 *
 *
 * Problem Constraints
 * 1 <= A <= 10
 *
 *
 *
 * Input Format
 * First argument is an integer n denoting the size of chessboard
 *
 *
 *
 * Output Format
 * Return an array consisting of all distinct solutions in which each element is a 2d char array representing a unique solution.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 * A = 4
 * Input 2:
 *
 * A = 1
 *
 *
 * Example Output
 * Output 1:
 *
 * [
 *  [".Q..",  // Solution 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 *
 *  ["..Q.",  // Solution 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 * Output 1:
 *
 * [
 *  [Q]
 * ]
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 * There exist only two distinct solutions to the 4-queens puzzle:
 * Explanation 1:
 *
 * There exist only one distinct solutions to the 1-queens puzzle:
 */
public class NQueens {
    public ArrayList<ArrayList<String>> solveNQueens(int n) {
        if (A == 2 || A == 3) return new ArrayList<>();
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        dfs(result, new ArrayList<>(), 0, n);
        return result;
    }

    /**
     * Conditions to place a queen at (i, j):
     * 1. No queen in ith row: use hashset - O(1)
     * 2. No queen in jth col: use hashset - O(1)
     * 3. No queen in both diagonals: use hashset - O(1)
     * <p>
     * Recursive relation: T(N) = [T(N-1) * (N-1)] + 1
     * TC: O(N!)
     * SC: O(N) - max depth of the recursion tree will be N
     */
    private void dfs(ArrayList<ArrayList<String>> result, List<Integer> list, int row, int n) {
        if (row == n) {
            ArrayList<String> tempList = new ArrayList<>();
            for (int x : list) {
                char[] arr = new char[n];
                Arrays.fill(arr, '.');
                arr[x] = 'Q';
                tempList.add(new String(arr));
            }
            result.add(tempList);
            return;
        }

        Set<Integer> colSet = new HashSet<>();
        Set<Integer> leftDiagSet = new HashSet<>();
        Set<Integer> rightDiagSet = new HashSet<>();

        for (int col = 0; col < n; col++) {
            if (colSet.contains(col) || leftDiagSet.contains(row + col) || rightDiagSet.contains(row - col))
                continue;

            // DO
            list.add(col);
            colSet.add(col);
            leftDiagSet.add(row + col);
            rightDiagSet.add(row - col);

            // Recur call
            dfs(result, list, row + 1, n);

            // UNDO
            list.remove(list.size() - 1);
            colSet.remove(col);
            leftDiagSet.remove(row + col);
            rightDiagSet.remove(row - col);
        }
    }
}
