package module3;

import java.util.Stack;

public class Problem5{
    static int precedence(char op) {
        switch (op) {
            case '+': case '-': return 1;
            case '*': case '/': return 2;
            default: return -1;
        }
    }

    static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    static String convert(String infix) {
        StringBuilder output = new StringBuilder();
        Stack<Character> opStack = new Stack<>();

        for (char ch : infix.toCharArray()) {
            if (Character.isLetterOrDigit(ch)) {
                output.append(ch);
            } else if (ch == '(') {
                opStack.push(ch);
            } else if (ch == ')') {
                while (!opStack.isEmpty() && opStack.peek() != '(') {
                    output.append(opStack.pop());
                }
                opStack.pop();
            } else if (isOperator(ch)) {
                while (!opStack.isEmpty() && opStack.peek() != '(' &&
                        precedence(opStack.peek()) >= precedence(ch)) {
                    output.append(opStack.pop());
                }
                opStack.push(ch);
            }
        }
        while (!opStack.isEmpty()) {
            output.append(opStack.pop());
        }
        return output.toString();
    }

    public static void main(String[] args) {
        String infix = "a+b*c";
        System.out.println("Infix:   " + infix);
        System.out.println("Postfix: " + convert(infix));

        String infix2 = "(a+b)*(c-d)";
        System.out.println("Infix:   " + infix2);
        System.out.println("Postfix: " + convert(infix2));
    }
}
