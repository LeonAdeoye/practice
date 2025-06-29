package com.leon;

import java.util.concurrent.*;

public class Exec
{
    public static void main (String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        Callable<String> callableTask = () -> {
            return "Callable task completed in thread: " + Thread.currentThread().getName();
        };

        ExecutorService executorService = java.util.concurrent.Executors.newFixedThreadPool(10);

        System.out.println(executorService.submit(callableTask).get(10, java.util.concurrent.TimeUnit.SECONDS));

        executorService.submit(() -> System.out.println("Task is running " + Thread.currentThread().getName() + " in thread pool."));

        executorService.shutdown();
        boolean isTerminated = executorService.awaitTermination(10, java.util.concurrent.TimeUnit.SECONDS);
        if(!isTerminated)
            executorService.shutdownNow();
    }

}
