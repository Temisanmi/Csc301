package module2;

public class Exercise2 {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    static Node head;

    static void insertAtEnd(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode; return;
        }
        Node temp = head;
        while (temp.next != null) temp = temp.next;
        temp.next = newNode;
    }

    static void reverse() {
        head = reverseRecursive(head);
    }

    private static Node reverseRecursive(Node node) {
        // Base case: empty list or reached the last node (new head)
        if (node == null || node.next == null) {
            return node;
        }

        // Recurse to the end; newHead is the old tail
        Node newHead = reverseRecursive(node.next);

        // On the way back: make the next node point back to this one
        node.next.next = node;

        // Break the old forward link (this becomes the tail, or gets
        // overwritten by the caller above it)
        node.next = null;

        return newHead; // old tail stays the head all the way up
    }

    static void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data);
            if (temp.next != null) System.out.print(" -> ");
            temp = temp.next;
        }
        System.out.println(" -> NULL");
    }

    public static void main(String[] args) {
        insertAtEnd(10);
        insertAtEnd(20);
        insertAtEnd(30);
        insertAtEnd(40);

        System.out.print("Before: ");
        print();

        reverse();

        System.out.print("After: ");
        print();
    }
}
