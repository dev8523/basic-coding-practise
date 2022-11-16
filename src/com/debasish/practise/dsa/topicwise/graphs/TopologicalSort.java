package com.debasish.practise.dsa.topicwise.graphs;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * Problem Description
 * Given an directed acyclic graph having A nodes. A matrix B of size M x 2 is given which represents the M edges such that there is a edge directed from node B[i][0] to node B[i][1].
 * <p>
 * Topological sorting for Directed Acyclic Graph (DAG) is a linear ordering of vertices such that for every directed edge uv, vertex u comes before v in the ordering. Topological Sorting for a graph is not possible if the graph is not a DAG.
 * <p>
 * Return the topological ordering of the graph and if it doesn't exist then return an empty array.
 * <p>
 * If there is a solution return the correct ordering. If there are multiple solutions print the lexographically smallest one.
 * <p>
 * Ordering (a, b, c) is said to be lexographically smaller than ordering (e, f, g) if a < e or if(a==e) then b < f and so on.
 * <p>
 * NOTE:
 * <p>
 * There are no self-loops in the graph.
 * There are no multiple edges between two nodes.
 * The graph may or may not be connected.
 * Nodes are numbered from 1 to A.
 * Your solution will run on multiple test cases. If you are using global variables make sure to clear them.
 * <p>
 * <p>
 * Problem Constraints
 * 2 <= A <= 104
 * <p>
 * 1 <= M <= min(100000,A*(A-1))
 * <p>
 * 1 <= B[i][0], B[i][1] <= A
 * <p>
 * <p>
 * <p>
 * Input Format
 * The first argument given is an integer A representing the number of nodes in the graph.
 * <p>
 * The second argument given a matrix B of size M x 2 which represents the M edges such that there is a edge directed from node B[i][0] to node B[i][1].
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return a one-dimensional array denoting the topological ordering of the graph and it it doesn't exist then return empty array.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = 6
 * B = [  [6, 3]
 * [6, 1]
 * [5, 1]
 * [5, 2]
 * [3, 4]
 * [4, 2] ]
 * Input 2:
 * <p>
 * A = 3
 * B = [  [1, 2]
 * [2, 3]
 * [3, 1] ]
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * [5, 6, 1, 3, 4, 2]
 * Output 2:
 * <p>
 * []
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * The given graph contain no cycle so topological ordering exists which is [5, 6, 1, 3, 4, 2]
 * Explanation 2:
 * <p>
 * The given graph contain cycle so topological ordering not possible we will return empty array.
 */
public class TopologicalSort {
    /**
     * Using Kahn's Algo:
     * TC: O(V+E)
     * SC: (V+E)
     */
    public int[] solve(int A, int[][] B) {
        int[] inDegreeArr = new int[A + 1];

        // Create the list and in-degree array.
        // will consider the node which has 0 as in-degree.
        ArrayList<Integer>[] list = new ArrayList[A + 1];
        createListAndInDegreeArr(A, B, list, inDegreeArr);
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 1; i < inDegreeArr.length; i++) {
            if (inDegreeArr[i] == 0) {
                queue.add(i);
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        while (!queue.isEmpty()) {
            int front = queue.poll();
            ans.add(front);
            for (int i = 0; i < list[front].size(); i++) {
                int neighbour = list[front].get(i);
                inDegreeArr[neighbour]--;
                if (inDegreeArr[neighbour] == 0) {
                    queue.add(neighbour);
                }
            }
        }
        if (ans.size() < A) {
            return new int[]{};
        }
        int[] res = new int[A];
        for (int i = 0; i < ans.size(); i++) {
            res[i] = ans.get(i);
        }
        return res;
    }

    public void createListAndInDegreeArr(int A, int[][] B, ArrayList<Integer>[] list, int[] inDegreeArr) {
        for (int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < B.length; i++) {
            list[B[i][0]].add(B[i][1]);
            inDegreeArr[B[i][1]]++;
        }
    }
}
