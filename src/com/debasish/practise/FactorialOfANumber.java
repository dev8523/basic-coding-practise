package com.debasish.practise;

import java.util.Scanner;

public class FactorialOfANumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Provide your input: ");
        System.out.println("Factorial : " + fact(scanner.nextInt()));
    }

    private static int fact(int input) {
        if (input == 1) {
            return input;
        }
        return input * fact(input - 1);
    }
}
