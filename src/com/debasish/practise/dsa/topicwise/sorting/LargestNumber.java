package com.debasish.practise.dsa.topicwise.sorting;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Problem Description
 * Given an array A of non-negative integers, arrange them such that they form the largest number.
 * <p>
 * Note: The result may be very large, so you need to return a string instead of an integer.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= len(A) <= 100000
 * 0 <= A[i] <= 2*109
 * <p>
 * <p>
 * <p>
 * Input Format
 * The first argument is an array of integers.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return a string representing the largest number.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = [3, 30, 34, 5, 9]
 * Input 2:
 * <p>
 * A = [2, 3, 9, 0]
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * "9534330"
 * Output 2:
 * <p>
 * "9320"
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * Reorder the numbers to [9, 5, 34, 3, 30] to form the largest number.
 * Explanation 2:
 * <p>
 * Reorder the numbers to [9, 3, 2, 0] to form the largest number 9320.
 */
public class LargestNumber {

    /**
     * Define own custom comparator. TC: O(N * logN), SC: O(N)
     */
    public static String largestNumber(final int[] A) {
        String result = "";
        List<String> listOfNum = new ArrayList<>();
        for (int i : A) {
            listOfNum.add(String.valueOf(i));
        }
        listOfNum.sort(new Comparator<String>() {
            @Override
            public int compare(String X, String Y) {

                // first append Y at the end of X
                String XY = X + Y;

                // then append X at the end of Y
                String YX = Y + X;

                // Now see which of the two
                // formed numbers
                // is greater
                return XY.compareTo(YX) > 0 ? -1 : 1;
            }
        });

        // for (String s : listOfNum) System.out.print(s);
        for (int i = 0; i < listOfNum.size(); i++) {
            result += listOfNum.get(i);
        }
        int pos = 0;
        while (result.charAt(pos) == '0' && pos + 1 < result.length()) pos++;
        return result.substring(pos);
    }

    public static void main(String[] args) {
        int[] A = new int[]{3, 30, 34, 5, 9};
        System.out.println(largestNumber(A));
    }
}
