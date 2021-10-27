package com.debasish.practise.javabrains;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ConvertRomanNumeralToIntegerValue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Roman Numeral Input : ");
        String romanInput = scanner.next();
        System.out.println("Integer value for '" + romanInput + "' : " + romanToInt(romanInput));
        scanner.close();
    }

    private static int romanToInt(String romanInputString) {
        Map<Character, Integer> romanWithIntValueMap = new HashMap<>();
        romanWithIntValueMap.put('I', 1);
        romanWithIntValueMap.put('V', 5);
        romanWithIntValueMap.put('X', 10);
        romanWithIntValueMap.put('L', 50);
        romanWithIntValueMap.put('C', 100);
        romanWithIntValueMap.put('D', 500);
        romanWithIntValueMap.put('M', 1000);

        int result = 0;
        for (int i = 0; i < romanInputString.length(); i++) {
            /* Check if the previous number that we found is less than the current number then subtract the number from the current number
            else add the numbers to the result. */
            if (i > 0 && romanWithIntValueMap.get(romanInputString.charAt(i)) > romanWithIntValueMap.get(romanInputString.charAt(i - 1))) {
                result += romanWithIntValueMap.get(romanInputString.charAt(i)) - 2 * romanWithIntValueMap.get(romanInputString.charAt(i - 1));
            } else {
                result += romanWithIntValueMap.get(romanInputString.charAt(i));
            }
        }
        return result;
    }
}
