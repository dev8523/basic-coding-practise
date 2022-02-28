package com.debasish.practise.dsa.topicwise.tree;

/**
 * @author debasishsahoo
 * Problem Description
 * <p>
 * Given a binary search tree of integers. You are given a range B and C.
 * <p>
 * Return the count of the number of nodes that lies in the given range.
 */
public class BSTNodesInARange {
    public int solve(TreeNode A, int B, int C) {
        if (A == null) return 0;
        if (A.val <= C && A.val >= B) return 1 + solve(A.left, B, C) + solve(A.right, B, C);
        else if (A.val < B) return solve(A.right, B, C);
        else return solve(A.left, B, C);
    }
}
