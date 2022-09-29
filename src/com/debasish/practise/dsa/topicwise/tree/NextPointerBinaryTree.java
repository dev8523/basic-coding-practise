package com.debasish.practise.dsa.topicwise.tree;

/**
 * Problem Description
 * Given a binary tree,
 *
 * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
 *
 * Initially, all next pointers are set to NULL.
 *
 * Assume perfect binary tree and try to solve this in constant extra space.
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
 * Return the head of the binary tree after the changes are made.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *
 *      1
 *     /  \
 *    2    3
 * Input 2:
 *
 *
 *         1
 *        /  \
 *       2    5
 *      / \  / \
 *     3  4  6  7
 *
 *
 * Example Output
 * Output 1:
 *
 *
 *         1 -> NULL
 *        /  \
 *       2 -> 3 -> NULL
 * Output 2:
 *
 *
 *          1 -> NULL
 *        /  \
 *       2 -> 5 -> NULL
 *      / \  / \
 *     3->4->6->7 -> NULL
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 * Next pointers are set as given in the output.
 * Explanation 2:
 *
 * Next pointers are set as given in the output.
 */
public class NextPointerBinaryTree {
    /**
     * MOST OPTIMISED SOLUTION
     * <p>
     * TC: O(N) - Every node is getting visited at max twice.
     * SC: O(1) - Constant space.
     */
    void connect(TreeLinkNode root) {
        TreeLinkNode ver = root;
        while (ver != null) {
            TreeLinkNode hor = ver;
            while (hor != null) {
                if (hor.left != null) {
                    if (hor.right != null) {
                        hor.left.next = hor.right;
                    } else { // else for hor.right == null
                        hor.left.next = getNextRight(hor);
                    }
                }
                if (hor.right != null) {
                    hor.right.next = getNextRight(hor);
                }
                hor = hor.next;
            }
            if (ver.left != null) {
                ver = ver.left;
            } else if (ver.right != null) {
                ver = ver.right;
            } else {
                ver = null;
            }
        }
    }

    /**
     * Provides the node info of the node's next's right node.
     */
    private TreeLinkNode getNextRight(TreeLinkNode hor) {
        TreeLinkNode cur = hor.next;
        while (cur != null) {
            if (cur.left != null) return cur.left;
            if (cur.right != null) return cur.right;
            cur = cur.next;
        }
        return null;
    }

    /**
     * Definition for binary tree with next pointer.
     */
    public static class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;

        TreeLinkNode(int x) {
            val = x;
        }
    }
}
