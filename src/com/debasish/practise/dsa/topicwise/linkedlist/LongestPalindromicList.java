package com.debasish.practise.dsa.topicwise.linkedlist;

/**
 * Problem Description
 * Given a linked list of integers. Find and return the length of the longest palindrome list that exists in that linked list.
 * <p>
 * A palindrome list is a list that reads the same backward and forward.
 * <p>
 * Expected memory complexity : O(1)
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= length of the linked list <= 2000
 * <p>
 * 1 <= Node value <= 100
 * <p>
 * <p>
 * <p>
 * Input Format
 * The only argument given is head pointer of the linked list.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return the length of the longest palindrome list.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * 2 -> 3 -> 3 -> 3
 * Input 2:
 * <p>
 * 2 -> 1 -> 2 -> 1 ->  2 -> 2 -> 1 -> 3 -> 2 -> 2
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * 3
 * Output 2:
 * <p>
 * 5
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * 3 -> 3 -> 3 is largest palindromic sublist
 * Explanation 2:
 * <p>
 * 2 -> 1 -> 2 -> 1 -> 2 is largest palindromic sublist.
 */
public class LongestPalindromicList {
    private static int findLengthOfLL(ListNode A, ListNode B) {
        int length = 0;
        while (A != null && B != null) {
            if (A.data != B.data) break;
            length++;
            A = A.next;
            B = B.next;
        }
        return length;
    }

    // TC: O(N ^ 2), SC: O(1)
    public int lengthOfLongestPalindromicSubList(ListNode A) {
        if (A.next == null) return 1;
        ListNode cur = A, prev = null;
        int lengthOfPalinSubList = 0;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            // For even length
            lengthOfPalinSubList = Math.max(lengthOfPalinSubList, 2 * findLengthOfLL(cur, next));
            // For odd length
            lengthOfPalinSubList = Math.max(lengthOfPalinSubList, 2 * findLengthOfLL(prev, next) + 1);
            prev = cur;
            cur = next;
        }
        return lengthOfPalinSubList;
    }
}
