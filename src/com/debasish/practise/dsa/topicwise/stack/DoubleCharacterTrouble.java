package com.debasish.practise.dsa.topicwise.stack;

import java.util.Stack;

/**
 * Problem Description
 * You are given a string A.
 * <p>
 * An operation on the string is defined as follows:
 * <p>
 * Remove the first occurrence of the same consecutive characters. eg for a string "abbcd", the first occurrence of same consecutive characters is "bb".
 * <p>
 * Therefore the string after this operation will be "acd".
 * <p>
 * Keep performing this operation on the string until there are no more occurrences of the same consecutive characters and return the final string.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= |A| <= 100000
 * <p>
 * <p>
 * <p>
 * Input Format
 * First and only argument is string A.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return the final string.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = abccbc
 * Input 2:
 * <p>
 * A = ab
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * "ac"
 * Output 2:
 * <p>
 * "ab"
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * Remove the first occurrence of same consecutive characters. eg for a string "abbc",
 * the first occurrence of same consecutive characters is "bb".
 * Therefore the string after this operation will be "ac".
 * Explanation 2:
 * <p>
 * No removals are to be done.
 */
public class DoubleCharacterTrouble {
    /**
     * Time Complexity: O(N)
     * Auxiliary Space: O(N)
     */
    static String shortenString(String A) {
        Stack<Character> stack = new Stack<>();
        for (char ch : A.toCharArray()) {
            if (stack.isEmpty() || ch != stack.peek()) stack.push(ch);
            else stack.pop();
        }
        if (stack.isEmpty()) {
            return ("Empty String");
        } else {
            StringBuilder shortString = new StringBuilder();
            while (!stack.isEmpty()) {
                shortString.insert(0, stack.peek());
                stack.pop();
            }
            return (shortString.toString());
        }
    }

    public static void main(String[] args) {
        System.out.println("Result: " + shortenString("abccbc"));
    }
}
