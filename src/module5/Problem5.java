package module5;

public class Problem5 {
    static class Entry {
        String key;
        int value;
        Entry next;
        Entry(String key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Entry[] buckets;
    private int numBuckets;
    private int size;

    Problem5(int numBuckets) {
        this.numBuckets = numBuckets;
        this.buckets = new Entry[numBuckets];
        this.size = 0;
    }

    // maps any key to a valid bucket index
    private int getBucketIndex(String key) {
        return Math.abs(key.hashCode()) % numBuckets;
    }

    void put(String key, int value) {
        int index = getBucketIndex(key);
        Entry head = buckets[index];

        // if the key already exists in this chain, update it
        Entry current = head;
        while (current != null) {
            if (current.key.equals(key)) {
                current.value = value;
                return;
            }
            current = current.next;
        }

        // otherwise insert a new entry at the head of the chain
        Entry newEntry = new Entry(key, value);
        newEntry.next = head;
        buckets[index] = newEntry;
        size++;
    }

    Integer get(String key) {
        int index = getBucketIndex(key);
        Entry current = buckets[index];

        while (current != null) {
            if (current.key.equals(key)) return current.value;
            current = current.next;
        }
        return null;   // key not found
    }

    boolean remove(String key) {
        int index = getBucketIndex(key);
        Entry current = buckets[index];
        Entry prev = null;

        while (current != null) {
            if (current.key.equals(key)) {
                if (prev == null) buckets[index] = current.next;
                else prev.next = current.next;
                size--;
                return true;
            }
            prev = current;
            current = current.next;
        }
        return false;
    }

    int size() { return size; }

    void printTable() {
        for (int i = 0; i < numBuckets; i++) {
            System.out.print("bucket " + i + ": ");
            Entry current = buckets[i];
            if (current == null) System.out.print("null");
            while (current != null) {
                System.out.print(current.key + ":" + current.value);
                if (current.next != null) System.out.print(" -> ");
                current = current.next;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Problem5 map = new Problem5(5);

        map.put("apple", 3);
        map.put("pear", 7);
        map.put("plum", 2);
        map.put("fig", 5);

        map.printTable();

        System.out.println("get(\"plum\") = " + map.get("plum"));
        System.out.println("get(\"mango\") = " + map.get("mango"));

        map.put("apple", 10);    // update existing key
        System.out.println("after update, apple = " + map.get("apple"));

        System.out.println("remove(\"pear\") = " + map.remove("pear"));
        System.out.println("size = " + map.size());
    }
}
