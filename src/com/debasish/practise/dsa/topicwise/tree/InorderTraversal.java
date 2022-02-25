package com.debasish.practise.dsa.topicwise.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author debasishsahoo
 *
 * Problem Description
 *
 * Given a binary tree, return the inorder traversal of its nodes values.
 *
 * NOTE: Using recursion is not allowed.
 *
 * Example Input
 *
 * Input 1:
 *
 *    1
 *     \
 *      2
 *     /
 *    3
 * Input 2:
 *
 *    1
 *   / \
 *  6   2
 *     /
 *    3
 *
 * Example Output
 *
 * Output 1:
 *
 *  [1, 3, 2]
 * Output 2:
 *
 *  [6, 1, 3, 2]
 */
public class InorderTraversal {
    public int[] inorderTraversal(TreeNode A) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(A);
        while (!stack.isEmpty()) {
            TreeNode curNode = stack.peek();
            if (curNode.left != null) {
                stack.push(curNode.left);
                curNode.left = null;
            } else {
                list.add(curNode.val);
                stack.pop();
                if (curNode.right != null) stack.push(curNode.right);
            }
        }
        // Below is result array creation steps
        int[] result = new int[list.size()];
        int i = 0;
        for (int element : list) {
            result[i++] = element;
        }
        return result;
    }
}
