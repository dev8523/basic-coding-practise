package com.debasish.practise.dsa.linkedlist;

/**
 * All methods are one linkedlist question. Problem Statement can be found on Hackerrank under Data Structures > LinkedList section.
 *
 * @author debasishsahoo
 */
public class SinglyLinkedList {

    public static void main(String[] args) {
        SinglyLinkedListNode linkedListNode = new SinglyLinkedListNode(3);
        insertNodeAtTail(linkedListNode, 9);
        insertNodeAtTail(linkedListNode, 2);
        insertNodeAtTail(linkedListNode, 5);
        deleteNode(linkedListNode, 1);
        insertNodeAtPosition(linkedListNode, 43, 1);
        printLinkedList(linkedListNode);

        // We have to do pass by value in case of inserting a node at head.
        SinglyLinkedListNode linkedListNode1 = new SinglyLinkedListNode(10);
        linkedListNode1 = insertNodeAtHead(linkedListNode1, 40);
        linkedListNode1 = insertNodeAtHead(linkedListNode1, 60);
        printLinkedList(linkedListNode1);

        SinglyLinkedListNode linkedListNode2 = new SinglyLinkedListNode(3);
        insertNodeAtTail(linkedListNode2, 9);
        insertNodeAtTail(linkedListNode2, 2);
        insertNodeAtTail(linkedListNode2, 5);
        insertNodeAtPosition(linkedListNode2, 43, 2);
        printLinkedList(linkedListNode2);

        System.out.println("After comparing 2 linked lists: " + compareLists(linkedListNode, linkedListNode2));

        SinglyLinkedListNode linkedListNode3 = new SinglyLinkedListNode(3);
        insertNodeAtTail(linkedListNode3, 9);
        insertNodeAtTail(linkedListNode3, 2);
        insertNodeAtTail(linkedListNode3, 5);
        insertNodeAtPosition(linkedListNode3, 43, 1);
        printLinkedList(linkedListNode3);
        System.out.println("Get a specific node by iterating from last: " + getNode(linkedListNode3, 2));
        reversePrint(linkedListNode3);
        System.out.println("\n########## MERGE 2 LIST ############");
        printLinkedList(linkedListNode);
        printLinkedList(linkedListNode1);
        SinglyLinkedListNode mergeTwoListResult = mergeTwoLists(linkedListNode, linkedListNode1);
        printLinkedList(mergeTwoListResult);
    }

    static void printLinkedList(SinglyLinkedListNode head) {
        SinglyLinkedListNode current = head;
        while (current != null) {
            System.out.print(current.data);
            System.out.print(" -> ");
            current = current.next;
        }
        System.out.println("X");
    }

    static SinglyLinkedListNode insertNodeAtHead(SinglyLinkedListNode llist, int data) {
        SinglyLinkedListNode insertableNode = new SinglyLinkedListNode(data);
        insertableNode.next = llist;
        return insertableNode;
    }

    static SinglyLinkedListNode insertNodeAtTail(SinglyLinkedListNode head, int data) {
        SinglyLinkedListNode insertableNode = new SinglyLinkedListNode(data);
        if (head == null) {
            head = insertableNode;
        } else {
            SinglyLinkedListNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = insertableNode;
        }
        return head;
    }

    static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode llist, int data, int position) {
        SinglyLinkedListNode current = llist;
        SinglyLinkedListNode insertableNode = new SinglyLinkedListNode(data);
        int i = 1;
        while (i < position) {
            i++;
            current = current.next;
        }
        System.out.println("Node after which u want to insert: " + current.data);
        insertableNode.next = current.next;
        current.next = insertableNode;
        return llist;
    }

    public static SinglyLinkedListNode deleteNode(SinglyLinkedListNode llist, int position) {
        if (position == 0)
            return llist;
        SinglyLinkedListNode currentNode = llist;
        int i = 1;
        while (i < position) {
            i++;
            currentNode = currentNode.next;
        }
        System.out.println("Current Node to be deleted: " + currentNode.data);
        currentNode.next = currentNode.next.next;
        return llist;
    }

    static boolean compareLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        while (head1 != null && head2 != null && head1.data == head2.data) {
            head1 = head1.next;
            head2 = head2.next;
        }
        return head1 == null && head2 == null;
    }

    public static int getNode(SinglyLinkedListNode llist, int positionFromTail) {
        SinglyLinkedListNode currentNode = llist;
        int lenOfCurrentNode = 0;
        while (currentNode != null) {
            currentNode = currentNode.next;
            lenOfCurrentNode++;
        }
        int newPosition = lenOfCurrentNode - positionFromTail - 1;
        currentNode = llist;
        for (int i = 0; i < newPosition; i++) {
            currentNode = currentNode.next;
        }
        return currentNode.data;
    }

    public static void reversePrint(SinglyLinkedListNode llist) {
        if (llist == null)
            return;
        reversePrint(llist.next);
        System.out.print(llist.data + " ");
    }

    public static SinglyLinkedListNode mergeTwoLists(SinglyLinkedListNode l1, SinglyLinkedListNode l2) {
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
}
