package com.debasish.practise.dsa.topicwise.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Problem Description
 * Given two sorted integer arrays A and B, merge B and A as one sorted array and return it as an output.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * -1010 <= A[i], B[i] <= 1010
 * <p>
 * <p>
 * <p>
 * Input Format
 * First Argument is a 1-D array representing A.
 * <p>
 * Second Argument is also a 1-D array representing B.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return a 1-D vector which you got after merging A and B.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = [4, 7, 9 ]
 * B = [2, 11, 19 ]
 * Input 2:
 * <p>
 * A = [1]
 * B = [2]
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * [2, 4, 7, 9, 11, 19]
 * Output 2:
 * <p>
 * [1, 2]
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * Merging A and B produces the output as described above.
 * Explanation 2:
 * <p>
 * Merging A and B produces the output as described above.
 */
public class MergeTwoSortedArrays {
    public static ArrayList<Integer> solve(final List<Integer> A, final List<Integer> B) {
        int N = A.size();
        int M = B.size();
        int p1 = 0, p2 = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        while (p1 < N && p2 < M) {
            if (A.get(p1) < B.get(p2)) {
                ans.add(A.get(p1));
                p1++;
            } else {
                ans.add(B.get(p2));
                p2++;
            }
        }
        while (p1 < N) {
            ans.add(A.get(p1));
            p1++;
        }
        while (p2 < M) {
            ans.add(B.get(p2));
            p2++;
        }
        return ans;
    }

    public static void main(String[] args) {
        List<Integer> A = Arrays.asList(4, 7, 9);
        List<Integer> B = Arrays.asList(2, 11, 19);
        System.out.println(solve(A, B));
    }
}
