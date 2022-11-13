package com.debasish.practise.dsa.topicwise.graphs;

/**
 * Problem Description
 * Given the number of vertices A in a Cyclic Graph.
 * <p>
 * Your task is to determine the minimum number of colors required to color the graph so that no two Adjacent vertices have the same color.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 3 <= A <= 109
 * <p>
 * <p>
 * <p>
 * Input Format
 * First argument is an integer A denoting the number of vertices in the Cyclic Graph.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return an single integer denoting the minimum number of colors required to color the graph so that no two Adjacent vertices have the same color.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * 5
 * Input 2:
 * <p>
 * 4
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * 3
 * Output 2:
 * <p>
 * 2
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * <p>
 * Color required = 3
 * Explanation 2:
 * <p>
 * <p>
 * Color required = 2
 */
public class ColoringACyclicGraph {
    /**
     * TC: O(1)
     * SC: O(1)
     */
    public int solve(int A) {
        return ((A & 1) == 0) ? 2 : 3;
    }
}
