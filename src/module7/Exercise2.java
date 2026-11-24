package module7;

public class Exercise2 {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    static Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        x.right = y;     // y becomes x's right child
        y.left = T2;     // y adopts x's old right subtree

        return x;        // x is the new subtree root
    }

    // Single LEFT rotation - fixes an RR (right-right) imbalance
    static Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        y.left = x;      // x becomes y's left child
        x.right = T2;    // x adopts y's old left subtree

        return y;
    }

    static void printPreorder(Node node, StringBuilder sb) {
        if (node == null) {
            return;
        }
        sb.append(node.data).append(" ");
        printPreorder(node.left, sb);
        printPreorder(node.right, sb);
    }

    // NEW: left, node, right
    static void printInorder(Node node, StringBuilder sb) {
        if (node == null) {
            return;
        }
        printInorder(node.left, sb);
        sb.append(node.data).append(" ");
        printInorder(node.right, sb);
    }

    static String preorder(Node root) {
        StringBuilder sb = new StringBuilder();
        printPreorder(root, sb);
        return sb.toString().trim();
    }

    static String inorder(Node root) {
        StringBuilder sb = new StringBuilder();
        printInorder(root, sb);
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        // ---- LL case: chain 30 -> 20 -> 10 ----
        Node llRoot = new Node(30);
        llRoot.left = new Node(20);
        llRoot.left.left = new Node(10);

        String llPreBefore = preorder(llRoot);
        String llInBefore = inorder(llRoot);
        System.out.println("LL before:               pre-order = " + llPreBefore
                + " | in-order = " + llInBefore);

        llRoot = rightRotate(llRoot);

        String llPreAfter = preorder(llRoot);
        String llInAfter = inorder(llRoot);
        System.out.println("LL after right-rotate:   pre-order = " + llPreAfter
                + " | in-order = " + llInAfter);
        System.out.println("LL in-order identical? " + llInBefore.equals(llInAfter));

        System.out.println();

        // ---- RR case: chain 10 -> 20 -> 30 ----
        Node rrRoot = new Node(10);
        rrRoot.right = new Node(20);
        rrRoot.right.right = new Node(30);

        String rrPreBefore = preorder(rrRoot);
        String rrInBefore = inorder(rrRoot);
        System.out.println("RR before:               pre-order = " + rrPreBefore
                + " | in-order = " + rrInBefore);

        rrRoot = leftRotate(rrRoot);

        String rrPreAfter = preorder(rrRoot);
        String rrInAfter = inorder(rrRoot);
        System.out.println("RR after left-rotate:    pre-order = " + rrPreAfter
                + " | in-order = " + rrInAfter);
        System.out.println("RR in-order identical? " + rrInBefore.equals(rrInAfter));
    }
}