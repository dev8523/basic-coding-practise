package com.debasish.practise.dsa.topicwise.tree;

public class BalancedHeightBinaryTree {
    static boolean result;

    private static boolean isHeightBalanced(TreeNode root) {
        result = true;
        isBalancedHelper(root);
        return result;
    }

    private static int isBalancedHelper(TreeNode root) {
        if (root == null) return 0;
        int leftHeight = isBalancedHelper(root.left);
        int rightHeight = isBalancedHelper(root.right);
        if (Math.abs(leftHeight - rightHeight) > 1) result = false;
        return 1 + Math.max(leftHeight, rightHeight);
    }

    /**
     * TC: O(N) - Visiting each node for once.
     * SC: O(N) - recursion stack space.
     */
    public int isBalanced(TreeNode A) {
        return isHeightBalanced(A) ? 1 : 0;
    }
}
