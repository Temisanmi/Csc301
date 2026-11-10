package module6;

import java.util.ArrayList;
import java.util.List;

public class Exercise5 {
    static class Node {
        int data;
        Node left, right;
        Node(int data) {
            this.data = data;
        }
    }

    static boolean isValidBST(Node node, Integer min, Integer max) {
        if (node == null) return true;

        if ((min != null && node.data <= min) || (max != null && node.data >= max)) {
            return false;
        }

        return isValidBST(node.left, min, node.data) && isValidBST(node.right, node.data, max);
    }

    static void inorder(Node node, List<Integer> list) {
        if (node == null) return;
        inorder(node.left, list);
        list.add(node.data);
        inorder(node.right, list);
    }

    static boolean isValidBSTInorder(Node root) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);

        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) <= list.get(i - 1)) {
                return false;
            }
        }
        return true;
    }

    static String listOf(Node root) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        return list.toString();
    }

    public static void main(String[] args) {
        Node invalidRoot = new Node(10);
        invalidRoot.left = new Node(5);
        invalidRoot.right = new Node(15);
        invalidRoot.right.left = new Node(6);
        invalidRoot.right.right = new Node(20);

        Node validRoot = new Node(10);
        validRoot.left = new Node(5);
        validRoot.right = new Node(15);
        validRoot.right.left = new Node(12);
        validRoot.right.right = new Node(20);

        boolean invRange = isValidBST(invalidRoot, null, null);
        boolean invInorder = isValidBSTInorder(invalidRoot);
        System.out.println("Invalid tree in-order list: " + listOf(invalidRoot));
        System.out.println("  range-based:     " + invRange);
        System.out.println("  traversal-based: " + invInorder);
        System.out.println("  methods agree:   " + (invRange == invInorder));
        System.out.println();

        boolean valRange = isValidBST(validRoot, null, null);
        boolean valInorder = isValidBSTInorder(validRoot);
        System.out.println("Valid tree in-order list:   " + listOf(validRoot));
        System.out.println("  range-based:     " + valRange);
        System.out.println("  traversal-based: " + valInorder);
        System.out.println("  methods agree:   " + (valRange == valInorder));
    }
}
