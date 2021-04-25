package main.java.Collection;

import main.java.Interfaces.MyList;

public class MyQueue implements MyList {

    private MyLinkedList list = new MyLinkedList();

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public void remove(int index) {
        list.remove(index);
    }

    @Override
    public void clear() {
        list.clear();
    }

    @Override
    public void add(Object value) {
        list.add(value);
    }

    @Override
    public Object get(int index) {
        return list.get(index);
    }

    public Object peek() {
        return list.get(0);
    }

    public Object poll() {
        Object x = list.get(0);
        list.remove(0);
        return x;
    }

    @Override
    public String toString() {
        return list.toString();
    }
}
