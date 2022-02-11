package com.debasish.practise.dsa.topicwise.strings;

/**
 * @author debasishsahoo
 * <p>
 * Problem Description
 * <p>
 * You are given a function to_lower() consisting of a character array A.
 * <p>
 * Convert each charater of A into lowercase character if it exists. If the lowercase of a character does not exist, it remains unmodified.
 * The uppercase letters from A to Z is converted to lowercase letters from a to z respectively.
 * <p>
 * Return the lowercase version of the given character array.
 */
public class CovertStringToLowerCase {
    public char[] to_lower(char[] A) {
        for (int i = 0; i < A.length; i++) {
            if (A[i] >= 'A' && A[i] <= 'Z') A[i] = (char) (A[i] + 32);
        }
        return A;
    }
}
