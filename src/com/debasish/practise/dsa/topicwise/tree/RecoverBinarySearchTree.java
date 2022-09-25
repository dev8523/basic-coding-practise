package com.debasish.practise.dsa.topicwise.tree;

public class RecoverBinarySearchTree {
    int prev = Integer.MIN_VALUE, minDip, maxDip;
    boolean flag = true;

    /**
     * Traversing the tree using in-order traversal, and take 2 vars say minDip & maxDip => O(N)
     * Check if something is fishy in the BST, then update the value of maxDip and minDip. => O(1)
     * <p>
     * TC: O(N)
     * SC: O(H)
     */
    public int[] recoverTree(TreeNode A) {
        if (A == null) return new int[]{minDip, maxDip};
        recoverTree(A.left); // traverse each LST
        /* Check if current node is smaller than prev node,
        then update the maxDip as prev and minDip as current node.
        And in flag true then unset it */
        if (A.val < prev && flag) {
            maxDip = prev;
            minDip = A.val;
            flag = false;
        } else if (A.val < prev) {
            minDip = A.val;
        }
        prev = A.val;
        recoverTree(A.right); // traverse each RST
        return new int[]{minDip, maxDip};
    }
}
