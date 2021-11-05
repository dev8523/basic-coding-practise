/**
 * URLify: Write a method to replace all spaces in a string with '%20'.
 * You may assume that the string has sufficient space at the end to hold the additional characters,
 * and that you are given the "true" length of the string. (Note: if implementing in Java,
 * please use a character array so that you can perform this operation in place.)
 * <p>
 * EXAMPLE:
 * Input: "Mr John Smith ", 13
 * Output: "Mr%20John%20Smith"
 */
package com.debasish.practise.dsa;

/**
 * @author debasishsahoo
 */
public class URLify {

    public static void main(String[] args) {
        String inputStr = "Mr-John-Smith----";
        int lengthOfInputStr = 13;
        System.out.println("Solution1 : " + urlifyUsingStringBuilder(inputStr, lengthOfInputStr));
        System.out.println("Solution2 : " + urlifyWithCharArray(inputStr, lengthOfInputStr));
    }

    private static String urlifyUsingStringBuilder(String inputString, int lengthOfInputStr) {
        StringBuilder sb = new StringBuilder();
        int sbLength = 0;
        for (char c : inputString.toCharArray()) {
            if (c == '-') {
                sb.append("%20");
            } else {
                sb.append(c);
            }
            sbLength++;
            if (sbLength >= lengthOfInputStr) {
                break;
            }
        }
        return sb.toString();
    }

    private static String urlifyWithCharArray(String inputString, int lengthOfInputStr) {
        int spaces = 0;
        for (char c : inputString.toCharArray()) {
            if (c == '-') {
                spaces++;
            }
        }
        char[] outputArray = new char[lengthOfInputStr + spaces * 2];
        int index = 0;
        int currentLength = 0;
        for (char c : inputString.toCharArray()) {
            if (c == '-') {
                outputArray[index++] = '%';
                outputArray[index++] = '2';
                outputArray[index++] = '0';
            } else {
                outputArray[index++] = c;
            }
            currentLength++;
            if (currentLength >= lengthOfInputStr) {
                break;
            }
        }
        return String.valueOf(outputArray).substring(0, index);
    }
}
