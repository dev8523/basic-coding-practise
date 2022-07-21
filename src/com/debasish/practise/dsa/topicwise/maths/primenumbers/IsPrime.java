package com.debasish.practise.dsa.topicwise.maths.primenumbers;

import java.util.Scanner;

/**
 * Problem Description
 * <p>
 * Given an integer A, you have to tell whether it is a prime number or not.
 * <p>
 * A prime number is a natural number greater than 1 which is divisible only by 1 and itself.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * <p>
 * 1 <= A <= 106
 * <p>
 * <p>
 * <p>
 * Input Format
 * <p>
 * First and only line of the input contains a single integer A.
 * <p>
 * <p>
 * <p>
 * Output Format
 * <p>
 * Print YES if A is a prime, else print NO.
 * <p>
 * <p>
 * <p>
 * Example Input
 * <p>
 * Input 1:
 * <p>
 * 3
 * Input 2:
 * <p>
 * 4
 * <p>
 * <p>
 * Example Output
 * <p>
 * Output 1:
 * <p>
 * YES
 * Output 2:
 * <p>
 * NO
 * <p>
 * <p>
 * Example Explanation
 * <p>
 * Explanation 1:
 * <p>
 * 3 is a prime number as it is only divisible by 1 and 3.
 * Explanation 2:
 * <p>
 * 4 is not a prime number as it is divisible by 2.
 */
public class IsPrime {
    // TC: O(Math.sqrt(N)), SC = O(1)
    public static void main(String[] args) {
        // YOUR CODE GOES HERE
        // Please take input and print output to standard input/output (stdin/stdout)
        // DO NOT USE ARGUMENTS FOR INPUTS
        // E.g. 'Scanner' for input & 'System.out' for output
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String res = isPrime(N) ? "YES" : "NO";
        System.out.print(res);
    }

    // Check for number prime or not
    static boolean isPrime(int n) {
        // Check if number is less than
        // equal to 1
        if (n <= 1) return false;

            // Check if number is 2
        else if (n == 2) return true;

            // Check if n is a multiple of 2
        else if (n % 2 == 0) return false;

        // If not, then just check the odds
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
