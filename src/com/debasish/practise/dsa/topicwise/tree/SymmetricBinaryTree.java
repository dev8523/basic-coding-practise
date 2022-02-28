package com.debasish.practise.dsa.topicwise.tree;

/**
 * @author debasishsahoo
 * <p>
 * Problem Description
 * <p>
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 */
public class SymmetricBinaryTree {
    public int isSymmetric(TreeNode A) {
        if (isSymmetrical(A, A)) return 1;
        else return 0;
    }

    boolean isSymmetrical(TreeNode A, TreeNode B) {
        if (A == null && B == null) return true;
        if (A == null || B == null) return false;
        if (A.val != B.val) return false;
        return isSymmetrical(A.left, B.right) && isSymmetrical(A.right, B.left);
    }
}
