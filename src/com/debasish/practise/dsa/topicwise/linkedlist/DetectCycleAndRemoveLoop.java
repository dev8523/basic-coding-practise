package com.debasish.practise.dsa.topicwise.linkedlist;

/**
 * Problem Description
 * You are given a linked list that contains a loop.
 * You need to find the node, which creates a loop and break it by making the node point to NULL.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= number of nodes <= 1000
 * <p>
 * <p>
 * <p>
 * Input Format
 * Only argument is the head of the linked list.
 * <p>
 * <p>
 * <p>
 * Output Format
 * return the head of the updated linked list.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * <p>
 * 1 -> 2
 * ^    |
 * | - -
 * Input 2:
 * <p>
 * 3 -> 2 -> 4 -> 5 -> 6
 * ^         |
 * |         |
 * - - - - - -
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * 1 -> 2 -> NULL
 * Output 2:
 * <p>
 * 3 -> 2 -> 4 -> 5 -> 6 -> NULL
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * Chain of 1->2 is broken.
 * Explanation 2:
 * <p>
 * Chain of 4->6 is broken.
 */
public class DetectCycleAndRemoveLoop {

    /**
     * Using FLOYD DETECTION ALGO (fast and slow pointers), detect if there is a loop in the linked list.
     * <p>
     * TC: O(N)
     * Auxiliary SC: As only two pointers are used therefore constant space complexity.
     */
    public ListNode detectLoopAndBreakTheCycle(ListNode head) {
        if (head.next == null) return head;
        ListNode slow = head, fast = head; // For ex: If slow is V, then fast will be 2V.
        while (slow != null
                && fast != null
                && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) break;
        }
        if (slow != fast) return null; // if no loop exists, return;
        slow = head; // reset slow pointer to head and traverse again
        while (slow.next != fast.next) {
            slow = slow.next;
            fast = fast.next;
        }
        // BREAK the loop/CYCLE and return the new head.
        fast.next = null;
        return head;
    }

    /**
     * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
     * <p>
     * Try solving it using constant additional space.
     * <p>
     * Using FLOYD DETECTION ALGO (fast and slow pointers), detect if there is a loop in the linked list.
     * <p>
     * TC: O(N)
     * Auxiliary SC: As only two pointers are used therefore constant space complexity.
     */
    public ListNode detectCycle(ListNode head) {
        if (head.next == null) return head;
        ListNode slow = head, fast = head; // For ex: If slow is V, then fast will be 2V.
        while (slow != null
                && fast != null
                && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) break;
        }
        if (slow != fast) return null; // if no loop exists, return;
        slow = head; // reset slow pointer to head and traverse again
        while (slow.next != fast.next) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow.next; // Node where the cycle begins.
    }
}
