package com.debasish.practise.dsa.topicwise.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * Problem Description
 * Given a stack of integers A, sort it using another stack.
 * <p>
 * Return the array of integers after sorting the stack using another stack.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= |A| <= 5000
 * <p>
 * 0 <= A[i] <= 109
 * <p>
 * <p>
 * <p>
 * Input Format
 * The only argument is a stack given as an integer array A.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return the array of integers after sorting the stack using another stack.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = [5, 4, 3, 2, 1]
 * Input 2:
 * <p>
 * A = [5, 17, 100, 11]
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * [1, 2, 3, 4, 5]
 * Output 2:
 * <p>
 * [5, 11, 17, 100]
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * Just sort the given numbers.
 * Explanation 2:
 * <p>
 * Just sort the given numbers.
 */
public class SortStackUsingAnotherStack {
    /**
     * TC: O(N^2), Auxiliary space: O(N)
     * Pseudo code:
     */
    // 1. Create a temporary stack say B.
    // 2. While input stack is not empty:
    //     1. pop an element from input stack call it x.
    //     2. while the temporary stack is not empty and top of temporary stack is greater than x,
    //        pop from the temporary stack and push it into the input stack.
    //     3. push x in the temporary stack.
    // 3. The sorted numbers are in the temporary stack.
    public static int[] solve(int[] A) {
        int N = A.length;
        if (N == 1) return A;
        Stack<Integer> inputStack = new Stack<>();
        for (int num : A) {
            inputStack.push(num);
        }
        Stack<Integer> tempStack = new Stack<>();
        while (!inputStack.isEmpty()) {
            int x = inputStack.pop();
            while (!tempStack.isEmpty() && tempStack.peek() > x) {
                inputStack.push(tempStack.pop());
            }
            tempStack.push(x);
        }
        // Now we will have sorted no in tempStack. Just extract them into an ans array and return.
        int[] ans = new int[tempStack.size()];
        int i = 0;
        while (i < tempStack.size()) {
            ans[i] = tempStack.get(i);
            i++;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println("After sorting using another stack: " + Arrays.toString(solve(new int[]{2, 1, 3, 4, 3})));
    }
}
