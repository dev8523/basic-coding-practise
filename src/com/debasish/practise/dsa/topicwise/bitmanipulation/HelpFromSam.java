package com.debasish.practise.dsa.topicwise.bitmanipulation;

/**
 * Alex and Sam are very good friends. Alex is doing programming a lot these days. He has set a target A for himself. Initially, Alex score is zero. Alex can only double his score by doing a question or Alex can seek help from Sam for doing questions which will contribute 1 to Alex score. Alex wants his score to be exactly A. Also, he does not want to take much help from Sam.
 * <p>
 * Find and return the minimum number of times Alex needs to take help from Sam to achieve a score of exactly A.
 * <p>
 * Input Format
 * <p>
 * The only argument given is integer A.
 * <p>
 * Output Format
 * <p>
 * Return the minimum number of times help taken from Sam.
 * <p>
 * Input 1:
 * A = 5
 * <p>
 * Output 1:
 * 2
 * Initial score : 0
 * Takes help from Sam, score : 1
 * Alex solves a question, score : 2
 * Alex solves a question, score : 4
 * Takes help from Sam, score: 5
 * <p>
 * Input 2:
 * A = 3
 * <p>
 * Output 2:
 * 2
 * Initial score : 0
 * Takes help from Sam, score : 1
 * Alex solves a question, score : 2
 * Takes help from Sam, score : 3
 */
public class HelpFromSam {
    public int solve(int A) {
        int countOfUnsetBits = 0;
        while (A > 0) {
            if (A % 2 == 1) {
                countOfUnsetBits++;
            }
            A /= 2;
        }
        return countOfUnsetBits;
    }
}
