package module5;

import java.util.HashMap;
import java.util.Map;

public class Exercise2 {
    static String normalize(String s) {
        return s.replaceAll("\\s+", "").toLowerCase();
    }

    static boolean areAnagrams(String a, String b) {
        if (a.length() != b.length()) return false;   // quick rejection

        Map<Character, Integer> freq = new HashMap<>();

        for (char ch : a.toCharArray()) {
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }

        for (char ch : b.toCharArray()) {
            if (!freq.containsKey(ch)) return false;
            freq.put(ch, freq.get(ch) - 1);
            if (freq.get(ch) == 0) freq.remove(ch);
        }

        return freq.isEmpty();
    }

    static boolean areAnagramsIgnoreCaseAndSpaces(String a, String b) {
        return areAnagrams(normalize(a), normalize(b));
    }

    public static void main(String[] args) {
        System.out.println("listen/silent -> "
                + areAnagrams("listen", "silent"));
        System.out.println("hello/world   -> "
                + areAnagrams("hello", "world"));
        System.out.println("aab/abb       -> "
                + areAnagrams("aab", "abb"));

        System.out.println();

        System.out.println("Dormitory/Dirty Room (original)  -> "
                + areAnagrams("Dormitory", "Dirty Room"));
        System.out.println("Dormitory/Dirty Room (extended)  -> "
                + areAnagramsIgnoreCaseAndSpaces("Dormitory", "Dirty Room"));
        System.out.println("Astronomer/Moon starer (extended) -> "
                + areAnagramsIgnoreCaseAndSpaces("Astronomer", "Moon starer"));
        System.out.println("Hello/World (extended)            -> "
                + areAnagramsIgnoreCaseAndSpaces("Hello", "World"));
    }
}
