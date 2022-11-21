package com.debasish.practise.dsa.topicwise.graphs;

/**
 * Problem Description
 * Given a matrix of integers A of size N x N, where A[i][j] represents the weight of directed edge from i to j (i ---> j).
 * <p>
 * If i == j, A[i][j] = 0, and if there is no directed edge from vertex i to vertex j, A[i][j] = -1.
 * <p>
 * Return a matrix B of size N x N where B[i][j] = shortest path from vertex i to vertex j.
 * <p>
 * If there is no possible path from vertex i to vertex j , B[i][j] = -1
 * <p>
 * Note: Rows are numbered from top to bottom and columns are numbered from left to right.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= N <= 200
 * -1 <= A[i][j] <= 1000000
 * <p>
 * <p>
 * Input Format
 * The first and only argument given is the integer matrix A.
 * <p>
 * <p>
 * Output Format
 * Return a matrix B of size N x N where B[i][j] = shortest path from vertex i to vertex j
 * If there is no possible path from vertex i to vertex j, B[i][j] = -1.
 * <p>
 * <p>
 * Example Input
 * A = [ [0 , 50 , 39]
 * [-1 , 0 , 1]
 * [-1 , 10 , 0] ]
 * <p>
 * <p>
 * Example Output
 * [ [0 , 49 , 39 ]
 * [-1 , 0 , -1 ]
 * [-1 , 10 , 0 ] ]
 * <p>
 * <p>
 * Example Explanation
 * Shortest Path from 1 to 2 would be 1 ---> 3 ---> 2 and not directly from 1 to 2,
 * All remaining distances remains same.
 */
public class FloydWarshallAlgorithm {

    /**
     * Find the shortest path from vertex i to j.
     * All pair shortest path algorithm.
     * TC: O(V ^ 3)
     * SC: O(V ^ 2)
     */
    public int[][] solve(int[][] A) {
        int r = A.length, c = A[0].length;

        // copy the initial state of distance arr.
        int[][] dist = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (A[i][j] == -1) {
                    dist[i][j] = (int) (1e9);
                } else if (i == j) { // for diagonal elements, as self loop is not possible
                    dist[i][j] = 0; // diagonal elements are 0.
                } else {
                    dist[i][j] = A[i][j];
                }
            }
        }
        for (int k = 0; k < r; k++) {
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (i == j) {
                        continue;
                    } else { // Check phase by phase
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (dist[i][j] == (int) (1e9)) {
                    dist[i][j] = -1;
                }
            }
        }
        return dist;
    }
}
