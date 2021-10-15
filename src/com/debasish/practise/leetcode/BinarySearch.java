/**
 * 704. Binary Search
 *
 * Problem Statement: Given an array of integers nums which is sorted in ascending order, and an integer target,
 * write a function to search target in nums.
 * If target exists, then return its index. Otherwise, return -1.
 */
package com.debasish.practise.leetcode;

/**
 * @author debasishsahoo
 */
public class BinarySearch {

    /* Binary search approach with O(log n) time complexity */
    public static int search(int[] nums, int target) {
        int mid, left = 0, right = nums.length - 1;
        while (left <= right) {
            mid = left + (right - left) / 2;
            System.out.println(" nums" + "[" + mid + "] : " + nums[mid]);
            if (target == nums[mid])
                return mid;
            if (target > nums[mid])
                left = mid + 1;
            if (target < nums[mid])
                right = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int output = search(new int[]{-1, 0, 3, 5, 9, 12}, 5);
        System.out.println("Final Output : " + output);
    }
}
