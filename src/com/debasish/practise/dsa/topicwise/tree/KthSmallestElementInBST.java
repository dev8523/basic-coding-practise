package com.debasish.practise.dsa.topicwise.tree;

/**
 * Problem Description
 * Given a binary search tree represented by root A, write a function to find the Bth smallest element in the tree.
 *
 *
 *
 * Problem Constraints
 * 1 <= Number of nodes in binary tree <= 100000
 *
 * 0 <= node values <= 10^9
 *
 *
 *
 * Input Format
 * First and only argument is head of the binary tree A.
 *
 *
 *
 * Output Format
 * Return an integer, representing the Bth element.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *
 *             2
 *           /   \
 *          1    3
 * B = 2
 * Input 2:
 *
 *
 *             3
 *            /
 *           2
 *          /
 *         1
 * B = 1
 *
 *
 *
 * Example Output
 * Output 1:
 *
 *  2
 * Output 2:
 *
 *  1
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 * 2nd element is 2.
 * Explanation 2:
 *
 * 1st element is 1.
 */
public class KthSmallestElementInBST {
    int count = 0, ans = Integer.MIN_VALUE;

    /**
     * Do Inorder traversal and take a global count which increments each time we visit a node.
     * TC: O(K) or O(N) in worst case.
     * SC: O(H) - Recursion stack space of tree's height.
     */
    public int kthSmallest(TreeNode root, int k) {
        if (root == null) return ans;
        if (ans != Integer.MIN_VALUE) return ans;
        kthSmallest(root.left, k);
        count++;
        if (count == k) ans = root.val;
        kthSmallest(root.right, k);
        return ans;
    }
}
