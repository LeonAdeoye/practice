package com.leon;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.TemporalUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.LongSummaryStatistics;
import java.util.Random;
import java.util.stream.Collectors;

// Given a list of timestamps for order sent and order acknowledged, compute average and max latency.
public class Latency {
    private record Order(int id, LocalDateTime sendTime, LocalDateTime ackTime) {}

    public static int getRandomSeconds(int start, int end)
    {
        Random rand = new Random();
        return rand.nextInt(end-start) + start;
    }

    public static void main (String... args) {
        List<Order> orders = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            orders.add(new Order(i, LocalDateTime.now().plusSeconds(i), LocalDateTime.now().plusSeconds(getRandomSeconds(10, 20) + i)));
        }

        orders.forEach(System.out::println);

        List<Long> durations = orders.stream().map(order -> Duration.between(order.sendTime(), order.ackTime()).getSeconds()).collect(Collectors.toList());

        System.out.println(durations);

        System.out.println("Avg: " + durations.stream().collect(Collectors.summarizingLong(p -> p)).getAverage());
        System.out.println("Max: " + durations.stream().collect(Collectors.summarizingLong(p -> p)).getMax());
        System.out.println("Sum: " + durations.stream().collect(Collectors.summarizingLong(p -> p)).getSum());
        System.out.println("Count: " + durations.stream().collect(Collectors.summarizingLong(p -> p)).getCount());

        LongSummaryStatistics stats = durations.stream().collect(Collectors.summarizingLong(p -> p));
        System.out.println("Average latency: " + stats.getAverage() + " seconds");
        System.out.println("Max latency: " + stats.getMax() + " seconds");
    }

}
