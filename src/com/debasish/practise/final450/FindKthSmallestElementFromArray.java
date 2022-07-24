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
        int k = 4, l = arr[0], r = arr[arr.length - 1];
        System.out.println("Kth smallest element without using inbuilt sorting method : " + findKthSmallestWithoutUsingInbuiltSorting(arr, l, r, k));
        System.out.println("Kth smallest element : " + findKthSmallest(arr, l, r, k));
        System.out.println("Kth largest element : " + findKthLargest(arr, l, r, k));
    }

    /**
     * Do not use any inbuilt sorting method.
     */
    private static int findKthSmallestWithoutUsingInbuiltSorting(int[] arr, int l, int r, int k) {
        for (int i = 0; i < k; i++) {
            int minn = Integer.MAX_VALUE, idx = 0;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < minn) {
                    minn = arr[j];
                    idx = j;
                }
            }
            int tmp = arr[i];
            arr[i] = arr[idx];
            arr[idx] = tmp;
        }
        return arr[k - 1];
    }

    /**
     * Sort the array then find the element by doing search number minus 1.
     *
     * @param arr the given input array
     * @param l   the minimum element to set.
     * @param r   the maximum element to set.
     * @param k   the kth element to find.
     * @return the kth largest element.
     */
    private static int findKthLargest(int[] arr, int l, int r, int k) {
        Arrays.sort(arr);
        return arr[k];
    }

    /**
     * Sort the array then find the element by doing search number minus 1.
     *
     * @param arr the given input array
     * @param l   the minimum element to set.
     * @param r   the maximum element to set.
     * @param k   the kth element to find.
     * @return the kth minimum element.
     */
    private static int findKthSmallest(int[] arr, int l, int r, int k) {
        /*Arrays.sort(arr);
        return (arr[k - 1]);*/

        /* OR */

        return Arrays.stream(arr)
                .sorted()
                .limit(k)
                .skip(k - 1)
                .findFirst()
                .getAsInt();
    }
}
