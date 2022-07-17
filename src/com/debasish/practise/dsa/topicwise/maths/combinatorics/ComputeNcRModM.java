package com.debasish.practise.dsa.topicwise.maths.combinatorics;

/**
 * Problem Description
 * Given three integers A, B, and C, where A represents n, B represents r, and C represents m, find and return the value of nCr % m where nCr % m = (n!/((n-r)!*r!))% m.
 * <p>
 * x! means factorial of x i.e. x! = 1 * 2 * 3... * x.
 * <p>
 * Problem Constraints
 * 1 <= A * B <= 106
 * <p>
 * 1 <= B <= A
 * <p>
 * 1 <= C <= 106
 * <p>
 * <p>
 * <p>
 * Input Format
 * The first argument given is integer A ( = n).
 * The second argument given is integer B ( = r).
 * The third argument given is integer C ( = m).
 * <p>
 * <p>
 * Output Format
 * Return the value of nCr % m.
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
 * The value of 5C2 % 11 is 10.
 * Explanation 2:
 * <p>
 * The value of 6C2 % 13 is 2.
 */
public class ComputeNcRModM {
    public int solve(int A, int B, int C) {
        int n = A, r = B; // not needed - Just for my understanding in NcR wise.
        int[][] c = new int[A + 1][B + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= Math.min(i, r); j++) {
                if (j == 0 || j == i) // Fill 0th col and diagonal elements with 1.
                    c[i][j] = 1;
                else // Else consider the upper and upper left element of the previous row.
                    c[i][j] = c[i - 1][j - 1] + c[i - 1][j];
            }
        }
        return c[n][r] % C;
    }
}
