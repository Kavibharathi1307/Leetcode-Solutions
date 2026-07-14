import java.util.*;

class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {

        // Store banned words
        Set<String> bannedSet = new HashSet<>();
        for (String word : banned) {
            bannedSet.add(word);
        }

        // Convert to lowercase and replace punctuation with spaces
        paragraph = paragraph.toLowerCase().replaceAll("[^a-z]", " ");

        // Count frequency
        Map<String, Integer> map = new HashMap<>();
        String result = "";
        int maxCount = 0;

        String[] words = paragraph.split("\\s+");

        for (String word : words) {
            if (!word.isEmpty() && !bannedSet.contains(word)) {
                int count = map.getOrDefault(word, 0) + 1;
                map.put(word, count);

                if (count > maxCount) {
                    maxCount = count;
                    result = word;
                }
            }
        }

        return result;
    }
}
