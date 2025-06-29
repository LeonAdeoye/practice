package com.leon;

import java.util.stream.IntStream;



// Given an array of daily temperatures, return the number of days the temperature increased compared to the previous day.

public class TemperatureDiff
{
    public static void main(String args[])
    {
        Double[] temperatures = {7.5, 4.0, 8.5, 3.1, 22.4, 6.2, 1.2, 3.4, 5.6, 4.9, 5.7, 7.8, 9.2};
        int count = 0;
        for(int i = 0; i < temperatures.length - 1; i++)
        {
            if(temperatures[i+1] > temperatures[i])
                count++;
        }
        System.out.println("Count of higher temps: " + count);

        long cnt = IntStream.range(1, temperatures.length)
                .filter(i -> temperatures[i] > temperatures[i - 1])
                .count();
        System.out.println("Count of higher temps: " + cnt);
    }
}
