package com.debasish.practise.dsa.topicwise.strings;

/**
 * @author debasishsahoo
 * <p>
 * Problem Description
 * <p>
 * Given a string A of size N, find and return the longest palindromic substring's length in A.
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
 * 7
 * <p>
 * Example Explanation
 * <p>
 * We can see that longest palindromic substring is of length 7 and the string is "aaabaaa".
 */
public class LongestPalindromicSubstringLength {
    static int checkPalindromeFromCenter(String str, int l, int r) {
        int lengthOfPalindrome = 0;
        while (l >= 0 && r < str.length() && str.charAt(l) == str.charAt(r)) {
            l--; // go from center towards left
            r++; // go from center towards right
            if (l != r)
                lengthOfPalindrome = lengthOfPalindrome + 2; // if l and r are not same -> It means we are traelling twice(once with l to left and once with r to the right).
            else lengthOfPalindrome++; // if l == r, it means we are at the center.
        }
        return lengthOfPalindrome;
    }

    public String longestPalindrome(String A) {
        int longestPalindromeLength = 0;
        for (int i = 0; i < A.length(); i++) { // For odd palindrome length
            longestPalindromeLength = Math.max(longestPalindromeLength, checkPalindromeFromCenter(A, i, i)); // if palindrome is having odd length, then there will be only 1 center. So passing i 2 times.
        }
        for (int i = 0; i < A.length() - 1; i++) { // For even palindrome length
            longestPalindromeLength = Math.max(longestPalindromeLength, checkPalindromeFromCenter(A, i, i + 1)); // if palindrome is having even length, then there will be 2 centers. So passing middle and middle + 1 as i.
        }
        System.out.print(":: " + longestPalindromeLength);
        return "";
    }
}
