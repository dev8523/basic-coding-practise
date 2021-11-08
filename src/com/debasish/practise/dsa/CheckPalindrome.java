/**
 * Given a string, check whether the string is Palindrome or not.
 * Palindrome: A string should match from both the sides (forward and backward).
 */
package com.debasish.practise.dsa;

/**
 * @author debasishsahoo
 */
public class CheckPalindrome {
    public static void main(String[] args) {
        String inputString = "kayaK";
        isPalindrome(inputString);
    }

    private static void isPalindrome(String inputString) {
        boolean flag = false;
        for (int i = 0; i < inputString.length(); i++) {
            if (inputString.charAt(i) == inputString.charAt(inputString.length() - i - 1)) {
                flag = true;
            }
        }
        if (flag) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Not Palindrome");
        }
    }

}
