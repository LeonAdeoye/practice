package com.leon;

import java.util.*;

class Order {
    enum Type { BUY, SELL }
    Type type;
    int price;
    int quantity;
    long timestamp;

    public Order(Type type, int price, int quantity, long timestamp) {
        this.type = type;
        this.price = price;
        this.quantity = quantity;
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return type + " " + quantity + " @ " + price + " (ts: " + timestamp + ")";
    }
}

class OrderBook {

    private PriorityQueue<Order> buyOrders = new PriorityQueue<>(
            (a, b) -> a.price != b.price ? Integer.compare(b.price, a.price) : Long.compare(a.timestamp, b.timestamp)
    );

    private PriorityQueue<Order> sellOrders = new PriorityQueue<>(
            (a, b) -> a.price != b.price ? Integer.compare(a.price, b.price) : Long.compare(a.timestamp, b.timestamp)
    );

    public void placeOrder(Order order) {
        if (order.type == Order.Type.BUY) {
            matchOrder(order, sellOrders, buyOrders, true);
        } else {
            matchOrder(order, buyOrders, sellOrders, false);
        }
    }

    private void matchOrder(Order incoming, PriorityQueue<Order> oppositeQueue, PriorityQueue<Order> sameQueue, boolean isBuy) {
        while (!oppositeQueue.isEmpty() && incoming.quantity > 0) {
            Order bestMatch = oppositeQueue.peek();
            boolean canTrade = isBuy ? incoming.price >= bestMatch.price : incoming.price <= bestMatch.price;

            if (canTrade) {
                int tradeQty = Math.min(incoming.quantity, bestMatch.quantity);
                System.out.println("Trade executed: " + tradeQty + " @ " + bestMatch.price);

                incoming.quantity -= tradeQty;
                bestMatch.quantity -= tradeQty;

                if (bestMatch.quantity == 0) {
                    oppositeQueue.poll();
                }
            } else {
                break;
            }
        }

        if (incoming.quantity > 0) {
            sameQueue.add(incoming);
        }
    }

    public void printOrderBook() {
        System.out.println("Buy Orders:");
        buyOrders.forEach(System.out::println);

        System.out.println("Sell Orders:");
        sellOrders.forEach(System.out::println);
    }

    public static void main(String[] args) throws InterruptedException {
        OrderBook book = new OrderBook();

        book.placeOrder(new Order(Order.Type.BUY, 100, 10, System.nanoTime()));
        Thread.sleep(1); // Simulate time delay
        book.placeOrder(new Order(Order.Type.SELL, 95, 5, System.nanoTime()));
        Thread.sleep(1);
        book.placeOrder(new Order(Order.Type.SELL, 100, 10, System.nanoTime()));

        System.out.println("Final Order Book:");
        book.printOrderBook();
    }
}
