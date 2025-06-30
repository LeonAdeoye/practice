package com.leon;

import java.util.HashMap;
import java.util.Map;

//Given a list of current holdings and target allocations, calculate the buy/sell quantities needed to rebalance.
public class Rebalance {

    public static void main(String... args)
    {
        Map<String, Integer> holdings = new HashMap<>();
        holdings.put("0001.HK", 190);
        holdings.put("0005.HK", 100);
        holdings.put("8604.T", 110);
        holdings.put("8602.T", 70);

        Map<String, Integer> allocations = new HashMap<>();
        allocations.put("0001.HK", 100);
        allocations.put("0005.HK", 100);
        allocations.put("8604.T", 100);
        allocations.put("8602.T", 100);

        allocations.forEach((allocation_symbol, allocation_quantity) ->
        {
            if(holdings.containsKey(allocation_symbol))
            {
                int rebalance = allocation_quantity - holdings.get(allocation_symbol);

                if(rebalance > 0)
                    System.out.println("Buy " + rebalance + " of stock: " + allocation_symbol);
                else if(rebalance < 0)
                    System.out.println("Sell " + Math.abs(rebalance) + " of stock: " + allocation_symbol);
            }
            else
                System.out.println("Buy " + allocation_quantity + " of stock: " + allocation_symbol);
        });
    }
}
