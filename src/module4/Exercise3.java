package module4;

public class Exercise3 {
    int[] arr;
    int front, rear, count, capacity;

    Exercise3(int capacity) {
        this.capacity = capacity;
        arr = new int[capacity];
        front = 0;
        rear = -1;
        count = 0;
    }

    boolean isEmpty() {
        return count == 0;
    }

    boolean isFull() {
        return count == capacity;
    }

    void resize() {
        int newCapacity = capacity * 2;
        int[] newArr = new int[newCapacity];

        for (int i = 0; i < count; i++) {
            newArr[i] = arr[(front + i) % capacity];   // walk from front, wrapping around
        }

        System.out.println("Resizing: " + capacity + " -> " + newCapacity);

        arr = newArr;
        capacity = newCapacity;
        front = 0;
        rear = count - 1;
    }

    void enqueue(int value) {
        if (isFull()) {
            resize();
        }
        rear = (rear + 1) % capacity;
        arr[rear] = value;
        count++;
    }

    int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue Underflow");
            return -1;
        }
        int value = arr[front];
        front = (front + 1) % capacity;
        count--;
        return value;
    }

    int peekFront() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        return arr[front];
    }

    public static void main(String[] args) {
        Problem3CircularQueue q = new Problem3CircularQueue(5);

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        System.out.println("Dequeue: " + q.dequeue());
        System.out.println("Dequeue: " + q.dequeue());


        q.enqueue(40);
        q.enqueue(50);
        q.enqueue(60);
        q.enqueue(70);

        System.out.println("Front: " + q.peekFront());
        System.out.println("Is full? " + q.isFull());

        q.enqueue(80);
        System.out.println("After resize -> front = " + q.front + ", rear = " + q.rear
                + ", count = " + q.count + ", capacity = " + q.capacity);

        System.out.print("Contents in order:");
        while (!q.isEmpty()) {
            System.out.print(" " + q.dequeue());
        }
        System.out.println();
    }
}
