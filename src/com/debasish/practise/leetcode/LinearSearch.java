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
public class LinearSearch {

    /*Linear search approach with O(n) time complexity*/
    public static int search(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            System.out.println(" nums" + "[" + i + "] : " + nums[i]);
            if (nums[i] == target)
                return i;
        }
        System.out.println("target : " + target);
        return -1;
    }

    public static void main(String[] args) {
        int output = search(new int[]{-1, 0, 3, 5, 9, 12}, 12);
        System.out.println("Final Output : " + output);
    }
}
