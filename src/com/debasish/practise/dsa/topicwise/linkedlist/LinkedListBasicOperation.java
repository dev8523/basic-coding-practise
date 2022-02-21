package com.debasish.practise.dsa.topicwise.linkedlist;

/**
 * @author debasishsahoo
 * <p>
 * Problem Description
 * <p>
 * Design and implement a Linked List data structure. A node in a linked list should have the following attributes - an integer value and a pointer to the next node. It should support the following operations:
 * <p>
 * insert_node(position, value) - To insert the input value at the given position in the linked list.
 * delete_node(position) - Delete the value at the given position from the linked list.
 * print_ll() - Print the entire linked list, such that each element is followed by a single space.
 * <p>
 * Example Input
 * <p>
 * 5
 * i 1 23
 * i 2 24
 * p
 * d 1
 * p
 * <p>
 * Example Output
 * <p>
 * 23 24
 * 24
 * <p>
 * Example Explanation
 * <p>
 * After first two cases linked list contains two elements 23 and 24.
 * At third case print: 23 24.
 * At fourth case delete value at first position, only one element left 24.
 * At fifth case print: 24.
 */
public class LinkedListBasicOperation {
    public static Node head = null;
    public static int size_of_ll = 0;

    public static void insert_node(int position, int value) {
        // @params position, integer
        // @params value, integer
        Node curNode = head;
        Node insertableNode = new Node(value);
        if (position == 1) { // insert at begin
            insertableNode.next = head;
            head = insertableNode;
            size_of_ll++;
            return;
        }
        // insert at any position
        int i = 2;
        while (i < position) {
            i++;
            curNode = curNode.next;
        }
        insertableNode.next = curNode.next;
        curNode.next = insertableNode;
        size_of_ll++;
    }

    public static void delete_node(int position) {
        // @params position, integer
        if (position >= 1 && position <= size_of_ll) {
            Node temp = null;
            if (position == 1) {
                temp = head;
                head = head.next;
            } else {
                int count = 1;
                Node prev = head;
                while (count < position - 1) {
                    prev = prev.next;
                    count++;
                }
                temp = prev.next;
                prev.next = prev.next.next;
            }
            size_of_ll--;
        }
    }

    public static void print_ll() {
        // Output each element followed by a space
        if (head == null) return;
        Node curNode = head;
        while (curNode != null) {
            if (curNode.next != null) System.out.print(curNode.data + " ");
            else System.out.print(curNode.data);
            curNode = curNode.next;
        }
    }

    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
}
