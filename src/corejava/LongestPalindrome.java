package corejava;

public class LongestPalindrome {
    public static void main(String[] args) {
        String str = "forgeeksskeegfor";
        Result result = longestPalindrome(str);
        System.out.println("Palindrome: " + result.palindrome + ", Length: " + result.length);
    }

    public static Result longestPalindrome(String s) {
        int start = 0, maxLength = 1;

        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);

            if (len > maxLength) {
                maxLength = len;
                start = i - (len - 1) / 2;
            }
        }

        return new Result(s.substring(start, start + maxLength), maxLength);
    }

    private static int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

    static class Result {
        String palindrome;
        int length;

        Result(String palindrome, int length) {
            this.palindrome = palindrome;
            this.length = length;
        }
    }
}
