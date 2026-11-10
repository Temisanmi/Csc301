package module5;

import java.util.*;

public class Problem4 {
    static List<List<String>> groupAnagrams(String[] words) {
        Map<String, List<String>> groups = new HashMap<>();

        for (String word : words) {
            // sorting the letters gives all anagrams an identical key
            char[] letters = word.toCharArray();
            Arrays.sort(letters);
            String key = new String(letters);

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
