package com.debasish.practise.dsa.topicwise.maths;

import java.util.Scanner;

/**
 * Problem Description
 * <p>
 * Write a program to find sum all Natural numbers from 1 to N where you have to take N as input from user
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * <p>
 * 1 <= N <= 1000
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
 * A single integer showing sum of all Natural numbers from 1 to N
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
 * 15
 * Output 2:
 * <p>
 * 55
 */
public class SummationOfNaturalNos {
    public static void main(String[] args) {
        // YOUR CODE GOES HERE
        // Please take input and print output to standard input/output (stdin/stdout)
        // DO NOT USE ARGUMENTS FOR INPUTS
        // E.g. 'Scanner' for input & 'System.out' for output
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        System.out.print(sumOfNaturalNo(N));
    }

    static int sumOfNaturalNo(int n) {
        int sum = 0, i = 1;

        /* While loop*/

        // Test condition
        while (i <= n) {

            /* Statements to execute */

            // Update the current sum till
            // test condition holds true
            sum = sum + i;

            // Increment the variable counter
            // or jumping to next natural number
            i++;
        }
        return sum;
    }
}
