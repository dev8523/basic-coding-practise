/**
 * OpenText Interview question (Coding Test)
 * Description: If the given input has the character 't' and it contains the number, we should display the output as mentioned below.
 *
 * Example:
 * Given Input: thang14, Output: thang14 (5)
 * Given Input: rag13, Output: none
 * Given Input: 4bat32 are rat45, Output: bat32 (9), none, rat45 (9)
 */
package com.debasish.practise;

/**
 * @author debasishsahoo
 */
public class SumOfNumsInCharArrayIfTExists {

    public static void main(String[] args) {
        solution("hantg3442");
    }

    private static void solution(String inputStr) {
        char[] ch = inputStr.toCharArray();
        int temp = 0;
        boolean flag = false;
        for (char c : ch) {
            if (c == 't') {
                flag = true;
                break;
            }
        }
        if (flag) {
            for (char c : ch) {
                if (Character.isDigit(c)) {
                    int a = c - '0';
                    temp += a;
                }
            }
            System.out.println(inputStr + " (" + temp + ")");
        } else {
            System.out.println("none");
        }
    }
}
