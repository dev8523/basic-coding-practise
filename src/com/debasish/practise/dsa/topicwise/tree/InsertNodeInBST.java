package com.debasish.practise.dsa.topicwise.tree;

/**
 * Given a root node of a BST and a key to insert in the Tree. Return the root node after inserting the key.
 */
public class InsertNodeInBST {
    /**
     * TC: O(H)
     * SC: O(H)
     */
    TreeNode insertANodeInBST(TreeNode root, int key) {
        if (root == null) {
            TreeNode node = new TreeNode(key);
            return node;
        }
        if (root.val > key) insertANodeInBST(root.right, key);
        else insertANodeInBST(root.left, key);
        return root;
    }
}
