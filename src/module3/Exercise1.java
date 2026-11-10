package module3;

import java.util.ArrayList;

public class Exercise1 {
    static ArrayList<Integer> arr = new ArrayList<>();

    static boolean isEmpty() {
        return arr.isEmpty();
    }

    static void push(int value) {
        arr.add(value);
    }

    static int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow");
            return -1;
        }
        return arr.removeLast();
    }

    static int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        return arr.getLast();
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
