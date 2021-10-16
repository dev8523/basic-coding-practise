/**
 * Given an array (or string), the task is to reverse the array/string.
 */
package com.debasish.practise.javabrains;

/**
 * @author debasishsahoo
 */
public class ReverseString {

    public static void main(String[] args) {
        String str = "Hello World!";
        System.out.println(reverseWithStringBuilder(str));
        System.out.println(reverseManually(str));
    }

    /**
     * Reverse each character of the string manually by storing it in another string as Strings are immutable.
     *
     * @param str input string
     * @return String - returns the reverse string
     */
    private static String reverseManually(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }

    /**
     * Reverse using out of the box API from StringBuilder.
     *
     * @param str input string
     * @return String - returns the reverse string
     */
    private static String reverseWithStringBuilder(String str) {
        return new StringBuilder(str).reverse().toString();
    }


}
