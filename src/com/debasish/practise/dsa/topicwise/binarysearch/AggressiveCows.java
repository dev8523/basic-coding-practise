package com.debasish.practise.dsa.topicwise.binarysearch;

import java.util.Arrays;

/**
 * Problem Description
 * Farmer John has built a new long barn with N stalls. Given an array of integers A of size N where each element of the array represents the location of the stall and an integer B which represents the number of cows.
 * <p>
 * His cows don't like this barn layout and become aggressive towards each other once put into a stall. To prevent the cows from hurting each other, John wants to assign the cows to the stalls, such that the minimum distance between any two of them is as large as possible. What is the largest minimum distance?
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 2 <= N <= 100000
 * 0 <= A[i] <= 109
 * 2 <= B <= N
 * <p>
 * <p>
 * <p>
 * Input Format
 * The first argument given is the integer array A.
 * The second argument given is the integer B.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return the largest minimum distance possible among the cows.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = [1, 2, 3, 4, 5]
 * B = 3
 * Input 2:
 * <p>
 * A = [1, 2]
 * B = 2
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * 2
 * Output 2:
 * <p>
 * 1
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * John can assign the stalls at location 1, 3 and 5 to the 3 cows respectively. So the minimum distance will be 2.
 * Explanation 2:
 * <p>
 * The minimum distance will be 1.
 */
public class AggressiveCows {
    /**
     * Code explained in details here: <a href="https://leetcode.com/discuss/general-discussion/1302335/aggressive-cows-spoj-fully-explained-c">...</a>
     */
    static boolean isPossible(int[] stalls, int minDist, int k) {
        int cows = 1;
        int lastCowPosition = stalls[0];
        for (int i = 1; i < stalls.length; i++) {
            if (stalls[i] - lastCowPosition >= minDist) {
                cows++;
                lastCowPosition = stalls[i];
            }
        }
        return (cows >= k);
    }

    static int aggressiveCows(int[] A, int B) {
        int n = A.length;
        Arrays.sort(A);
        int low = 1, high = A[n - 1] - A[0];
        int res = 0;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (isPossible(A, mid, B)) {
                res = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(aggressiveCows(new int[]{1, 2, 3, 4, 5}, 3));
    }
}
