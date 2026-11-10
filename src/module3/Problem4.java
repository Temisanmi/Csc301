package module3;

import java.util.Stack;

public class Problem4{
    static Stack<Integer> mainStack = new Stack<>();
    static Stack<Integer> minStack = new Stack<>();   // top = current minimum

    static void push(int value) {
        mainStack.push(value);

        if (minStack.isEmpty() || value <= minStack.peek()) {
            minStack.push(value);          // new minimum (or tie)
        } else {
            minStack.push(minStack.peek()); // repeat current minimum
        }
    }

    static int pop() {
        minStack.pop();               // keep both stacks in sync
        return mainStack.pop();
    }

    static int getMin() {
        return minStack.peek();       // O(1) — no scanning required
    }

    public static void main(String[] args) {
        push(5);
        push(3);
        push(7);
        push(2);

        System.out.println("Current minimum: " + getMin());   // 2

        pop();  // removes 2
        System.out.println("Current minimum: " + getMin());   // 3

        pop();  // removes 7
        System.out.println("Current minimum: " + getMin());   // 3
    }
}
