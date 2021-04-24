package main.java;

import java.util.NoSuchElementException;

public class MyArrayList implements MyList{
    private static final int INITIAL_CAPACITY = 10;
    private int size;
    private Object[] array;

    public MyArrayList() {
        array = new Object[INITIAL_CAPACITY];
        size = 0;
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
        int newSize = size - 1;
        if (newSize > index) {
            System.arraycopy(array, index + 1, array, index, newSize - index);
        }
        array[size = newSize] = null;
    }

    @Override
    public void clear() {
        for (int i = 0; i < array.length; i++) {
            array[i] = null;
        }
        size = 0;
    }

    @Override
    public void add(Object value) {
        if (size >= array.length) {
            resize();
        }
        if (value == null) {
            array[size] = null;
        } else {
            array[size] = value;
        }
        size++;
    }

    private void resize() {
        Object[] newArray = new Object[array.length * 2];
        System.arraycopy(array, 0, newArray, 0, array.length);
        array = newArray;
    }

    @Override
    public Object get(int index) {
        if (index > size) {
            throw new NoSuchElementException();
        }
        return array[index];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(array[i]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
