package module5;

import java.util.HashMap;
import java.util.Map;

public class Exercise1 {
    static void countFrequency(int[] arr) {
        Map<Integer, Integer> freq = new HashMap<>();

        for (int value : arr) {
            freq.put(value, freq.getOrDefault(value, 0) + 1);
        }

        System.out.println("Element frequencies:");
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            System.out.println("  " + entry.getKey() + " -> " + entry.getValue());
        }

        int mostFrequent = 0;
        int highestCount = 0;
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            if (entry.getValue() > highestCount) {
                highestCount = entry.getValue();
                mostFrequent = entry.getKey();
            }
        }
        System.out.println("Most frequent: " + mostFrequent
                + " (" + highestCount + " times)");
    }

    public static void main(String[] args) {
        int[] arr = {4, 7, 4, 2, 7, 4};
        printAndCount(arr);

        int[] tie = {7, 7, 4, 4, 2};
        printAndCount(tie);
    }

    static void printAndCount(int[] arr) {
        System.out.print("Array: ");
        for (int v : arr) System.out.print(v + " ");
        System.out.println();
        countFrequency(arr);
        System.out.println();
    }
}
