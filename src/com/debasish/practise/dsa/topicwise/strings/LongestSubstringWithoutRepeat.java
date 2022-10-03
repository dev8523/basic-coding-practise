package com.debasish.practise.dsa.topicwise.strings;

/**
 * Problem Description
 * Given a string A, find the length of the longest substring without repeating characters.
 *
 * Note: Users are expected to solve in O(N) time complexity.
 *
 *
 *
 * Problem Constraints
 * 1 <= size(A) <= 106
 *
 * String consists of lowerCase,upperCase characters and digits are also present in the string A.
 *
 *
 *
 * Input Format
 * Single Argument representing string A.
 *
 *
 *
 * Output Format
 * Return an integer denoting the maximum possible length of substring without repeating characters.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = "abcabcbb"
 * Input 2:
 *
 *  A = "AaaA"
 *
 *
 * Example Output
 * Output 1:
 *
 *  3
 * Output 2:
 *
 *  2
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  Substring "abc" is the longest substring without repeating characters in string A.
 * Explanation 2:
 *
 *  Substring "Aa" or "aA" is the longest substring without repeating characters in string A.
 */
public class LongestSubstringWithoutRepeat {
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }

    /**
     * Algorithm:
     * <p>
     * Initialise left = 0 and right = 0.
     * Initialise a HashSet to store the characters of the current window.
     * Slide the index right toward N and if it is not present in the current HashSet, slide it further.
     * Till this point, we have the maximum non repeating substring length.
     * If a character is  found, which is present in the current window, remove the character from the current window and slide further.
     */
    public static int lengthOfLongestSubstring(String s) {
        int[] chars = new int[128];

        int left = 0;
        int right = 0;

        int res = 0;
        while (right < s.length()) {
            char r = s.charAt(right);
            chars[r]++;

            while (chars[r] > 1) {
                char l = s.charAt(left);
                chars[l]--;
                left++;
            }

            res = Math.max(res, right - left + 1);

            right++;
        }
        return res;
    }
}
