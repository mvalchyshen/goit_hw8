package main.java.Collection;


import main.java.Interfaces.MyCollection;

import java.util.NoSuchElementException;

public class Stack implements MyCollection {

    private Node first;
    private Node last;
    private int size;

    public void push(Object value) {
        if (size == 0) {
            first = last = new Node(value);
        } else {
            Node x = first;
            first = new Node(value);
            first.next = x;
        }
        size++;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void remove(int index) {
        if (index > size) {
            throw new NoSuchElementException();
        }
        Node delete;
        if (index == 0) {
            delete = nodeIndex(0);
            first = delete.next;
            delete.element = null;
        } else {
            delete = nodeIndex(index);
            Node prev = nodeIndex(index - 1);
            prev.next = delete.next;
            delete.element = null;
        }
        size--;
    }


    private Node nodeIndex(int index) {
        Node cur = first;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur;
    }

    @Override
    public void clear() {
        Node cur = first;
        first = last = null;
        while (cur != null) {
            Node next = cur.next;
            cur.element = null;
            cur.next = null;
            cur = next;
        }
        size = 0;
    }

    public Object peek() {
        if (size == 0) {
            return null;
        }
        return first.element;
    }

    public Object pop() {
        Node x = first;
        first = x.next;
        size--;
        return x.element;
    }

    private static class Node {
        Node next;
        Object element;

        public Node(Node next, Object element) {
            this.next = next;
            this.element = element;
        }

        public Node(Object element) {
            this.element = element;
        }

        @Override
        public String toString() {
            return "[" + element + "]";
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node cur = first;
        while (cur != null) {
            sb.append(cur.element);
            if (cur.next != null) {
                sb.append(", ");
            }
            cur = cur.next;
        }
        return sb.append("]").toString();
    }
}
