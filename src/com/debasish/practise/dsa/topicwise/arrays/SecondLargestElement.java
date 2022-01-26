package com.debasish.practise.dsa.topicwise.arrays;

import java.util.Scanner;

/**
 * @author debasishsahoo
 * <p><p>
 * Problem Description
 * <p>
 * You are given an integer T (Number of test cases). For each test case, You are given an integer array A. You have to find the second largest element/value in the array or report that no such element exists.
 * <p>
 * Input Format
 * <p>
 * First line consists of a single integer T.
 * <p>
 * Each test case, on a separate line,first integer is an integer |A| denoting the length of array, and then |A| integers denote the array elements.
 * <p>
 * Output Format
 * <p>
 * For each test case, If such an element exists, print its value, else print -1, on a separate line.
 * <p>
 * Example Input
 * <p>
 * Input 1:
 * <p>
 * 1
 * 3 2 1 2
 * <p>
 * Input 2:
 * <p>
 * 1
 * 1 2
 * <p>
 * Example Output
 * <p>
 * Output 1:
 * <p>
 * 2
 * <p>
 * Output 2:
 * <p>
 * -1
 */
public class SecondLargestElement {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();
            int[] A = new int[N];
            for (int j = 0; j < N; j++) {
                A[j] = sc.nextInt();
            }
            if (N <= 1) System.out.println(-1);
            else System.out.println(findSecondMax(A, N));
        }
    }

    static int findSecondMax(int[] A, int N) {
        int max = A[0];
        int secondMax = max;
        for (int i = 1; i < N; i++) {
            if (A[i] > max) {
                max = A[i];
            }
        }
        for (int i = 1; i < N; i++) {
            if (A[i] != max) {
                if (A[i] > secondMax) {
                    secondMax = A[i];
                }
            }
        }
        return secondMax;
    }
}
