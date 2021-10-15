package com.debasish.practise.javabrains;

import java.util.Scanner;

/**
 * @author debasishsahoo
 */
public class FizzBuzz {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(":: Your Input ::");
        findFizzBuzz(scanner.nextInt());
        System.out.println("\n:: Your Input to check for each number in the input ::");
        printFizzBuzzForEachNumInInput(scanner.nextInt());
    }

    private static void findFizzBuzz(int input) {
        if ((input % 3 == 0) && (input % 5 == 0))
            System.out.println("FizzBuzz");
        else if (input % 3 == 0)
            System.out.println("Fizz");
        else if (input % 5 == 0)
            System.out.println("Buzz");
        else
            System.out.println("Neither a multiple of 3 nor 5 !!");
    }

    private static void printFizzBuzzForEachNumInInput(int input) {
        for (int num = 0; num <= input; num++) {
            if ((num % 3 == 0) && (num % 5 == 0)) {
                System.out.println("FizzBuzz");
            }
            else if (num % 3 == 0) {
                System.out.println("Fizz");
            }
            else if (num % 5 == 0) {
                System.out.println("Buzz");
            }
            else {
                System.out.println(num);
            }
        }
    }
}
