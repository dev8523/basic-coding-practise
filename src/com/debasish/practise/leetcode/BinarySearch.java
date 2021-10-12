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
        int index = 0, left = 0, right = nums.length - 1;
        while (left <= right) {
            index = left + (right - left) / 2;
            System.out.println(" nums" + "[" + index + "] : " + nums[index]);
            if (target == nums[index])
                return index;
            if (target > nums[index])
                left = index + 1;
            if (target < nums[index])
                right = index - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int output = search(new int[]{-1, 0, 3, 5, 9, 12}, 12);
        System.out.println("Final Output : " + output);
    }
}
