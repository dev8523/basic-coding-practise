package com.debasish.practise;

import java.util.Scanner;

public class FactorialOfANumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Provide your input: ");
        System.out.println("Factorial : " + fact(scanner.nextInt()));
    }

    private static int fact(int input) {
        if (input < 0) throw new RuntimeException("Input too small!");
        if (input == 0) return 1;
        return input * fact(input - 1);
    }
}
