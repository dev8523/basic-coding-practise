package com.debasish.practise.javabrains;

/**
 * @author debasishsahoo
 */
public class ReverseInteger {

    public static void main(String[] args) {
        System.out.println(reverseInteger(539901123));
    }

    private static int reverseInteger(int input) {
        int reverse = 0;
        while (input != 0) {
            reverse = reverse * 10 + input % 10;
            input /= 10;
        }
        return reverse;
    }
}
