package module1;

import java.util.Arrays;

public class Exercise4 {
    static void reverse(int[] arr, int start, int end) {
        while (start < end) {

            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }
    }

    static void rotateRight(int[] arr, int k) {
        int n = arr.length;

        k = k % n;

        int leftRotation = n - k;

        reverse(arr, 0, leftRotation - 1);
        reverse(arr, leftRotation, n - 1);
        reverse(arr, 0, n - 1);
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;

        System.out.println("Original: " + Arrays.toString(arr));

        rotateRight(arr, k);

        System.out.println("Rotated right by " + k + ": " + Arrays.toString(arr));
    }
}
