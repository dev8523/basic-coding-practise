package com.debasish.practise.dsa.topicwise.tree;

public class BalancedHeightBinaryTree {
    private static boolean isHeightBalanced(TreeNode root) {
        boolean result = true;
        isBalancedHelper(root, result);
        return result;
    }

    private static int isBalancedHelper(TreeNode root, boolean result) {
        if (root == null) return 0;
        int leftHeight = isBalancedHelper(root.left, result);
        int rightHeight = isBalancedHelper(root.right, result);
        if (Math.abs(leftHeight - rightHeight) > 0) result = false;
        return 1 + Math.max(leftHeight, rightHeight);
    }

    /**
     * TC: O(N) - Visiting each node for once.
     * SC: O(N) - recursion stack space.
     */
    public static int isBalanced(TreeNode A) {
        return isHeightBalanced(A) ? 1 : 0;
    }
}
