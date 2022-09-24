package com.debasish.practise.dsa.topicwise.tree;

/**
 * Problem Description
 * Given a Binary Tree A consisting of N integer nodes, you need to find the diameter of the tree.
 * <p>
 * The diameter of a tree is the number of edges on the longest path between two nodes in the tree.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 0 <= N <= 105
 * <p>
 * <p>
 * <p>
 * Input Format
 * First and only Argument represents the root of binary tree A.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return an single integer denoting the diameter of the tree.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * 1
 * /   \
 * 2     3
 * / \
 * 4   5
 * Input 2:
 * <p>
 * 1
 * /   \
 * 2     3
 * / \     \
 * 4   5     6
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * 3
 * Output 2:
 * <p>
 * 4
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * Longest Path in the tree is 4 -> 2 -> 1 -> 3 and the number of edges in this path is 3 so diameter is 3.
 * Explanation 2:
 * <p>
 * Longest Path in the tree is 4 -> 2 -> 1 -> 3 -> 6 and the number of edges in this path is 4 so diameter is 4.
 */
public class DiameterOfBinaryTree {
    int dia = 0;

    /**
     * Find the diameter of a binary tree by finding the height of the tree.
     * <p>
     * TC: O(N)
     * SC:(H) - Height of the tree. In worst case it would be O(N) in case of skewed tree.
     */
    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return dia;
    }

    private int maxDepth(TreeNode root) {
        if (root == null) return 0;

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        dia = Math.max(dia, left + right);

        return Math.max(left, right) + 1;
    }
}
