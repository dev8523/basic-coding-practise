package com.debasish.practise.dsa.topicwise.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author debasishsahoo
 * <p>
 * Problem Description
 * <p>
 * Given a binary tree, return the inorder traversal of its nodes values.
 * <p>
 * NOTE: Using recursion is not allowed.
 * <p>
 * Example Input
 * <p>
 * Input 1:
 * <p>
 * 1
 * \
 * 2
 * /
 * 3
 * Input 2:
 * <p>
 * 1
 * / \
 * 6   2
 * /
 * 3
 * <p>
 * Example Output
 * <p>
 * Output 1:
 * <p>
 * [1, 3, 2]
 * Output 2:
 * <p>
 * [6, 1, 3, 2]
 */
public class InorderTraversal {
    /**
     * TC: O(N)
     * SC: O(H) - Height of the tree. Worst case will be O(N) if there are N nodes.
     * Pre-order visit root, left, right node. (NLR)
     */
    public int[] inorderTraversal(TreeNode A) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(A); // only push the first element.
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
