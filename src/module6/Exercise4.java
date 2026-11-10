package module6;

import java.util.ArrayList;
import java.util.List;

public class Exercise4 {
    static class Node {
        int data;
        Node left, right;
        Node(int data) {
            this.data = data;
        }
    }

    static Node root;

    static Node insert(Node node, int value) {
        if (node == null) return new Node(value);
        if (value < node.data) node.left = insert(node.left, value);
        else if (value > node.data) node.right = insert(node.right, value);
        return node;
    }

    static Node findLCA(Node node, int a, int b) {
        if (node == null) return null;

        if (a < node.data && b < node.data) {
            return findLCA(node.left, a, b);
        }

        if (a > node.data && b > node.data) {
            return findLCA(node.right, a, b);
        }
        return node;
    }

    static List<Integer> findPath(Node node, int target) {
        List<Integer> path = new ArrayList<>();
        while (node != null) {
            path.add(node.data);
            if (target == node.data) return path;
            node = (target < node.data) ? node.left : node.right;
        }
        return new ArrayList<>();
    }

    static String format(List<Integer> path) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < path.size(); i++) {
            if (i > 0) sb.append(" -> ");
            sb.append(path.get(i));
        }
        return sb.toString();
    }

    static void report(int a, int b) {
        List<Integer> pathA = findPath(root, a);
        List<Integer> pathB = findPath(root, b);
        Node lca = findLCA(root, a, b);

        System.out.println("Path to " + a + ": " + format(pathA));
        System.out.println("Path to " + b + ": " + format(pathB));
        System.out.println("LCA(" + a + ", " + b + ") = " + lca.data);
        System.out.println();
    }

    public static void main(String[] args) {
        int[] values = {50, 30, 70, 20, 40, 60, 80};
        for (int v : values) root = insert(root, v);

        report(20, 60);
        report(20, 40);
    }
}
