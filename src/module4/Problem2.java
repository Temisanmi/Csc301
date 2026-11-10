package module4;

import java.util.Stack;

public class Problem2 {
    static Stack<Integer> inStack = new Stack<>();    // receives new elements
    static Stack<Integer> outStack = new Stack<>();   // serves dequeue calls

    static void enqueue(int value) {
        inStack.push(value);
    }

    static int dequeue() {
        if (outStack.isEmpty()) {
            // pour everything from inStack into outStack, reversing the order
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
        if (outStack.isEmpty()) {
            System.out.println("Queue Underflow");
            return -1;
        }
        return outStack.pop();
    }

    public static void main(String[] args) {
        enqueue(1);
        enqueue(2);
        enqueue(3);

        System.out.println("Dequeue: " + dequeue());  // expect 1 (FIFO order)

        enqueue(4);   // added while outStack is not yet empty

        System.out.println("Dequeue: " + dequeue());  // expect 2
        System.out.println("Dequeue: " + dequeue());  // expect 3
        System.out.println("Dequeue: " + dequeue());  // expect 4
    }
}
