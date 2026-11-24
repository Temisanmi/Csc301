package module7;

public class Exercise4 {
    static class Node {
        int data, height;
        Node left, right;
        Node(int data) { this.data = data; this.height = 0; }
    }

    static int rotations;   // counts every single rotation performed

    static int height(Node n) { return (n == null) ? -1 : n.height; }

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
        if (node == null) return new Node(value);
        if (value < node.data) node.left = insert(node.left, value);
        else if (value > node.data) node.right = insert(node.right, value);
        else return node;

        updateHeight(node);
        int bf = balanceFactor(node);

        if (bf > 1 && value < node.left.data) return rightRotate(node);
        if (bf < -1 && value > node.right.data) return leftRotate(node);
        if (bf > 1 && value > node.left.data) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        if (bf < -1 && value < node.right.data) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        return node;
    }

    static Node minValueNode(Node node) {
        while (node.left != null) node = node.left;
        return node;
    }

    static Node delete(Node node, int value) {
        if (node == null) return null;

        if (value < node.data) {
            node.left = delete(node.left, value);
        } else if (value > node.data) {
            node.right = delete(node.right, value);
        } else {
            // node found - standard BST deletion first
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;

            Node successor = minValueNode(node.right);
            node.data = successor.data;
            node.right = delete(node.right, successor.data);
        }

        updateHeight(node);
        int bf = balanceFactor(node);

        // LL / LR cases (left-heavy after deletion)
        if (bf > 1 && balanceFactor(node.left) >= 0) return rightRotate(node);
        if (bf > 1 && balanceFactor(node.left) < 0) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        // RR / RL cases (right-heavy after deletion)
        if (bf < -1 && balanceFactor(node.right) <= 0) {
            return leftRotate(node);
        }
        if (bf < -1 && balanceFactor(node.right) > 0) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    static void inorder(Node node, StringBuilder sb) {
        if (node == null) return;
        inorder(node.left, sb);
        sb.append(node.data).append(" ");
        inorder(node.right, sb);
    }

    static String inorder(Node root) {
        StringBuilder sb = new StringBuilder();
        inorder(root, sb);
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        int[] values = {50, 30, 70, 20, 40, 60, 80, 10};
        Node root = null;
        for (int v : values) root = insert(root, v);

        System.out.println("Before delete(70): " + inorder(root));
        System.out.println("Root before: " + root.data
                + ", root's left child: " + root.left.data);

        int rotBefore = rotations;
        root = delete(root, 70);

        System.out.println("After  delete(70): " + inorder(root));
        System.out.println("Root after:  " + root.data
                + ", root's left child: " + root.left.data);
        System.out.println("Rotations triggered by delete(70): " + (rotations - rotBefore));
    }
}