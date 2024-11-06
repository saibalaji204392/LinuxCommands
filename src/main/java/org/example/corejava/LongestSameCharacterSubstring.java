package org.example.corejava;

public class LongestSameCharacterSubstring {
    public static void main(String[] args) {
        String str = "aabbbbCCddd";
        Result result = longestSameCharacterSubstring(str);
        System.out.println("Starting Index: " + result.index + ", Length: " + result.length);
        System.out.println("Longest Substring: " + str.substring(result.index, result.index + result.length));
    }

    public static Result longestSameCharacterSubstring(String str) {
        int maxLength = 0;
        int maxIndex = 0;
        int currentLength = 1;
        int currentIndex = 0;

        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == str.charAt(i - 1)) {
                currentLength++;
            } else {
                if (currentLength > maxLength) {
                    maxLength = currentLength;
                    maxIndex = currentIndex;
                }
                currentLength = 1;
                currentIndex = i;
            }
        }


        if (currentLength > maxLength) {
            maxLength = currentLength;
            maxIndex = currentIndex;
        }

        return new Result(maxIndex, maxLength);
    }

    static class Result {
        int index;
        int length;

        Result(int index, int length) {
            this.index = index;
            this.length = length;
        }
    }
}
