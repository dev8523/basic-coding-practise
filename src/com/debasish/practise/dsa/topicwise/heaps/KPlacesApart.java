package com.debasish.practise.dsa.topicwise.heaps;

import java.util.PriorityQueue;

/**
 * Problem Description
 * N people having different priorities are standing in a queue.
 * <p>
 * The queue follows the property that each person is standing at most B places away from its position in the sorted queue.
 * <p>
 * Your task is to sort the queue in the increasing order of priorities.
 * <p>
 * NOTE:
 * <p>
 * No two persons can have the same priority.
 * Use the property of the queue to sort the queue with complexity O(NlogB).
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= N <= 100000
 * 0 <= B <= N
 * <p>
 * <p>
 * <p>
 * Input Format
 * The first argument is an integer array A representing the priorities and initial order of N persons.
 * The second argument is an integer B.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return an integer array representing the sorted queue.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = [1, 40, 2, 3]
 * B = 2
 * Input 2:
 * <p>
 * A = [2, 1, 17, 10, 21, 95]
 * B = 1
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * [1, 2, 3, 40]
 * Output 2:
 * <p>
 * [1, 2, 10, 17, 21, 95]
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * Given array A = [1, 40, 2, 3]
 * After sorting, A = [1, 2, 3, 40].
 * We can see that difference between initial position of elements amd the final position <= 2.
 * Explanation 2:
 * <p>
 * After sorting, the array becomes [1, 2, 10, 17, 21, 95].
 */
public class KPlacesApart {
    /**
     * Using min heap
     * TC: O(NlogN)
     * SC: O(N)
     */
    public int[] solve(int[] A, int B) {
        int n = A.length;
        int[] ans = new int[n];
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < B + 1; i++) {
            minHeap.add(A[i]);
        }
        int index = 0;
        for (int i = B + 1; i < n; i++) {
            ans[index++] = minHeap.poll();
            minHeap.add(A[i]);
        }
        while (!minHeap.isEmpty()) {
            ans[index++] = minHeap.poll();
        }
        return ans;
    }
}
