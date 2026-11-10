package module2;

import java.util.PriorityQueue;

public class Exercise4 {
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
            }
            else {
                tail.next = newNode; tail = newNode;
            }
        }
        return head;
    }

    static Node merge(Node a, Node b) {
        Node dummy = new Node(0);   // dummy node simplifies edge cases
        Node tail = dummy;

        while (a != null && b != null) {
            if (a.data <= b.data) {
                tail.next = a; a = a.next;
            }
            else {
                tail.next = b; b = b.next;
            }
            tail = tail.next;
        }
        tail.next = (a != null) ? a : b;  // attach whichever list remains

        return dummy.next;
    }

    static Node mergeK(Node[] lists) {
        if (lists == null || lists.length == 0) return null;

        PriorityQueue<Node> heap = new PriorityQueue<>((x, y) -> Integer.compare(x.data, y.data));

        // Seed the heap with the head of every non-empty list
        for (Node head : lists) {
            if (head != null) heap.add(head);
        }

        Node dummy = new Node(0);
        Node tail = dummy;

        while (!heap.isEmpty()) {
            Node smallest = heap.poll();   // smallest node among all heads
            tail.next = smallest;
            tail = smallest;

            if (smallest.next != null) {
                heap.add(smallest.next);   // next candidate from that list
            }
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
        Node list1 = buildList(new int[]{1, 4, 7});
        Node list2 = buildList(new int[]{2, 5, 8});
        Node list3 = buildList(new int[]{0, 3, 6, 9});
        Node list4 = null;   // empty list, handled safely

        // Print before merging, since merging relinks the nodes in place
        System.out.print("List 1: "); print(list1);
        System.out.print("List 2: "); print(list2);
        System.out.print("List 3: "); print(list3);

        Node[] lists = { list1, list2, list3, list4 };
        Node merged = mergeK(lists);

        System.out.print("Merged: "); print(merged);
    }
}
