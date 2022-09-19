package com.debasish.practise.dsa.topicwise.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Problem Description
 * Given a binary tree of integers denoted by root A. Return an array of integers representing the right view of the Binary tree.
 *
 * Right view of a Binary Tree is a set of nodes visible when the tree is visited from Right side.
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
 * Return an array, representing the right view of the binary tree.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *
 *             1
 *           /   \
 *          2    3
 *         / \  / \
 *        4   5 6  7
 *       /
 *      8
 * Input 2:
 *
 *
 *             1
 *            /  \
 *           2    3
 *            \
 *             4
 *              \
 *               5
 *
 *
 * Example Output
 * Output 1:
 *
 *  [1, 3, 7, 8]
 * Output 2:
 *
 *  [1, 3, 4, 5]
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 * Right view is described.
 * Explanation 2:
 *
 * Right view is described.
 */
public class RightViewOfBinaryTree {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        rightViewWithRecursion(root, result, 0);
        return result;
    }

    /**
     * The core idea of this algorithm:
     * <p>
     * 1. Each depth of the tree only select one node.
     * 2. View depth is current size of result list.
     * <p>
     * TC: O(N)
     * SC: O(N) - recursion stack space.
     */
    public void rightViewWithRecursion(TreeNode curr, List<Integer> result, int currDepth) {
        if (curr == null) {
            return;
        }
        if (currDepth == result.size()) {
            result.add(curr.val);
        }
        rightViewWithRecursion(curr.right, result, currDepth + 1);
        rightViewWithRecursion(curr.left, result, currDepth + 1);
    }

    /**
     * Reverse Level order traversal.
     * TC: O(N)
     * SC: O(N)
     */
    public List<Integer> rightSideViewWithoutRecursion(TreeNode root) {
        // reverse level traversal
        List<Integer> result = new ArrayList();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) return result;

        queue.offer(root); // push the root node into queue.
        while (queue.size() != 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) { // iterate till the size of the current level
                TreeNode cur = queue.poll(); // pop the current node
                if (i == 0) result.add(cur.val);
                if (cur.right != null) queue.offer(cur.right);
                if (cur.left != null) queue.offer(cur.left);
            }
        }
        return result;
    }
}
