package com.debasish.practise.dsa.topicwise.recursion;

/**
 * @author debasishsahoo
 * <p>
 * Problem Description
 * <p>
 * Implement pow(x, n) % d.
 * In other words, given x, n and d,
 * <p>
 * find (xn % d)
 * <p>
 * Note that remainders on division cannot be negative. In other words, make sure the answer you return is non negative.
 * <p>
 * Input : x = 2, n = 3, d = 3
 * Output : 2
 * <p>
 * 2^3 % 3 = 8 % 3 = 2.
 */
public class PowerFunctionImpl {
    public int pow(int A, int B, int C) {
        if (A == 0) return 0;
        if (B == 0) return 1;
        long x = pow(A, B / 2, C);
        long ASquare = ((x % C) * (x % C)) % C;
        if ((B & 1) != 0) { // If B is odd
            return (int) ((((long) A) * (ASquare) + C) % C);
        } else {
            return (int) (ASquare);
        }
    }
}
