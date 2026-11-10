package module3;

import java.util.Stack;

public class Exercise2{
    static boolean matches(char open, char close) {
        return (open == '(' && close == ')') ||
                (open == '{' && close == '}') ||
                (open == '[' && close == ']');
    }

    static boolean isBalanced(String expr) {
        Stack<Integer> stack = new Stack<>();

        Stack<Character> brackets = new Stack<>();

        for (int i = 0; i < expr.length(); i++) {
            char ch = expr.charAt(i);

            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(i);
                brackets.push(ch);
            } else if (ch == ')' || ch == '}' || ch == ']') {
                if (stack.isEmpty()) {
                    System.out.println("Unmatched closing bracket '" + ch + "' at index " + i);
                    return false;
                }

                int openIndex = stack.pop();
                char open = brackets.pop();

                if (!matches(open, ch)) {
                    System.out.println("Mismatched bracket '" + ch + "' at index " + i + ". Expected closing bracket for '" + open + "' opened at index " + openIndex);
                    return false;
                }
            }
        }

        if (!stack.isEmpty()) {
            int openIndex = stack.peek();
            char open = brackets.peek();

            System.out.println("Unmatched opening bracket '" + open + "' at index " + openIndex);
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String expr1 = "{(a+b)*[c-d]}";
        String expr2 = "[(a+b)*(c-d]";
        String expr3 = "a+b)";
        String expr4 = "((a+b)";

        System.out.println("\nChecking: " + expr1);
        System.out.println("Balanced: " + isBalanced(expr1));

        System.out.println("\nChecking: " + expr2);
        System.out.println("Balanced: " + isBalanced(expr2));

        System.out.println("\nChecking: " + expr3);
        System.out.println("Balanced: " + isBalanced(expr3));

        System.out.println("\nChecking: " + expr4);
        System.out.println("Balanced: " + isBalanced(expr4));
    }
}
