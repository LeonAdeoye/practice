package com.leon;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.List;

// Given arrays of current stock and minimum required stock, return a list of items that need restocking.
public class StockFiller {
    public static void main(String[] args)
    {
        int[] currentStocks = {10, 20, 13, 16, 18, 19, 5, 17, 14, 3};
        int[] minimumStocks = {20, 30, 10, 10, 15, 20, 10, 15, 10, 15};
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < currentStocks.length; i++)
        {
            if(currentStocks[i] < minimumStocks[i])
            {
                if(builder.length() > 0)
                    builder.append(", ");
                builder.append(i);
            }
        }

        System.out.println(builder);

        List<Integer> stocks = IntStream.range(0, currentStocks.length)
                .filter(index -> currentStocks[index] < minimumStocks[index])
                .boxed()
                .collect(Collectors.toList());

        System.out.println(stocks);
    }
}
