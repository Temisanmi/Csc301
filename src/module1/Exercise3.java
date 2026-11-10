package module1;

import java.util.HashSet;

public class Exercise3 {
    static void findPairs(int[] arr, int target) {
        HashSet<Integer> seen = new HashSet<>();
        HashSet<String> printedPairs = new HashSet<>();

        int pairCount = 0;

        System.out.println("Pairs that sum to " + target + ":");

        for (int x : arr) {

            int complement = target - x;

            if (seen.contains(complement)) {

                // Store the pair in a consistent order.
                int first = Math.min(complement, x);
                int second = Math.max(complement, x);

                String pair = first + "," + second;

                // Print the pair only if it has not been printed before.
                if (!printedPairs.contains(pair)) {
                    System.out.println("  (" + first + ", " + second + ")");
                    printedPairs.add(pair);
                    pairCount++;
                }
            }

            seen.add(x);
        }

        if (pairCount == 0) {
            System.out.println("  No pairs found.");
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 3, 6};
        int target = 6;

        findPairs(arr, target);
    }
}
