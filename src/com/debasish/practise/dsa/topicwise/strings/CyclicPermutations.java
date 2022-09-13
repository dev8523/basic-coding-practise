package com.debasish.practise.dsa.topicwise.strings;

/**
 * Count of cyclic permutations having XOR with other binary string as 0.
 * <p>
 * Problem Description
 * Given two binary strings A and B, count how many cyclic shift of B when taken XOR with A give 0.
 * <p>
 * NOTE: If there is a string, S0, S1, ... Sn-1 , then it is a cyclic shift is of the form Sk, Sk+1, ... Sn-1, S0, S1, ... Sk-1 where k can be any integer from 0 to N-1.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 1 ≤ length(A) = length(B) ≤ 105
 * <p>
 * <p>
 * <p>
 * Input Format
 * The first argument is a string A.
 * The second argument is a string B.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return an integer denoting the required answer.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = "1001"
 * B = "0011"
 * Input 2:
 * <p>
 * A = "111"
 * B = "111"
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * 1
 * Output 2:
 * <p>
 * 3
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * 4 cyclic shifts of B exists: "0011", "0110", "1100", "1001".
 * There is only one cyclic shift of B i.e. "1001" which has 0 xor with A.
 * Explanation 2:
 * <p>
 * All cyclic shifts of B are same as A and give 0 when taken xor with A. So, the ans is 3.
 */
public class CyclicPermutations {
    /**
     * Implementation of Z-algorithm for linear time pattern searching
     * <p>
     * Time Complexity : O(|a+b|) ,where |a+b| is size of string(a+b).
     * Space Complexity : O(|a+b|)
     */
    static void compute_z(String s, int[] z) {
        int l = 0, r = 0;
        int n = s.length();
        for (int i = 1; i <= n - 1; i++) {
            if (i > r) {
                l = i;
                r = i;
                while (r < n && s.charAt(r - l) == s.charAt(r))
                    r++;
                z[i] = r - l;
                r--;
            } else {
                int k = i - l;
                if (z[k] < r - i + 1) {
                    z[i] = z[k];
                } else {
                    l = i;
                    while (r < n && s.charAt(r - l) == s.charAt(r))
                        r++;
                    z[i] = r - l;
                    r--;
                }
            }
        }
    }

    /**
     * Function to get the count of the cyclic permutations of b that given 0 when XORed with a
     */
    static int countPermutation(String A, String B) {
        // concatenate b with b
        B = B + B;
        // new b now contains all the cyclic
        // permutations of old b as it's sub-strings
        B = B.substring(0, B.length() - 1);

        // concatenate pattern with text
        int ans = 0;
        String s = A + "$" + B;
        int n = s.length();

        // Fill z array used in Z algorithm
        int[] z = new int[n];
        compute_z(s, z);

        for (int i = 1; i <= n - 1; i++) {

            // pattern occurs at index i since
            // z value of i equals pattern length
            if (z[i] == A.length())
                ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        String a = "101";
        String b = "101";
        System.out.println(countPermutation(a, b));
    }
}
