package com.debasish.practise.dsa.topicwise.tree;

import java.util.HashSet;
import java.util.Set;

/**
 * Problem Description
 * Given a binary tree A. Check whether it is possible to partition the tree to two trees which have equal sum of values after removing exactly one edge on the original tree.
 *
 *
 *
 * Problem Constraints
 * 1 <= size of tree <= 100000
 *
 * 0 <= value of node <= 109
 *
 *
 *
 * Input Format
 * First and only argument is head of tree A.
 *
 *
 *
 * Output Format
 * Return 1 if the tree can be partitioned into two trees of equal sum else return 0.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *
 *                 5
 *                /  \
 *               3    7
 *              / \  / \
 *             4  6  5  6
 * Input 2:
 *
 *
 *                 1
 *                / \
 *               2   10
 *                   / \
 *                  20  2
 *
 *
 * Example Output
 * Output 1:
 *
 *  1
 * Output 2:
 *
 *  0
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  Remove edge between 5(root node) and 7:
 *         Tree 1 =                                               Tree 2 =
 *                         5                                                     7
 *                        /                                                     / \
 *                       3                                                     5   6
 *                      / \
 *                     4   6
 *         Sum of Tree 1 = Sum of Tree 2 = 18
 * Explanation 2:
 *
 *  The given Tree cannot be partitioned.
 */
public class EqualTreePartition {
    /**
     * TC: O(N)
     * SC: O(N)
     */
    static int checkEqualPartition(TreeNode root) {
        int flag = 0;
        Set<Long> set = new HashSet<>();
        long sum = dfs(root, set, flag);
        if (sum == 0) return flag;
        if (((sum & 1) == 1)) return 0; // check if sum is odd, then we cannot halve.
        if (set.contains(sum / 2)) return 1; // if HashSet contains the sum, then it can be partitioned.
        return 0;
    }

    static long dfs(TreeNode root, Set<Long> set, int flag) {
        if (root == null) return 0;
        long cur = root.val + dfs(root.left, set, flag) + dfs(root.right, set, flag);
        set.add(cur);
        return cur;
    }

    public int solve(TreeNode A) {
        return checkEqualPartition(A);
    }
}
