package main.java.Collection;


import main.java.Interfaces.MyCollection;

import java.util.NoSuchElementException;

public class Stack implements MyCollection {

    private Node head;
    private Node tail;
    private int size;

    public void push(Object value) {
        Node node = new Node(value);
        if (size == 0) {
            head = tail = node;
        } else {
            Node x = head;
            head = node;
            node.next = x;
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
            head = delete.next;
            delete.element = null;
            delete.next = null;
        } else {
            delete = nodeIndex(index);
            Node prev = nodeIndex(index - 1);
            prev.next = delete.next;
            delete.element = null;
            delete.next = null;
        }
        size--;
    }


    private Node nodeIndex(int index) {
        Node cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur;
    }

    @Override
    public void clear() {
        Node cur = head;
        head = tail = null;
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
        return head.element;
    }

    public Object pop() {
        Node x = head;
        head = x.next;
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
        Node cur = head;
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
