package org.example.corejava;

import java.util.LinkedHashMap;
import java.util.Map;

public class CharCount {
    public static void main(String[] args) {
        System.out.println(convertString("aabbb"));
        System.out.println(convertString("aaaa"));
        System.out.println(convertString("a"));

        System.out.println(convertStringInMap("aabbb"));
        System.out.println(convertStringInMap("aaaa"));
        System.out.println(convertStringInMap("a"));
    }

    public static String convertString(String str) {
        StringBuilder result = new StringBuilder();
        int count = 1;
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == str.charAt(i - 1)) {
                count++;
            } else {
                result.append(str.charAt(i - 1)).append(count);
                count = 1;
            }
        }
        result.append(str.charAt(str.length() - 1)).append(count);
        return result.toString();
    }
    public static String convertStringInMap(String str) {
        Map<Character, Integer> countMap = new LinkedHashMap<>();
        for (char c : str.toCharArray()) {
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        }
        StringBuilder result = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : countMap.entrySet()) {
            result.append(entry.getKey()).append(entry.getValue());
        }
        return result.toString();
    }
}
