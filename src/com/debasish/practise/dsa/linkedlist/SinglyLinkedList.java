package com.debasish.practise.dsa.linkedlist;

public class SinglyLinkedList {

    public static void main(String[] args) {
        SinglyLinkedListNode linkedListNode = new SinglyLinkedListNode(3);
        insertNodeAtTail(linkedListNode, 9);
        insertNodeAtTail(linkedListNode, 2);
        insertNodeAtTail(linkedListNode, 5);
        deleteNode(linkedListNode, 1);
        insertNodeAtPosition(linkedListNode, 43, 2);
        printLinkedList(linkedListNode);

        // We have to do pass by value in case of inserting a node at head.
        SinglyLinkedListNode linkedListNode1 = new SinglyLinkedListNode(10);
        linkedListNode1 = insertNodeAtHead(linkedListNode1, 40);
        linkedListNode1 = insertNodeAtHead(linkedListNode1, 60);
        printLinkedList(linkedListNode1);

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

    /**
     * Delete the node at a given position in a linked list and return a reference to the head node.
     * The head is at position 0.
     * The list may be empty after you delete the node. In that case, return a null value.
     *
     * @param llist
     * @param position
     * @return the linkedlist
     */
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

}
