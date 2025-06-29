package com.leon;

import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.concurrent.CompletableFuture;
import java.util.List;
import java.util.stream.Collectors;

// Given a list of fake e-commerce sites, simulate checking each for a product’s price using separate async calls. Combine the futures and return the minimum price.
//Key concepts: supplyAsync(), allOf(), result aggregation
public class PriceChecker
{
    public static void main(String... args)
    {
        List<CompletableFuture<Double>> futures = Arrays.asList(
            CompletableFuture.supplyAsync(() -> {
                sleep(5);
                return 5.0;
            }),
            CompletableFuture.supplyAsync(() -> {
                sleep(3);
                return 30.0;
            }),
            CompletableFuture.supplyAsync(() -> {
                sleep(4);
                return 20.0;
            }),
            CompletableFuture.supplyAsync(() -> {
                sleep(2);
                return 15.0;
            })
        );

        List<Double> results = CompletableFuture.allOf(futures.toArray(CompletableFuture[]::new))
                .thenApply(v -> futures.stream().map(CompletableFuture::join).collect(Collectors.toList())).join();

        DoubleSummaryStatistics res = results.stream().collect(Collectors.summarizingDouble(p -> p));
        System.out.println("Min price: " +  res.getMin());
    }

    private static void sleep(int seconds) {
        try
        {
            Thread.sleep(seconds * 1000);
        }
        catch(InterruptedException ie)
        {
            Thread.currentThread().interrupt();
        }
    }
}
