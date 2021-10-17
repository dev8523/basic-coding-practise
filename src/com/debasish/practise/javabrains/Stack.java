/**
 * This demonstrates how we can create Stack implementation of our own using Array.
 */
package com.debasish.practise.javabrains;

/**
 * @author debasishsahoo
 */
public class Stack {

    private final int[] array;
    private final int capacity;
    private int top;

    public Stack(int[] array, int top, int capacity) {
        this.array = new int[capacity];
        this.top = -1;
        this.capacity = capacity;
    }

    public void push(int item) {
        if (isFull()) {
            throw new RuntimeException("Stack is full");
        }
        array[top++] = item;
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return array[top--];
    }

    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return array[top];
    }

    private boolean isFull() {
        return top == capacity - 1;
    }

    private boolean isEmpty() {
        return top == -1;
    }
}
