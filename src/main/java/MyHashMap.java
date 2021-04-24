package main.java;

import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.StringJoiner;

public class MyHashMap implements MyCollection {
    private static final int INITIAL_CAPACITY = 16;
    private static final float INITIAL_LOAD_FACTOR = 0.75f;
    private Node[] table;
    private int threshold;
    private int size;

    public MyHashMap() {
        table = new Node[INITIAL_CAPACITY];
        threshold = (int) (INITIAL_CAPACITY * INITIAL_LOAD_FACTOR);
        size = 0;
    }

    public void put(Object key, Object value) {
        int index = indexOf(hash(key), table.length);
        putVal(hash(key), index, key, value);
    }

    private int indexOf(int hash, int length) {
        return hash & (length - 1);
    }

    private void putVal(int hash, int index, Object key, Object value) {
        Node newNode = new Node(hash, key, value, null);
        Node current = table[index];
        if (current == null) {
            table[index] = newNode;
        } else {
            while (current != null) {
                if (current.hash == hash && Objects.equals(key, current.key)) {
                    current.value = value;
                } else if (current.next == null) {
                    current.next = newNode;
                }
                current = current.next;
            }
        }
        if (++size > threshold) {
            resize();
        }
    }

    private void resize() {
        Node[] oldTab = table;
        int newCap = oldTab.length * 2;
        int newThr = threshold * 2;
        Node[] newTab = new Node[newCap];
        System.arraycopy(table, 0, newTab, 0, oldTab.length);
        threshold = newThr;
        table = newTab;
    }

    private int hash(Object key) {
        int h;
        return (key == null) ? 0 : ((h = key.hashCode()) ^ (h >>> 16));
    }

    public Object get(Object key) {
        int index = indexOf(hash(key), table.length);
        Node current = table[index];
        while (current != null) {
            if (current.hash == hash(key) && Objects.equals(key, current.key)) {
                return current.value;
            }
            current = current.next;
        }
        return -1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void remove(int index) {
        remove(index);
    }

    public void remove(Object key) {
        int index = indexOf(hash(key), table.length);
        if (index > size) {
            throw new NoSuchElementException();
        }
        Node current = table[index];
        Node previous = null;
        while (current != null) {
            if (current.hash == hash(key) && Objects.equals(key, current.key)) {
                if (previous == null) {
                    table[index] = table[index].next;
                } else {
                    previous.next = current.next;
                }
            }
            previous = current;
            current = current.next;
        }
        size--;
    }

    @Override
    public void clear() {
        Node[] tab;
        if ((tab = table) != null && size !=0) {
            for (int i = 0; i < tab.length; i++) {
                tab[i] = null;
            }
            size = 0;
        }
    }

    @Override
    public String toString() {
        String begining = "MyHashMap{" +
                "size=" + size + ", nodes: [";
        StringJoiner joiner = new StringJoiner(", ", begining, "]}");
        for (Node node : table) {
            if (node == null) {
                //joiner.add("null");
            } else {
                joiner.add(node.toString());
                while (node.next != null) {
                    node = node.next;
                    joiner.add(node.toString());
                }
            }

        }

        return joiner.toString();
    }

    private static class Node {
        int hash;
        Node next;
        Object key;
        Object value;

        public Node(int hash, Object key, Object value, Node next) {
            this.hash = hash;
            this.next = next;
            this.key = key;
            this.value = value;
        }

        public Node(Object key, Object value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return key + "=" + value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return Objects.equals(key, node.getKey()) && Objects.equals(value, node.getValue());
        }

        @Override
        public int hashCode() {
            return Objects.hash(key) ^ Objects.hashCode(value);
        }

        public Object getKey() {
            return key;
        }

        public Object getValue() {
            return value;
        }
    }

}
