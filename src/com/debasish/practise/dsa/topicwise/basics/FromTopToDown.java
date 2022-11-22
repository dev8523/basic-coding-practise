package com.debasish.practise.dsa.topicwise.basics;

import java.util.Scanner;

/**
 * Problem Description
 * <p>
 * You are given a positive integer A as input. You have to print the sum of all odd numbers in the range [1, A].
 * <p>
 * <p>
 * Problem Constraints
 * <p>
 * 1 <= A <= 1000
 * <p>
 * <p>
 * <p>
 * Input Format
 * <p>
 * First and only line contains a single positive integer A.
 * <p>
 * <p>
 * <p>
 * Output Format
 * <p>
 * Print the required sum in a single line.
 * <p>
 * <p>
 * Example Input
 * <p>
 * Input 1:
 * <p>
 * 1
 * Input 2:
 * <p>
 * 4
 * <p>
 * <p>
 * Example Output
 * <p>
 * Output 1:
 * <p>
 * 1
 * Output 2:
 * <p>
 * 4
 * <p>
 * <p>
 * Example Explanation
 * <p>
 * Explanation 1:
 * <p>
 * For A = 1, 1 is the only odd number which lies in the range [1, 1].
 * Explanation 2:
 * <p>
 * For A = 4, Odd numbers 1 and 3 lie in the range [1, 4].
 * Sum = 1 + 3 = 4.
 */
public class FromTopToDown {
    /**
     * TC: O(N)
     * SC: O(1)
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int i = 1, ans = 0;
        while (i <= A) {
            if ((i & 1) != 0) {
                ans += i;
            }
            i++;
        }
        System.out.print(ans);
    }
}
