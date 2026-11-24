package module7;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Exercise1 {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    static int height(Node node) {
        if (node == null) {
            return -1;
        }
        return 1 + Math.max(height(node.left), height(node.right));
    }

    static int balanceFactor(Node node) {
        if (node == null) {
            return 0;
        }
        return height(node.left) - height(node.right);
    }

    static int collectBalanceFactors(Node node, List<String> out) {
        if (node == null) {
            return -1;
        }
        int hl = collectBalanceFactors(node.left, out);
        int slot = out.size();
        out.add(null);
        int hr = collectBalanceFactors(node.right, out);

        int h = 1 + Math.max(hl, hr);
        int bf = hl - hr;
        out.set(slot, "  Node " + node.data + ": height=" + h + ", BF=" + bf);
        return h;
    }

    static void printBalanceFactors(Node node) {
        List<String> lines = new ArrayList<>();
        collectBalanceFactors(node, lines);
        for (String line : lines) {
            System.out.println(line);
        }
    }

    static void originalLines(Node node, List<String> out) {
        if (node == null) {
            return;
        }
        originalLines(node.left, out);
        out.add("  Node " + node.data + ": height=" + height(node) + ", BF=" + balanceFactor(node));
        originalLines(node.right, out);
    }

    static boolean isHeightBalanced(Node node) {
        if (node == null) return true;
        int bf = balanceFactor(node);
        if (Math.abs(bf) > 1) return false;
        return isHeightBalanced(node.left) && isHeightBalanced(node.right);
    }

    static int counter;

    static Node randomTree(int depth, Random rnd) {
        if (depth == 0 || rnd.nextInt(4) == 0) {
            return null;
        }
        Node n = new Node(counter++);
        n.left = randomTree(depth - 1, rnd);
        n.right = randomTree(depth - 1, rnd);
        return n;
    }

    static boolean sameOutput(Node root) {
        List<String> oldLines = new ArrayList<>();
        List<String> newLines = new ArrayList<>();
        originalLines(root, oldLines);
        collectBalanceFactors(root, newLines);
        return oldLines.equals(newLines);
    }

    public static void main(String[] args) {
        Node root = new Node(50);
        root.left = new Node(30);
        root.right = new Node(70);
        root.left.left = new Node(20);
        root.left.right = new Node(40);
        root.right.right = new Node(80);

        System.out.println("Balance factors (in-order):");
        printBalanceFactors(root);

        System.out.println("Is the tree height-balanced? " + isHeightBalanced(root));

        boolean allMatch = sameOutput(root) && sameOutput(null);
        Random rnd = new Random(42);
        for (int i = 0; i < 5000 && allMatch; i++) {
            counter = 0;
            allMatch = sameOutput(randomTree(10, rnd));
        }
        System.out.println("Rewrite matches original on all tests? " + allMatch);
    }
}