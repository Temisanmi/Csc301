package module2;

public class Exercise1 {
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
            head = newNode;
            return;
        }

        Node temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
    }

    static void traverse() {
        Node temp = head;
        int count = 0;

        System.out.print("List: ");

        while (temp != null) {
            System.out.print(temp.data);

            if (temp.next != null) {
                System.out.print(" -> ");
            }

            temp = temp.next;
            count++;
        }
        System.out.println(" -> NULL");
        System.out.println("Total number of nodes: " + count);
    }

    static int search(int target) {
        Node temp = head;
        int position = 0;

        while (temp != null) {

            if (temp.data == target) {
                return position;
            }

            temp = temp.next;
            position++;
        }
        return -1;
    }

    public static void main(String[] args) {
        insertAtEnd(10);
        insertAtEnd(25);
        insertAtEnd(40);
        insertAtEnd(55);

        traverse();

        int target = 40;
        int position = search(target);

        System.out.println("Position of " + target + ": " + position);

        int missingTarget = 100;
        System.out.println("Position of " + missingTarget + ": " + search(missingTarget));
    }
}
