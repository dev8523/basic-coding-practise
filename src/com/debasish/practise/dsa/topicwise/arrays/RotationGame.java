package com.debasish.practise.dsa.topicwise.arrays;

import java.util.Scanner;

/**
 * @author debasishsahoo
 * <p><p>
 * Problem Description
 * <p>
 * You are given an integer array A and an integer B. You have to print the same array after rotating it B times towards right.
 * <p>
 * NOTE: You can use extra memory.
 * <p>
 * Input Format
 * <p>
 * First line begins with an integer |A| denoting the length of array, and then |A| integers denote the array elements.
 * Second line contains a single integer B
 * <p>
 * Output Format
 * <p>
 * Print an array of integers which is the Bth right rotation of input array A, on a separate line.
 */
public class RotationGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }
        int B = sc.nextInt();

        for (int r = 1; r <= (B % N); r++) {
            int i = N - 2;
            int temp = A[N - 1];
            while (i >= 0) {
                A[i + 1] = A[i];
                i--;
            }
            A[0] = temp;
        }
        for (int c = 0; c < N; c++) {
            System.out.print(A[c] + " ");
        }
    }
}
/* Dry Run */

// A = [1 2 3 4], N = 4
// B = 2, 40
// 0 rot = [1 2 3 4]
// 1 rot = [4 1 2 3]
// 2 = [3 4 1 2]
// 3 = [2 3 4 1]
// 4 = [1 2 3 4]
// 5 = [4 1 2 3]
// 6 = [3 4 1 2]
// 7 = [2 3 4 1]
// 8 = [1 2 3 4]

// 40%4 = 0

// r = 2
// i

// --------
// r = 1
// i = 2, 1, 0 , -1
// tmp = 4

// i = 2 -> [1 2 3 3]
// i = 1 -> [1 2 2 3]
// i = 0 -> [1 1 2 3]
// A[0] = 4 -> [4 1 2 3]


