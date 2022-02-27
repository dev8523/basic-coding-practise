package com.debasish.practise.dsa.topicwise.tree;

/**
 * @author debasishsahoo
 * <p>
 * Problem Description
 * <p>
 * Given two binary trees, check if they are equal or not.
 * <p>
 * Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
 */
public class IdenticalBinaryTrees {
    public int isSameTree(TreeNode A, TreeNode B) {
        if (isIdentical(A, B)) return 1;
        else return 0;
    }

    boolean isIdentical(TreeNode A, TreeNode B) {
        if (A == null && B == null) return true;
        if (A == null || B == null) return false;
        if (A.val != B.val) return false;
        return isIdentical(A.left, B.left) && isIdentical(A.right, B.right);
    }
}
