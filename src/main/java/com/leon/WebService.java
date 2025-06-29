package com.leon;

import java.util.Random;
import java.util.concurrent.CompletableFuture;

//Simulate calling two dependent services: one fetches a user ID (simulated with sleep), and the next fetches that user's data. Chain them using thenCompose().
//Key concepts: thenCompose() for flattening dependent futures
public class WebService
{
    private record UserData(String userId, int age, int heightInCm) {}
    private static CompletableFuture<String> getUserId()
    {
        sleep(100);
        return CompletableFuture.supplyAsync(() -> {
            sleep(100);
            return "ladeoye";
        });
    }
    private static CompletableFuture<UserData> getUserData(String userId)
    {
        return CompletableFuture.supplyAsync(() -> {
            sleep(2000);
            return new UserData(userId, getRandomNumber(20, 50), getRandomNumber(160, 190));
        });
    }

    private static int getRandomNumber(int start, int end)
    {
        Random rand = new Random();
        return rand.nextInt(end-start) + start;
    }

    private static void sleep(long millis) {
        try { Thread.sleep(millis); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
    }

    public static void main(String... args)
    {
        CompletableFuture<UserData> result = getUserId().thenCompose(id -> getUserData(id));
        result.thenAccept(System.out::println).join();
    }
}
