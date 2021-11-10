package com.debasish.practise.dsa.linkedlist;

public class SinglyLinkedList {
    private final SinglyLinkedListNode head = null;

    public static void main(String[] args) {
        SinglyLinkedListNode linkedListNode = new SinglyLinkedListNode(3);
        insertNodeAtTail(linkedListNode, 9);
        insertNodeAtTail(linkedListNode, 2);
        insertNodeAtTail(linkedListNode, 5);
        printLinkedList(linkedListNode);
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
}
