package com.debasish.practise.dsa.topicwise.basics;

import java.util.Scanner;

/**
 * Problem Description
 * <p>
 * Write a program to print all Natural numbers from 1 to N where you have to take N as input from user
 * <p>
 * <p>
 * Problem Constraints
 * <p>
 * 1 <= N <= 1000000
 * <p>
 * <p>
 * <p>
 * Input Format
 * <p>
 * A single line representing N
 * <p>
 * <p>
 * <p>
 * Output Format
 * <p>
 * N space separated integers from 1 to N.
 * <p>
 * <p>
 * <p>
 * Example Input
 * <p>
 * Input 1:
 * <p>
 * 5
 * Input 2:
 * <p>
 * 10
 * <p>
 * <p>
 * Example Output
 * <p>
 * Output 1:
 * <p>
 * 1 2 3 4 5
 * Output 2:
 * <p>
 * 1 2 3 4 5 6 7 8 9 10
 */
public class PrintAllNaturalNumbers {
    /**
     * TC: O(N)
     * SC: O(1)
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int i = 1;
        while (i <= N) {
            System.out.print(i + " ");
            i++;
        }
    }
}
