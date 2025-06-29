package com.leon;

import java.util.ArrayList;

public class MyPriorityQueue<T> {
    private static class Node<T> {
        T value;
        int priority;

        Node(T value, int priority) {
            this.value = value;
            this.priority = priority;
        }
    }

    private ArrayList<Node<T>> heap = new ArrayList<>();

    public void add(T value, int priority) {
        heap.add(new Node<>(value, priority));
        bubbleUp();
    }

    public T poll() {
        if (heap.isEmpty()) return null;
        T result = heap.get(0).value;
        swap(0, heap.size() - 1);
        heap.remove(heap.size() - 1);
        bubbleDown();
        return result;
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    private void bubbleUp() {
        int index = heap.size() - 1;
        while (index > 0) {
            int parent = (index - 1) / 2;
            if (heap.get(index).priority >= heap.get(parent).priority) break;
            swap(index, parent);
            index = parent;
        }
    }

    private void bubbleDown() {
        int index = 0;
        int size = heap.size();
        while (true) {
            int left = 2 * index + 1;
            int right = 2 * index + 2;
            int smallest = index;

            if (left < size && heap.get(left).priority < heap.get(smallest).priority) {
                smallest = left;
            }
            if (right < size && heap.get(right).priority < heap.get(smallest).priority) {
                smallest = right;
            }
            if (smallest == index) break;
            swap(index, smallest);
            index = smallest;
        }
    }

    private void swap(int i, int j) {
        Node<T> temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    public static void main(String[] args) {
        MyPriorityQueue<String> queue = new MyPriorityQueue<>();
        queue.add("Low-priority", 5);
        queue.add("Top-priority", 1);
        queue.add("Mid-priority", 3);

        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }
}