package com.debasish.practise.dsa.topicwise.recursion;

/**
 * @author debasishsahoo
 * <p>
 * Problem Description
 * <p>
 * Write a recursive function that checks whether a string A is a palindrome or Not.
 * Return 1 if the string A is palindrome, else return 0.
 * <p>
 * Note: A palindrome is a string that's the same when reads forwards and backwards.
 * <p>
 * Input 1:
 * <p>
 * A = "naman"
 * Input 2:
 * <p>
 * A = "strings"
 * <p>
 * Example Output
 * <p>
 * Output 1:
 * <p>
 * 1
 * Output 2:
 * <p>
 * 0
 * <p>
 * Example Explanation
 * <p>
 * Explanation 1:
 * <p>
 * "naman" is a palindomic string, so return 1.
 * Explanation 2:
 * <p>
 * "strings" is not a palindrome, so return 0.
 */
public class CheckPalindrome {
    static boolean isPalindrome(String str, int s, int e) {
        if (s >= e) return true;
        if (str.charAt(s) == str.charAt(e)) return isPalindrome(str, s + 1, e - 1);
        else return false;
    }

    public int solve(String A) {
        if (A.length() == 0) return 1;
        boolean flag = isPalindrome(A, 0, A.length() - 1);
        if (flag) return 1;
        return 0;
    }
}
