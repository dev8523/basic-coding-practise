package com.debasish.practise.dsa.topicwise.stack;

import java.util.Stack;

/**
 * @author debasishsahoo
 * <p>
 * Problem Description
 * <p>
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * <p>
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 * <p>
 * NOTE:
 * <p>
 * All the operations have to be constant time operations.
 * getMin() should return -1 if the stack is empty.
 * pop() should return nothing if the stack is empty.
 * top() should return -1 if the stack is empty.
 * <p>
 * Example Input
 * <p>
 * Input 1:
 * <p>
 * push(1)
 * push(2)
 * push(-2)
 * getMin()
 * pop()
 * getMin()
 * top()
 * <p>
 * Input 2:
 * <p>
 * getMin()
 * pop()
 * top()
 * <p>
 * Example Output
 * <p>
 * Output 1:
 * <p>
 * -2 1 2
 * <p>
 * Output 2:
 * <p>
 * -1 -1
 */
public class DesignMinStack {
    // Maintain 2 stacks (valueStack and minStack) for storing the value and minValue.
    Stack<Integer> valueStack; // This will store all the new values
    Stack<Integer> minStack; // This will store the minimum values comparing with the valueStack elements.

    public DesignMinStack() {
        valueStack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        valueStack.push(x); // simple push to the valueStack
        if (minStack.isEmpty()) minStack.push(x); // check if minStack is empty then push first element
        else if (x < minStack.peek())
            minStack.push(x); // else if check if 'x' is less than the current value that is to be pushed into the valueStack, then push that element into the minStack.
    }

    public void pop() {
        if (valueStack.isEmpty()) return;
        int k = valueStack.pop();
        if ((!minStack.isEmpty()) && k == minStack.peek())
            minStack.pop(); // pop one element from the valueStack and compare that with the minStack top element, If same pop from minStack.
    }

    public int top() {
        if (valueStack.isEmpty()) return -1;
        return valueStack.peek();
    }

    public int getMin() {
        if (minStack.isEmpty()) return -1;
        return minStack.peek();
    }
}
