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
        //deleteNode(linkedListNode, 1);
        insertNodeAtPosition(linkedListNode, 43, 2);
        printLinkedList(linkedListNode);

        // We have to do pass by value in case of inserting a node at head.
        SinglyLinkedListNode linkedListNode1 = new SinglyLinkedListNode(10);
        linkedListNode1 = insertNodeAtHead(linkedListNode1, 40);
        linkedListNode1 = insertNodeAtHead(linkedListNode1, 60);
        printLinkedList(linkedListNode1);

        SinglyLinkedListNode linkedListNode2 = new SinglyLinkedListNode(3);
        insertNodeAtTail(linkedListNode, 9);
        insertNodeAtTail(linkedListNode, 2);
        insertNodeAtTail(linkedListNode, 5);
        insertNodeAtPosition(linkedListNode, 43, 2);
        printLinkedList(linkedListNode);

        System.out.println("After comparing 2 linkedlists: " + compareLists(linkedListNode, linkedListNode2));
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
}
