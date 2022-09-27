package com.debasish.practise.dsa.topicwise.tree;

/**
 * Problem Description
 * You are given a Binary Tree A with N nodes.
 *
 * Write a function that returns the size of the largest subtree, which is also a Binary Search Tree (BST).
 *
 * If the complete Binary Tree is BST, then return the size of the whole tree.
 *
 * NOTE:
 *
 * The largest subtree is the subtree with the most number of nodes.
 *
 *
 * Problem Constraints
 * 1 <= N <= 105
 *
 *
 *
 * Input Format
 * First and only argument is an pointer to root of the binary tree A.
 *
 *
 *
 * Output Format
 * Return an single integer denoting the size of the largest subtree which is also a BST.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *      10
 *     / \
 *    5  15
 *   / \   \
 *  1   8   7
 * Input 2:
 *
 *      5
 *     / \
 *    3   8
 *   / \ / \
 *  1  4 7  9
 *
 *
 * Example Output
 * Output 1:
 *
 *  3
 * Output 2:
 *
 *  7
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  Largest BST subtree is
 *                             5
 *                            / \
 *                           1   8
 * Explanation 2:
 *
 *  Given binary tree itself is BST.
 */
public class LargestSubtreeBST {
    static int MAX = Integer.MAX_VALUE;
    static int MIN = Integer.MIN_VALUE;

    /**
     * Return the size of the largest sub-tree which is also a BST
     */
    static int largestBst(TreeNode root) {
        return largestBST(root).size;
    }

    /**
     * TC : O(N)
     * SC: O(H) where H is the height of the binary tree. For call stack since using recursion.
     */
    static NodeInfo largestBST(TreeNode root) {

        // Base case : When the current subtree is empty or
        // the node corresponds to a null.
        if (root == null) {
            return new NodeInfo(0, Integer.MIN_VALUE, Integer.MAX_VALUE, true);
        }
        // We will here do the POSTORDER traversal since we
        // want our left and right subtrees to be computed
        // first.

        // Recur for left subtree and right subtrees
        NodeInfo left = largestBST(root.left);
        NodeInfo right = largestBST(root.right);

        // Create a new NodeInfo variable to store info
        // about the current node.
        NodeInfo returnInfo = new NodeInfo();

        returnInfo.min = Math.min(left.min, root.val);
        returnInfo.max = Math.max(right.max, root.val);
        returnInfo.isBST = left.isBST && right.isBST && root.val > left.max && root.val < right.min;

        /*
        If suppose the left and right subtrees of the
        current node are BST and the current node value is
        greater than the maximum value in the left subtree
        and also the current node value is smaller that the
        minimum value in the right subtree (Basic conditions
        for the formation of BST) then our whole subtree
        with the root as current root can be considered as a
        BST. Hence, the size of the BST will become size of
        left BST subtree + size of right BST subtree +
        1(adding current node).

        Else we will consider the largest of the left BST or
        the  right BST.
        */

        /*We need to find maximum height BST subtree then
        adding the height of left an right subtree will not
        give the maximum height, we need to find max.
        */
        if (returnInfo.isBST)

            // Calculate the size of subtree if
            // this is a BST
            returnInfo.size = left.size + right.size + 1;
        else
            returnInfo.size
                    = Math.max(left.size, right.size);

        return returnInfo;
    }

    static class NodeInfo {
        int size; // Size of subtree
        int max; // Min value in subtree
        int min; // Max value in subtree
        boolean isBST; // If subtree is BST

        NodeInfo() {
        }

        NodeInfo(int size, int max, int min, boolean isBST) {
            this.size = size;
            this.max = max;
            this.min = min;
            this.isBST = isBST;
        }
    }
}