package com.debasish.practise.dsa.topicwise.stack;

import java.util.Stack;

/**
 * @author debasishsahoo
 * <p>
 * Problem Description
 * <p>
 * Given a string A consisting only of '(' and ')'.
 * <p>
 * You need to find whether parantheses in A is balanced or not ,if it is balanced then return 1 else return 0.
 * <p>
 * Example Input
 * <p>
 * Input 1:
 * <p>
 * A = "(()())"
 * Input 2:
 * <p>
 * A = "(()"
 * <p>
 * Example Output
 * <p>
 * Output 1:
 * <p>
 * 1
 * Output 2:
 * <p>
 * 0
 */
public class BalancedParenthesis {
    public int solve(String A) {
        /**
         * My approach: check if there is any open parenthesis then insert close parenthesis in stack.
         * and check popping one-by-one from the stack if they are not matching then return false.
         */
        Stack<Character> stack = new Stack<>();
        for (char ch : A.toCharArray()) {
            if (ch == '(') stack.push(')');
            else if (stack.isEmpty() || stack.pop() != ch) return 0;
        }
        if (stack.isEmpty()) return 1;
        else return 0;
    }
}
