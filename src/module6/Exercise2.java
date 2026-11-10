package module6;

public class Exercise2 {
    static class Node {
        int data;
        Node left, right;
        Node(int data) {
            this.data = data;
        }
    }

    static Node root;
    static int comparisons;

    static Node insert(Node node, int value) {
        if (node == null) return new Node(value);
        if (value < node.data) node.left = insert(node.left, value);
        else if (value > node.data) node.right = insert(node.right, value);
        return node;
    }

    static boolean searchIterative(Node node, int target) {
        comparisons = 0;
        while (node != null) {
            comparisons++;
            if (target == node.data) return true;
            node = (target < node.data) ? node.left : node.right;
        }
        return false;
    }

    private static boolean searchHelper(Node node, int target) {
        if (node == null) return false;
        comparisons++;
        if (target == node.data) return true;
        if (target < node.data) return searchHelper(node.left, target);
        return searchHelper(node.right, target);
    }

    static boolean search(Node node, int target) {
        comparisons = 0;
        return searchHelper(node, target);
    }

    public static void main(String[] args) {
        int[] values = {50, 30, 70, 20, 40, 60, 80};
        for (int v : values) root = insert(root, v);

        int[] targets = {60, 65};
        for (int t : targets) {
            boolean iter = searchIterative(root, t);
            int iterCount = comparisons;

            boolean rec = search(root, t);
            int recCount = comparisons;

            System.out.println("search(" + t + ") iterative -> " + iter + " (comparisons: " + iterCount + ")");
            System.out.println("search(" + t + ") recursive -> " + rec + " (comparisons: " + recCount + ")");
            System.out.println("  counts match: " + (iterCount == recCount));
        }
    }
}
