package com.debasish.practise.dsa.topicwise.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem Description
 * Given the inorder and postorder traversal of a tree, construct the binary tree.
 *
 * NOTE: You may assume that duplicates do not exist in the tree.
 *
 *
 *
 * Problem Constraints
 * 1 <= number of nodes <= 105
 *
 *
 *
 * Input Format
 * First argument is an integer array A denoting the inorder traversal of the tree.
 *
 * Second argument is an integer array B denoting the postorder traversal of the tree.
 *
 *
 *
 * Output Format
 * Return the root node of the binary tree.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [2, 1, 3]
 *  B = [2, 3, 1]
 * Input 2:
 *
 *  A = [6, 1, 3, 2]
 *  B = [6, 3, 2, 1]
 *
 *
 * Example Output
 * Output 1:
 *
 *    1
 *   / \
 *  2   3
 * Output 2:
 *
 *    1
 *   / \
 *  6   2
 *     /
 *    3
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  Create the binary tree and return the root node of the tree.
 */
public class ConstructBinaryTreeFromInorderAndPostorder {
    private static TreeNode buildTreeUsingPostAndInOrder(int[] inorder,
                                                         int is,
                                                         int ie,
                                                         int[] postorder,
                                                         int ps,
                                                         int pe,
                                                         Map<Integer, Integer> map) {
        if (ps > pe || is > ie) return null;
        TreeNode root = new TreeNode(postorder[pe]);
        int ri = map.get(postorder[pe]);
        TreeNode leftChild = buildTreeUsingPostAndInOrder(inorder, is, ri - 1, postorder, ps, ps + ri - is - 1, map);
        TreeNode rightChild = buildTreeUsingPostAndInOrder(inorder, ri + 1, ie, postorder, ps + ri - is, pe - 1, map);
        root.left = leftChild;
        root.right = rightChild;
        return root;
    }

    /**
     * The basic idea is to take the last element in postorder array as the root,
     * find the position of the root in the inorder array;
     * then locate the range for left subtree and right subtree and do recursion.
     * Use a HashMap to record the index of root in the inorder array.
     * <p>
     * TC: O(N)
     * SC: O(N) using recursion stack and hashmap.
     */
    public TreeNode buildTreeUsingPostAndInOrder(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length != postorder.length) return null;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; ++i)
            map.put(inorder[i], i);
        return buildTreeUsingPostAndInOrder(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, map);
    }
}
