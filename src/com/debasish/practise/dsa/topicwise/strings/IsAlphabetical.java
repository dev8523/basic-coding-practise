package com.debasish.practise.dsa.topicwise.strings;

/**
 * @author debasishsahoo
 * <p>
 * Problem Description
 * <p>
 * You are given a function isalpha() consisting of a character array A.
 * <p>
 * Return 1 if all the characters of the character array are alphabetical (a-z and A-Z), else return 0.
 */
public class IsAlphabetical {
    public int solve(char[] A) {
        for (int i = 0; i < A.length; i++) {
            if (!((A[i] >= 'a' && A[i] <= 'z') || (A[i] >= 'A' && A[i] <= 'Z'))) return 0;
        }
        return 1;
    }
}
