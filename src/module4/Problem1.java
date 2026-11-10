package module4;

public class Problem1 {
    static final int CAPACITY = 100;
    static int[] arr = new int[CAPACITY];
    static int front = 0;   // index of the front element
    static int rear = -1;   // index of the rear element
    static int count = 0;   // current number of elements

    static boolean isEmpty() {
        return count == 0;
    }

    static boolean isFull()  {
        return count == CAPACITY;
    }

    static void enqueue(int value) {
        if (isFull()) {
            System.out.println("Queue Overflow"); return;
        }
        rear = rear + 1;
        arr[rear] = value;
        count++;
    }

    static int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue Underflow"); return -1;
        }
        int value = arr[front];
        front++;
        count--;
        return value;
    }

    static int peekFront() {
        if (isEmpty()) {
            System.out.println("Queue is empty"); return -1;
        }
        return arr[front];
    }

    public static void main(String[] args) {
        enqueue(10);
        enqueue(20);
        enqueue(30);
        System.out.println("Front: " + peekFront());

        System.out.println("Dequeue: " + dequeue());

        enqueue(40);
        System.out.println("Front: " + peekFront());
        System.out.println("Is empty? " + isEmpty());
    }
}
