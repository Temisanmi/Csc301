package module1;

import java.util.Arrays;

public class Exercise2 {
    static void reverse(int[] arr) {
        reverseRecursive(arr, 0, arr.length - 1);
    }

    static void reverseRecursive(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }

        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;

        reverseRecursive(arr, left + 1, right - 1);
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50};

        System.out.println("Before: " + Arrays.toString(arr));

        reverse(arr);

        System.out.println("After:  " + Arrays.toString(arr));
    }
}
