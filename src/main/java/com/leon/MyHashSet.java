package com.leon;

import java.util.LinkedList;

public class MyHashSet {
    private static final int SIZE = 16;
    private LinkedList<String>[] buckets;

    public MyHashSet() {
        buckets = new LinkedList[SIZE];
        for (int i = 0; i < SIZE; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    private int hash(String key) {
        return Math.abs(key.hashCode() % SIZE);
    }

    public void add(String key) {
        int index = hash(key);
        if (!buckets[index].contains(key)) {
            buckets[index].add(key);
        }
    }

    public boolean contains(String key) {
        int index = hash(key);
        return buckets[index].contains(key);
    }

    public void remove(String key) {
        int index = hash(key);
        buckets[index].remove(key);
    }

    public void printAll() {
        for (int i = 0; i < SIZE; i++) {
            for (String key : buckets[i]) {
                System.out.print(key + " ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MyHashSet set = new MyHashSet();

        set.add("apple");
        set.add("banana");
        set.add("orange");

        System.out.println("Contains banana? " + set.contains("banana")); // true
        set.remove("banana");
        System.out.println("Contains banana after removal? " + set.contains("banana")); // false

        System.out.print("Current elements: ");
        set.printAll();
    }
}