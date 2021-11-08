/**
 * Given a string, check whether the string is Palindrome or not.
 * Palindrome: A string should match from both the sides (forward and backward).
 */
package com.debasish.practise.dsa;

import java.util.stream.IntStream;

/**
 * @author debasishsahoo
 */
public class CheckPalindrome {
    public static void main(String[] args) {
        String inputString = "KayaK";
        if (isPalindromeUsingSimpleForEachLoop(inputString))
            System.out.println("Palindrome");
        else
            System.out.println("Not Palindrome");
    }

    private static boolean isPalindromeUsingSimpleForLoop(String inputString) {
        boolean flag = false;
        for (int i = 0; i < inputString.length(); i++) {
            if (inputString.charAt(i) == inputString.charAt(inputString.length() - i - 1)) {
                flag = true;
            }
        }
        return flag;
    }

    private static boolean isPalindromeUsingSimpleForEachLoop(String inputString) {
        boolean flag = false;
        int counter = 0;
        for (Character ch : inputString.toCharArray()) {
            if (inputString.charAt(counter) == inputString.charAt(inputString.length() - counter - 1)) {
                counter++;
                flag = true;
            }
        }
        return flag;
    }

}
