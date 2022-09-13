package com.debasish.practise.dsa.topicwise.queue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Problem Description
 * A CPU has N tasks to be performed. It is to be noted that the tasks have to be completed in a specific order to avoid deadlock. In every clock cycle, the CPU can either perform a task or move it to the back of the queue. You are given the current state of the scheduler queue in array A and the required order of the tasks in array B.
 * <p>
 * Determine the minimum number of clock cycles to complete all the tasks.
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= N <= 1000
 * 1 <= A[i], B[i] <= N
 * <p>
 * <p>
 * Input Format
 * First argument consist of integer array A.
 * Second argument consist of integer array B.
 * <p>
 * <p>
 * Output Format
 * Return an integer denoting the minimum number of clock cycles required to complete all the tasks.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = [2, 3, 1, 5, 4]
 * B = [1, 3, 5, 4, 2]
 * Input 2:
 * <p>
 * A = [1]
 * B = [1]
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * 10
 * Output 2:
 * <p>
 * 1
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * According to the order array B task 1 has to be performed first, so the CPU will move tasks 2 and 3 to the end of the queue (in 2 clock cycles).
 * Total clock cycles till now = 2
 * Now CPU will perform task 1.
 * Total clock cycles till now = 3
 * Now, queue becomes [5, 4, 2, 3]
 * Now, CPU has to perform task 3. So it moves tasks 5, 4, and 2 to the back one-by-one.
 * Total clock cycles till now = 6
 * Now all the tasks in the queue are as in the required order so the CPU will perform them one-by-one.
 * Total clock cycles = 10
 * Explanation 2:
 * <p>
 * Directly task 1 is completed.
 */
public class TaskScheduling {
    /**
     * TC: O(N^2)
     * SC: O(N)
     */
    public static int leastInterval(int[] A, int[] B) {
        Deque<Integer> deque = new ArrayDeque<>(); // It will work for [Queue<Integer> queue = new LinkedList<>()] as well.
        for (int num : A) {
            deque.offer(num); // Push into Queue
        }
        int cycle = 0;
        for (int i = 0; i < A.length; i++) {
            while (!deque.peek().equals(B[i])) {
                int tmp = deque.peek();
                deque.poll(); // Remove from front of the queue
                cycle++;
                deque.add(tmp); // Insert the front element at end
            }
            cycle++;
            deque.remove(); // Remove from the queue
        }
        return cycle;
    }

    public static void main(String[] args) {
        int[] A = {2, 3, 1, 5, 4};
        int[] B = {1, 3, 5, 4, 2};
        System.out.println("Least no. of clock cycles taken by the CPU: " + leastInterval(A, B));
    }
}
