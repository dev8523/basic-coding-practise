/**
 * Given an array arr[] and an integer K where K is smaller than size of array,
 * the task is to find the Kth smallest element in the given array.
 * It is given that all array elements are distinct.
 */
package com.debasish.practise.final450;

import java.util.Arrays;

/**
 * @author debasishsahoo
 */
public class FindKthSmallestElementFromArray {
    public static void main(String[] args) {
        int[] arr = {7, 10, 4, 2, 20, 15};
        int k = 3, l = arr[0], r = arr[arr.length - 1];
        System.out.println("Kth smallest element : " + findKthSmallest(arr, l, r, k));
    }

    /**
     * Sort the array then find the element by doing search number minus 1.
     *
     * @param arr the given input array
     * @param l   the minimum element to set.
     * @param r   the maximum element to set.
     * @param k   the kth element to find.
     * @return the minimum element.
     */
    private static int findKthSmallest(int[] arr, int l, int r, int k) {
        Arrays.sort(arr);
        return (arr[k - 1]);
    }
}
