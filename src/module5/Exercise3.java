package module5;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Exercise3 {
    static Optional<Integer> findFirstNonRepeating(int[] arr) {
        Map<Integer, Integer> freq = new HashMap<>();

        for (int value : arr) {
            freq.put(value, freq.getOrDefault(value, 0) + 1);
        }

        for (int value : arr) {
            if (freq.get(value) == 1) return Optional.of(value);
        }

        return Optional.empty();
    }

    static void printResult(int[] arr) {
        System.out.print("Array: ");
        for (int v : arr) System.out.print(v + " ");
        System.out.println();

        Optional<Integer> result = findFirstNonRepeating(arr);
        if (result.isPresent()) {
            System.out.println("First non-repeating element: " + result.get());
        } else {
            System.out.println("No non-repeating element exists");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        printResult(new int[]{9, 4, 9, 6, 4, 8});
        printResult(new int[]{5, 5, 3, 3});
        printResult(new int[]{2, 2, -1, 2});
    }
}
