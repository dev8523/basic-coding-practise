/**
 * 20. Valid Parentheses
 * <p>
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * <p>
 * An input string is valid if:
 * <p>
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 */
package com.debasish.practise.dsa.topicwise.stack;

import java.util.Stack;

/**
 * Given an expression string A, examine whether the pairs and the orders of “{“,”}”, ”(“,”)”, ”[“,”]” are correct in A.
 * <p>
 * Refer to the examples for more clarity.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= |A| <= 100
 * <p>
 * <p>
 * <p>
 * Input Format
 * The first and the only argument of input contains the string A having the parenthesis sequence.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return 0 if the parenthesis sequence is not balanced.
 * <p>
 * Return 1 if the parenthesis sequence is balanced.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = {([])}
 * Input 2:
 * <p>
 * A = (){
 * Input 3:
 * <p>
 * A = ()[]
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * 1
 * Output 2:
 * <p>
 * 0
 * Output 3:
 * <p>
 * 1
 * <p>
 * <p>
 * Example Explanation
 * You can clearly see that the first and third case contain valid paranthesis.
 * <p>
 * In the second case, there is no closing bracket for {, thus the paranthesis sequence is invalid.
 */
public class ValidParentheses {
    public static void main(String[] args) {
        System.out.println(isValid("(){}"));
    }

    /**
     * TC: O(N), SC: O(N)
     */
    private static int isValid(String A) {
        Stack<Character> stack = new Stack<>();
        for (char ch : A.toCharArray()) {
            if (ch == '(') stack.push(')');
            else if (ch == '{') stack.push('}');
            else if (ch == '[') stack.push(']');
            else if (stack.isEmpty() || stack.peek() != ch) return 0;
            else stack.pop();
        }
        return stack.isEmpty() ? 1 : 0;
    }
}
