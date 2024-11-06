package org.example.corejava;

import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeating {
    public static void main(String[] args) {
        System.out.println(findFirstNonRepeating("12345"));
        System.out.println(findFirstNonRepeating("abbacd"));
    }

    public static Character findFirstNonRepeating(String str) {
        Map<Character, Integer> charCount = new HashMap<>();

        for (char c : str.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        for (char c : str.toCharArray()) {
            if (charCount.get(c) == 1) {
                return c;
            }
        }

        return null;
    }
}
