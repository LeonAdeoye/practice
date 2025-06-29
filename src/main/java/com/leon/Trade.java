package com.leon;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// Given a list of trade orders (price, quantity), group them by price and return the total quantity per price level.

public class Trade {
    private record TradeRec(Double price, Integer quantity) {}
    public static void main(String... args)
    {
        List<TradeRec> trades = Arrays.asList(new TradeRec(10.0, 500), new TradeRec(10.0, 100), new TradeRec(5.7, 10000), new TradeRec(5.7, 15700));
        Map<Double, Integer> totals = trades.stream().collect(Collectors.groupingBy(TradeRec::price, Collectors.summingInt(TradeRec::quantity)));
        totals.forEach((key, val) -> System.out.println("Price: " + key + " with total: " + val));
    }
}
