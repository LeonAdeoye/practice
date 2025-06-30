package com.leon;

import java.time.LocalDateTime;
import java.util.PriorityQueue;
import java.util.Comparator;

public class OrderQueue
{
    private record Order(
            String orderId,
            double price,
            LocalDateTime timestamp) {}

    public static void main(String[] args) {
        Comparator<Order> orderComparator = Comparator
                .comparing(Order::price)
                .thenComparing(Order::timestamp).reversed();

        PriorityQueue<Order> queue = new PriorityQueue<>(orderComparator);

        queue.add(new Order("A1", 100.0, LocalDateTime.of(2023, 8, 1, 9, 0, 1)));
        queue.add(new Order("A2", 99.0, LocalDateTime.of(2023, 8, 1, 9, 0, 1))); // same time, lower price
        queue.add(new Order("A3", 101.0, LocalDateTime.of(2023, 8, 1, 8, 59, 59))); // earlier time
        queue.add(new Order("A4", 100.0, LocalDateTime.of(2023, 8, 1, 9, 0, 5)));

        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }
}

