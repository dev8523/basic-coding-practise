package com.debasish.practise.dsa.topicwise.strings;

public class ReverseString {
    public String solve(String A) {
        String reverse = "";
        for (int i = A.length() - 1; i >= 0; i--) {
            reverse += A.charAt(i);
        }
        return reverse;
    }

    /**
     * Using swap we are only swapping for n/2 times with an extra space.
     */
    public String usingSwap(String A) {
        // using swap
        char[] tmpArray = A.toCharArray();
        int left = 0;
        int right = A.length() - 1;
        while (left <= right) {
            char temp = tmpArray[left];
            tmpArray[left] = tmpArray[right];
            tmpArray[right] = temp;
            left++;
            right--;
        }
        return new String(tmpArray);
    }
}
