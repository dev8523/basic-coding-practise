package com.debasish.practise.dsa.topicwise.linkedlist;

public class MergeTwoSortedLinkedLists {

    /**
     * TC: O(N), SC: O(1) {no extra space}
     */
    public ListNode mergeTwoLists(ListNode A, ListNode B) {
        ListNode head1 = A, head2 = B, head, tail;
        if (head1 == null) return head2;
        if (head2 == null) return head1;
        if (head1.data < head2.data) {
            head = head1;
            tail = head1;
            head1 = head1.next;
        } else {
            head = head2;
            tail = head2;
            head2 = head2.next;
        }
        while (head1 != null && head2 != null) {
            if (head1.data < head2.data) {
                tail.next = head1;
                tail = head1;
                head1 = head1.next;
            } else {
                tail.next = head2;
                tail = head2;
                head2 = head2.next;
            }
        }
        if (head1 == null) tail.next = head2;
        if (head2 == null) tail.next = head1;
        return head;
    }
}
