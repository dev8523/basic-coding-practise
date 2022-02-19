package com.debasish.practise.dsa.topicwise.recursion;

/**
 * @author debasishsahoo
 * <p>
 * Problem Description
 * <p>
 * Given a number A, check if it is a magic number or not.
 * <p>
 * A number is said to be a magic number, if the sum of its digits are calculated till a single digit recursively by adding the sum of the digits after every addition. If the single digit comes out to be 1, then the number is a magic number.
 * <p>
 * Example Input
 * <p>
 * Input 1:
 * <p>
 * A = 83557
 * Input 2:
 * <p>
 * A = 1291
 * <p>
 * Example Output
 * <p>
 * Output 1:
 * <p>
 * 1
 * Output 2:
 * <p>
 * 0
 * <p>
 * Example Explanation
 * <p>
 * Explanation 1:
 * <p>
 * Sum of digits of (83557) = 28
 * Sum of digits of (28) = 10
 * Sum of digits of (10) = 1.
 * Single digit is 1, so it's a magic number. Return 1.
 * <p>
 * Explanation 2:
 * <p>
 * Sum of digits of (1291) = 13
 * Sum of digits of (13) = 4
 * Single digit is not 1, so it's not a magic number. Return 0.
 */
public class IsMagicNumber {
    public int solve(int A) {
        int sumOfEachDigit = sum(A);
        while (sumOfEachDigit >= 10) {
            sumOfEachDigit = sumOfEachDigit % 10 + sum(sumOfEachDigit / 10);
        }
        if (sumOfEachDigit == 1) return 1;
        return 0;
    }

    public int sum(int A) {
        if (A < 10) return A;
        return A % 10 + sum(A / 10);
    }
}
