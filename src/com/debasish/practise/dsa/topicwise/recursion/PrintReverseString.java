package com.debasish.practise.dsa.topicwise.recursion;

import java.util.Scanner;

/**
 * @author debasishsahoo
 * <p>
 * Problem Description
 * <p>
 * Write a recursive function that, given a string S, prints the characters of S in reverse order.
 */
public class PrintReverseString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inputStr = sc.next();
        System.out.println(recursiveString(inputStr));
    }

    public static String recursiveString(String str) {
        if (str == null || str.length() <= 1) return str;
        return recursiveString(str.substring(1)) + str.charAt(0);
    }
}
