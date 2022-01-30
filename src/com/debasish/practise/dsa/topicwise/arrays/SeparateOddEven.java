package com.debasish.practise.dsa.topicwise.arrays;

import java.util.Scanner;

/**
 * @author debasishsahoo
 * <p>
 * Problem Description
 * <p>
 * You are given an integer T denoting the number of test cases. For each test case, you are given an integer array A.
 * <p>
 * You have to put the odd and even elements of array A in 2 separate arrays and print the new arrays.
 * <p>
 * NOTE: Array elements should have same relative order as in A.
 * <p>
 * Input Format
 * <p>
 * First line of the input contains a single integer T.
 * <p>
 * For each test case:
 * <p>
 * First line consists of a single integer |A| denoting the length of array.
 * Second line consists of |A| space separated integers denoting the elements of array A.
 * <p>
 * Output Format
 * <p>
 * For each test case:
 * <p>
 * First line should contain an array of space separated integers containing all the odd elements of array A
 * Second line should contain an array of space separated integers containing all the even elements of array A
 * <p>
 * Example Input
 * <p>
 * Input 1:
 * <p>
 * 2
 * 5
 * 1 2 3 4 5
 * 3
 * 4 3 2
 * <p>
 * Example Output
 * <p>
 * Output 1:
 * <p>
 * 1 3 5
 * 2 4
 * 3
 * 4 2
 */
public class SeparateOddEven {
    public static void main(String[] args) {
        // YOUR CODE GOES HERE
        // Please take input and print output to standard input/output (stdin/stdout)
        // DO NOT USE ARGUMENTS FOR INPUTS
        // E.g. 'Scanner' for input & 'System.out' for output
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();
            int[] A = new int[N];
            for (int j = 0; j < N; j++) {
                A[j] = sc.nextInt();
            }
            printOddArray(A, N);
            System.out.println();
            printEvenArray(A, N);
            System.out.println();
        }
    }

    static void printOddArray(int[] A, int N) {
        int count = 0;
        for (int i = 0; i < N; i++) {
            if (A[i] % 2 != 0) {
                count++;
            }
        }
        int[] oddArr = new int[count];
        int j = 0;
        for (int i = 0; i < N; i++) {
            if (A[i] % 2 != 0) {
                oddArr[j++] = A[i];
            }
        }
        for (int i = 0; i < count; i++) {
            System.out.print(oddArr[i] + " ");
        }
    }

    static void printEvenArray(int[] A, int N) {
        int count = 0;
        for (int i = 0; i < N; i++) {
            if (A[i] % 2 == 0) {
                count++;
            }
        }
        int[] evenArr = new int[count];
        int j = 0;
        for (int i = 0; i < N; i++) {
            if (A[i] % 2 == 0) {
                evenArr[j++] = A[i];
            }
        }
        for (int i = 0; i < count; i++) {
            System.out.print(evenArr[i] + " ");
        }
    }
}
