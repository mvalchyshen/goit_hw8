package main.java.Collection;


import main.java.Interfaces.MyList;

import java.util.NoSuchElementException;

public class MyLinkedList implements MyList {
    private MyNode head;
    private MyNode tail;
    private int size;

    @Override
    public int size() {
        return size;
    }

    @Override
    public void remove(int index) {
        if (index > size) {
            throw new NoSuchElementException();
        }
        delete(myNode(index));
    }

    private void delete(MyNode myNode) {
        MyNode prev = myNode.prev;
        MyNode next = myNode.next;
        if (prev == null) {
            head = next;
        } else {
            prev.next = next;
            myNode.prev = null;
        }
        if (next == null) {
            tail = prev;
        } else {
            next.prev = prev;
            myNode.next = null;
        }
        myNode.item = null;
        size--;
    }

    @Override
    public void clear() {
        MyNode cur = head;
        while (cur != null) {
            MyNode next = cur.next;
            cur.item = null;
            cur.prev = null;
            cur.next = null;
            cur = next;
        }
        size = 0;
    }

    @Override
    public void add(Object value) {
        if (size == 0) {
            addFirst(value);
        } else {
            addLast(value);
        }
    }


    private void addFirst(Object value) {
        MyNode current = head;
        MyNode node = new MyNode(null, value, current);
        head = node;
        if (current == null) {
            tail = node;
        } else {
            current.prev = node;
        }
        size++;
    }

    private void addLast(Object value) {
        MyNode current = tail;
        MyNode node = new MyNode(current, value, null);
        current.next = node;
        tail = node;
        size++;
    }

    @Override
    public Object get(int index) {
        if (index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            return head.item;
        }
        if (index == size - 1) {
            return tail.item;
        }
        return myNode(index).item;
    }

    private MyNode myNode(int index) {
        MyNode cur;
        if (index < size / 2) {
            cur = head;
            for (int i = 0; i < index; i++) {
                cur = cur.next;
            }
        } else {
            cur = tail;
            for (int i = size - 1; i < index; i--) {
                cur = cur.prev;
            }
        }
        return cur;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        MyNode x = head;
        while (x != null) {
            sb.append(x.item);
            if (x.next != null) {
                sb.append(", ");
            }
            x = x.next;

        }
        return sb.append("]").toString();
    }

    private static class MyNode {
        Object item;
        MyNode next;
        MyNode prev;

        public MyNode(MyNode prev, Object item, MyNode next) {
            this.prev = prev;
            this.next = next;
            this.item = item;
        }

        public MyNode(Object item) {
            this.item = item;
        }

        @Override
        public String toString() {
            return "{" +
                    "item=" + item +
                    '}';
        }
    }
}
