package com.debasish.practise.dsa.topicwise.graphs;

import java.util.ArrayList;

/**
 * Problem Description
 * <p>
 * Given an undirected graph having A nodes labelled from 1 to A with M edges given in a form of matrix B of size M x 2 where (B[i][0], B[i][1]) represents two nodes B[i][0] and B[i][1] connected by an edge.
 * <p>
 * Find whether the graph contains a cycle or not, return 1 if cycle is present else return 0.
 * <p>
 * NOTE:
 * <p>
 * The cycle must contain atleast three nodes.
 * There are no self-loops in the graph.
 * There are no multiple edges between two nodes.
 * The graph may or may not be connected.
 * Nodes are numbered from 1 to A.
 * Your solution will run on multiple test cases. If you are using global variables make sure to clear them.
 * <p>
 * <p>
 * Problem Constraints
 * <p>
 * 1 <= A, M <= 3*105
 * <p>
 * 1 <= B[i][0], B[i][1] <= A
 * <p>
 * <p>
 * <p>
 * Input Format
 * <p>
 * The first argument given is an integer A representing the number of nodes in the graph.
 * <p>
 * The second argument given is an matrix B of size M x 2 which represents the M edges such that there is a edge between node B[i][0] and node B[i][1].
 * <p>
 * <p>
 * <p>
 * Output Format
 * <p>
 * Return 1 if cycle is present else return 0.
 * <p>
 * <p>
 * <p>
 * Example Input
 * <p>
 * Input 1:
 * <p>
 * A = 5
 * B = [  [1. 2]
 * [1, 3]
 * [2, 3]
 * [1, 4]
 * [4, 5]
 * ]
 * Input 2:
 * <p>
 * A = 3
 * B = [  [1. 2]
 * [1, 3]
 * ]
 * <p>
 * <p>
 * Example Output
 * <p>
 * Output 1:
 * <p>
 * 1
 * Output 2:
 * <p>
 * 0
 * <p>
 * <p>
 * Example Explanation
 * <p>
 * Explanation 1:
 * <p>
 * There is a cycle in the graph i.e 1 -> 2 -> 3 -> 1 so we will return 1
 * Explanation 2:
 * <p>
 * No cycle present in the graph so we will return 0.
 */
public class CycleInUndirectedGraph {
    ArrayList<Integer>[] graph;
    boolean[] visited;
    boolean isCycle;

    /**
     * Using DFS traversal.
     * TC: O(V + E)
     * SC: O(V + E)
     * V: no. of vertices
     * E: no. of edges
     */
    public int solve(int A, int[][] B) {
        isCycle = false;
        graph = buildAdjacencyList(A, B);
        visited = new boolean[A + 1];
        return isCycleInUndirectedGraph(A) ? 1 : 0;
    }

    private boolean isCycleInUndirectedGraph(int A) {
        for (int i = 1; i <= A; i++) {
            if (!visited[i]) {
                dfs(i, 0);
            }
            if (isCycle) {
                break;
            }
        }
        return isCycle;
    }

    private boolean dfs(int v, int previous) {
        visited[v] = true;
        for (int u : graph[v]) {
            if (u != previous) {
                if (!visited[u]) {
                    dfs(u, v);
                } else {
                    isCycle = true;
                    return true;
                }
            }
        }
        return false;
    }

    private ArrayList<Integer>[] buildAdjacencyList(int A, int[][] B) {
        ArrayList<Integer>[] g = new ArrayList[A + 1];
        for (int i = 0; i <= A; i++) {
            g[i] = new ArrayList<>();
        }
        for (int[] num : B) {
            int u = num[0];
            int v = num[1];
            g[u].add(v);
            g[v].add(u);
        }
        return g;
    }
}
