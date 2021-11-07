/**
 * String Compression: Implement a method to perform basic string compression using the counts of repeated characters.
 * For example, the string aabcccccaaa would become a2blc5a3.
 * If the "compressed" string would not become smaller than the original string, your method should return
 * the original string. You can assume the string has only uppercase and lowercase letters (a - z).
 */
package com.debasish.practise.dsa;

public class StringCompression {
    public static void main(String[] args) {
        String inputCharString = "aabcccccaaabbb";
        System.out.println(findCharCountAsYouGo(inputCharString));
    }

    private static String findCharCountAsYouGo(String inputCharString) {
        char[] inputStringArr = inputCharString.toCharArray();
        StringBuilder sb = new StringBuilder();
        char currentChar = inputStringArr[0];
        int charCount = 1;
        for (int i = 1; i < inputStringArr.length; i++) {
            if (inputStringArr[i] != currentChar) {
                sb.append(currentChar);
                sb.append(charCount);
                charCount = 1;
                currentChar = inputStringArr[i];
            } else {
                charCount++;
            }
        }
        sb.append(currentChar);
        sb.append(charCount);
        return sb.toString();
    }
}
