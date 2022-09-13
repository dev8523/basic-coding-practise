package com.debasish.practise.dsa.topicwise.queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Problem Description
 * Given an integer, A. Find and Return first positive A integers in ascending order containing only digits 1, 2, and 3.
 * <p>
 * NOTE: All the A integers will fit in 32-bit integers.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= A <= 29500
 * <p>
 * <p>
 * <p>
 * Input Format
 * The only argument given is integer A.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return an integer array denoting the first positive A integers in ascending order containing only digits 1, 2 and 3.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = 3
 * Input 2:
 * <p>
 * A = 7
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * [1, 2, 3]
 * Output 2:
 * <p>
 * [1, 2, 3, 11, 12, 13, 21]
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * Output denotes the first 3 integers that contains only digits 1, 2 and 3.
 * Explanation 2:
 * <p>
 * Output denotes the first 3 integers that contains only digits 1, 2 and 3.
 */
public class NIntegersContainingOnly1And2And3 {
    /*
    We know the initial three values will be 1, 2, and 3.

    Now, the upcoming values will be by appending 1, 2, and 3 in each given value.

    We will use a queue to store the elements in ascending order.

    Pseudocode

    Queue = Empty Queue

    Q.insert(1)
    Q.insert(2)
    Q.insert(3)

    count = 0
    while(count < n):
        num = Q.front;
        Q.insert(string(num) + string(1) )
        Q.insert(string(num) + string(2) )
        Q.insert(string(num) + string(3) )
        Q.pop()
        count++;
    */
    public ArrayList<Integer> solve(int A) {
        // Using Queue, TC: O(N), SC:O(N)
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        int cnt = 3;
        while (ans.size() < A) {
            int x = q.peek();
            ans.add(x);
            q.remove();
            if (cnt >= A) continue;
            q.add(10 * x + 1);
            q.add(10 * x + 2);
            q.add(10 * x + 3);
            cnt += 3;
        }
        return ans;
    }
}
