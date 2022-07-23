package com.debasish.practise.dsa.topicwise.maths;

import java.util.Scanner;

/**
 * Problem Description
 * <p>
 * You are given N positive integers.
 * <p>
 * For each given integer A, you have to tell whether it is a perfect number or not.
 * <p>
 * Perfect number is a positive integer which is equal to the sum of its proper positive divisors.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * <p>
 * 1 <= N <= 10
 * <p>
 * 1 <= A <= 106
 * <p>
 * <p>
 * <p>
 * Input Format
 * <p>
 * First line of the input contains a single integer N.
 * <p>
 * Each of the next N lines contains a single integer A.
 * <p>
 * <p>
 * <p>
 * Output Format
 * <p>
 * In a seperate line, print YES if a given integer is perfect, else print NO.
 * <p>
 * <p>
 * <p>
 * Example Input
 * <p>
 * Input 1:
 * <p>
 * 2
 * 4
 * 6
 * Input 2:
 * <p>
 * 1
 * 3
 * <p>
 * <p>
 * Example Output
 * <p>
 * Output 1:
 * <p>
 * NO
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
 * For A = 4, the answer is "NO" as sum of its proper divisors = 1 + 2 = 3, is not equal to 4.
 * For A = 6, the answer is "YES" as sum of its proper divisors = 1 + 2 + 3 = 6, is equal to 6.
 * Explanation 2:
 * <p>
 * For A = 3, the answer is "NO" as sum of its proper divisors = 1, is not equal to 3.
 */
public class IsPerfectNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberOfInputs = sc.nextInt();
        for (int i = 1; i <= numberOfInputs; i++) {
            int num = sc.nextInt();
            String res = isPerfect(num) ? "YES" : "NO";
            System.out.println(res);
        }
    }

    static boolean isPerfect(int n) {
        if (n == 1) return true;
        int sum = 0;
        for (int i = 1; i < n; i++) {
            if (n % i == 0) {
                sum += i;
            }
        }
        return n == sum;
    }
}
