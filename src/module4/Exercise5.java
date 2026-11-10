package module4;

import java.util.ArrayDeque;
import java.util.Deque;

public class Exercise5 {
    static int[] minSlidingWindow(int[] arr, int k) {
        int n = arr.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            while (!deque.isEmpty() && arr[deque.peekLast()] >= arr[i]) {   // <= changed to >=
                deque.pollLast();
            }
            deque.addLast(i);

            if (deque.peekFirst() == i - k) {
                deque.pollFirst();
            }

            if (i >= k - 1) {
                result[i - k + 1] = arr[deque.peekFirst()];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;

        int[] result = minSlidingWindow(arr, k);

        System.out.print("Array: ");
        for (int v : arr) System.out.print(v + " ");
        System.out.println("\nWindow size k = " + k);
        System.out.print("Minimums: ");
        for (int v : result) System.out.print(v + " ");
        System.out.println();
    }
}
