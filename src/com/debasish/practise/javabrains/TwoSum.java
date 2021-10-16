/**
 * 1. Two Sum
 * <p>
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * <p>
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * <p>
 * You can return the answer in any order.
 */
package com.debasish.practise.javabrains;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author debasishsahoo
 */
public class TwoSum {

    public static void main(String[] args) throws Exception {
        int[] numbers = {-2, 3, -7, 15, 0};
        int target = -9;
        System.out.println(Arrays.toString(solveTwoSumByBruteForceApproach(numbers, target)));
        System.out.println(Arrays.toString(solveTwoSumByUsingMap(numbers, target)));
    }

    /**
     * This will have O(n) time complexity which is a good approach to use Map data structure.
     *
     * @param numbers input array
     * @param target  target element
     * @return int[] returns the indices of the two numbers
     * @throws Exception
     */
    private static int[] solveTwoSumByUsingMap(int[] numbers, int target) throws Exception {
        Map<Integer, Integer> visitedNumbers = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int delta = target - numbers[i];
            if (visitedNumbers.containsKey(delta)) {
                return new int[]{i, visitedNumbers.get(delta)};
            }
            visitedNumbers.put(numbers[i], i);
        }
        throw new Exception("404 Not Found");
    }

    /**
     * This will have O(n)^2 time complexity which is not a good approach to use brute force mechanism.
     *
     * @param numbers input array
     * @param target  target element
     * @return int[] returns the indices of the two numbers
     * @throws Exception
     */
    private static int[] solveTwoSumByBruteForceApproach(int[] numbers, int target) throws Exception {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        throw new Exception("404 Not Found");
    }

}