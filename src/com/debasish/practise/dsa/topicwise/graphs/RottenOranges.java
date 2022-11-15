package com.debasish.practise.dsa.topicwise.graphs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Problem Description
 * Given a matrix of integers A of size N x M consisting of 0, 1 or 2.
 * <p>
 * Each cell can have three values:
 * <p>
 * The value 0 representing an empty cell.
 * <p>
 * The value 1 representing a fresh orange.
 * <p>
 * The value 2 representing a rotten orange.
 * <p>
 * Every minute, any fresh orange that is adjacent (Left, Right, Top, or Bottom) to a rotten orange becomes rotten. Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1 instead.
 * <p>
 * Note: Your solution will run on multiple test cases. If you are using global variables, make sure to clear them.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= N, M <= 1000
 * <p>
 * 0 <= A[i][j] <= 2
 * <p>
 * <p>
 * <p>
 * Input Format
 * The first argument given is the integer matrix A.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return the minimum number of minutes that must elapse until no cell has a fresh orange.
 * <p>
 * If this is impossible, return -1 instead.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = [   [2, 1, 1]
 * [1, 1, 0]
 * [0, 1, 1]   ]
 * Input 2:
 * <p>
 * <p>
 * A = [   [2, 1, 1]
 * [0, 1, 1]
 * [1, 0, 1]   ]
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * 4
 * Output 2:
 * <p>
 * -1
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * Max of 4 using (0,0) , (0,1) , (1,1) , (1,2) , (2,2)
 * Explanation 2:
 * <p>
 * Task is impossible
 */
public class RottenOranges {
    /**
     * Using DFS traversal.
     * TC: O(NM)
     * SC: O(NM)
     */
    public int solve(int[][] A) {
        Queue<Pair> q = new LinkedList<>();
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (A[i][j] == 2) {
                    q.add(new Pair(i, j, 0));

                }
            }
        }

        int maxTime = Integer.MIN_VALUE;
        while (!q.isEmpty()) {
            Pair p = q.remove();
            int row = p.row;
            int col = p.col;
            int[] dx = {1, 0, -1, 0};
            int[] dy = {0, 1, 0, -1};
            for (int i = 0; i < 4; i++) {
                int x = row + dx[i];
                int y = col + dy[i];
                if (x >= 0 && y >= 0 && x < A.length && y < A[0].length && A[x][y] == 1) {
                    A[x][y] = 2;
                    q.add(new Pair(x, y, p.time + 1));
                    maxTime = Math.max(maxTime, p.time + 1);

                }

            }
        }

        for (int[] arr : A) {
            for (int num : arr) {
                if (num == 1) return -1;
            }
        }
        return maxTime;
    }

    class Pair {
        int row;
        int col;
        int time;

        Pair(int row, int col, int time) {
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }
}
