package module1;

public class Exercise1{
    static int max, min;
    static int maxIndex, minIndex;

    static void findMaxMin(int[] arr) {
        max = arr[0];
        min = arr[0];

        maxIndex = 0;
        minIndex = 0;

        for (int i = 1; i < arr.length; i++) {

            if (arr[i] > max) {
                max = arr[i];
                maxIndex = i;
            }

            if (arr[i] < min) {
                min = arr[i];
                minIndex = i;
            }
        }
    }

    public static void main(String[] args) {
        // The maximum value 89 occurs at indices 1 and 3.
        // The program returns index 1 because it only updates maxIndex
        // when it finds a value strictly greater than the current maximum.
        int[] arr = {12, 89, 3, 89, 27, 6, 49};

        findMaxMin(arr);

        System.out.print("Array: ");
        for (int v : arr) {
            System.out.print(v + " ");
        }

        System.out.println();

        System.out.println("Maximum = " + max);
        System.out.println("Maximum Index = " + maxIndex);

        System.out.println("Minimum = " + min);
        System.out.println("Minimum Index = " + minIndex);
    }
}