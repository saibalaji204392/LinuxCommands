package corejava;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FormableWords {
    public static void main(String[] args) {
        String[] dict1 = {"ab", "abcd", "bcdaf", "bcad", "acb", "acab"};
        String input1 = "abcd";
        System.out.println(findFormableWords(dict1, input1));

        String[] dict2 = {"ab", "abcd", "bcdaf", "bcad", "acaab", "acab"};
        String input2 = "caab";
        System.out.println(findFormableWords(dict2, input2));
    }

    public static List<String> findFormableWords(String[] dict, String input) {
        List<String> result = new ArrayList<>();
        Map<Character, Integer> inputCharCount = new HashMap<>();

        for (char c : input.toCharArray()) {
            inputCharCount.put(c, inputCharCount.getOrDefault(c, 0) + 1);
        }

        for (String word : dict) {
            if (canFormWord(word, inputCharCount)) {
                result.add(word);
            }
        }

        return result;
    }

    private static boolean canFormWord(String word, Map<Character, Integer> inputCharCount) {
        Map<Character, Integer> wordCharCount = new HashMap<>();

        for (char c : word.toCharArray()) {
            wordCharCount.put(c, wordCharCount.getOrDefault(c, 0) + 1);
        }

        for (char c : wordCharCount.keySet()) {
            if (wordCharCount.get(c) > inputCharCount.getOrDefault(c, 0)) {
                return false;
            }
        }

        return true;
    }
}
