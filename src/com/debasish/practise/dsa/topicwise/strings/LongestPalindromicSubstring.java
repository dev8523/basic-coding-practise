package com.debasish.practise.dsa.topicwise.strings;

/**
 * @author debasishsahoo
 * <p>
 * Problem Description
 * <p>
 * Given a string A of size N, find and return the longest palindromic substring in A.
 * <p>
 * Substring of string A is A[i...j] where 0 <= i <= j < len(A)
 * <p>
 * Palindrome string:
 * A string which reads the same backwards. More formally, A is palindrome if reverse(A) = A.
 * <p>
 * Incase of conflict, return the substring which occurs first ( with the least starting index).
 * <p>
 * Example Input
 * <p>
 * A = "aaaabaaa"
 * <p>
 * <p>
 * Example Output
 * <p>
 * "aaabaaa"
 * <p>
 * Example Explanation
 * <p>
 * We can see that longest palindromic substring is of length 7 and the string is "aaabaaa".
 */
public class LongestPalindromicSubstring {
    static String checkPalindromeFromCenter(String str, int l, int r) {
        while (l >= 0 && r < str.length() && str.charAt(l) == str.charAt(r)) {
            l--; // go from center towards left
            r++; // go from center towards right
        }
        return str.substring(l + 1, r);
    }

    public String longestPalindrome(String A) {
        if (A.length() == 0) return "";
        String longestPalindromeSubString = A.substring(0, 1); // A single character itself is a palindrome.
        for (int i = 0; i < A.length(); i++) {
            String p1 = checkPalindromeFromCenter(A, i, i); // if palindrome is having odd length, then there will be only 1 center. So passing i 2 times.
            if (p1.length() > longestPalindromeSubString.length()) longestPalindromeSubString = p1;
            String p2 = checkPalindromeFromCenter(A, i, i + 1); // if palindrome is having even length, then there will be 2 centers. So passing middle and middle + 1 as i.
            if (p2.length() > longestPalindromeSubString.length()) longestPalindromeSubString = p2;
        }
        return longestPalindromeSubString;
    }
}
