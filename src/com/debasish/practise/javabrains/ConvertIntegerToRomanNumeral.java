/**
 * Convert the given integer to roman numeral. Given integer range will be in between 0 to 4k.
 */
package com.debasish.practise.javabrains;

import java.util.Scanner;

/**
 * @author debasishsahoo
 */
public class ConvertIntegerToRomanNumeral {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input (0 < input < 4k): ");
        int num = scanner.nextInt();
        System.out.println("Roman numeral for " + num + " : " + intToRoman(num));
        scanner.close();
    }

    private static String intToRoman(int num) {
        String[] units = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"}; // "", 0, 1, 2, ..., 9
        String[] tens = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"}; // "", 10, 20, 30, ..., 90
        String[] hundreds = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"}; // "", 100, 200, 300, ..., 900
        String[] thousands = {"", "M", "MM", "MMM"}; // "", 1000, 2000, 3000, 4000

        if (num < 4000)
            return thousands[num / 1000] +
                    hundreds[(num % 1000) / 100] +
                    tens[(num % 100) / 10] +
                    units[(num % 10)];
        else
            throw new RuntimeException("Given input is not in range of the algorithm!! Try any input from 0 to 3999.");
    }
}
