package com.debasish.practise.dsa.topicwise.tree;

/**
 * Given a root node of a BST and a key. Search the key in the BST and return true if found.
 */
public class SearchingElementInBST {
    /**
     * TC: O(H) - height of the tree.
     * SC: O(H)
     */
    boolean searchElementInBST(TreeNode root, int key) {
        if (root == null) return false;
        if (root.val == key) return true;
        if (root.val > key) searchElementInBST(root.right, key);
        return searchElementInBST(root.left, key);
    }
}
