package module3;

import java.util.Stack;

public class Exercise4{
    static Stack<Integer> mainStack = new Stack<>();
    static Stack<Integer> minStack = new Stack<>();

    static void push(int value) {
        mainStack.push(value);

        if (minStack.isEmpty() || value <= minStack.peek()) {
            minStack.push(value);
        }
    }

    static int pop() {
        int removed = mainStack.pop();

        if (removed == minStack.peek()) {
            minStack.pop();
        }
        return removed;
    }

    static int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        push(5);
        push(3);
        push(7);
        push(2);

        System.out.println("Current minimum: " + getMin());

        pop();
        System.out.println("Current minimum: " + getMin());

        pop();
        System.out.println("Current minimum: " + getMin());

        pop();
        System.out.println("Current minimum: " + getMin());
    }
}
