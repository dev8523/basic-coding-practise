package com.debasish.practise.dsa.topicwise.heaps;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Problem Description
 * Given N bags, each bag contains Bi chocolates. There is a kid and a magician.
 * In a unit of time, the kid can choose any bag i, and eat Bi chocolates from it, then the magician will fill the ith bag with floor(Bi/2) chocolates.
 *
 * Find the maximum number of chocolates that the kid can eat in A units of time.
 *
 * NOTE:
 *
 * floor() function returns the largest integer less than or equal to a given number.
 * Return your answer modulo 109+7
 *
 *
 * Problem Constraints
 * 1 <= N <= 100000
 * 0 <= B[i] <= INT_MAX
 * 0 <= A <= 105
 *
 *
 *
 * Input Format
 * The first argument is an integer A.
 * The second argument is an integer array B of size N.
 *
 *
 *
 * Output Format
 * Return an integer denoting the maximum number of chocolates the kid can eat in A units of time.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = 3
 *  B = [6, 5]
 * Input 2:
 *
 *  A = 5
 *  b = [2, 4, 6, 8, 10]
 *
 *
 * Example Output
 * Output 1:
 *
 *  14
 * Output 2:
 *
 *  33
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  At t = 1 kid eats 6 chocolates from bag 0, and the bag gets filled by 3 chocolates.
 *  At t = 2 kid eats 5 chocolates from bag 1, and the bag gets filled by 2 chocolates.
 *  At t = 3 kid eats 3 chocolates from bag 0, and the bag gets filled by 1 chocolate.
 *  so, total number of chocolates eaten are 6 + 5 + 3 = 14
 * Explanation 2:
 *
 *  Maximum number of chocolates that can be eaten is 33.
 */
public class MagicianAndChocolates {
    /**
     * First loop takes TC O(N), 2nd loop has TC O(AlogN). Total TC = O(N)+O(AlogN)
     * SC is O(N)
     */
    public int nChoc(int A, int[] B) {
        // Max heap is a data structure that can help us in getting the bag with maximum chocolates at any moment
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        // Creating a max heap containing all elements of B
        for (int i : B) {
            pq.offer(i); // offer() method is used to insert a particular element into the Priority Queue
        }

        // declaring sum and mod variables
        long maxChocolate = 0;
        long mod = 1000000007;

        // Get bag with maximum number of chocolates from the max heap (feed this to the kid i.e. store it in sum)
        while (A-- > 0) {
            int temp = pq.poll(); // poll function is used to fetch & remove max element from max heap
            maxChocolate += (temp) % mod;

            // Magician has to now Push floor value (B[i]/2) back to max heap.
            pq.offer((int) Math.floor(temp / 2));
        }
        maxChocolate %= mod;
        return (int) maxChocolate;
    }
}
