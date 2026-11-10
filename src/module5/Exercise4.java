package module5;

import java.util.*;

public class Exercise4 {
    static String frequencyKey(String word) {
        int[] counts = new int[26];
        for (char ch : word.toCharArray()) {
            counts[ch - 'a']++;
        }

        StringBuilder key = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (counts[i] > 0) {
                key.append((char) ('a' + i)).append(counts[i]);
            }
        }
        return key.toString();
    }

    static List<List<String>> groupAnagrams(String[] words) {
        Map<String, List<String>> groups = new LinkedHashMap<>();

        for (String word : words) {
            String key = frequencyKey(word);

            groups.putIfAbsent(key, new ArrayList<>());
            groups.get(key).add(word);
        }

        return new ArrayList<>(groups.values());
    }

    public static void main(String[] args) {
        String[] words = {"eat", "tea", "tan", "ate", "nat", "bat"};

        System.out.println("Input: " + Arrays.toString(words));
        System.out.println("Grouped anagrams:");

        for (List<String> group : groupAnagrams(words)) {
            System.out.println("  " + group);
        }
    }
}
