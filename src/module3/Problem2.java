package module3;

import java.util.Stack;

public class Problem2 {
    static boolean matches(char open, char close) {
        return (open == '(' && close == ')') ||
                (open == '{' && close == '}') ||
                (open == '[' && close == ']');
    }

    static boolean isBalanced(String expr) {
        Stack<Character> stack = new Stack<>();

        for (char ch : expr.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else if (ch == ')' || ch == '}' || ch == ']') {
                if (stack.isEmpty()) return false;

                char open = stack.pop();

                if (!matches(open, ch)) return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String expr1 = "{(a+b)*[c-d]}";
        String expr2 = "[(a+b)*(c-d]";

        System.out.println(expr1 + "  -> Balanced: " + isBalanced(expr1));
        System.out.println(expr2 + "  -> Balanced: " + isBalanced(expr2));
    }
}
