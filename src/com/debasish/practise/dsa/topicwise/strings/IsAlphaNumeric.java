package com.debasish.practise.dsa.topicwise.strings;

/**
 * @author debasishsahoo
 * <p>
 * Problem Description
 * <p>
 * You are given a function isalpha() consisting of a character array A.
 * <p>
 * Return 1 if all the characters of a character array are alphanumeric (a-z, A-Z and 0-9), else return 0.
 */
public class IsAlphaNumeric {
    public int solve(char[] A) {
        for (int i = 0; i < A.length; i++) {
            if (!((A[i] >= 'a' && A[i] <= 'z') || (A[i] >= 'A' && A[i] <= 'Z') || (A[i] >= '0' && A[i] <= '9')))
                return 0;
        }
        return 1;
    }
}
