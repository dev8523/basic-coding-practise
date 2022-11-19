package com.debasish.practise.dsa.topicwise.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Problem Description
 * Given a weighted undirected graph having A nodes and M weighted edges, and a source node C.
 * <p>
 * You have to find an integer array D of size A such that:
 * <p>
 * => D[i] : Shortest distance form the C node to node i.
 * <p>
 * => If node i is not reachable from C then -1.
 * <p>
 * Note:
 * <p>
 * There are no self-loops in the graph.
 * <p>
 * No multiple edges between two pair of vertices.
 * <p>
 * The graph may or may not be connected.
 * <p>
 * Nodes are numbered from 0 to A-1.
 * <p>
 * Your solution will run on multiple testcases. If you are using global variables make sure to clear them.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= A <= 1e5
 * <p>
 * 0 <= B[i][0],B[i][1] < A
 * <p>
 * 0 <= B[i][2] <= 1e3
 * <p>
 * 0 <= C < A
 * <p>
 * <p>
 * <p>
 * Input Format
 * The first argument given is an integer A, representing the number of nodes.
 * <p>
 * The second argument given is the matrix B of size M x 3, where nodes B[i][0] and B[i][1] are connected with an edge of weight B[i][2].
 * <p>
 * The third argument given is an integer C.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return the integer array D.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = 6
 * B = [   [0, 4, 9]
 * [3, 4, 6]
 * [1, 2, 1]
 * [2, 5, 1]
 * [2, 4, 5]
 * [0, 3, 7]
 * [0, 1, 1]
 * [4, 5, 7]
 * [0, 5, 1] ]
 * C = 4
 * Input 2:
 * <p>
 * A = 5
 * B = [   [0, 3, 4]
 * [2, 3, 3]
 * [0, 1, 9]
 * [3, 4, 10]
 * [1, 3, 8]  ]
 * C = 4
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * D = [7, 6, 5, 6, 0, 6]
 * Output 2:
 * <p>
 * D = [14, 18, 13, 10, 0]
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * All Paths can be considered from the node C to get shortest path
 * Explanation 2:
 * <p>
 * All Paths can be considered from the node C to get shortest path
 */
public class SingleSourceShortestPathUsingDijkstra {

    /**
     * Find single source shortest path, using Dijkstra algorithm.
     * TC: O(V + E) * O(logV) = O(E.logV)
     * SC: O(V) - for min heap
     */
    public int[] solve(int A, int[][] B, int C) {
        ArrayList<ArrayList<Pair>> list = adjList(A, B);
        int[] distance = new int[A];

        // Fill all the elements of distance arr with infinity.
        Arrays.fill(distance, (int) 1e9);

        // Create a min heap with distance to
        // pop out the min distance every time.
        PriorityQueue<Pair> minHeapPQ = new PriorityQueue<>((x, y) -> x.weight - y.weight);

        // Insert first node into the min heap
        minHeapPQ.add(new Pair(0, C));
        distance[C] = 0;

        // Pick the node which has the min distance and is present in the min heap.
        while (!minHeapPQ.isEmpty()) {
            int dist = minHeapPQ.peek().node;
            int node = minHeapPQ.peek().weight;

            // Pop all the neighbours of the picked nodes(update distance in the minheap also)
            // then remove the current vertex from the min heap.
            minHeapPQ.remove();
            for (Pair p : list.get(node)) {
                int edgeWeight = p.weight;
                int adjNode = p.node;
                if (dist + edgeWeight < distance[adjNode]) {

                    // calculate the distance of neighbour node using already computed dist.
                    distance[adjNode] = dist + edgeWeight;

                    // update the min distance in min heap
                    minHeapPQ.add(new Pair(distance[adjNode], adjNode));
                }
            }

        }
        for (int i = 0; i < A; i++) {
            if (distance[i] == (int) 1e9) {
                distance[i] = -1;
            }
        }
        return distance;
    }

    /**
     * Build adjacency list.
     */
    private ArrayList<ArrayList<Pair>> adjList(int A, int[][] B) {
        ArrayList<ArrayList<Pair>> list = new ArrayList<>();
        for (int i = 0; i < A; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < B.length; i++) {
            int u = B[i][0];
            int v = B[i][1];
            int w = B[i][2];
            list.get(u).add(new Pair(v, w));
            list.get(v).add(new Pair(u, w));
        }
        return list;
    }

    class Pair {
        int node;
        int weight;

        Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }
}
