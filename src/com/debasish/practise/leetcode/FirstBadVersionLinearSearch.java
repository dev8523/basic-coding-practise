/**
 * 278. First Bad Version
 *
 * You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.
 *
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.
 *
 * You are given an API bool isBadVersion(version) which returns whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.
 */
package com.debasish.practise.leetcode;

/**
 * @author debasishsahoo
 */
public class FirstBadVersionLinearSearch {

    public static void main(String[] args) {
        System.out.println("Bad version : " + firstBadVersion(5));
    }

    public static int firstBadVersion(int n) {
        for(int i = 0; i < n; i++) {
            if (isBadVersion(i)) {
                return i;
            }
        }
        return n;
    }

    private static boolean isBadVersion(int version) {
        // This is a leetcode API, hardcoding as true for now.
        return true;
    }
}
