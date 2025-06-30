package com.leon;

import java.util.*;

class Order {
    enum Type { BUY, SELL }
    Type type;
    int price;
    int quantity;
    long timestamp;

    public int getPrice()
    {
        return price;
    }

    public long getTimestamp()
    {
        return timestamp;
    }


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

    // In a buy order book, you usually want higher-priced orders to have higher priority—since buyers who are willing to pay more should get filled first.
    // For buy orders, we use .reversed() on the price comparator. This turns the ascending price comparison (lowest to highest) into descending order (highest to lowest), which aligns with how a buy-side priority queue should work.
    Comparator<Order> buyOrderComparator = Comparator
            .comparingInt(Order::getPrice).reversed()
            .thenComparingLong(Order::getTimestamp);
    // By contrast, sell orders, the lowest price is the most attractive to buyers, so the natural ascending order (without reversed()) works just fine.
    Comparator<Order> sellOrderComparator = Comparator
            .comparingInt(Order::getPrice)
            .thenComparingLong(Order::getTimestamp);

    private PriorityQueue<Order> buyOrders = new PriorityQueue<>(buyOrderComparator);

    private PriorityQueue<Order> sellOrders = new PriorityQueue<>(sellOrderComparator);

    public void placeOrder(Order order) {
        if (order.type == Order.Type.BUY) {
            matchOrder(order, sellOrders, buyOrders, true);
        } else {
            matchOrder(order, buyOrders, sellOrders, false);
        }
    }

    private void matchOrder(Order incoming, PriorityQueue<Order> oppositeQueue, PriorityQueue<Order> sameQueue, boolean isBuy) {
        while(!oppositeQueue.isEmpty() && incoming.quantity > 0)
        {
            Order match = oppositeQueue.peek();
            boolean canTrade = isBuy ? incoming.price >= match.price : incoming.price <= match.price;
            if(canTrade)
            {
                int tradeQty = Math.min(incoming.quantity, match.quantity);
                incoming.quantity -= tradeQty;
                match.quantity -= tradeQty;
            }
            else
                break;
        }
        if(incoming.quantity > 0)
            sameQueue.add(incoming);
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
