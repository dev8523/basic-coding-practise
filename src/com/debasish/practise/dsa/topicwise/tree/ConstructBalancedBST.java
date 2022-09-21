package com.debasish.practise.dsa.topicwise.tree;

/**
 * Problem Description
 * Given an array where elements are sorted in ascending order, convert it to a height Balanced Binary Search Tree (BBST).
 *
 * Balanced tree : a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 *
 *
 *
 * Problem Constraints
 * 1 <= length of array <= 100000
 *
 *
 *
 * Input Format
 * First argument is an integer array A.
 *
 *
 *
 * Output Format
 * Return a root node of the Binary Search Tree.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A : [1, 2, 3]
 * Input 2:
 *
 *  A : [1, 2, 3, 5, 10]
 *
 *
 * Example Output
 * Output 1:
 *
 *       2
 *     /   \
 *    1     3
 * Output 2:
 *
 *       3
 *     /   \
 *    2     5
 *   /       \
 *  1         10
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  You need to return the root node of the Binary Tree.
 */
public class ConstructBalancedBST {
    /**
     * TC: O(N) - We are considering all the nodes.
     * SC: O(logN) - As it is a balanced BST
     * <p>
     * Given can be a sorted array or an inorder tree. - Both are same.
     */
    private static TreeNode createBalancedBST(int[] sortedArr, int start, int end) {
        if (start > end) return null;
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(sortedArr[mid]);
        root.left = createBalancedBST(sortedArr, start, mid - 1);
        root.right = createBalancedBST(sortedArr, mid + 1, end);
        return root;
    }

    public TreeNode sortedArrayToBST(final int[] A) {
        return createBalancedBST(A, 0, A.length - 1);
    }
}
