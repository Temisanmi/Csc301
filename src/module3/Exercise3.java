package module3;

import java.util.Stack;

public class Exercise3{
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

    static int evaluatePrefix(String expr) {
        Stack<Integer> stack = new Stack<>();
        String[] tokens = expr.trim().split("\\s+");

        for (int i = tokens.length - 1; i >= 0; i--) {
            String token = tokens[i];

            if (isOperator(token)) {
                int a = stack.pop();
                int b = stack.pop();

                stack.push(applyOp(a, b, token.charAt(0)));
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String prefix = "+ 2 * 3 4";

        System.out.println("Prefix expression: " + prefix);
        System.out.println("Result = " + evaluatePrefix(prefix));
    }
}
