package corejava;

public class Dictionary {
    public static void main(String[] args) {
        String[] dict = {"CODGE", "ODG", "LODGES", "SODG", "dodge", "mODJ", "LODGESSSS"};
        String toSearch = "ODG";
        System.out.println(findLongestWordLength(dict, toSearch));
    }

    public static int findLongestWordLength(String[] dict, String toSearch) {
        int maxLength = 0;
        for (String word : dict) {
            if (word.toUpperCase().contains(toSearch.toUpperCase())) {
                maxLength = Math.max(maxLength, word.length());
            }
        }
        return maxLength;
    }
}
