package module2;

public class Exercise5 {
    static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
        }
    }

    static Node buildList(int[] values) {
        Node head = null, tail = null;
        for (int v : values) {
            Node newNode = new Node(v);
            if (head == null) {
                head = newNode; tail = newNode;
            } else {
                tail.next = newNode; tail = newNode;
            }
        }
        return head;
    }

    static Node reverseInGroups(Node head, int k) {
        if (head == null || k <= 1) return head;   // nothing to reverse

        Node dummy = new Node(0);    // dummy simplifies updating the new head
        dummy.next = head;
        Node groupPrev = dummy;      // tail of the previous (already reversed) group
        Node curr = head;

        while (curr != null) {       // one iteration per group
            Node groupHead = curr;   // becomes the tail after reversal
            Node prev = null;
            int count = 0;

            // reverse up to k nodes (fewer if the list runs out)
            while (curr != null && count < k) {
                Node next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
                count++;
            }

            // prev = new head of this group, curr = first node of the next group
            groupPrev.next = prev;   // connect previous group to this one
            groupHead.next = curr;   // temporary link to the next group
            // (overwritten if that group gets reversed)
            groupPrev = groupHead;   // this group's tail is the next link point
        }
        return dummy.next;
    }

    static void print(Node head) {
        while (head != null) {
            System.out.print(head.data);
            if (head.next != null) System.out.print(" -> ");
            head = head.next;
        }
        System.out.println(" -> NULL");
    }

    public static void main(String[] args) {
        Node head = buildList(new int[]{1, 2, 3, 4, 5, 6, 7, 8});
        int k = 3;

        System.out.print("Before: "); print(head);

        head = reverseInGroups(head, k);

        System.out.print("After:  "); print(head);
    }
}
