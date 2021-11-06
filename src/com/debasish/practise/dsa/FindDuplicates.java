package com.debasish.practise.dsa;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class FindDuplicates {
    public static void main(String[] args) {
        String inputString = "I am am am learning java java am";
        findDuplicateWord(inputString);
    }

    private static void findDuplicateWord(String string) {
        String[] arr = string.split(" ");
        Map<String, Integer> map = new HashMap<>();
        for (String tempString : arr) {
            if (map.get(tempString) != null) {
                map.put(tempString, map.get(tempString) + 1);
            } else {
                map.put(tempString, 1);
            }
        }
        System.out.println("Showing each word's occurrence: \n" + map + "\n");
        Iterator<String> keyIterator = map.keySet().iterator();
        while (keyIterator.hasNext()) {
            String temp = keyIterator.next();
            if (map.get(temp) > 1) {
                System.out.println("The word '" + temp + "' appeared " + map.get(temp) + " no. of times.");
            }
        }
    }

}
