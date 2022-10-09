package com.debasish.practise.dsa.topicwise.heaps;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * Problem Description
 * Given an array of integers A and an integer B. You must modify the array exactly B number of times. In a single modification, we can replace any one array element A[i] by -A[i].
 *
 * You need to perform these modifications in such a way that after exactly B modifications, sum of the array must be maximum.
 *
 *
 *
 * Problem Constraints
 * 1 <= length of the array <= 5*105
 * 1 <= B <= 5 * 106
 * -100 <= A[i] <= 100
 *
 *
 *
 * Input Format
 * The first argument given is an integer array A.
 * The second argument given is an integer B.
 *
 *
 *
 * Output Format
 * Return an integer denoting the maximum array sum after B modifications.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [24, -68, -29, -9, 84]
 *  B = 4
 * Input 2:
 *
 *  A = [57, 3, -14, -87, 42, 38, 31, -7, -28, -61]
 *  B = 10
 *
 *
 * Example Output
 * Output 1:
 *
 *  196
 * Output 2:
 *
 *  362
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  Final array after B modifications = [24, 68, 29, -9, 84]
 * Explanation 2:
 *
 *  Final array after B modifications = [57, -3, 14, 87, 42, 38, 31, 7, 28, 61]
 */
public class MaximumArraySumAfterBNegations {
    /**
     * Using MIN HEAP
     * TC: O(NlogN) = Inserting ele into minheap -> O(N) and removing in between from heap -> O(logN)
     * SC: O(N) = Using PriorityQueue/Min heap size
     */
    public int solve(ArrayList<Integer> A, int B) {
        int sum = 0;
        // Min heap is a data structure that can help us in
        // getting the bag with minimum chocolates at any moment/iteration.
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Insert all elements into min heap.
        for (Integer integer : A) {
            minHeap.offer(integer); // offer() method is used to insert a particular element into the Priority Queue
        }

        // Looping B times
        for (int i = 1; i <= B; i++) {
            // Extract min element from minheap and modify the value
            int min_val = minHeap.poll();
            min_val = -(min_val);

            // Push the min element back into minheap.
            minHeap.offer(min_val);
        }

        /*
        Iterator<Integer> itr = pq.iterator();
        while(itr.hasNext()){
            sum += itr.next();
        }*/

        // OR //

        // Remove elements from the minheap until the heap becomes empty
        // and add it to the result sum.
        while (!minHeap.isEmpty()) {
            sum += minHeap.poll();
        }

        return sum;
    }
}
