package com.debasish.practise.final450;

import java.util.Arrays;

/**
 * WAP to return minimum and maximum in an array.
 * Your program should make the minimum number of comparisons.
 *
 * @author debasishsahoo
 */
public class FindMinAndMaxOfAnArray {
    public static void main(String[] args) {
        int[] arr = {-1, 3, 0, 11, 1, -9};
        System.out.println("[Min, Max] : " + Arrays.toString(findMin(arr)));
    }

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     *
     * @param arr pass input array
     * @return int[]
     */
    private static int[] findMin(int[] arr) {
        int min = arr[0];
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return new int[]{min, max};
    }
}
