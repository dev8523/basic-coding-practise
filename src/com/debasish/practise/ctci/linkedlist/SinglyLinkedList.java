package com.debasish.practise.ctci.linkedlist;

/**
 * All methods are one linkedlist question. Problem Statement can be found on Hackerrank under Data Structures > LinkedList section.
 *
 * @author debasishsahoo
 */
public class SinglyLinkedList {

    public static void main(String[] args) {
        Node linkedListNode = new Node(3);
        insertNodeAtTail(linkedListNode, 9);
        insertNodeAtTail(linkedListNode, 2);
        insertNodeAtTail(linkedListNode, 5);
        deleteNode(linkedListNode, 1);
        insertNodeAtPosition(linkedListNode, 43, 1);
        printLinkedList(linkedListNode);

        // We have to do pass by value in case of inserting a node at head.
        Node linkedListNode1 = new Node(10);
        linkedListNode1 = insertNodeAtHead(linkedListNode1, 40);
        linkedListNode1 = insertNodeAtHead(linkedListNode1, 60);
        printLinkedList(linkedListNode1);

        Node linkedListNode2 = new Node(3);
        insertNodeAtTail(linkedListNode2, 9);
        insertNodeAtTail(linkedListNode2, 2);
        insertNodeAtTail(linkedListNode2, 5);
        insertNodeAtPosition(linkedListNode2, 43, 2);
        printLinkedList(linkedListNode2);

        System.out.println("After comparing 2 linked lists: " + compareLists(linkedListNode, linkedListNode2));

        Node linkedListNode3 = new Node(3);
        insertNodeAtTail(linkedListNode3, 9);
        insertNodeAtTail(linkedListNode3, 2);
        insertNodeAtTail(linkedListNode3, 5);
        insertNodeAtPosition(linkedListNode3, 43, 1);
        printLinkedList(linkedListNode3);
        System.out.println("Get a specific node by iterating from last: " + getNode(linkedListNode3, 2));
        reversePrint(linkedListNode3);
        reversePrintWithoutUsingRecursion(linkedListNode3);
        System.out.println("\n########## MERGE 2 LIST ############");
        printLinkedList(linkedListNode);
        printLinkedList(linkedListNode1);
        Node mergeTwoListResult = mergeTwoLists(linkedListNode, linkedListNode1);
        printLinkedList(mergeTwoListResult);
        printLinkedList(middleNode(linkedListNode));
    }

    /**
     * TC: O(N), SC: O(1)
     * <p>
     * Traverse LL in TC: O(N).
     * only taking a head ptr. So no extra space.
     */
    static void printLinkedList(Node head) {
        Node current = head;
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
    static Node insertNodeAtHead(Node head, int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        return newNode;
    }

    /**
     * TC: O(N) {iterating unto last node}, SC: O(1)
     */
    static Node insertNodeAtTail(Node head, int data) {
        Node insertableNode = new Node(data);
        if (head == null) {
            head = insertableNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = insertableNode;
        }
        return head;
    }

    /**
     * TC: O(position) or O(N) {worst TC}, SC: O(1)
     */
    static Node insertNodeAtPosition(Node head, int data, int position) {
        Node current = head;
        Node insertableNode = new Node(data);
        int i = 1;
        while (i < position) {
            i++;
            current = current.next;
        }
        System.out.println("Node after which u want to insert: " + current.data);
        insertableNode.next = current.next;
        current.next = insertableNode;
        return head;
    }

    /**
     * TC: O(N), SC: O(1)
     */
    public static Node deleteNode(Node head, int position) {
        if (position == 0)
            return head;
        Node currentNode = head;
        int i = 1;
        while (i < position) {
            i++;
            currentNode = currentNode.next;
        }
        System.out.println("Current Node to be deleted: " + currentNode.data);
        currentNode.next = currentNode.next.next;
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
    public static Node deleteNodeFromMid(Node head) {
        // Base cases
        if (head == null)
            return null;
        if (head.next == null) {
            return null;
        }

        // Initialize slow and fast pointers
        // to reach middle of linked list
        Node slow_ptr = head;
        Node fast_ptr = head;

        // Find the middle and previous of middle.
        Node prev = null;

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

    static boolean compareLists(Node head1, Node head2) {
        while (head1 != null && head2 != null && head1.data == head2.data) {
            head1 = head1.next;
            head2 = head2.next;
        }
        return head1 == null && head2 == null;
    }

    public static int getNode(Node head, int positionFromTail) {
        Node currentNode = head;
        int lenOfCurrentNode = 0;
        while (currentNode != null) {
            currentNode = currentNode.next;
            lenOfCurrentNode++;
        }
        int newPosition = lenOfCurrentNode - positionFromTail - 1;
        currentNode = head;
        for (int i = 0; i < newPosition; i++) {
            currentNode = currentNode.next;
        }
        return currentNode.data;
    }

    /**
     * Using Recursion.
     * TC: O(N), SC: O(N) {using recursion stack}
     */
    public static void reversePrint(Node head) {
        if (head == null)
            return;
        reversePrint(head.next);
        System.out.print(head.data + " ");
    }

    /**
     * Without using Recursion, using iteration.
     * TC: O(N), SC: O(1)
     */
    public static void reversePrintWithoutUsingRecursion(Node head) {
        Node curNode = head;
        Node prev = null;
        Node next = null;

        while (curNode != null) {
            next = curNode.next;
            curNode.next = prev;
            prev = curNode;
            curNode = next;
        }
        curNode = prev;
        System.out.println(curNode);
    }

    public static Node mergeTwoLists(Node l1, Node l2) {
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

    public static Node middleNode(Node head) {
        Node x = head;
        Node y = head.next;
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
     * Problem Description:
     * Given a singly linked list head and an integer k, reverse the nodes of the list k at a time and return the modified linked list.
     * <p>
     * TC: O(N), SC: O(N) {recursion stack}
     */
    public Node reverseKList(Node head, int k) {
        Node curr = head;
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
                Node tmp = head.next; // tmp - next head in direct part
                head.next = curr; // preappending "direct" head to the reversed list
                curr = head; // move head of reversed part to a new node
                head = tmp; // move "direct" head to the next node in direct part
            }
            head = curr;
        }
        return head;
    }

}
