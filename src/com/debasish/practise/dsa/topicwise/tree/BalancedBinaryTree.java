package com.debasish.practise.dsa.topicwise.tree;

/**
 * Problem Description
 * Given a root of binary tree A, determine if it is height-balanced.
 * <p>
 * A height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= size of tree <= 100000
 * <p>
 * <p>
 * <p>
 * Input Format
 * First and only argument is the root of the tree A.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return 0 / 1 ( 0 for false, 1 for true ) for this problem.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * 1
 * / \
 * 2   3
 * Input 2:
 * <p>
 * <p>
 * 1
 * /
 * 2
 * /
 * 3
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * 1
 * Output 2:
 * <p>
 * 0
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * It is a complete binary tree.
 * Explanation 2:
 * <p>
 * Because for the root node, left subtree has depth 2 and right subtree has depth 0.
 * Difference = 2 > 1.
 */
public class BalancedBinaryTree {
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
