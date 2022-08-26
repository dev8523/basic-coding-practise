package com.debasish.practise.dsa.topicwise.linkedlist;

public class IsPalindromeLL {
    public static void main(String[] args) {
        ListNode linkedListListNode = new ListNode(8);
        ListNode linkedListListNode1 = new ListNode(6);
        ListNode linkedListListNode2 = new ListNode(4);
        ListNode linkedListListNode3 = new ListNode(8);
        linkedListListNode.next = linkedListListNode1;
        linkedListListNode1.next = linkedListListNode2;
        linkedListListNode2.next = linkedListListNode3;
        linkedListListNode3.next = null;
        System.out.println(isPalindrome(linkedListListNode));
    }

    public static boolean isPalindrome(ListNode head) {
        if (head.next == null) return true;
        if (findLengthOfLL(head) == 2) {
            return head.data == head.next.data;
        }

        // Find mid using fast/slow pointers. This should handle both odd & even cases.
        ListNode mid = findMiddleNodeUsingSlowAndFastPointers(head);

        // Take right pointer from last node of the list.
        ListNode right = reverseList(mid.next);

        // Take left pointer from the first node of the list.
        ListNode left = head;

        // Check if they are equal
        while (left != null && right != null) {
            if (left.data != right.data) return false;
            left = left.next;
            right = right.next;
        }
        return true;

        // Revert back the reversed LL - Do this for a good practise.
    }

    private static int findLengthOfLL(ListNode head) {
        ListNode tmp = head;
        int count = 0;
        while (tmp != null) {
            count++;
            tmp = tmp.next;
        }
        return count;
    }

    /**
     * Find middle element using slow/fast pointer, we are reducing 1 extra iteration.
     * Same TC: O(N), SC:O(1)
     */
    private static ListNode findMiddleNodeUsingSlowAndFastPointers(ListNode head) {
        if (head.next == null) return head;
        ListNode slow = head, fast = head; // For ex: If slow is X, then fast will be 2X.
        while (fast != null && fast.next != null && fast.next.next == null) {
            slow = slow.next; // move 1 node at a time.
            fast = fast.next.next; // move 2 nodes at a time.
        }
        return slow;
    }

    /**
     * Without using Recursion, using iteration.
     * TC: O(N), SC: O(1)
     */
    public static ListNode reverseList(ListNode A) {
        if (A == null) return null;
        ListNode curr = A;
        ListNode next = null;
        ListNode prev = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        curr = prev;
        return curr;
    }
}
