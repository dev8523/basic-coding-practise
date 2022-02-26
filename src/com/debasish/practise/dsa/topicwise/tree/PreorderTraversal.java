package com.debasish.practise.dsa.topicwise.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author debasishsahoo
 *
 * Problem Description
 *
 * Given a binary tree, return the preorder traversal of its nodes values.
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
 *  [1, 2, 3]
 * Output 2:
 *
 *  [1, 6, 2, 3]
 */
public class PreorderTraversal {
    public int[] preorderTraversal(TreeNode A) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(A);
        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();
            stack.pop();
            list.add(node.val);
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
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
