package org.example.corejava;

import java.util.ArrayList;
import java.util.List;

public class PrefixSearch {
    public static void main(String[] args) {
        String[] arr = {"apple", "applet", "bread", "aper"};
        String prefix = "app";
        System.out.println(findWordsWithPrefix(arr, prefix));
    }

    public static List<String> findWordsWithPrefix(String[] arr, String prefix) {
        List<String> result = new ArrayList<>();
        for (String word : arr) {
            if (word.startsWith(prefix)) {
                result.add(word);
            }
        }
        return result;
    }
}
