package module3;

import java.util.Stack;

public class Problem3 {
    static boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

    static int applyOp(int a, int b, char op) {
        switch (op) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            case '/': return a / b;
        }
        throw new IllegalArgumentException("Invalid operator: " + op);
    }

    static int evaluate(String expr) {
        Stack<Integer> stack = new Stack<>();
        String[] tokens = expr.trim().split("\\s+");

        for (String token : tokens) {
            if (isOperator(token)) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(applyOp(a, b, token.charAt(0)));
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String postfix = "2 3 4 * +";
        System.out.println("Postfix expression: " + postfix);
        System.out.println("Result = " + evaluate(postfix));
    }
}
