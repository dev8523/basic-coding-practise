package com.debasish.practise.dsa.topicwise.binarysearch;

/**
 * Problem Description
 * You are given three positive integers, A, B, and C.
 * <p>
 * Any positive integer is magical if divisible by either B or C.
 * <p>
 * Return the Ath smallest magical number. Since the answer may be very large, return modulo 109 + 7.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= A <= 109
 * <p>
 * 2 <= B, C <= 40000
 * <p>
 * <p>
 * <p>
 * Input Format
 * The first argument given is an integer A.
 * <p>
 * The second argument given is an integer B.
 * <p>
 * The third argument given is an integer C.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return the Ath smallest magical number. Since the answer may be very large, return modulo 109 + 7.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = 1
 * B = 2
 * C = 3
 * Input 2:
 * <p>
 * A = 4
 * B = 2
 * C = 3
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * 2
 * Output 2:
 * <p>
 * 6
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * 1st magical number is 2.
 * Explanation 2:
 * <p>
 * First four magical numbers are 2, 3, 4, 6 so the 4th magical number is 6.
 */
public class AthMagicalNumber {
    // TC: O(log(min(B, C) * A)), SC: O(1)
    public static int solve(int A, int B, int C) {
        long low = 1, high = (long) A * Math.min(B, C), ans = 1, mod = (long) 1e9 + 7;
        while (low <= high) {
            long mid = (low + high) / 2;
            if ((mid / B) + (mid / C) - (mid / (lcm(B, C))) < A) {
                low = mid + 1;
                ans = low;
            } else {
                high = mid - 1;
            }
        }
        return (int) (ans % mod);
    }

    public static int lcm(int a, int b) {
        int gcd = 1;
        for (int i = 1; i <= a && i <= b; ++i) {
            if (a % i == 0 && b % i == 0)
                gcd = i;
        }
        return (a * b) / gcd;
    }

    public static void main(String[] args) {
        System.out.println(solve(7, 2, 3));
    }
}
