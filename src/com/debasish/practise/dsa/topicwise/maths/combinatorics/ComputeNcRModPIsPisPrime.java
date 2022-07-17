package com.debasish.practise.dsa.topicwise.maths.combinatorics;

/**
 * Problem Description
 * Given three integers A, B, and C, where A represents n, B represents r, and C represents p and p is a prime number greater than equal to n, find and return the value of nCr % p where nCr % p = (n! / ((n-r)! * r!)) % p.
 * <p>
 * x! means factorial of x i.e. x! = 1 * 2 * 3... * x.
 * <p>
 * NOTE: For this problem, we are considering 1 as a prime.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= A <= 106
 * 1 <= B <= A
 * A <= C <= 109+7
 * <p>
 * <p>
 * Input Format
 * The first argument given is the integer A ( = n).
 * The second argument given is the integer B ( = r).
 * The third argument given is the integer C ( = p).
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return the value of nCr % p.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = 5
 * B = 2
 * C = 13
 * Input 2:
 * <p>
 * A = 6
 * B = 2
 * C = 13
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * 10
 * Output 2:
 * <p>
 * 2
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * nCr( n=5 and r=2) = 10.
 * p=13. Therefore, nCr%p = 10.
 */
public class ComputeNcRModPIsPisPrime {
    public static int modInverse(int a, int c) {
        return power(a, c - 2, c);
    }

    public static int power(int x, int y, int m) {
        if (y == 0)
            return 1;
        int p = power(x, y / 2, m) % m;
        p = (p * p) % m;
        return (y % 2 == 0) ? p : (x * p) % m;
    }

    public static int solve(int A, int B, int C) {
        if (B == 0)
            return 1;
        int[] factorial = new int[A + 1];
        factorial[0] = 1;
        for (int i = 1; i <= A; i++) {
            factorial[i] = (factorial[i - 1] * i) % C;
        }
        return (factorial[A] % C * (modInverse(factorial[A - B], C) % C) * (modInverse(factorial[B], C) % C)) % C;
    }

    public static void main(String[] args) {
        System.out.println(solve(5, 2, 13));
    }
}
