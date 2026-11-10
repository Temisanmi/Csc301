package module4;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Exercise4 {
    static Map<Character, Integer> freq = new HashMap<>();

    static void processStream(String stream) {
        Queue<Character> candidates = new LinkedList<>();
        freq = new HashMap<>();

        for (char ch : stream.toCharArray()) {
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
            candidates.add(ch);

            while (!candidates.isEmpty() && freq.get(candidates.peek()) > 1) {
                candidates.poll();
            }

            char result = candidates.isEmpty() ? '#' : candidates.peek();
            System.out.println("After '" + ch + "': first non-repeating = " +
                    (result == '#' ? "None" : result));
        }
    }

    static boolean streamEnded() {
        for (int count : freq.values()) {
            if (count == 1) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        processStream("aabc");
        System.out.println("Stream ended: at least one non-repeating character? "
                + streamEnded());

        System.out.println();

        processStream("aabbcc");
        System.out.println("Stream ended: at least one non-repeating character? "
                + streamEnded());
    }
}
