package com.leon;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

//Create a CompletableFuture that simulates a long-running task (sleep for 3 seconds). Use completeOnTimeout() or orTimeout() to fail or recover after 2 seconds if it's taking too long.
public class Timeout {
    public static void main(String... args) throws ExecutionException, InterruptedException, TimeoutException {
        CompletableFuture<String> horatio = CompletableFuture.supplyAsync(() ->
        {
            sleep(3);
            return "Horatio";
        });
        CompletableFuture<String> harper = CompletableFuture.supplyAsync(() ->
        {
            sleep(3);
            return "Harper";
        });
        CompletableFuture<String> saori = CompletableFuture.supplyAsync(() ->
        {
            sleep(3);
            return "Saori";
        }).orTimeout(1, TimeUnit.SECONDS);

        try
        {
            horatio.get(2, TimeUnit.SECONDS);
        }
        catch(TimeoutException te)
        {
            System.out.println("Horatio timed out!");
        }

        saori.thenAccept(System.out::println).exceptionally(ex -> {
            System.out.println("Saori timed out!");
            return null;
        }).join();

        System.out.println("Daughter's name defaults to: " + harper.completeOnTimeout("Harper", 2, TimeUnit.SECONDS).get());
    }

    private static void sleep(int seconds)
    {
        try
        {
            Thread.sleep(seconds * 1000);
        }
        catch (InterruptedException e)
        {
            Thread.currentThread().interrupt();
        }
    }
}
