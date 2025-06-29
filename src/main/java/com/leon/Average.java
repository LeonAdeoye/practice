package com.leon;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.List;


// Given an array of noisy sensor readings, return a new array where each value is the average of itself and its neighbors.

public class Average
{
    public static void main(String[] args)
    {
        int[] readings = {10, 20, 8, 9, 4, 6, 8, 9, 2, 3};
        double[] averages = new double[readings.length];
        int size = readings.length;
        for(int i = 0; i < readings.length; i++)
        {
            if(i == 0)
            {
                averages[i] = (readings[i] + readings[i+1])/2.0;
            }
            else if (i == size - 1)
            {
                averages[i] = (readings[i] + readings[i-1])/2.0;
            }
            else
            {
                averages[i] = (readings[i] + readings[i+1] + readings[i-1])/3.0;
            }
        }
        System.out.println(Arrays.toString(averages));

        List<Double> avgs = IntStream.range(0, readings.length)
                .mapToDouble(i -> {
                    if(i == 0)
                        return (readings[i] + readings[i+1])/2.0;
                    else if (i == readings.length - 1)
                        return (readings[i] + readings[i-1])/2.0;
                    else
                        return (readings[i] + readings[i+1] + readings[i-1])/3.0;
                })
                .boxed()
                .collect(Collectors.toList());

        System.out.println(avgs);
    }
}
