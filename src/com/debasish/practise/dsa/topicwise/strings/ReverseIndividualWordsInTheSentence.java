package com.debasish.practise.dsa.topicwise.strings;

/**
 * @author debasishsahoo
 * <p>
 * Problem Description
 * <p>
 * Given a string A of size N.
 * <p>
 * Return the string A after reversing the string word by word.
 * <p>
 * NOTE:
 * <p>
 * A sequence of non-space characters constitutes a word.
 * Your reversed string should not contain leading or trailing spaces, even if it is present in the input string.
 * If there are multiple spaces between words, reduce them to a single space in the reversed string.
 * <p>
 * Input Format
 * <p>
 * The only argument given is string A.
 * <p>
 * Output Format
 * <p>
 * Return the string A after reversing the string word by word.
 * <p>
 * Example Input
 * <p>
 * Input 1:
 * A = "the sky is blue"
 * Input 2:
 * A = "this is ib"
 * <p>
 * Example Output
 * <p>
 * Output 1:
 * "blue is sky the"
 * Output 2:
 * "ib is this"
 */
public class ReverseIndividualWordsInTheSentence {
    static String reverse(String A, int l, int r) {
        // using swap
        char[] tmpArray = A.toCharArray();
        int left = l;
        int right = r;
        while (left <= right) {
            char temp = tmpArray[left];
            tmpArray[left] = tmpArray[right];
            tmpArray[right] = temp;
            left++;
            right--;
        }
        return new String(tmpArray);
    }

    public String solve(String A) {
        int l = 0;
        int r = A.length() - 1;
        // 1. Reverse the whole string
        String reverseStr = "";
        reverseStr = reverse(A, l, r);

        // 2. Reverse individual words
        for (int i = 0; i < reverseStr.length(); i++) {
            if (reverseStr.charAt(i) == ' ') {
                r = i - 1; // ending of each word
                reverseStr = reverse(reverseStr, l, r);
                l = i + 1; // starting of each next word
            }
        }
        reverseStr = reverse(reverseStr, l, A.length() - 1);
        return reverseStr.trim();
    }
}
