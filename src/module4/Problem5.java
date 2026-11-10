package module4;

import java.util.ArrayDeque;
import java.util.Deque;

public class Problem5 {
    static int[] maxSlidingWindow(int[] arr, int k) {
        int n = arr.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();  // indices, decreasing

        for (int i = 0; i < n; i++) {
            // remove indices whose values are smaller than arr[i];
            // they can never be the window maximum from now on
            while (!deque.isEmpty() && arr[deque.peekLast()] <= arr[i]) {
                deque.pollLast();
            }
            deque.addLast(i);

            // remove the front index if it has left the window
            if (deque.peekFirst() == i - k) {
                deque.pollFirst();
            }

            // record a result once the first full window has been formed
            if (i >= k - 1) {
                result[i - k + 1] = arr[deque.peekFirst()];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;

        int[] result = maxSlidingWindow(arr, k);

        System.out.print("Array: ");
        for (int v : arr) System.out.print(v + " ");
        System.out.println("\nWindow size k = " + k);
        System.out.print("Maximums: ");
        for (int v : result) System.out.print(v + " ");
        System.out.println();
    }
}
