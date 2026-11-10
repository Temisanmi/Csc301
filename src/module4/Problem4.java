package module4;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Problem4 {
    static void processStream(String stream) {
        Queue<Character> candidates = new LinkedList<>();
        Map<Character, Integer> freq = new HashMap<>();

        for (char ch : stream.toCharArray()) {
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
            candidates.add(ch);

            // discard candidates from the front that have become repeated
            while (!candidates.isEmpty() && freq.get(candidates.peek()) > 1) {
                candidates.poll();
            }

            char result = candidates.isEmpty() ? '#' : candidates.peek();
            System.out.println("After '" + ch + "': first non-repeating = " +
                    (result == '#' ? "None" : result));
        }
    }

    public static void main(String[] args) {
        processStream("aabc");
    }
}
