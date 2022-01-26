/**
 * WAP to show each word's/char's occurrence in a given string.
 * Then show only the duplicate words/chars and their occurrences.
 */
package com.debasish.practise.ctci;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author debasishsahoo
 */
public class FindDuplicates {
    public static void main(String[] args) {
        String inputString = "I am am am learning java java am";
        String inputCharString = "javaj2ee";
        System.out.println("######################################");
        findDuplicateWord(inputString);
        System.out.println("======================================");
        findDuplicateCharacters(inputCharString);
        System.out.println("**************************************");
    }

    /**
     * Pseudo Code: <br/>
     * 1. Split each word by " ". <br/>
     * 2. Use a hashmap to store each word and their no. of occurrence.<br/>
     * 3. For each word in the string: <br/>
     * 3.1: Check if the word is not null means it is already present in the string: <br/>
     * 3.1.1: Store the word into the map's key and increment the value by 1. <br/>
     * 3.2: If word is null/not present already: <br/>
     * 3.2.1: Add that to the map with value 1. -> When no words will be there initially, then this will be executed. <br/>
     * 4. Come out of loop and print the map. <br/>
     * 5. Iterate only the words/keys of the map. <br/>
     * 6. Check while we have the words in the map: <br/>
     * 6.1: Extract each word in a temporary variable. <br/>
     * 6.2: Check if the value of each word is greater than 1 then it means it is DUPLICATED: <br/>
     * 6.2.1: Print the duplicates. <br/>
     * <p>
     *
     * @param string the input string.
     */
    private static void findDuplicateWord(String string) {
        String[] arr = string.split(" "); // 1
        Map<String, Integer> map = new HashMap<>(); // 2
        for (String tempString : arr) { // 3
            if (map.get(tempString) != null) { // 3.1
                map.put(tempString, map.get(tempString) + 1); // 3.1.1
            } else { // 3.2
                map.put(tempString, 1); // 3.2.1
            }
        }
        System.out.println("Showing each word's occurrence: \n" + map + "\n"); // 4
        Iterator<String> keyIterator = map.keySet().iterator(); // 5
        while (keyIterator.hasNext()) { // 6
            String temp = keyIterator.next(); // 6.1
            if (map.get(temp) > 1) { // 6.2
                System.out.println("The word '" + temp + "' appeared " + map.get(temp) + " no. of times."); //6.2.1
            }
        }
    }

    private static void findDuplicateCharacters(String inputCharString) {
        Map<Character, Integer> map = new HashMap<>();
        for (Character ch : inputCharString.toCharArray()) {
            if (map.get(ch) != null) {
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }
        }
        System.out.println("Showing each char's occurrence: \n" + map + "\n");
        for (char temp : map.keySet()) {
            if (map.get(temp) > 1) {
                System.out.println("The char '" + temp + "' appeared " + map.get(temp) + " no. of times.");
            }
        }
    }

}
