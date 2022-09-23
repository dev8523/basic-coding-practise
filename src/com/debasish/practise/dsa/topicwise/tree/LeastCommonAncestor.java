package com.debasish.practise.dsa.topicwise.tree;

/**
 * Problem Description
 * Find the lowest common ancestor in an unordered binary tree A, given two values, B and C, in the tree.
 *
 * Lowest common ancestor: the lowest common ancestor (LCA) of two nodes and w in a tree or directed acyclic graph (DAG) is the lowest (i.e., deepest) node that has both v and w as descendants.
 *
 *
 *
 * Problem Constraints
 * 1 <= size of tree <= 100000
 *
 * 1 <= B, C <= 109
 *
 *
 *
 * Input Format
 * First argument is head of tree A.
 *
 * Second argument is integer B.
 *
 * Third argument is integer C.
 *
 *
 *
 * Output Format
 * Return the LCA.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *
 *       1
 *      /  \
 *     2    3
 * B = 2
 * C = 3
 * Input 2:
 *
 *       1
 *      /  \
 *     2    3
 *    / \
 *   4   5
 * B = 4
 * C = 5
 *
 *
 * Example Output
 * Output 1:
 *
 *  1
 * Output 2:
 *
 *  2
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  LCA is 1.
 * Explanation 2:
 *
 *  LCA is 2.
 */
public class LeastCommonAncestor {
    /**
     * TC: O(N), N is no of nodes
     * SC: O(H) - recursion stack max storing height of tree.
     */
    public int lca(TreeNode A, int B, int C) {
        if (!find(A, B) || !find(A, C)) return -1;
        return lowestCommonAncestor(A, B, C).val;
    }

    private TreeNode lowestCommonAncestor(TreeNode A, int B, int C) {
        if (A == null) return null;
        if (A.val == B || A.val == C) return A;
        TreeNode left = lowestCommonAncestor(A.left, B, C);
        TreeNode right = lowestCommonAncestor(A.right, B, C);
        if (left != null && right != null) return A;
        return left != null ? left : right;
    }

    boolean find(TreeNode root, int val) {
        if (root == null) return false;
        if (root.val == val) return true;
        boolean left = find(root.left, val);
        boolean right = find(root.right, val);
        return left || right;
    }
}
