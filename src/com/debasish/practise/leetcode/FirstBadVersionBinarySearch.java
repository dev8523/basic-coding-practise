package com.debasish.practise.leetcode;

public class FirstBadVersionBinarySearch {

    public static void main(String[] args) {
        System.out.println("Bad version : " + firstBadVersion(5));
    }

    public static int firstBadVersion(int n) {
        int left = 1, right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private static boolean isBadVersion(int version) {
        // This is a leetcode API, hardcoding as true for now.
        return true;
    }
}
