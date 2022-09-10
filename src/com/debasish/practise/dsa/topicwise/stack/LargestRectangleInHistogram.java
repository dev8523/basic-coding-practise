package com.debasish.practise.dsa.topicwise.stack;

import java.util.Stack;

public class LargestRectangleInHistogram {
    /**
     * TC: O(N), SC: O(N)
     * Algorithm:
     */
    // 1. Traverse left to right. Maintain a stack of histogram bars.
    // 2. Every height is pushed to stack. A height is popped from stack when a bar of smaller height is seen.
    // 3. When the height is popped, we calculate the area with the popped height.
    public static int largestRectangleArea(int[] heights) {
        int len = heights.length;
        Stack<Integer> s = new Stack<>();
        int maxArea = 0;
        for (int i = 0; i <= len; i++) {
            int h = (i == len ? 0 : heights[i]);
            if (s.isEmpty() || h >= heights[s.peek()]) {
                s.push(i);
            } else {
                int tp = s.pop();
                maxArea = Math.max(maxArea, heights[tp] * (s.isEmpty() ? i : i - 1 - s.peek()));
                i--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        System.out.println("Largest rectangle area in histogram: " + largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
    }
}
