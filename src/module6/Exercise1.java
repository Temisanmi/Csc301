package module6;

public class Exercise1 {
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

        if (value < node.data) {
            node.left = insert(node.left, value);
        } else if (value > node.data) {
            node.right = insert(node.right, value);
        }
        return node;
    }

    static void inorder(Node node, StringBuilder sb) {
        if (node == null) return;
        inorder(node.left, sb);
        sb.append(node.data).append(" ");
        inorder(node.right, sb);
    }

    public static void main(String[] args) {
        int[] values = {10, 20, 30, 40, 50};

        for (int v : values) {
            root = insert(root, v);
        }

        StringBuilder sb = new StringBuilder();
        inorder(root, sb);

        System.out.print("Insertion order: ");
        for (int v : values) System.out.print(v + " ");
        System.out.println();
        System.out.println("In-order traversal: " + sb.toString().trim());
    }
}
