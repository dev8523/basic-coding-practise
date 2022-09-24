package com.debasish.practise.dsa.topicwise.tree;

/**
 * Problem Description
 * Given a Binary Tree A consisting of N integer nodes, you need to find the diameter of the tree.
 *
 * The diameter of a tree is the number of edges on the longest path between two nodes in the tree.
 *
 *
 *
 * Problem Constraints
 * 0 <= N <= 105
 *
 *
 *
 * Input Format
 * First and only Argument represents the root of binary tree A.
 *
 *
 *
 * Output Format
 * Return an single integer denoting the diameter of the tree.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *            1
 *          /   \
 *         2     3
 *        / \
 *       4   5
 * Input 2:
 *
 *             1
 *           /   \
 *          2     3
 *         / \     \
 *        4   5     6
 *
 *
 * Example Output
 * Output 1:
 *
 *  3
 * Output 2:
 *
 *  4
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  Longest Path in the tree is 4 -> 2 -> 1 -> 3 and the number of edges in this path is 3 so diameter is 3.
 * Explanation 2:
 *
 *  Longest Path in the tree is 4 -> 2 -> 1 -> 3 -> 6 and the number of edges in this path is 4 so diameter is 4.
 */
public class DiameterOfBinaryTree {
    int dia = -1;

    /**
     * Find the diameter of a binary tree by finding the height of the tree.
     * <p>
     * TC: O(N)
     * SC:(H) - Height of the tree. In worst case it would be O(N) in case of skewed tree.
     */
    public int findDiameterOfABinaryTree(TreeNode root) {
        if (root == null) return -1;
        int left = findDiameterOfABinaryTree(root.left);
        int right = findDiameterOfABinaryTree(root.right);
        int curHeight = 1 + Math.max(left, right);
        dia = Math.max(dia, 2 + left + right);
        return curHeight;
    }
}
