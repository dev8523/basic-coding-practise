package com.debasish.practise.dsa.topicwise.linkedlist;

public class MergeSortLinkedList {

    public static void main(String[] args) {
        ListNode linkedListListNode = new ListNode(-1);
        ListNode linkedListListNode1 = new ListNode(5);
        ListNode linkedListListNode2 = new ListNode(4);
        ListNode linkedListListNode3 = new ListNode(3);
        ListNode linkedListListNode4 = new ListNode(0);
        linkedListListNode.next = linkedListListNode1;
        linkedListListNode1.next = linkedListListNode2;
        linkedListListNode2.next = linkedListListNode3;
        linkedListListNode3.next = linkedListListNode4;
        linkedListListNode4.next = null;
        printLinkedList(sortList(linkedListListNode));
    }

    /**
     * Find middle element using slow/fast pointer, we are reducing 1 extra iteration.
     * Same TC: O(N), SC:O(1)
     */
    private static ListNode findMiddleNodeUsingSlowAndFastPointers(ListNode head) {
        if (head.next == null || head.next.next == null) return head;
        ListNode slow = head, fast = head; // For ex: If slow is X, then fast will be 2X.
        while (fast != null && fast.next != null) {
            slow = slow.next; // move 1 node at a time.
            fast = fast.next.next; // move 2 nodes at a time.
        }
        return slow;
    }

    /**
     * Using Merge Sort. TC: O(N * logN), SC: O(logN) {Due to recursion stack}
     */
    public static ListNode sortList(ListNode A) {
        if (A == null || A.next == null) return A;
        // Step-1: Find middle node using slow/fast pointers and divide them in equal half.
        ListNode mid = findMiddleNodeUsingSlowAndFastPointers(A); // TC: O(N)
        //System.out.println("MID: " + mid.val);
        ListNode h1 = A;
        ListNode h2 = mid.next;
        mid.next = null;
        // Step-2: Sort both 2 lists recursively.
        ListNode new_h1 = sortList(h1); // TC: O(N * logN)
        ListNode new_h2 = sortList(h2); // TC: O(N * logN)
        // Step-3: Merge both sorted LL.
        return mergeTwoLists(new_h1, new_h2); // TC: O(N)
    }

    /**
     * TC: O(N), SC: O(1) {no extra space}
     */
    public static ListNode mergeTwoLists(ListNode A, ListNode B) {
        if (A == null)
            return B;
        if (B == null)
            return A;
        ListNode head;
        ListNode node = new ListNode(0);
        head = node;
        while (A != null && B != null) {
            if (A.data <= B.data) {
                node.next = A;
                A = A.next;
                node = node.next;
            } else {
                node.next = B;
                B = B.next;
                node = node.next;
            }
        }
        if (A == null)
            node.next = B;
        else
            node.next = A;
        head = head.next;
        return head;
    }

    /**
     * TC: O(N), SC: O(1)
     * <p>
     * Traverse LL in TC: O(N).
     * only taking a head ptr. So no extra space.
     */
    static void printLinkedList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.data);
            System.out.print(" -> ");
            current = current.next;
        }
        System.out.println("X");
    }
}
