package com.debasish.practise.dsa.topicwise.linkedlist;

/**
 * All methods are one linkedlist question. Problem Statement can be found on Hackerrank under Data Structures > LinkedList section.
 *
 * @author debasishsahoo
 */
public class SinglyLinkedList {

    public static void main(String[] args) {
        ListNode linkedListListNode = new ListNode(3);
        insertNodeAtTail(linkedListListNode, 9);
        insertNodeAtTail(linkedListListNode, 2);
        insertNodeAtTail(linkedListListNode, 5);
        deleteNode(linkedListListNode, 1);
        insertNodeAtPosition(linkedListListNode, 43, 1);
        printLinkedList(linkedListListNode);

        // We have to do pass by value in case of inserting a node at head.
        ListNode linkedListListNode1 = new ListNode(10);
        linkedListListNode1 = insertNodeAtHead(linkedListListNode1, 40);
        linkedListListNode1 = insertNodeAtHead(linkedListListNode1, 60);
        printLinkedList(linkedListListNode1);

        ListNode linkedListListNode2 = new ListNode(3);
        insertNodeAtTail(linkedListListNode2, 9);
        insertNodeAtTail(linkedListListNode2, 2);
        insertNodeAtTail(linkedListListNode2, 5);
        insertNodeAtPosition(linkedListListNode2, 43, 2);
        printLinkedList(linkedListListNode2);

        System.out.println("After comparing 2 linked lists: " + compareLists(linkedListListNode, linkedListListNode2));

        ListNode linkedListListNode3 = new ListNode(3);
        insertNodeAtTail(linkedListListNode3, 9);
        insertNodeAtTail(linkedListListNode3, 2);
        insertNodeAtTail(linkedListListNode3, 5);
        insertNodeAtPosition(linkedListListNode3, 43, 1);
        printLinkedList(linkedListListNode3);
        System.out.println("Get a specific node by iterating from last: " + getNode(linkedListListNode3, 2));
        reversePrint(linkedListListNode3);
        reversePrintWithoutUsingRecursion(linkedListListNode3);
        System.out.println("\n########## MERGE 2 LIST ############");
        printLinkedList(linkedListListNode);
        printLinkedList(linkedListListNode1);
        ListNode mergeTwoListResult = mergeTwoLists(linkedListListNode, linkedListListNode1);
        printLinkedList(mergeTwoListResult);
        printLinkedList(middleNode(linkedListListNode));
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

    /**
     * TC: O(1), SC: O(1)
     */
    static ListNode insertNodeAtHead(ListNode head, int data) {
        ListNode newListNode = new ListNode(data);
        newListNode.next = head;
        return newListNode;
    }

    /**
     * TC: O(N) {iterating unto last node}, SC: O(1)
     */
    static ListNode insertNodeAtTail(ListNode head, int data) {
        ListNode insertableListNode = new ListNode(data);
        if (head == null) {
            head = insertableListNode;
        } else {
            ListNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = insertableListNode;
        }
        return head;
    }

    /**
     * TC: O(position) or O(N) {worst TC}, SC: O(1)
     */
    static ListNode insertNodeAtPosition(ListNode head, int data, int position) {
        ListNode current = head;
        ListNode insertableListNode = new ListNode(data);
        int i = 1;
        while (i < position) {
            i++;
            current = current.next;
        }
        System.out.println("ListNode after which u want to insert: " + current.data);
        insertableListNode.next = current.next;
        current.next = insertableListNode;
        return head;
    }

    /**
     * TC: O(N), SC: O(1)
     */
    public static ListNode deleteNode(ListNode head, int position) {
        if (position == 0)
            return head;
        ListNode currentListNode = head;
        int i = 1;
        while (i < position) {
            i++;
            currentListNode = currentListNode.next;
        }
        System.out.println("Current ListNode to be deleted: " + currentListNode.data);
        currentListNode.next = currentListNode.next.next;
        return head;
    }

    /**
     * Delete middle of the linked list.
     * If there are even nodes, then there would be two middle nodes, we need to delete the second middle element.
     * For example, if given linked list is 1->2->3->4->5 then linked list should be modified to 1->2->4->5
     * <p>
     * If there are even nodes, then there would be two middle nodes, we need to delete the second middle element.
     * <p>
     * For example, if given linked list is 1->2->3->4->5->6 then it should be modified to 1->2->3->5->6.
     * <p>
     * Return the head of the linked list after removing the middle node.
     * <p>
     * TC: O(N), SC: O(1)
     */
    public static ListNode deleteNodeFromMid(ListNode head) {
        // Base cases
        if (head == null)
            return null;
        if (head.next == null) {
            return null;
        }

        // Initialize slow and fast pointers
        // to reach middle of linked list
        ListNode slow_ptr = head;
        ListNode fast_ptr = head;

        // Find the middle and previous of middle.
        ListNode prev = null;

        // To store previous of slow_ptr
        while (fast_ptr != null
                && fast_ptr.next != null) {
            fast_ptr = fast_ptr.next.next;
            prev = slow_ptr;
            slow_ptr = slow_ptr.next;
        }

        // Delete the middle node
        prev.next = slow_ptr.next;

        return head;
    }

    static boolean compareLists(ListNode head1, ListNode head2) {
        while (head1 != null && head2 != null && head1.data == head2.data) {
            head1 = head1.next;
            head2 = head2.next;
        }
        return head1 == null && head2 == null;
    }

    public static int getNode(ListNode head, int positionFromTail) {
        ListNode currentListNode = head;
        int lenOfCurrentNode = 0;
        while (currentListNode != null) {
            currentListNode = currentListNode.next;
            lenOfCurrentNode++;
        }
        int newPosition = lenOfCurrentNode - positionFromTail - 1;
        currentListNode = head;
        for (int i = 0; i < newPosition; i++) {
            currentListNode = currentListNode.next;
        }
        return currentListNode.data;
    }

    /**
     * Using Recursion.
     * TC: O(N), SC: O(N) {using recursion stack}
     */
    public static void reversePrint(ListNode head) {
        if (head == null)
            return;
        reversePrint(head.next);
        System.out.print(head.data + " ");
    }

    /**
     * Without using Recursion, using iteration.
     * TC: O(N), SC: O(1)
     */
    public static void reversePrintWithoutUsingRecursion(ListNode head) {
        if (head == null) return;
        ListNode curListNode = head;
        ListNode prev = null;
        ListNode next = null;
        while (curListNode != null) {
            next = curListNode.next;
            curListNode.next = prev;
            prev = curListNode;
            curListNode = next;
        }
        curListNode = prev;
        System.out.println(curListNode);
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        if (l1.data < l2.data) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    public static ListNode middleNode(ListNode head) {
        ListNode x = head;
        ListNode y = head.next;
        while (y != null) {
            x = x.next;
            y = y.next;
            if (y != null) {
                y = y.next;
            }
            System.out.println(":: x :: " + x.data);
        }
        return x;
    }

    /**
     * Given a linked list of integers, find and return the middle element of the linked list.
     * <p>
     * NOTE: If there are N nodes in the linked list and N is even then return the (N/2 + 1)th element.
     * <p>
     * TC: O(N), SC: O(1)
     * <p>
     * Doing here 2 iterations.
     */
    private static int findMiddleNode(ListNode head) {
        int n = findLengthOfLL(head);
        // return n/2 node val.
        return getNthIndexNode(head, n / 2);
    }

    /**
     * Find middle element using slow/fast pointer, we are reducing 1 extra iteration.
     * Same TC: O(N), SC:O(1)
     */
    private static int findMiddleNodeUsingSlowAndFastPointers(ListNode head) {
        if (head.next == null)
            return head.data;
        ListNode slow = head, fast = head; // For ex: If slow is X, then fast will be 2X.
        while (fast != null && fast.next != null) {
            slow = slow.next; // move 1 node at a time.
            fast = fast.next.next; // move 2 nodes at a time.
        }
        return slow.data;
    }

    /**
     * Takes index as argument and return data at index.
     * <p>
     * TC: O(N), SC: O(1)
     */
    private static int getNthIndexNode(ListNode head, int idx) {
        ListNode tmp = head;
        int count = 0; /* index of ListNode we are
                          currently looking at */
        while (tmp != null) {
            if (count == idx) return tmp.data;
            count++;
            tmp = tmp.next;
        }
        return 0;
    }

    /**
     * Find length of a given linked-list.
     * <p>
     * TC: O(N), SC: O(1)
     */
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
     * Problem Description:
     * Given a singly linked list head and an integer k, reverse the nodes of the list k at a time and return the modified linked list.
     * <p>
     * TC: O(N), SC: O(N) {recursion stack}
     */
    public ListNode reverseKList(ListNode head, int k) {
        ListNode curr = head;
        int count = 0;
        while (curr != null && count != k) { // find the k+1 node
            curr = curr.next;
            count++;
        }
        if (count == k) { // if k+1 node is found
            curr = reverseKList(curr, k); // reverse list with k+1 node as head
            // head - head-pointer to direct part,
            // curr - head-pointer to reversed part;
            while (count-- > 0) { // reverse current k-group:
                ListNode tmp = head.next; // tmp - next head in direct part
                head.next = curr; // preappending "direct" head to the reversed list
                curr = head; // move head of reversed part to a new node
                head = tmp; // move "direct" head to the next node in direct part
            }
            head = curr;
        }
        return head;
    }
}
