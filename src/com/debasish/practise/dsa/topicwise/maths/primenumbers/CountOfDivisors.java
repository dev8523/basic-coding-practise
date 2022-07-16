package com.debasish.practise.dsa.topicwise.maths.primenumbers;

/**
 * Problem Description
 * Given an array of integers A, find and return the count of divisors of each element of the array.
 * <p>
 * NOTE: The order of the resultant array should be the same as the input array.
 * <p>
 * Problem Constraints
 * 1 <= length of the array <= 100000
 * 1 <= A[i] <= 106
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = [2, 3, 4, 5]
 * Input 2:
 * <p>
 * A = [8, 9, 10]
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * [2, 2, 3, 2]
 * Output 1:
 * <p>
 * [4, 3, 4]
 */
public class CountOfDivisors {
    public int[] solve(int[] A) {
        int[] spf = generateSpfArray(100000); // Given the
        for (int i = 0; i < A.length; i++) {
            int count = 1;
            int temp = A[i];
            while (temp != 1) {
                int countOfDiv = 1;
                int smallestPrime = spf[temp];
                while (temp % smallestPrime == 0) {
                    temp = temp / smallestPrime;
                    countOfDiv++;
                }
                count = count * countOfDiv;
            }
            A[i] = count;
        }
        return A;
    }

    private int[] generateSpfArray(int n) {
        int[] spf = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            spf[i] = i;
        }
        for (int i = 2; i * i <= n; i++) {
            if (spf[i] == i) {
                for (int j = i; j <= n; j += i) {
                    if (spf[j] == j) spf[j] = i;
                }
            }
        }
        return spf;
    }
}
