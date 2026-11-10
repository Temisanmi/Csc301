package module4;

public class Problem3CircularQueue {
    int[] arr;
    int front, rear, count, capacity;

    Problem3CircularQueue(int capacity) {
        this.capacity = capacity;
        arr = new int[capacity];
        front = 0;
        rear = -1;
        count = 0;
    }

    boolean isEmpty() {
        return count == 0;
    }
    boolean isFull()  {
        return count == capacity;
    }

    void enqueue(int value) {
        if (isFull()) {
            System.out.println("Queue Overflow"); return;
        }
        rear = (rear + 1) % capacity;   // wrap around when reaching the end
        arr[rear] = value;
        count++;
    }

    int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue Underflow"); return -1;
        }
        int value = arr[front];
        front = (front + 1) % capacity; // wrap around when reaching the end
        count--;
        return value;
    }

    int peekFront() {
        if (isEmpty()) {
            System.out.println("Queue is empty"); return -1;
        }
        return arr[front];
    }

    public static void main(String[] args) {
        Problem3CircularQueue q = new Problem3CircularQueue(5);

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        System.out.println("Dequeue: " + q.dequeue());   // removes 10
        System.out.println("Dequeue: " + q.dequeue());   // removes 20

        // Enqueue enough elements to force wrap-around past index 4
        q.enqueue(40);
        q.enqueue(50);
        q.enqueue(60);   // rear wraps back to index 0
        q.enqueue(70);   // fills the queue to capacity

        System.out.println("Front: " + q.peekFront());   // expect 30
        System.out.println("Is full? " + q.isFull());    // 5/5 slots used
    }
}
