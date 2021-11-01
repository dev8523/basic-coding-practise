package com.debasish.practise.final450;

import java.util.Arrays;

public class FindKthSmallestElementFromArray {
    public static void main(String[] args) {
        int[] arr = {7, 10, 4, 2, 20, 15};
        int k = 3, l = arr[0], r = arr[arr.length - 1];
        System.out.println("Kth smallest element : " + findKthSmallest(arr, l, r, k));
    }

    private static int findKthSmallest(int[] arr, int l, int r, int k) {
        Arrays.sort(arr);
        return (arr[k - 1]);
    }
}
