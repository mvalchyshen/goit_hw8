package main.java;

import main.java.Collection.MyArrayList;
import main.java.Collection.MyHashMap;
import main.java.Collection.MyLinkedList;
import main.java.Collection.Stack;

public class Demo {
    public static void main(String[] args) {
        MyArrayList arrayList = new MyArrayList();
        for (int i = 0; i < 10; i++) {
            arrayList.add(i);
        }
        arrayList.add(null);
        System.out.println("arrayList : \n" + arrayList + "\n" +
                "size : " + arrayList.size());
        System.out.println("Tenth element : " + arrayList.get(10));
        arrayList.remove(10);
        System.out.println("arrayList : \n" + arrayList + "\n" +
                "size : " + arrayList.size());
        arrayList.clear();
        System.out.println("arrayList : \n" + arrayList + "\n" +
                "size : " + arrayList.size());

        Stack stack = new Stack();
        for (int i = 0; i < 10; i++) {
            stack.push(i);
        }
        System.out.println("---------------------------\n" +
                "stack : \n" + stack + "\n" +
                "size : " + stack.size() +
                "first element : " + stack.peek() +
                "\n---------------------------");
        stack.remove(0);
        System.out.println("---------------------------\n" +
                "stack : \n" + stack + "\n" +
                "size : " + stack.size() +
                "first element : " + stack.peek() +
                "\n---------------------------");
        stack.remove(4);
        System.out.println("---------------------------\n" +
                "stack : \n" + stack + "\n" +
                "size : " + stack.size() +
                "first element : " + stack.peek() +
                "\n---------------------------");
        stack.remove(2);
        System.out.println("---------------------------\n" +
                "stack : \n" + stack + "\n" +
                "size : " + stack.size() +
                "first element : " + stack.peek() +
                "\n---------------------------");
        for (int i = 0; i < 3; i++) {
            stack.pop();
            System.out.println("---------------------------\n" +
                    "stack : \n" + stack + "\n" +
                    "size : " + stack.size() +
                    "first element : " + stack.peek() +
                    "\n---------------------------");
        }
        System.out.println("---------------------------\n" +
                "stack : \n" + stack + "\n" +
                "size : " + stack.size() +
                "first element : " + stack.peek() +
                "\n---------------------------");
        stack.clear();
        System.out.println("---------------------------\n" +
                "stack : \n" + stack + "\n" +
                "size : " + stack.size() +
                "first element : " + stack.peek() +
                "\n---------------------------");

        MyLinkedList queue = new MyLinkedList();
        for (int i = 0; i < 10; i++) {
            queue.add(i);
        }
        queue.add(null);
        System.out.println("Queue : \n" +
                queue + "\nsize: " + queue.size());

        MyHashMap hashMap = new MyHashMap();
        for (int i = 0; i < 20; i++) {
            hashMap.put("i"+i,i);
        }
        System.out.println(hashMap);
        System.out.println(hashMap.get("i19"));
        System.out.println(hashMap.get("i21"));
        hashMap.remove("i19");
        System.out.println(hashMap);
        hashMap.clear();
        System.out.println(hashMap);
    }
}
