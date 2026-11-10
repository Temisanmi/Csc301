package module3;

public class Problem1 {
    static final int CAPACITY = 100;
    static int[] arr = new int[CAPACITY];
    static int top = -1;   // -1 means the stack is empty

    static boolean isEmpty() {
        return top == -1;
    }

    static boolean isFull() {
        return top == CAPACITY - 1;
    }

    static void push(int value) {
        if (isFull()) {
            System.out.println("Stack Overflow");
            return;
        }
        arr[++top] = value;
    }

    static int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow");
            return -1;
        }
        return arr[top--];
    }

    static int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        return arr[top];
    }

    public static void main(String[] args) {
        push(10);
        push(20);
        push(30);
        System.out.println("Peek: " + peek());

        System.out.println("Pop: " + pop());
        System.out.println("Pop: " + pop());

        push(40);
        System.out.println("Peek: " + peek());
        System.out.println("Is empty? " + isEmpty());
    }
}
