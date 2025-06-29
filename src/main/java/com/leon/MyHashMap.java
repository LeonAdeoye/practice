package com.leon;

import java.util.LinkedList;
public class MyHashMap<T,R> {
    private static final int SIZE = 16; // Number of buckets
    private LinkedList<Entry>[] buckets;

    public MyHashMap() {
        buckets = new LinkedList[SIZE];
        for (int i = 0; i < SIZE; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    private class Entry {
        T key;
        R value;

        Entry(T key, R value) {
            this.key = key;
            this.value = value;
        }
    }

    private int hash(T key) {
        return Math.abs(key.hashCode() % SIZE);
    }

    public void put(T key, R value) {
        int index = hash(key);
        for (Entry entry : buckets[index]) {
            if (entry.key.equals(key)) {
                entry.value = value; // Update existing key
                return;
            }
        }
        buckets[index].add(new Entry(key, value)); // New entry
    }

    public R get(T key) {
        int index = hash(key);
        for (Entry entry : buckets[index]) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }
        return null; // Not found
    }

    public boolean containsKey(T key) {
        return get(key) != null;
    }

    public void remove(T key) {
        int index = hash(key);
        buckets[index].removeIf(entry -> entry.key.equals(key));
    }

    public static void main(String[] args) {
        MyHashMap<String, Integer> map = new MyHashMap();
        map.put("apple", 10);
        map.put("banana", 20);
        map.put("apple", 15); // Updates the value

        System.out.println("apple: " + map.get("apple"));   // 15
        System.out.println("banana: " + map.get("banana")); // 20
        System.out.println("kiwi: " + map.get("kiwi"));     // null

        map.remove("banana");
        System.out.println("banana exists? " + map.containsKey("banana")); // false
    }
}
