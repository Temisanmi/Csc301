package module5;

import java.util.HashMap;
import java.util.Map;

public class Problem2 {
    static boolean areAnagrams(String a, String b) {
        if (a.length() != b.length()) return false;   // quick rejection

        Map<Character, Integer> freq = new HashMap<>();

        // count characters of the first string
        for (char ch : a.toCharArray()) {
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }

        // subtract characters of the second string
        for (char ch : b.toCharArray()) {
            if (!freq.containsKey(ch)) return false;  // not in first string
            freq.put(ch, freq.get(ch) - 1);
            if (freq.get(ch) == 0) freq.remove(ch);
        }

        return freq.isEmpty();   // empty => perfectly balanced => anagram
    }

    public static void main(String[] args) {
        System.out.println("listen/silent -> "
                + areAnagrams("listen", "silent"));
        System.out.println("hello/world   -> "
                + areAnagrams("hello", "world"));
        System.out.println("aab/abb       -> "
                + areAnagrams("aab", "abb"));
    }
}
