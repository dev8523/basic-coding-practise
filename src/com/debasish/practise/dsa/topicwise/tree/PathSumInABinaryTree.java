package com.debasish.practise.dsa.topicwise.tree;

/**
 * Problem Description
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
 *
 *
 *
 * Problem Constraints
 * 1 <= number of nodes <= 105
 *
 * -100000 <= B, value of nodes <= 100000
 *
 *
 *
 * Input Format
 * First argument is a root node of the binary tree, A.
 *
 * Second argument is an integer B denoting the sum.
 *
 *
 *
 * Output Format
 * Return 1, if there exist root-to-leaf path such that adding up all the values along the path equals the given sum. Else, return 0.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  Tree:    5
 *          / \
 *         4   8
 *        /   / \
 *       11  13  4
 *      /  \      \
 *     7    2      1
 *
 *  B = 22
 * Input 2:
 *
 *  Tree:    5
 *          / \
 *         4   8
 *        /   / \
 *      -11 -13  4
 *
 *  B = -1
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
 *  There exist a root-to-leaf path 5 -> 4 -> 11 -> 2 which has sum 22. So, return 1.
 * Explanation 2:
 *
 *  There is no path which has sum -1.
 */
public class PathSumInABinaryTree {
    /**
     * TC: O(N) - no of nodes
     * SC: O(H) - height of the tree.
     * worst case SC: O(logN) - in case of unbalanced tree i.e., skewed tree
     */
    public int hasPathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        sum = sum - root.val;
        if (root.left == null && root.right == null) { // This condition verifies if it's a leaf node.
            return sum == 0 ? 1 : 0; // if sum = 0, then return 1 else return 0.
        }
        return (hasPathSum(root.left, sum) == 1 || hasPathSum(root.right, sum) == 1)
                ? 1
                : 0;
    }
}
