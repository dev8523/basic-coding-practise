package com.debasish.practise.dsa.topicwise.maths.primenumbers;

/**
 * Problem Description
 * Given an even number A ( greater than 2 ), return two prime numbers whose sum will be equal to the given number.
 * <p>
 * If there is more than one solution possible, return the lexicographically smaller solution.
 * <p>
 * If [a, b] is one solution with a <= b, and [c,d] is another solution with c <= d, then
 * [a, b] < [c, d], If a < c OR a==c AND b < d.
 * NOTE: A solution will always exist. Read Goldbach's conjecture.
 * <p>
 * Example Input
 * 4
 * <p>
 * Example Output
 * [2, 2]
 * <p>
 * Example Explanation
 * There is only 1 solution for A = 4.
 */
public class PrimeSumUsingSieveOfEratosthenesAlgo {
    public int[] primesum(int A) {
        int first = 0, second = 0;
        for (int i = 1; i <= A; i++) {
            int otherNum = A - i;
            if (isPrimeUsingSieveOfEratosthenes(i) && isPrimeUsingSieveOfEratosthenes(otherNum)) {
                first = i;
                second = otherNum;
                break;
            }
        }
        return new int[]{first, second};
    }

    /**
     * Check prime using SieveOfEratosthenes algo
     */
    public boolean isPrimeUsingSieveOfEratosthenes(int num) {
        if (num < 2) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
