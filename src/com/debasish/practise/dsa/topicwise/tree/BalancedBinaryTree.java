package com.debasish.practise.dsa.topicwise.tree;

/**
 * Problem Description
 * Given a root of binary tree A, determine if it is height-balanced.
 *
 * A height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 *
 *
 *
 * Problem Constraints
 * 1 <= size of tree <= 100000
 *
 *
 *
 * Input Format
 * First and only argument is the root of the tree A.
 *
 *
 *
 * Output Format
 * Return 0 / 1 ( 0 for false, 1 for true ) for this problem.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *     1
 *    / \
 *   2   3
 * Input 2:
 *
 *
 *        1
 *       /
 *      2
 *     /
 *    3
 *
 *
 * Example Output
 * Output 1:
 *
 * 1
 * Output 2:
 *
 * 0
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 * It is a complete binary tree.
 * Explanation 2:
 *
 * Because for the root node, left subtree has depth 2 and right subtree has depth 0.
 * Difference = 2 > 1.
 */
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
