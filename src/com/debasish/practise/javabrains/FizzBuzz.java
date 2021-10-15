package com.debasish.practise.javabrains;

import java.util.Scanner;

/**
 * @author debasishsahoo
 */
public class FizzBuzz {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Your Input : ");
        findFizzBuzz(scanner.nextInt());
    }

    private static void findFizzBuzz(int input) {
        if (input % 3 == 0 && input % 5 == 0)
            System.out.println("FizzBuzz");
        else if (input % 3 == 0)
            System.out.println("Fizz");
        else if (input % 5 == 0)
            System.out.println("Buzz");
    }
}
