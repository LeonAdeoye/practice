package com.leon;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

// Write a method that takes a list of integers and returns a CompletableFuture for each that computes the factorial in a separate thread. Once all futures complete, combine the results into a list.
public class Factorial
{
    public static void main(String... args)
    {
        List<Integer> numbers = Arrays.asList(9, 5, 4, 2, 6, 8, 1);

        List<CompletableFuture<Integer>> futList = numbers.stream().map(number -> CompletableFuture.supplyAsync(() -> calculate(number))).collect(Collectors.toList());
        CompletableFuture.allOf(futList.toArray(CompletableFuture[]::new)).join();
        List<Integer> results = futList.stream().map(CompletableFuture::join).toList();
        System.out.println("Recursive factorials: " + results);

        List<CompletableFuture<Integer>> futList2 = numbers.stream().map(number -> CompletableFuture.supplyAsync(() -> calculateFactorial(number))).collect(Collectors.toList());
        CompletableFuture.allOf(futList2.toArray(CompletableFuture[]::new)).thenApply(v -> futList2.stream().map(CompletableFuture::join).toList()).thenAccept(list -> System.out.println("Iterative factorials: " + list));
    }

    private static int calculateFactorial(int number)
    {
        int factorial = 1;
        while(number > 1)
        {
            factorial *= number--;
        }
        return factorial;
    }

    public static int calculate(int number)
    {
        return number == 1 ? 1 : number * calculate(number - 1);
    }
}
