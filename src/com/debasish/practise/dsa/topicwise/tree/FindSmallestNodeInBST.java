package com.debasish.practise.dsa.topicwise.tree;

/**
 * Given a BST, find the smallest node in the BST.
 */
public class FindSmallestNodeInBST {
    /**
     * TC: O(H)
     * SC:O(H)
     */
    TreeNode smallest(TreeNode root) {
        TreeNode temp = root;
        while (temp != null && temp.left != null) smallest(root.left);
        return temp;
    }
}
