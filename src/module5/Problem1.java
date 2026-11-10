package module5;

import java.util.HashMap;
import java.util.Map;

public class Problem1 {
    static void countFrequency(int[] arr) {
        Map<Integer, Integer> freq = new HashMap<>();

        for (int value : arr) {
            // getOrDefault avoids a separate containsKey() check
            freq.put(value, freq.getOrDefault(value, 0) + 1);
        }

        System.out.println("Element frequencies:");
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            System.out.println("  " + entry.getKey() + " -> "
                    + entry.getValue());
        }
    }

    public static void main(String[] args) {
        int[] arr = {4, 7, 4, 2, 7, 4};

        System.out.print("Array: ");
        for (int v : arr) System.out.print(v + " ");
        System.out.println();

        countFrequency(arr);
    }
}
