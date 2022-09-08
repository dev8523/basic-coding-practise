package com.debasish.practise.dsa.topicwise.stack;

import java.util.Stack;

/**
 * Problem Description
 * An arithmetic expression is given by a character array A of size N. Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * <p>
 * Valid operators are +, -, *, /. Each character may be an integer or an operator.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= N <= 105
 * <p>
 * <p>
 * <p>
 * Input Format
 * The only argument given is character array A.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return the value of arithmetic expression formed using reverse Polish Notation.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * A =   ["2", "1", "+", "3", "*"]
 * Input 2:
 * A = ["4", "13", "5", "/", "+"]
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * 9
 * Output 2:
 * 6
 * <p>
 * <p>
 * Example Explanation
 * Explaination 1:
 * starting from backside:
 * * : () * ()
 * 3 : () * (3)
 * + : (() + ()) * (3)
 * 1 : (() + (1)) * (3)
 * 2 : ((2) + (1)) * (3)
 * ((2) + (1)) * (3) = 9
 * Explaination 2:
 * + : () + ()
 * / : () + (() / ())
 * 5 : () + (() / (5))
 * 13 : () + ((13) / (5))
 * 4 : (4) + ((13) / (5))
 * (4) + ((13) / (5)) = 6
 */
public class EvaluateReversePolishNotation {
    /**
     * TC: O(N)
     * SC: O(No. of operands)
     */
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String s : tokens) {
            int a, b;
            switch (s) {
                case "+":
                    stack.add(stack.pop() + stack.pop());
                    break;
                case "/":
                    b = stack.pop();
                    a = stack.pop();
                    stack.add(a / b);
                    break;
                case "*":
                    stack.add(stack.pop() * stack.pop());
                    break;
                case "-":
                    b = stack.pop();
                    a = stack.pop();
                    stack.add(a - b);
                    break;
                default:
                    stack.add(Integer.parseInt(s));
                    break;
            }
        }
        return stack.pop();
    }
}
