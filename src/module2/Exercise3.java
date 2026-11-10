package module2;

public class Exercise3 {
    static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
        }
    }

    static boolean hasCycle(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;          // moves 1 step
            fast = fast.next.next;     // moves 2 steps
            if (slow == fast) return true;  // pointers met -> cycle exists
        }
        return false;   // fast reached NULL -> no cycle
    }

    static Node findCycleStart(Node head) {
        Node slow = head;
        Node fast = head;

        // Phase 1: detect the cycle (find the meeting point)
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                // Phase 2: reset one pointer to head, move both 1 step at a time
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;   // the node where the cycle begins
            }
        }
        return null;   // no cycle
    }

    public static void main(String[] args) {
        // Build list: 10 -> 20 -> 30 -> 40 -> 50 -> 60 -> 70 -> (back to 40)
        Node n10 = new Node(10);
        Node n20 = new Node(20);
        Node n30 = new Node(30);
        Node n40 = new Node(40);
        Node n50 = new Node(50);
        Node n60 = new Node(60);
        Node n70 = new Node(70);

        n10.next = n20;
        n20.next = n30;
        n30.next = n40;
        n40.next = n50;
        n50.next = n60;
        n60.next = n70;
        n70.next = n40;   // creates the cycle

        System.out.println("List has cycle: " + hasCycle(n10));

        Node start = findCycleStart(n10);
        System.out.println("Cycle starts at node: " + (start != null ? start.data : "none"));

        // A separate, cycle-free list for comparison
        Node a = new Node(1);
        a.next = new Node(2);
        a.next.next = new Node(3);
        System.out.println("Cycle-free list has cycle: " + hasCycle(a));

        Node noStart = findCycleStart(a);
        System.out.println("Cycle-free list cycle start: " + (noStart != null ? noStart.data : "none"));
    }
}
