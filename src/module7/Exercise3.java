package module7;

public class Exercise3 {
    static class Node {
        int data, height;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.height = 0;
        }
    }

    static Node root;
    static int rotations;

    static int height(Node n) {
        return (n == null) ? -1 : n.height;
    }

    static int balanceFactor(Node n) {
        return (n == null) ? 0 : height(n.left) - height(n.right);
    }

    static void updateHeight(Node n) {
        n.height = 1 + Math.max(height(n.left), height(n.right));
    }

    static Node rightRotate(Node y) {
        rotations++;
        Node x = y.left;
        Node T2 = x.right;
        x.right = y;
        y.left = T2;
        updateHeight(y);
        updateHeight(x);
        return x;
    }

    static Node leftRotate(Node x) {
        rotations++;
        Node y = x.right;
        Node T2 = y.left;
        y.left = x;
        x.right = T2;
        updateHeight(x);
        updateHeight(y);
        return y;
    }

    static Node insert(Node node, int value) {
        if (node == null) {
            return new Node(value);
        }

        if (value < node.data) {
            node.left = insert(node.left, value);
        }
        else if (value > node.data) {
            node.right = insert(node.right, value);
        }
        else return node;   // no duplicates

        updateHeight(node);
        int bf = balanceFactor(node);

        // LL case
        if (bf > 1 && value < node.left.data) return rightRotate(node);
        // RR case
        if (bf < -1 && value > node.right.data) return leftRotate(node);
        // LR case
        if (bf > 1 && value > node.left.data) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        // RL case
        if (bf < -1 && value < node.right.data) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        return node;   // already balanced
    }

    static void inorder(Node node, StringBuilder sb) {
        if (node == null) {
            return;
        }
        inorder(node.left, sb);
        sb.append(node.data).append(" ");
        inorder(node.right, sb);
    }

    public static void main(String[] args) {
        int[] values = {1, 2, 3, 4, 5, 6, 7};   // already sorted

        for (int v : values) {
            int before = rotations;
            root = insert(root, v);
            System.out.println("insert(" + v + ") -> root is now " + root.data
                    + ", height=" + root.height
                    + ", rotations this insert=" + (rotations - before));
        }

        StringBuilder sb = new StringBuilder();
        inorder(root, sb);
        System.out.println("\nFinal in-order: " + sb.toString().trim());
        System.out.println("Total AVL rotations: " + rotations);
        System.out.println("Final AVL height: " + root.height);
        System.out.println("Plain BST (same input): 0 rotations, height = " + (values.length - 1));
    }
}