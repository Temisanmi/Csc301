package module5;

import java.util.HashMap;
import java.util.Map;

public class Problem3 {
    static int findFirstNonRepeating(int[] arr) {
        Map<Integer, Integer> freq = new HashMap<>();

        // PASS 1: count how many times each value occurs
        for (int value : arr) {
            freq.put(value, freq.getOrDefault(value, 0) + 1);
        }

        // PASS 2: re-scan in ORIGINAL order, return first value with count 1
        for (int value : arr) {
            if (freq.get(value) == 1) return value;
        }

        return -1;   // sentinel: every element repeats
    }

    public static void main(String[] args) {
        int[] arr = {9, 4, 9, 6, 4, 8};

        System.out.print("Array: ");
        for (int v : arr) System.out.print(v + " ");
        System.out.println();

        int result = findFirstNonRepeating(arr);
        System.out.println("First non-repeating element: " + result);

        int[] allRepeat = {5, 5, 3, 3};
        System.out.println("All-repeating array result: " +
                findFirstNonRepeating(allRepeat));
    }
}
