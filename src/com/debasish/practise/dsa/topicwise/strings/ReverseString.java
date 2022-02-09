package com.debasish.practise.dsa.topicwise.strings;

public class ReverseString {
    public String solve(String A) {
        String reverse = "";
        for (int i = A.length() - 1; i >= 0; i--) {
            reverse += A.charAt(i);
        }
        return reverse;
    }
}
