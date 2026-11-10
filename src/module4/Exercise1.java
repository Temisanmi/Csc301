package module4;

public class Exercise1 {
    static final int CAPACITY = 100;
    static int[] arr = new int[CAPACITY];
    static int front = 0;   // index of the front element
    static int rear = -1;   // index of the rear element
    static int count = 0;   // current number of elements

    static boolean isEmpty() {
        return count == 0;
    }

    static boolean isFull() {
        return rear == CAPACITY - 1;
    }

    static boolean enqueue(int value) {
        if (isFull()) {
            System.out.println("Queue Overflow");
            return false;
        }
        rear = rear + 1;
        arr[rear] = value;
        count++;
        return true;
    }

    static int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue Underflow");
            return -1;
        }
        int value = arr[front];
        front++;
        count--;
        return value;
    }

    static int peekFront() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        return arr[front];
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 60; i++) enqueue(i);
        for (int i = 0; i < 50; i++) dequeue();
        System.out.println("After enqueue/dequeue -> front = " + front + ", rear = " + rear + ", count = " + count);

        int remaining = CAPACITY - count;
        int enqueued = 0;
        for (int i = 0; i < remaining; i++) {
            if (!enqueue(1000 + i)) {
                break;
            }
            enqueued++;
        }

        System.out.println("Tried to enqueue " + remaining + ", only " + enqueued + " succeeded");
        System.out.println("At overflow -> front = " + front + ", rear = " + rear + ", count = " + count);
        System.out.println("Array length = " + CAPACITY
                + ", elements stored = " + count
                + ", unusable (wasted) slots = " + (CAPACITY - count));
    }
}
